package es.ies.claudiomoyano.dam2.pmdm.gestiongastos_martinayusolidia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    EditText etUsuario, etPass;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etUsuario);
        etPass = findViewById(R.id.etPass);
        btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = etUsuario.getText().toString().trim();
                String pass = etPass.getText().toString().trim();

                //lista de usuarios que pueden acceder (Se deberia ahcer con una base de datos :) )
                HashMap<String, String> usuarios = new HashMap<>();
                usuarios.put("admin", "1234");
                usuarios.put("lidia", "abcd");
                usuarios.put("inv", "0000");
                usuarios.put("usuario", "pass");

                //Comprobar si el usu introduce sus credenciales bien
                if (usuarios.containsKey(user)) {

                    if (usuarios.get(user).equals(pass)) {

                        //el user y la pass pasan al mainActivity
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        i.putExtra("usuario", user);
                        startActivity(i);

                    } else {
                        Toast.makeText(LoginActivity.this,
                                "Contraseña incorrecta",
                                Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(LoginActivity.this,
                            "El usuario no existe",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
