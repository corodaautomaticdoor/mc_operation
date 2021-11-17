package com.coroda.mcoperation.dao.implement;

import com.coroda.mcoperation.dao.OperationDao;
import com.coroda.mcoperation.model.api.request.*;
import com.coroda.mcoperation.model.api.response.DetailResponse;
import com.coroda.mcoperation.model.api.response.Response;
import com.coroda.mcoperation.model.api.response.TypeOperationResponse;
import com.coroda.mcoperation.model.entity.*;
import com.coroda.mcoperation.model.thirdparty.Person;
import com.coroda.mcoperation.model.thirdparty.Product;
import com.coroda.mcoperation.repository.OperationRepository;
import io.reactivex.*;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.BadRequestException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@Slf4j
@Data
public class OperationDaoImplement implements OperationDao {

    @Autowired
    private RestTemplate clienteRest;

    @Autowired
    private OperationRepository operationRepository;

    @Value("${service-product.ribbon.listOfServer}")
    private String mcProduct;

    @Value("${service-person.ribbon.listOfServer}")
    private String dataPerson;



    @Override
    public Completable save(Request request) {
        log.info("Guardando datos de la Operacion");
        return Single.fromCallable(() -> setOperacion(request))
                .map(operationRepository::save)
                .toCompletable();
    }

    @Override
    public Completable delete(Long operationId) {
        return maybeOperation(operationId)
                .flatMapCompletable(Operation ->
                {
                    operationRepository.deleteById(operationId);
                    return CompletableObserver::onComplete;
                });
    }

    private Maybe<Operation> maybeOperation(Long operationId) {
        log.info("buscando por id y obteniendo los campos");
        return Maybe.just(
                operationRepository.findById(operationId)
                        .<BadRequestException>orElseThrow(BadRequestException::new))
                .switchIfEmpty(Maybe.empty());
    }
    @Override
    public Completable update(Request request) {
        log.info("actualizando y guardando los campos");
        return maybeOperation(request.getOperationId())
                .flatMapCompletable(operation -> save(request));
    }

    private Operation setOperacion(Request model) {
        log.info("seteo de datos de Quotation del metodo save");
        Operation op = new Operation();
        op.setOperationId(model.getOperationId());
        op.setTypeOperation(model.getTypeOperation());
        op.setDate(model.getDate());
        op.setNumberDocument(model.getNumberDocument());
        op.setDetailOperacion(setlistaDetailOperacion(model.getDetail()));
        return op;
    }

    private List<DetailOperation> setlistaDetailOperacion(List<DetailRequest> listaDetail) {
        log.info("seteo de datos de QuotationItems ");
        return listaDetail.stream()
                .map(details -> setDetailOperacion(details))
                .collect(Collectors.toList());
    }

    private DetailOperation setDetailOperacion(DetailRequest detail) {
        DetailOperation detailOp = new DetailOperation();
        detailOp.setId(detail.getId());
        detailOp.setModel(detail.getModel());
        detailOp.setDetailOperationId(detail.getDetailOperationId());
        detailOp.setQuantity(detail.getQuantity());
        return detailOp;
    }




    @Override
    public Observable<Response>  getById(Long operationId) {
        log.info("Extrayendo reistros del Producto  acorde al modelo");
        return Observable.fromIterable(operationRepository.searchId(operationId))
                .filter(obj -> obj.getOperationId().equals(operationId))
                .map(operacion -> getOperation(operacion))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<Response> findAll() {
        log.info("seteo de todos los datos registrados");
        return Observable.fromIterable(operationRepository.findAll())
                .map(Operation -> getOperation(Operation))
                .subscribeOn(Schedulers.io());
    }

    private Response getOperation(Operation model) throws ParseException {
        log.info("Extrayendo reistros de OPERACION");
        Response op = new Response();
        op.setOperationId(model.getOperationId());
        op.setTypeOperation(model.getTypeOperation());
        op.setDate(getFecha(model.getDate()));
        op.setHora(getHora(model.getDate()));
        op.setPerson(getListPerson(model.getNumberDocument()));
        op.setDetail(getlistaDetail(model.getDetailOperacion()));
        return op;
    }
    public String getFecha(String date) throws ParseException {
        Date fecha = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse(date);
        String Fecha = new SimpleDateFormat("dd-MM-yyyy").format(fecha);
        String f = Fecha.toString();
        return f;
    }
    public String getHora(String date) throws ParseException {
        Date hora = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").parse(date);
        String Hora = new SimpleDateFormat("hh:mm:ss").format(hora);
        String h = Hora.toString();
        return h;
    }

    public Person getListPerson(Long numberDocument) {
        Map<String,String> pathVariables3= new HashMap<String,String>();
        pathVariables3.put("numberDocument",numberDocument.toString());
        log.info("Extrayendo registros de Cliente");
        Person person= clienteRest.getForObject(dataPerson, Person.class,pathVariables3);
        return person;
    }

    private List<DetailResponse> getlistaDetail(List<DetailOperation> listaDetail) {
        return listaDetail.stream()
                .map(details -> getDetail(details))
                .collect(Collectors.toList());
    }

    private DetailResponse getDetail(DetailOperation detail) {
        DetailResponse dr = new DetailResponse();
        log.info("Extrayendo registros de Detalle");
        dr.setDetailOperationId(detail.getDetailOperationId());
        dr.setId(detail.getId());
        dr.setProduct(getProduct(detail.getModel()));
        dr.setQuantity(detail.getQuantity());
        return dr;
    }

    public List<Product> getProduct(String model) {
        Map<String,String> modelProduct= new HashMap<String,String>();
        modelProduct.put("model",model);
        log.info("Extrayendo registros de Productos");
        Product[] product= clienteRest.getForObject(mcProduct,Product[].class,modelProduct);
        return Arrays.asList(product);
    }

    @Override
    public Observable<Response> searchTypeOperation(TypeOperation typeOperation) {
        log.info("Extrayendo registros acorde al tipo de Operacion");
        return Observable.fromIterable(operationRepository.searchTypeOperation(typeOperation))
                .filter(objType -> objType.getTypeOperation().equals(typeOperation))
                .map(operation -> getOperation(operation))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<Response> searchClient(String numberDocument) {
        log.info("Extrayendo registros de la Operacion  acorde al cliente");
        long number = Long.parseLong(numberDocument);
        return Observable.fromIterable(operationRepository.searchClient(number))
                .filter(objClient -> objClient.getNumberDocument().equals(number))
                .map(operation -> getOperation(operation))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<Response> getData(TypeOperation typeOperation, String numberDocument) {
        log.info("Extrayendo registros del Tipo de Operacion acorde al cliente");
        long number = Long.parseLong(numberDocument);
        return Observable.fromIterable(operationRepository.getData(typeOperation, number))
                .map(operation -> getOperation(operation))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<TypeOperationResponse> updateType(Long id, TypeOperationRequest typeOperationRequest) {
        TypeOperationResponse typeOperationResponse = new TypeOperationResponse();
        typeOperationResponse.setUpdate(operationRepository.updateType(id, typeOperationRequest.getTypeOperation()));
        log.info("Actualizando el tipo de Operacion");
        return Observable.just(typeOperationResponse)
                .map(x -> x)
                .subscribeOn(Schedulers.io());
    }
}
