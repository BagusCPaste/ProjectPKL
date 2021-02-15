package com.bagus.projectpkl.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KoneksiAPI {

    public static Retrofit retrofit= null;
    // Membuat base URL
    public static String BASE_URL = "http://simkoonline.ddns.net:8000/api/";

    public static ApiEndpoint endpoint (){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        return retrofit.create(ApiEndpoint.class);
    }
}
