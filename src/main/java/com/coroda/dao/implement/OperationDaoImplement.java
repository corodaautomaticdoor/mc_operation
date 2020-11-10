package com.coroda.dao.implement;

import com.coroda.dto.request.TypeOperationRequest;
import com.coroda.dto.response.TypeOperationResponse;
import com.coroda.entity.TypeOperation;
import lombok.Data;
import com.coroda.dao.OperationDao;
import com.coroda.dto.request.DetailOperationRequest;
import com.coroda.dto.response.DetailOperationResponse;
import com.coroda.dto.request.OperationRequest;
import com.coroda.dto.response.OperationResponse;
import com.coroda.entity.DetailOperation;
import com.coroda.entity.Operation;
import com.coroda.repository.OperationRepository;
import io.reactivex.*;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Repository
@Slf4j
@Data
public class OperationDaoImplement implements OperationDao {

    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Completable save(OperationRequest model) {
        log.info("Guardando datos de la Operacion");
        return Single.fromCallable(() -> setOperation(model))
                .map(operationRepository::save)
                .toCompletable();
    }

    private Operation setOperation(OperationRequest model) {
        log.info("seteo de datos de Quotation del metodo save");
        Operation op = new Operation();
        op.setOperationId(model.getOperationId());
        op.setTypeOperation(model.getTypeOperation());
        op.setDate(model.getDate());
        op.setClient(model.getClient());
        op.setDetailOperation(setlistaDetail(model.getDetailOperation()));
        return op;
    }

    private List<DetailOperation> setlistaDetail(List<DetailOperationRequest> listaDetail) {
        log.info("seteo de datos de QuotationItems ");
        return listaDetail.stream()
                .map(details -> setDetail(details))
                .collect(Collectors.toList());
    }

    private DetailOperation setDetail(DetailOperationRequest detail) {
        DetailOperation detailOp = new DetailOperation();
        detailOp.setId(detail.getId());
        detailOp.setDescription(detail.getDescription());
        detailOp.setDetailOperationId(detail.getDetailOperationId());
        detailOp.setQuantity(detail.getQuantity());
        detailOp.setPriceUnit(detail.getPriceUnit());
        return detailOp;
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
    public Completable update(OperationRequest model) {
        log.info("actualizando y guardando los campos");
        return maybeOperation(model.getOperationId())
                .flatMapCompletable(operation -> save(model));
    }

    @Override
    public Single<OperationResponse> getById(Long operationId) {
        return maybeOperation(operationId)
                .map(Operation -> getOperation(Operation))
                .toSingle();
    }

    @Override
    public Observable<OperationResponse> findAll() {
        log.info("seteo de todos los datos registrados");
        return Observable.fromIterable(operationRepository.findAll())
                .map(Operation -> getOperation(Operation))
                .subscribeOn(Schedulers.io());
    }

    private OperationResponse getOperation(Operation model) {
        OperationResponse op = new OperationResponse();
        op.setOperationId(model.getOperationId());
        op.setTypeOperation(model.getTypeOperation());
        op.setDate(model.getDate());
        op.setClient(model.getClient());
        op.setTotalAmount(model.getTotalAmount());
        op.setDetailOperation(getlistaDetail(model.getDetailOperation()));
        return op;
    }

    private List<DetailOperationResponse> getlistaDetail(List<DetailOperation> listaDetail) {
        return listaDetail.stream()
                .map(details -> getDetail(details))
                .collect(Collectors.toList());
    }

    private DetailOperationResponse getDetail(DetailOperation detail) {
        DetailOperationResponse detailOp = new DetailOperationResponse();
        detailOp.setDescription(detail.getDescription());
        detailOp.setDetailOperationId(detail.getDetailOperationId());
        detailOp.setId(detail.getId());
        detailOp.setQuantity(detail.getQuantity());
        detailOp.setPriceUnit(detail.getPriceUnit());
        detailOp.setTotalDetailAmount(detail.getTotalDetail());
        return detailOp;
    }

    @Override
    public Observable<OperationResponse> searchTypeOperation(TypeOperation typeOperation) {
        log.info("Extrayendo reistros acorde al tipo de Operacion");
        return Observable.fromIterable(operationRepository.searchTypeOperation(typeOperation))
                .filter(objType -> objType.getTypeOperation().equals(typeOperation))
                .map(operation -> getOperation(operation))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<OperationResponse> searchClient(String client) {
        log.info("Extrayendo reistros de la Operacion  acorde al cliente");
        return Observable.fromIterable(operationRepository.searchClient(client))
                .filter(objClient -> objClient.getClient().equals(client))
                .map(operation -> getOperation(operation))
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<OperationResponse> getData(TypeOperation typeOperation, String client) {
        log.info("Extrayendo reistros del Tipo de Operacion acorde al cliente");
        return Observable.fromIterable(operationRepository.getData(typeOperation, client))
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
