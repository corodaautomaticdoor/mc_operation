package com.coroda.dao;

import com.coroda.dto.request.OperationRequest;
import com.coroda.dto.request.TypeOperationRequest;
import com.coroda.dto.response.OperationResponse;
import com.coroda.dto.response.TypeOperationResponse;
import com.coroda.entity.TypeOperation;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface OperationDao {

    Completable save(OperationRequest model);
    Completable delete(Long operationId);
    Completable update(OperationRequest model);
    Single<OperationResponse> getById(Long operationId);
    Observable<OperationResponse> findAll();

    Observable<OperationResponse> searchTypeOperation(TypeOperation typeOperation);
    Observable<OperationResponse> searchClient(String client);
    Observable<OperationResponse> getData(TypeOperation typeOperation, String client);
    Observable<TypeOperationResponse> updateType(Long id, TypeOperationRequest typeOperationRequest);
    
}
