package com.bagus.projectpkl.api;

import com.bagus.projectpkl.Respons.ResponseLogin;
import com.bagus.projectpkl.Respons.ResponseMember;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface request{
    @FormUrlEncoded
    @POST("api/auth")
    Call<ResponseLogin> auth(@Field("USERNAME") String username,
                             @Field("PASSWORD") String password
    );

    @FormUrlEncoded
    @POST("api/login/")
    Call<ResponseLogin> login(@Field("OBJECT") String object
    );

    @POST("api/gettagihan")
    Call<ResponseMember> member();

}
