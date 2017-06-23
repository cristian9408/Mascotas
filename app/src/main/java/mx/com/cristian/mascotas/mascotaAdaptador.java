package mx.com.cristian.mascotas;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import static android.widget.Toast.LENGTH_SHORT;

public class mascotaAdaptador extends RecyclerView.Adapter<mascotaAdaptador.mascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public mascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;
    }

    @Override
    public mascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);

        return new mascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder (final mascotaViewHolder mascotaViewHolder, int position){
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgImg.setImageResource(mascota.getImg());
        mascotaViewHolder.textViewNombre.setText(mascota.getNombre());
        mascotaViewHolder.numText.setText(mascota.getCali());


        mascotaViewHolder.huesoBlanco.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                Toast.makeText(activity, "Le diste me gusta, al Perro " +  mascota.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public int getItemCount(){
      return mascotas.size();
    }

    public static class mascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgImg;
        private TextView textViewNombre;
        private TextView numText;
        private ImageView huesoBlanco;

        public mascotaViewHolder(View itemView){
            super(itemView);
            imgImg =(ImageView) itemView.findViewById(R.id.imgImg);
            textViewNombre= (TextView) itemView.findViewById(R.id.textViewNombre);
            numText = (TextView) itemView.findViewById(R.id.numText);
            huesoBlanco = (ImageView) itemView.findViewById(R.id.huesoBlanco);
        }
    }
}
