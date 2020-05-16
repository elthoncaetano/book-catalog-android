package com.ewcs.bookcatalog.data.network;

import com.ewcs.bookcatalog.data.Book;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BookResponse {

    @SerializedName("success")
    public Boolean success;

    @SerializedName("count")
    public int count;

    @SerializedName("data")
    public List<Book> bookList = new ArrayList<>();

}
