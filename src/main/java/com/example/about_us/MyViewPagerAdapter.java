package com.example.about_us;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.about_us.fragments.AboutUsFragment;
import com.example.about_us.fragments.ContactUsFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position){
        switch (position){
            case 0:
                return new AboutUsFragment();
            case 1:
                return new ContactUsFragment();
            default:
                return new AboutUsFragment();
        }
    }
    @Override
    public int getItemCount(){
        return 2;
    }
}
