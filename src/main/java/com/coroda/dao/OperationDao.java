package com.coroda.dao;

import com.coroda.dto.OperationRequest;
import com.coroda.dto.OperationResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface OperationDao {

    Completable save (OperationRequest model);
    Completable delete (Integer operationId);
    Completable update (OperationRequest model);
    Single<OperationResponse> getById (Integer operationId);
    Observable<OperationResponse> findAll();
}
