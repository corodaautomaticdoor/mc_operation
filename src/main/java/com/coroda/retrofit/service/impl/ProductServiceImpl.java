package com.coroda.retrofit.service.impl;

import com.coroda.retrofit.repository.ProductRepository;
import com.coroda.util.Constants;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
@Slf4j
public class ProductServiceImpl {

//    public static String baseUrl = Constants.URL_MCPRODUCT;

//    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//    Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.URL_MCPRODUCT)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(httpClient.build()).build();

    @Autowired
    public ProductRepository productRepository;
}
