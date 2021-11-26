package com.coroda.mcoperation.bussines.implement;

import com.coroda.mcoperation.bussines.OperationService;
import com.coroda.mcoperation.dao.OperationDao;
import com.coroda.mcoperation.model.api.request.Request;
import com.coroda.mcoperation.model.api.request.TypeOperationRequest;
import com.coroda.mcoperation.model.api.response.Response;
import com.coroda.mcoperation.model.api.response.TypeOperationResponse;
import com.coroda.mcoperation.model.entity.TypeOperation;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class OperationServiceImplement implements OperationService {

    @Autowired
    private OperationDao operationDao;

    @Override
    public Completable save(Request request) {
        return operationDao.save(request);
    }

    @Override
    public Completable delete(Long operationId) {
        return operationDao.delete(operationId);
    }

    @Override
    public Completable update(Request request) {
        return operationDao.update(request);
    }

    @Override
    public Maybe<Response> getById(Long operationId) {
        return operationDao.getById(operationId);
    }

    @Override
    public Observable<Response> getData(Map<String, String> params) {
        log.info("Busqueda Dinamica");
        Observable<Response> operationResponseObservable = null;
        String numberDocument;
        TypeOperation type;

        if (!params.isEmpty()) {
            if (params.get("type") != null && params.get("numberDocument") != null) {
                log.info("Buscando por Tipo de Operacion y cliente");
                type = TypeOperation.valueOf(params.get("type"));
                numberDocument = params.get("numberDocument");
                operationResponseObservable = operationDao.getData(type, numberDocument);
            } else if (params.get("type") != null && params.get("numberDocument") == null) {
                log.info("Buscando por Tipo de Operacion ");
                type = TypeOperation.valueOf(params.get("type"));
                operationResponseObservable = operationDao.searchTypeOperation(type);
            } else if (params.get("type") == null && params.get("numberDocument") != null) {
                log.info("Buscando por cliente");
                numberDocument = params.get("numberDocument");
                log.info("Buscando por cliente"+numberDocument);
                operationResponseObservable = operationDao.searchClient(numberDocument);
            }

        } else {
            log.info("Buscando todos los registros");
            operationResponseObservable = operationDao.findAll();
        }

        return operationResponseObservable;
    }

    @Override
    public Observable<TypeOperationResponse> updateType(Long id, TypeOperationRequest typeOperationRequest) {
        return operationDao.updateType(id, typeOperationRequest);
    }

}
