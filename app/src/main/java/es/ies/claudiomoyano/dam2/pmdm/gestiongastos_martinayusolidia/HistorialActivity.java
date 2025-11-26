package es.ies.claudiomoyano.dam2.pmdm.gestiongastos_martinayusolidia;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistorialActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        rv = findViewById(R.id.rvGastos);

        ArrayList<Gasto> lista = new ArrayList<>();
        lista.add(new Gasto("Comida", 15));
        lista.add(new Gasto("Taxi", 8));
        lista.add(new Gasto("Compras", 40));

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new GastoAdapter(lista));
    }
}
