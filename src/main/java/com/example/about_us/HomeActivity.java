package com.example.about_us;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.about_us.R;
import com.example.about_us.Adapter.ListViewAdapter;
import com.example.about_us.Adapter.SlideAdapter;
import com.example.about_us.Model.ListView;
import com.example.about_us.Model.SlideItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    String extra;
    TextView nameTxt;
    ViewPager2 viewpager2;
    RecyclerView recyclerView;
    ListViewAdapter adapter;
    Context context;

    //auto slide
    private Handler slideHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewpager2 = findViewById(R.id.viewPager);
        List<SlideItem> sliderItem = new ArrayList<>();

        sliderItem.add(new SlideItem(R.drawable.t1));
        sliderItem.add(new SlideItem(R.drawable.t2));
        sliderItem.add(new SlideItem(R.drawable.t3));
        sliderItem.add(new SlideItem(R.drawable.t4));

        viewpager2.setAdapter(new SlideAdapter(sliderItem, viewpager2));

        viewpager2.setClipToPadding(false);
        viewpager2.setClipChildren(false);
        viewpager2.setOffscreenPageLimit(5);
        viewpager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositionTransform = new CompositePageTransformer();
        compositionTransform.addTransformer(new MarginPageTransformer(20));
        compositionTransform.addTransformer(new ViewPager2.PageTransformer(){

            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1- Math.abs(position);
                page.setScaleY(0.85f + r*0.15f);
            }
        });

        viewpager2.setPageTransformer(compositionTransform);

        viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(sliderRunnable);
                slideHandler.postDelayed(sliderRunnable, 1000);
            }
        });

        // Buat Intent Welcome back, Nama
        nameTxt = findViewById(R.id.welcomeTxt);
//        nameTxt.setText("" + getIntent().getStringExtra("EXTRA_NAME"));
        nameTxt.setText(""+getIntent().getStringExtra("Name"));

        //Buat RecyclerView Popular
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Vector<ListView> itemVector = new Vector<>();
        itemVector.add(new ListView(1, "Art Performance - The Greatest Showman", "$499.99", "Jan 2, 2023", "Impressionism", R.drawable.t1));
        itemVector.add(new ListView(2, "Art Performance - The Greatest Sakura", "$589.99", "Jan 3, 2023", "Realism", R.drawable.t2));
        itemVector.add(new ListView(3, "Art Performance - Paintings from 15BC", "$690.99", "Jan 4, 2023", "Abstract", R.drawable.t3));
        itemVector.add(new ListView(4, "Art Performance - Rise & Shine Into The Diversity", "$801.99", "Jan 5, 2023", "Fauvism", R.drawable.t4));
        itemVector.add(new ListView(5, "Art Performance - Fallout to Pastlife In Time", "$999.99", "Jan 6, 2023", "Surrealism", R.drawable.t5));

        adapter = new ListViewAdapter(itemVector, context);
        recyclerView.setAdapter(adapter);
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewpager2.setCurrentItem(viewpager2.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        slideHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        slideHandler.postDelayed(sliderRunnable, 3000);
    }

    //Initialize Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
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
        }
        else if(item.getItemId() == R.id.aboutMenu) {
            Intent Coba2Intent = new Intent(this, MainActivity.class);
            startActivity(Coba2Intent);
        }
        return false;
    }
}
