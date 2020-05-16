package com.ewcs.bookcatalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.ewcs.bookcatalog.data.Book;
import com.ewcs.bookcatalog.data.network.BookResponse;
import com.ewcs.bookcatalog.data.repository.BookRepository;
import com.ewcs.bookcatalog.ui.book.BookAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchBookList();
    }

    private void fetchBookList() {
        BookRepository.getBookList(new Callback<BookResponse>() {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    final List<Book> bookList = response.body().bookList;
                    adapter = new BookAdapter(MainActivity.this, bookList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<BookResponse> call, Throwable t) {
                Log.e("MainActivity",t.getMessage());
            }
        });

    }
}
