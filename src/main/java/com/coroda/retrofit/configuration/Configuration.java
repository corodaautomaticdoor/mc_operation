package com.coroda.retrofit.configuration;

import com.coroda.retrofit.repository.ProductRepository;
import com.coroda.util.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Configuration {

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.URL_MCPRODUCT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build()).build();
    private ProductRepository productRepository = retrofit.create(ProductRepository.class);

    public Configuration() {
        Gson gson = new GsonBuilder().setLenient().create();
    }
}
