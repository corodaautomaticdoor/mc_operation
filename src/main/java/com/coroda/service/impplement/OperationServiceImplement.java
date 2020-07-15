package com.coroda.service.impplement;

import com.coroda.dao.OperationDao;
import com.coroda.dto.request.OperationRequest;
import com.coroda.dto.request.TypeOperationRequest;
import com.coroda.dto.response.OperationResponse;
import com.coroda.dto.response.TypeOperationResponse;
import com.coroda.entity.TypeOperation;
import com.coroda.service.OperationService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
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
    public Completable save(OperationRequest model) {
        return operationDao.save(model);
    }

    @Override
    public Completable delete(Long operationId) {
        return operationDao.delete(operationId);
    }

    @Override
    public Completable update(OperationRequest model) {
        return operationDao.update(model);
    }

    @Override
    public Single<OperationResponse> getById(Long operationId) {
        return operationDao.getById(operationId);
    }

    @Override
    public Observable<OperationResponse> getData(Map<String, String> params) {
        log.info("Busqueda Dinamica");
        Observable<OperationResponse> operationResponseObservable = null;
        String client;
        TypeOperation type;

        if (!params.isEmpty()) {
            if (params.get("type") != null && params.get("client") != null) {
                log.info("Buscando por Tipo de Operacion y cliente");
                type = TypeOperation.valueOf(params.get("type"));
                client = params.get("client");
                operationResponseObservable = operationDao.getData(type, client);
            } else if (params.get("type") != null && params.get("client") == null) {
                log.info("Buscando por Tipo de Operacion ");
                type = TypeOperation.valueOf(params.get("type"));
                operationResponseObservable = operationDao.searchTypeOperation(type);
            } else if (params.get("type") == null && params.get("client") != null) {
                log.info("Buscando por cliente");
                client = params.get("client");
                operationResponseObservable = operationDao.searchClient(client);
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
