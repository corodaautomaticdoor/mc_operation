package com.coroda.dao;

import com.coroda.dto.DetailOperationRequest;
import com.coroda.dto.DetailOperationResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface DetailOperationDao {

    Completable save(DetailOperationRequest model);
    Completable delete(Integer detailOperationId);
    Completable update(DetailOperationRequest model);
    Single<DetailOperationResponse> getById(Integer detailOperationId);
    Observable<DetailOperationResponse> findAll();
}
