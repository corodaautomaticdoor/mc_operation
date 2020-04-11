package com.coroda.dao;

import com.coroda.dto.OperationRequest;
import com.coroda.dto.OperationResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class OperationDaoImplement implements OperationDao {

    @Override
    public Completable save(OperationRequest model) {
        return null;
    }

    @Override
    public Completable delete(Integer operationId) {
        return null;
    }

    @Override
    public Completable update(OperationRequest model) {
        return null;
    }

    @Override
    public Single<OperationResponse> getById(Integer operationId) {
        return null;
    }

    @Override
    public Observable<OperationResponse> findAll() {
        return null;
    }
}
