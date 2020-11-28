package com.coroda.mcoperation.dao.implement;

import com.coroda.mcoperation.dao.OperationDao;
import com.coroda.mcoperation.model.api.request.*;
import com.coroda.mcoperation.model.api.response.DetailResponse;
import com.coroda.mcoperation.model.api.response.Response;
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

//@AllArgsConstructor
@Repository
@Slf4j
@Data
public class OperationDaoImplement implements OperationDao {
    @Autowired
    private RestTemplate clienteRest;

    @Autowired
    private OperationRepository operacionRepository;


    @Value("${service-product.ribbon.listOfServer}")
    private String mcProduct;

    @Value("${service-person.ribbon.listOfServer}")
    private String dataPerson;



    @Override
    public Completable saveretrofit(Request request) {
        log.info("Guardando datos de la Operacion");
        return Single.fromCallable(() -> setOperacion(request))
                .map(operacionRepository::save)
                .toCompletable();
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
    public Observable<Response>  searchOperacion(Long operationId) {
        log.info("Extrayendo reistros del Producto  acorde al modelo");
        return Observable.fromIterable(operacionRepository.searchId(operationId))
                .filter(obj -> obj.getOperationId().equals(operationId))
                .map(operacion -> getOperation(operacion))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Single<Response> getById(Long operationId) {
        return maybeOperation(operationId)
                .map(Operacion -> getOperation(Operacion))
                .toSingle();
    }
    private Maybe<Operation> maybeOperation(Long operationId) {
        log.info("buscando por id y obteniendo los campos");
        return Maybe.just(
                operacionRepository.findById(operationId)
                        .<BadRequestException>orElseThrow(BadRequestException::new))
                .switchIfEmpty(Maybe.empty());
    }

    private Response getOperation(Operation model) throws ParseException {
        log.info("Extrayendo reistros de OPERACION");
        Response op = new Response();
        op.setOperationId(model.getOperationId());
        op.setTypeOperation(model.getTypeOperation());
        op.setDate(getFecha(model.getDate()));
        op.setHora(getHora(model.getDate()));
        op.setPerson(getListPerson(model.getNumberDocument()));
//        op.setTotalAmount(model.getTotalAmount());
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

    public List<Person> getListPerson(Long numberDocument) {
        log.info("enviando numberDocument de persona "+numberDocument);

        Map<String,String> pathVariables3= new HashMap<String,String>();
        pathVariables3.put("numberDocument",numberDocument.toString());
        log.info("actualizando  numberDocument de persona "+pathVariables3);
        Person[] person= clienteRest.getForObject(dataPerson, Person[].class,pathVariables3);
        log.info("datos de persona "+person);
        return Arrays.asList(person);
    }

    private List<DetailResponse> getlistaDetail(List<DetailOperation> listaDetail) {
        return listaDetail.stream()
                .map(details -> getDetail(details))
                .collect(Collectors.toList());
    }

    private DetailResponse getDetail(DetailOperation detail) {
        DetailResponse dr = new DetailResponse();
        log.info("Extrayendo reistros de DETAIL");
        dr.setDetailOperationId(detail.getDetailOperationId());
        dr.setId(detail.getId());
        dr.setProduct(getProduct(detail.getModel()));
        dr.setQuantity(detail.getQuantity());
//        dr.setTotalDetailAmount(detail.getTotalDetail());
        return dr;
    }

    public List<Product> getProduct(String model) {
        Map<String,String> modelProduct= new HashMap<String,String>();
        modelProduct.put("model",model);
        log.info("Extrayendo reistros de PRODUCTO");
        Product[] product= clienteRest.getForObject(mcProduct,Product[].class,modelProduct);
        return Arrays.asList(product);
    }


}
