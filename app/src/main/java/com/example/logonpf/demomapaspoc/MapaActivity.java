package com.example.logonpf.demomapaspoc;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.logonpf.demomapaspoc.adapter.LinhaAdapter;
import com.example.logonpf.demomapaspoc.api.MetroAPI;
import com.example.logonpf.demomapaspoc.model.Estacao;
import com.example.logonpf.demomapaspoc.model.Linha;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MapaActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Linha linha;
    private LinhaAdapter mAdapter;
    private MetroAPI mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if (getIntent() != null){
            // Pega a classe parceabled da outra tela.
            linha = getIntent().getParcelableExtra("LINHA");
        }
    }


    public void loadEstacoes() {

        mService.getEstacoes(linha.getCor().toString())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Estacao>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getApplicationContext(), "Erro ao carregar estacoes!!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(List<Estacao> estacoes) {
                        Iterator<Estacao> i = estacoes.iterator();
                        while (i.hasNext()){
                            Estacao e = i.next();
                            loadEstacao(e);

                        }
                    }
                });
    }

    private void loadEstacao(Estacao e) {
        mMap = googleMap;

        LatLng posicao = new LatLng(-31,-42);
        mMap.addMarker(new MarkerOptions().position(posicao).title("Linha"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sidney, 17));
    }


//Toast.makeText(getApplicationContext(), "Erro ao carregar estações da linha " + linha.getCor().toString() + "!!", Toast.LENGTH_LONG).show();
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        loadEstacao();
        LatLng posicao = new LatLng(-31,-42);
        mMap.addMarker(new MarkerOptions().position(posicao).title("Linha"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sidney, 17));

    }
}
