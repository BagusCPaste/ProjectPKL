package com.bagus.projectpkl.retrofit;

import com.bagus.projectpkl.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiEndpoint {
    @FormUrlEncoded
    @POST("auth")
    Call<LoginResponse> UserLogin(
    @Field("email") String email,
    @Field("password") String password
    );
}
