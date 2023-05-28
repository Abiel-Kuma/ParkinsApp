package com.example.appexamen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText usuario, contrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.InicializarControles();
        this.ValidarLogin();

    }
    private void ValidarLogin() {
        SharedPreferences usuarioLogueado = getSharedPreferences("Login", Context.MODE_PRIVATE);

        String usuario = usuarioLogueado.getString("u","");
        if(!usuario.equals("")){
            startActivity(new Intent(this, Parkins_Clientes.class));
        }
    }

    private void InicializarControles() {
        usuario = (EditText)findViewById(R.id.txtUser);
        contrasena = (EditText)findViewById(R.id.txtPassword);
    }

    public void ValidarUser (View v){
        try{
            String userIngresado = usuario.getText().toString();
            String passIngresado = contrasena.getText().toString();

            List<Usuarios> usuarios = FileToList();
            boolean logueado = false;

            for (Usuarios usuario : usuarios){

                if(userIngresado.equals(usuario.getUsuario()) && passIngresado.equals(usuario.getContrasena())){
                    SharedPreferences user =
                            getSharedPreferences("Login", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor  = user.edit();
                    editor.putString("n",usuario.getNombre());
                    editor.putString("c",usuario.getCedula());
                    editor.putInt("e",usuario.getEdad());
                    editor.putString("u",usuario.getUsuario());
                    editor.putString("p",usuario.getContrasena());

                    editor.commit();

                    logueado = true;

                    startActivity(new Intent(this, Parkins_Clientes.class));
                }
            }

            if(!logueado)
                this.Notify("Usuario o cantraseña equivocados");

        }catch (Exception e){
            this.Notify("Error = "+e.getMessage());
        }
    }

    private void Notify(String mensajito){
        Toast.makeText(this,mensajito,Toast.LENGTH_LONG).show();
    }

    private List<Usuarios> FileToList(){
        List<Usuarios> usuarios = new ArrayList<Usuarios>();

        try {
            BufferedReader bf =
                    new BufferedReader(new InputStreamReader(
                            openFileInput("credenciales.txt")));
            String datos = bf.readLine();

            String[] arrUsuarios = datos.split("~");

            for (String strUsuario : arrUsuarios){
                String[] camposUsuario = strUsuario.split("\\|");

                Usuarios usuario = new Usuarios(
                        camposUsuario[0],
                        camposUsuario[1],
                        Integer.parseInt(camposUsuario[2]),
                        camposUsuario[3],
                        camposUsuario[4]
                );

                usuarios.add(usuario);
            }
        }catch (Exception e){
            this.Notify("Error = "+e.getMessage());
        }

        return usuarios;
    }

    public void Register (View v){
        startActivity(new Intent(this,Registrarse.class));
    }
}