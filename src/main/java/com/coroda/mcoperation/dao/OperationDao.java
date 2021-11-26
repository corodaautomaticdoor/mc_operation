package com.coroda.mcoperation.dao;

import com.coroda.mcoperation.model.api.request.Request;
import com.coroda.mcoperation.model.api.request.TypeOperationRequest;
import com.coroda.mcoperation.model.api.response.Response;
import com.coroda.mcoperation.model.api.response.TypeOperationResponse;
import com.coroda.mcoperation.model.entity.TypeOperation;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;

public interface OperationDao {

    Completable save(Request request);
    Completable delete(Long operationId);
    Completable update(Request request);
    Maybe<Response> getById(Long operationId);
    Observable<Response> findAll();

    Observable<Response> searchTypeOperation(TypeOperation typeOperation);
    Observable<Response> searchClient(String numberDocument);
    Observable<Response> getData(TypeOperation typeOperation, String numberDocument);
    Observable<TypeOperationResponse> updateType(Long id, TypeOperationRequest typeOperationRequest);

}
