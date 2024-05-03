package com.example.parcial2;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2.adaptadores.UsuarioAdaptador;
import com.example.parcial2.clases.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv_usuarios;
    List<Usuario> listaUsuarios = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_usuarios = findViewById(R.id.rcv_usuarios);

        Usuario user1 = new Usuario("https://rickandmortyapi.com/api/character/avatar/72.jpeg","Rick Sanchez","Human","Alive","tierra","masculino","city");
        Usuario user2= new Usuario("https://rickandmortyapi.com/api/character/avatar/120.jpeg","Morty Smith","Human","Alive","tierra","masculino","city");
        Usuario user3 = new Usuario("https://rickandmortyapi.com/api/character/avatar/190.jpeg","Summer Smith","Human","Alive","tierra","Femenino","city");
        Usuario user4 = new Usuario("https://rickandmortyapi.com/api/character/avatar/241.jpeg","Beth Smith","Human","Alive","tierra","Femenino","city");
        Usuario user5 = new Usuario("https://rickandmortyapi.com/api/character/avatar/201.jpeg","Jerry Smith","Human","Alive","tierra","masculino","city");

        listaUsuarios.add(user1);
        listaUsuarios.add(user2);
        listaUsuarios.add(user3);
        listaUsuarios.add(user4);
        listaUsuarios.add(user5);

        rcv_usuarios.setLayoutManager(new LinearLayoutManager(this));
        rcv_usuarios.setAdapter(new UsuarioAdaptador(listaUsuarios, new UsuarioAdaptador.OnItemClickListener() {
            @Override
            public void onItemClick(Usuario dato) {
                moveToDescription(dato);
            }
        }));

    }

    public void moveToDescription(Usuario dato) {
        Intent intent = new Intent(this,DescriptionActivity.class);
        intent.putExtra("Usuario",dato);
        startActivity(intent);
    }
}