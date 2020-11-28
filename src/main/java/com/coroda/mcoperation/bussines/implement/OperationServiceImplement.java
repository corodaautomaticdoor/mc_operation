package com.coroda.mcoperation.bussines.implement;

import com.coroda.mcoperation.bussines.OperationService;
import com.coroda.mcoperation.dao.OperationDao;
import com.coroda.mcoperation.model.api.request.Request;
import com.coroda.mcoperation.model.api.response.Response;
import io.reactivex.Completable;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OperationServiceImplement implements OperationService {

    @Autowired
    private OperationDao operacionDao;

    @Override
    public Completable saveretrofit(Request request) {
        return operacionDao.saveretrofit(request);
    }

    @Override
    public Observable<Response> getById(Long operationId) {
//        return operacionDao.getById(operationId);
        return  operacionDao.searchOperacion(operationId);
    }

}
