package mx.com.cristian.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opc, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }



    @Override
    /////ESTO SERVIRA DE MUCHO
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.mAbout:
                Intent intent =new Intent(this,contact.class);
                startActivity(intent);
                break;
            case R.id.mSettings:
                Intent intent2 =new Intent(this,AcercaDe.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
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

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
        MenuInflater inflater= new MenuInflater(this);


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.mEditar:
                Toast.makeText(this,getResources().getString(R.string.text_editar),Toast.LENGTH_SHORT).show();

                //Intent intent =new Intent(this,ActivityAbout.class);
                //startActivity(intent);
                break;
            case R.id.mEliminar:
                Toast.makeText(this,getResources().getString(R.string.text_eliminar),Toast.LENGTH_SHORT).show();

                //Intent intent2 =new Intent(this,ActivitySettings.class);
                //startActivity(intent2);
                break;
        }

        return super.onContextItemSelected(item);
    }



}
