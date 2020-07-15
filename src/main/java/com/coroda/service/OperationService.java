package com.coroda.service;

import com.coroda.dto.request.OperationRequest;
import com.coroda.dto.request.TypeOperationRequest;
import com.coroda.dto.response.OperationResponse;
import com.coroda.dto.response.TypeOperationResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.Map;


public interface OperationService {

    Completable save (OperationRequest model);
    Completable delete (Long operationId);
    Completable update (OperationRequest model);
    Single<OperationResponse> getById (Long operationId);

    Observable<OperationResponse> getData(Map<String, String> params);
    Observable<TypeOperationResponse> updateType(Long id , TypeOperationRequest typeOperationRequest);

}
