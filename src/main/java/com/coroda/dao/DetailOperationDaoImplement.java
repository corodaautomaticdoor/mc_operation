package com.coroda.dao;

import com.coroda.dto.DetailOperationRequest;
import com.coroda.dto.DetailOperationResponse;
import com.coroda.repository.DetailOperationRepository;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class DetailOperationDaoImplement  implements DetailOperationDao{

    private DetailOperationRepository detailOperationRepository;

    @Override
    public Completable save(DetailOperationRequest model) {
        return null;
    }

    @Override
    public Completable delete(Integer detailOperationId) {
        return null;
    }

    @Override
    public Completable update(DetailOperationRequest model) {
        return null;
    }

    @Override
    public Single<DetailOperationResponse> getById(Integer detailOperationId) {
        return null;
    }

    @Override
    public Observable<DetailOperationResponse> findAll() {
        return null;
    }
}
