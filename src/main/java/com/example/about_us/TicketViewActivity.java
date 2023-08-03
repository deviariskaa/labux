package com.example.about_us;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.about_us.Adapter.ListViewAdapter;
import com.example.about_us.Model.ListView;

import java.util.Vector;

public class TicketViewActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    RecyclerView recyclerView;
    ListViewAdapter adapter;
    Button btn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_view);

        btn = findViewById(R.id.backButton);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Vector<ListView> itemVector = new Vector<>();
        itemVector.add(new ListView(2, "Art Performance - The Greatest Sakura", "$589.99", "Jan 3, 2023", "Realism", R.drawable.t2));
        itemVector.add(new ListView(1, "Art Performance - The Greatest Showman", "$499.99", "Jan 2, 2023", "Impressionism", R.drawable.t1));
        itemVector.add(new ListView(3, "Art Performance - Paintings from 15BC", "$690.99", "Jan 4, 2023", "Abstract", R.drawable.t3));
        itemVector.add(new ListView(4, "Art Performance - Rise and Shine Towards Nature", "$801.99", "Jan 5, 2023", "Fauvism", R.drawable.t4));
        itemVector.add(new ListView(5, "Art Performance - Fallout to Pastlife In Time", "$999.99", "Jan 6, 2023", "Surrealism", R.drawable.t5));
        itemVector.add(new ListView(5, "Art Performance - Building Lego House in Summertime", "$1099.99", "Jan 7, 2023", "Classic", R.drawable.t1));

        adapter = new ListViewAdapter(itemVector, context);
        recyclerView.setAdapter(adapter);

        btn.setOnClickListener(view -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });

//        String extra = getTitle().toString();
//        btn.setOnClickListener(view -> {
//            Intent intent = new Intent(this, CobaActivity.class);
//            intent.putExtra("EXTRA_IMAGE", extra);
//            startActivity(intent);
//        });



    }

    //Menu Option
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        if(item.getItemId() == R.id.homeMenu){
            Intent homeIntent = new Intent(this, HomeActivity.class);
            startActivity(homeIntent);
        }else if(item.getItemId() == R.id.ticketMenu) {
            Intent ticketIntent = new Intent(this, TicketViewActivity.class);
            startActivity(ticketIntent);
        }else if(item.getItemId() == R.id.logoutMenu) {
            Intent logoutIntent = new Intent(this, LoginActivity.class);
            startActivity(logoutIntent);
        }        else if(item.getItemId() == R.id.aboutMenu) {
            Intent Coba2Intent = new Intent(this, MainActivity.class);
            startActivity(Coba2Intent);
        }

        return false;
    }
}
