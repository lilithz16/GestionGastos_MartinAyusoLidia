package es.ies.claudiomoyano.dam2.pmdm.gestiongastos_martinayusolidia;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {
    TextView txtBienvenido;
    EditText etCantidad;
    Spinner spAccion;
    Button btnHistorial, btnVolver;
    private double totalCuenta = 1000.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBienvenido = findViewById(R.id.txtBienvenido);
        etCantidad = findViewById(R.id.etCantidad);
        spAccion = findViewById(R.id.spAccion);
        btnHistorial = findViewById(R.id.btnHistorial);
        btnVolver = findViewById(R.id.btnVolver);

        //spinner
        String opciones[] = {"Selecciona acción", "Comida", "Transporte", "Compras"};
        spAccion.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones));

        //salta el mensaje de bienvenida
        String usuario = getIntent().getStringExtra("usuario");
        txtBienvenido.setText("Bienvenido " + usuario);

        //permiso
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

        //para hacer movimientos
        btnHistorial.setOnClickListener(v -> {

            String cantidadStr = etCantidad.getText().toString();

            if (cantidadStr.isEmpty()) {
                Toast.makeText(this, "Ingresa una cantidad", Toast.LENGTH_SHORT).show();
                return;
            }

            double cantidad = Double.parseDouble(cantidadStr);
            String accion = spAccion.getSelectedItem().toString();

            switch (accion) {

                case "Comida":
                case "Transporte":
                case "Compras":
                    totalCuenta -= cantidad; // RESTA porque son gastos
                    break;

                case "Selecciona acción":
                    Toast.makeText(this, "Selecciona una categoría válida", Toast.LENGTH_SHORT).show();
                    return;
            }

            Toast.makeText(this, "Total actual: $" + totalCuenta, Toast.LENGTH_LONG).show();

            // Ir al historial después de restar
            Intent i = new Intent(MainActivity.this, HistorialActivity.class);
            startActivity(i);
        });

        //ir a la parte del historial
        btnHistorial.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, HistorialActivity.class);
            startActivity(i);
        });

        //volver
        btnVolver.setOnClickListener(v -> finish());
    }

    //Menuuus
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.opPerfil:
                Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.opAjustes:
                Toast.makeText(this, "Ajustes", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.opSalir:
                finishAffinity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
*/

    //menu lateral
    DrawerLayout drawerLayout;
    ListView lvMenu;
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout); //la clase de main activity tiene que ser drawer layout y no va por eso :(
        lvMenu = findViewById(R.id.lvMenu);

        String[] opciones = {"Inicio", "Historial", "Configuración", "Ayuda"};
        lvMenu.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, opciones));

        lvMenu.setOnItemClickListener((parent, view, position, id) -> {
            switch (position) {
                case 0:
                    Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    startActivity(new Intent(this, HistorialActivity.class));
                    break;
                case 2:
                    Toast.makeText(this, "Configuración", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(this, "Ayuda", Toast.LENGTH_SHORT).show();
                    break;
            }
            drawerLayout.closeDrawers();
        });
    }

 */
}