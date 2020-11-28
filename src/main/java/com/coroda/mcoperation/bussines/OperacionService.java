package com.coroda.mcoperation.bussines;

import com.coroda.mcoperation.model.api.request.Request;
import com.coroda.mcoperation.model.api.response.Response;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;


public interface OperacionService {

    Completable saveretrofit (Request request);

    Observable<Response> getById (Long operationId);

}
