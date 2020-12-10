package com.coroda.mcoperation.bussines;

import com.coroda.mcoperation.model.api.request.Request;
import com.coroda.mcoperation.model.api.request.TypeOperationRequest;
import com.coroda.mcoperation.model.api.response.Response;
import com.coroda.mcoperation.model.api.response.TypeOperationResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;

import java.util.Map;


public interface OperationService {

    Completable save(Request request);
    Completable delete (Long operationId);
    Completable update (Request request);
    Observable<Response> getById (Long operationId);

    Observable<Response> getData(Map<String, String> params);
    Observable<TypeOperationResponse> updateType(Long id , TypeOperationRequest typeOperationRequest);

}
