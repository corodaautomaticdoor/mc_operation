package com.coroda.mcoperation.dao;

import com.coroda.mcoperation.model.api.request.Request;
import com.coroda.mcoperation.model.api.response.Response;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface OperationDao {

    Completable saveretrofit(Request request);

    Single<Response> getById(Long operationId);

    Observable<Response> searchOperacion(Long operationId);

}
