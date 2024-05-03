package com.example.parcial2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.parcial2.clases.Usuario;
import com.google.android.material.imageview.ShapeableImageView;
import com.squareup.picasso.Picasso;


public class DescriptionActivity extends AppCompatActivity {
    TextView txt_title,txt_description;
    ShapeableImageView img_usuario;
    Button btn_cerrar;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("Usuario");
        txt_title = findViewById(R.id.txt_title);
        txt_description = findViewById(R.id.txt_description);
        img_usuario = findViewById(R.id.img_usuario);
        btn_cerrar = findViewById(R.id.btn_cerrar);

        assert usuario != null;
        txt_title.setText(usuario.getNombre());
        txt_description.setText(usuario.getDescripcion());
        Picasso.get().load(usuario.getImagen()).into(img_usuario);
        sharedPreferences = getSharedPreferences(Login.dataUser, Login.modo_private);
        editor= sharedPreferences.edit();

        btn_cerrar.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                editor.remove("usuario");
                editor.apply();
                Intent intent = new Intent(DescriptionActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        });

    }
}