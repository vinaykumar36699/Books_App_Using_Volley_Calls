package com.example.books;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.books.models.Book;

import java.util.List;

public class RVAdapter<data> extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    List<Book> listOfBooks;

    public RVAdapter(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter.ViewHolder holder, int position) {
        Book book = listOfBooks.get(position);
        holder.title.setText(book.getTitle());
        holder.author.setText("Author : " + book.getArtistTitle());
        holder.creditLine.setText("Credit Line : " + book.getCreditLine());

        if (book.getPlaceOfOrigin().isEmpty()) {
            holder.PlaceOfOrigin.setText("--");
        } else {
            holder.PlaceOfOrigin.setText("Place of Origin : " + book.getPlaceOfOrigin());
        }


    }

    @Override
    public int getItemCount() {
        return listOfBooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, author, creditLine, PlaceOfOrigin, FiscalYear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            creditLine = itemView.findViewById(R.id.CL);
            PlaceOfOrigin = itemView.findViewById(R.id.PLO);
        }
    }

    interface ShareBook {
        void share(String book, String authorName);
    }
}
