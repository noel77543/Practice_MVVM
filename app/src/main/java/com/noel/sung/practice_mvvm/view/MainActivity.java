package com.noel.sung.practice_mvvm.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.noel.sung.practice_mvvm.R;
import com.noel.sung.practice_mvvm.databinding.MainActivityBinding;
import com.noel.sung.practice_mvvm.viewModel.MainVM;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityBinding  mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityBinding.setLifecycleOwner(this);
        MainVM  mainVM = new ViewModelProvider(this).get(MainVM.class);
        mainActivityBinding.setViewModel(mainVM);

        mainVM.init();
        mainVM.connectToGetMainDataFromServer();
    }
}