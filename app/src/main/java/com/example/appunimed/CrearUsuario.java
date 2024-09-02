package com.example.appunimed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;

public class CrearUsuario extends AppCompatActivity {
    EditText nombre,apellido,codigo,nuevousuario,nuevacontraseña,direccion;
    Button crearUsuario;
    ArrayList<Usuario>usuarios=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_usuario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nombre=findViewById(R.id.txtNombre);
        apellido=findViewById(R.id.txtApellidos);
        codigo=findViewById(R.id.txtAsegurado);
        nuevousuario=findViewById(R.id.txtUsuarioNuevo);
        nuevacontraseña=findViewById(R.id.txtContraseñaNueva);
        direccion=findViewById(R.id.txtDireccion);
        crearUsuario=findViewById(R.id.btnCrearNuevoUsuario);
        usuarios= (ArrayList<Usuario>) getIntent().getSerializableExtra("ListUsuarios");
    }
    public void CrearNuevoUsuario (View v){
        Usuario us=new Usuario(nombre.getText().toString(),apellido.getText().toString(),codigo.getText().toString(),nuevousuario.getText().toString(),nuevacontraseña.getText().toString(),direccion.getText().toString());
        usuarios.add(us);
        Intent it=new Intent(getApplicationContext(), MainActivity.class);
        it.putExtra("ListaNueva", (Serializable) usuarios);
        startActivity(it);
    }
}