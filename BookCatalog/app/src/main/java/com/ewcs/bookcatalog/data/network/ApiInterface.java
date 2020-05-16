package com.ewcs.bookcatalog.data.network;

import retrofit2.Call;
import retrofit2.http.GET;

// vai chamar o servidor
public interface ApiInterface {

    @GET("api/books")
    Call<BookResponse> getBookList();



}
