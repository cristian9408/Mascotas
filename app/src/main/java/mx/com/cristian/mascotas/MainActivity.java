package mx.com.cristian.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascostas();
        inicializarAdaptador();
    }

    public void presionoBoton(View v){
        Intent intent = new Intent(this, MainActivity2.class);
        System.out.println(intent);

        startActivity(intent);
    }


    public  mascotaAdaptador adaptador;


    public void inicializarAdaptador(){
        adaptador= new mascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    public void  inicializarListaMascostas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.cachorro,"Tatis", "0"));
        mascotas.add(new Mascota(R.drawable.user,"Tommy", "0"));
        mascotas.add(new Mascota(R.drawable.descarga,"Dranzer", "0"));
        mascotas.add(new Mascota(R.drawable.images,"Coraje", "0"));
        mascotas.add(new Mascota(R.drawable.cachorro,"Draciel", "0"));
    }


}
