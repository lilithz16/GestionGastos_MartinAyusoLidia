package es.ies.claudiomoyano.dam2.pmdm.gestiongastos_martinayusolidia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GastoAdapter extends RecyclerView.Adapter<GastoAdapter.ViewHolder> {

    ArrayList<Gasto> lista;

    public GastoAdapter(ArrayList<Gasto> lista) {
        this.lista = lista;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTipoGasto, txtCantidad;

        public ViewHolder(View itemView) {
            super(itemView);

            txtTipoGasto = itemView.findViewById(R.id.txtTipoGasto);
            txtCantidad = itemView.findViewById(R.id.txtCantidad);

            //para el menu
            /*
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    PopupMenu menu = new PopupMenu(v.getContext(), itemView);
                    menu.getMenuInflater().inflate(R.menu.menu_contextual, menu.getMenu());

                    menu.setOnMenuItemClickListener(item -> {
                        switch (item.getItemId()) {
                            case R.id.opEditar:
                                Toast.makeText(v.getContext(), "Editar gasto", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.opEliminar:
                                Toast.makeText(v.getContext(), "Eliminar gasto", Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return false;
                    });

                    menu.show();
                    return true;
                }
            });

             */
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gasto, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int pos) {
        Gasto g = lista.get(pos);
        holder.txtTipoGasto.setText(g.tipoGasto);
        holder.txtCantidad.setText("€" + g.cantidad);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
