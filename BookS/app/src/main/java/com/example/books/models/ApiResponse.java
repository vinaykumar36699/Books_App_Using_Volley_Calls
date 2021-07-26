package com.example.books.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ApiResponse implements Serializable {

    @SerializedName("data")
    @Expose
    private List<Book> listOfBooks = null;
    private final static long serialVersionUID = 4210297431210452758L;

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

}
