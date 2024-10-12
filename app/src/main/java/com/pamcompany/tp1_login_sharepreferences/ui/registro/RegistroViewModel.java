package com.pamcompany.tp1_login_sharepreferences.ui.registro;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.pamcompany.tp1_login_sharepreferences.model.Usuario;
import com.pamcompany.tp1_login_sharepreferences.request.ApiClient;

public class RegistroViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<String> mjeError;
    private MutableLiveData<String> mjeSuccess;
    public RegistroViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<String> getMjeError(){
        if (mjeError == null){
            mjeError = new MutableLiveData<>();
        }
        return mjeError;
    }

    public LiveData<String> getMjeSuccess(){
        if (mjeSuccess == null){
            mjeSuccess = new MutableLiveData<>();
        }
        return mjeSuccess;
    }

    public void registrarUsuario(String dni,String nombre, String apellido, String email, String password ) {
        if (validaCampos(dni,nombre,apellido,email,password)) {
            Usuario usuario = new Usuario(Long.parseLong(dni), nombre, apellido, email, password);
            ApiClient.guardar(context,usuario);
            mjeSuccess.setValue("Exito al guardar el registro");
        }
    }

    private boolean validaCampos(String dni, String nombre, String apellido, String email, String password){

            boolean sinError = true;
            if (dni.isBlank() || nombre.isBlank() || apellido.isBlank() || email.isBlank() ||password.isBlank() ) {
                mjeError.setValue("Debe completar el valor de todos los campos");
                sinError = false;
            }

            return sinError;
        }

    }
