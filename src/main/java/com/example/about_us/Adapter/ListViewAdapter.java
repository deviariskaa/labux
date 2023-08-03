package com.example.about_us.Adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.about_us.Model.ListView;
import com.example.about_us.HomeActivity;
import com.example.about_us.LoginActivity;
import com.example.about_us.Model.ListView;
import com.example.about_us.R;
import com.example.about_us.TicketForm;
//import com.example.about_us.TicketForm;

import org.w3c.dom.Text;

import java.util.Vector;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {

    private Vector<ListView> itemVector;
    private Context context;

    public ListViewAdapter(Vector<ListView> itemVector, Context context) {
        this.itemVector = itemVector;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewAdapter.ViewHolder holder, int position) {
        ListView listView = itemVector.get(position);

        holder.image.setImageResource(listView.getImage());
        holder.title.setText(listView.getTitle());
        holder.price.setText(listView.getPrice());
        holder.date.setText(listView.getDate());
        holder.genre.setText(listView.getGenre());

        holder.btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent moveIntent = new Intent(view.getContext(), TicketForm.class);
                moveIntent.putExtra("image", listView.getImage());
                view.getContext().startActivity(moveIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemVector.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        Button btn;
        ImageView image;
        TextView title;
        TextView price;
        TextView date;
        TextView genre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btn = itemView.findViewById(R.id.buttonOrder);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            date = itemView.findViewById(R.id.date);
            genre = itemView.findViewById(R.id.genre);

        }
    }
}
