package com.example.books;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.books.models.Book;

import java.util.List;

@Dao
public interface BookDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertOneBook(Book book);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertListOfBooks(List<Book> bookList);

    @Query("SELECT * FROM books_table")
    List<Book> getAllBooks();

}
