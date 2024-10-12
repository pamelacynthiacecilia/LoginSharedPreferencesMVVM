package com.pamcompany.tp1_login_sharepreferences.ui.registro;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.pamcompany.tp1_login_sharepreferences.ui.ErrorDialog;
import com.pamcompany.tp1_login_sharepreferences.databinding.RegistroActivityMainBinding;
import com.pamcompany.tp1_login_sharepreferences.ui.SuccessDialog;

public class RegistroMainActivity extends AppCompatActivity {

    private RegistroViewModel vm;
    private RegistroActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = RegistroActivityMainBinding.inflate(getLayoutInflater());
        vm =  ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroViewModel.class);
        setContentView(binding.getRoot());

        vm.getMjeError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String error) {
                if (error != null) {
                    ErrorDialog.showErrorDialog(RegistroMainActivity.this, "Error de registro", error);
                }
            }
        });

        vm.getMjeSuccess().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String mjeExito) {
                if (mjeExito != null) {
                    SuccessDialog.showErrorDialog(RegistroMainActivity.this, "Exito",mjeExito );
                }
            }
        });

        binding.btGuardarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.registrarUsuario(binding.etDni.getText().toString(), binding.etNombre.getText().toString(),binding.etApellido.getText().toString(), binding.etEmail.getText().toString(), binding.etPassword.getText().toString());
            }
        });


    }
}