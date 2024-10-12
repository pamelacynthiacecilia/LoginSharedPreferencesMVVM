package com.pamcompany.tp1_login_sharepreferences.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.pamcompany.tp1_login_sharepreferences.model.Usuario;

public class ApiClient {
    private static SharedPreferences sp;
    private static SharedPreferences conectar(Context context){
        if(sp==null){
            sp= context.getSharedPreferences("datos", 0);
        }
        return sp;
    }

    public static void guardar(Context context, Usuario usuario){
        SharedPreferences sp= conectar(context);
        SharedPreferences.Editor editor= sp.edit();
        editor.putLong("dni",usuario.getDni());
        editor.putString("apellido",usuario.getApellido());
        editor.putString("nombre",usuario.getNombre());
        editor.putString("email",usuario.getEmail());
        editor.putString("password",usuario.getPassword());
        editor.commit();
    }

    public static Usuario leer(Context context){
        SharedPreferences sp= conectar(context);
        long dni= sp.getLong("dni", -1);
        String apellido= sp.getString("apellido", "-1");
        String nombre= sp.getString("nombre", "-1");
        String email= sp.getString("email","-1");
        String pass= sp.getString("password", "-1");

        Usuario usuario= new Usuario(dni,apellido,nombre,email,pass);
        return usuario;
    }

    public static Usuario login(Context context,String mail, String pass){
        Usuario usuario;
        SharedPreferences sp= conectar(context);
        long dni=sp.getLong("dni",-1);
        String apellido= sp.getString("apellido","-1");
        String nombre= sp.getString("nombre","-1");
        String email= sp.getString("email","-1");
        String password= sp.getString("password","-1");

        if(email.equals(mail) && password.equals(pass)) {
            usuario = new Usuario(dni, apellido, nombre, email, password);
        }else {
            usuario=null;
        }
        return usuario;
    }

}