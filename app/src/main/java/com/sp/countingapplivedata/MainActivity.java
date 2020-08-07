package com.sp.countingapplivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sp.countingapplivedata.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final MainActivityViewModel model = new ViewModelProvider(this).get(MainActivityViewModel.class);
        model.getInitialCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.txt1.setText("Count is: " + integer);
            }
        });

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.getCurrentCount();
            }
        });

    }
}
