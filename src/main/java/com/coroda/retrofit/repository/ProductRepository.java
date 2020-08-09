package com.coroda.retrofit.repository;

import com.coroda.retrofit.model.RetrofitProduct;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductRepository {

    @GET("/product/{id}")
    public Single<RetrofitProduct> getById(@Path("id") Long id);
}
