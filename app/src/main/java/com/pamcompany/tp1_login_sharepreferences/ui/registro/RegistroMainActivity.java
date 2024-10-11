package com.pamcompany.tp1_login_sharepreferences.ui.registro;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.pamcompany.tp1_login_sharepreferences.R;
import com.pamcompany.tp1_login_sharepreferences.databinding.RegistroActivityMainBinding;

public class RegistroMainActivity extends AppCompatActivity {

    private RegistroViewModel vm;
    private RegistroActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = RegistroActivityMainBinding.inflate(getLayoutInflater());
        vm =  ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroViewModel.class);
        setContentView(binding.getRoot());

    }
}