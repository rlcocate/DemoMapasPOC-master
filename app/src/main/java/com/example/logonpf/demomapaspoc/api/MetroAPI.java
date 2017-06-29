package com.example.logonpf.demomapaspoc.api;

import com.example.logonpf.demomapaspoc.model.Estacao;
import com.example.logonpf.demomapaspoc.model.Linha;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface MetroAPI {

    @GET("/linhas")
    Observable<List<Linha>> getLinhas();

    @GET("/linhas/{linha}/estacoes")
    Observable<List<Estacao>> getEstacoes(@Path("linha") String linha);
}
