package com.example.books;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.books.models.ApiResponse;
import com.example.books.models.Book;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements RVAdapter.ShareBook {
    RecyclerView recyclerView;
    RVAdapter mRVAdapter;
    BookDatabase bookDatabase;
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookDatabase = BookDatabase.getInstance(this);
        recyclerView = findViewById(R.id.pagination);

        setUpAnim();
        getBooks();
    }

    private void setUpAnim() {
        animationView = findViewById(R.id.noInternetAnim);
        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                getBooks();
            }
        });
    }

    private List<Book> getBooks() {

        if (isNetworkConnected()) {
            animationView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            String apiURL = "https://api.artic.edu/api/v1/artworks?page=" + new Random().nextInt(10) + "&limit=10";
            RequestQueue requestQueue = Volley.newRequestQueue(this);

            JsonObjectRequest getResponse = new JsonObjectRequest(Request.Method.GET, apiURL, null, response -> {
                ApiResponse apiResponse = new GsonBuilder().create().fromJson(response.toString(), ApiResponse.class);
                bookDatabase.bookDao().insertListOfBooks(apiResponse.getListOfBooks());
                Log.e("apiRespose", response.toString());
                setUpRecyclerView(bookDatabase.bookDao().getAllBooks());
            },
                    error -> {
                        setUpRecyclerView(bookDatabase.bookDao().getAllBooks());
                    });
            requestQueue.add(getResponse);
        } else {
            List<Book> listOfBooks = getListOfBooks();
            if (listOfBooks.isEmpty()) {
                displayAnimation();
            } else {
                setUpRecyclerView(listOfBooks);
            }
        }

        return null;
    }

    private void setUpRecyclerView(List<Book> listOfBooks) {
        mRVAdapter = new RVAdapter(listOfBooks);
        recyclerView.setAdapter(mRVAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    private List<Book> getListOfBooks() {
        return (List<Book>) bookDatabase.bookDao().getAllBooks();
    }

    private void displayAnimation() {
        recyclerView.setVisibility(View.GONE);
        animationView.setVisibility(View.VISIBLE);
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    @Override
    public void share(String book, String authorName) {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, book + "\n\n- " + authorName);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, "Share this Book");
        startActivity(shareIntent);
    }



}