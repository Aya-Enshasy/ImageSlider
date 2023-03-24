package com.slider.sliderimageshw1.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.slider.sliderimageshw1.utils.ZoomOutPageTransformer;
import com.slider.sliderimageshw1.adapter.MyPagerAdapter;
import com.slider.sliderimageshw1.databinding.ActivityMainBinding;
import com.slider.sliderimageshw1.model.Image;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Image> list = new ArrayList<>();
    MyPagerAdapter mViewPagerAdapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        adapter();
        clickListeners();

    }

    private void adapter(){
        list.add(new Image("https://media.istockphoto.com/id/1173074943/photo/beautiful-pink-flower-blossom-in-night-skies-with-full-moon.jpg?s=170667a&w=0&k=20&c=blINfdyVecDdKgrViVCFxeWE39b4GAkdxPS8WCzGrmg="));
        list.add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSH0LndmMLZfEuEDUxkqCC-CN54JUfc8hd116q-IJJcX8USHy1_6NzIgKSEBQGlVN0t0S0&usqp=CAU"));
        list.add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlWzu9v22leCktBrbeRXnf0tS5LbklF-bbXj5y9o789NMMlDn5soL0sL7sOgVR2xpaVJM&usqp=CAU"));
        list.add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpw6L6Kk4R6rWj1q0-gk4MEsfz4n10A15DjrRWe2Z9RcIhs5YdOiq9tgtKH12fVTyKCAs&usqp=CAU"));
        list.add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUmGo7DCMP-AlTnkQ2r9qpPnn2dgHCPD2Djd1hkWr1-luJ-NP3QP5psUVVurcIGW8NwSs&usqp=CAU"));
        list.add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRgGOng03lXA1nN8KBRl9KrDYuSSxossRyRhQdeyfjmzeRqAb3DSo1LFzz0jFAqpMqFBYU&usqp=CAU"));
        list.add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjHhAIy_HSCPuIjBzJLM-SgLzek5zmllrkgt5mIskogoIl0RcoBKSjNs_y0dLvq_j-Iwg&usqp=CAU"));

        mViewPagerAdapter = new MyPagerAdapter(MainActivity.this, list);

        binding.viewPagerMain.setAdapter(mViewPagerAdapter);
        binding.viewPagerMain.setPageTransformer(new ZoomOutPageTransformer());
        new TabLayoutMediator(binding.tabLayout, binding.viewPagerMain, (tab, position) -> {
        }).attach();

    }

    private void clickListeners(){

        binding.previous.setOnClickListener(View -> {

            binding.viewPagerMain.setCurrentItem(binding.viewPagerMain.getCurrentItem() - 1);

        });

        binding.next.setOnClickListener(View -> {

            binding.viewPagerMain.setCurrentItem(binding.viewPagerMain.getCurrentItem() + 1);

        });
    }

}