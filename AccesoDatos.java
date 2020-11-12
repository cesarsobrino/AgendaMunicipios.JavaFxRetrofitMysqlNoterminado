/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agendamunicipios.javafxretrofitmysql;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 *
 * @author FP Mañana A
 */
class AccesoDatos {

    static void recogerProvincias() {
         String baseUrl = "http://ovc.catastro.meh.es//";

        //Instancia a GSON
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        
        //Instancia a retrofit agregando la baseURL y el convertidor GSON
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        
        //Se crea el servicio
        OperacionInterface service = retrofit.create(OperacionInterface.class);

        //Se realiza la llamada
        Call<Raiz> call = service.estaciones();

        //la llamada es asincronica
        //Retrofit descarga y analiza los datos del API en un subproceso en
        //paralelo y entrega los resultados a traves de los metodos
        // onFailure o onResponse
          
        call.enqueue(new Callback<Raiz>() {

            @Override
            public void onFailure(Call<Raiz> call, Throwable t) {
               System.out.println("Network Error :: " + t.getLocalizedMessage());
            }

          
            @Override
            public void onResponse(Call<Raiz> call, Response<Raiz> response) {

                   Raiz  articulo = response.body();
                   AccesoBD.introducirProvincias(articulo);
                   System.out.println(articulo);
            }
        });
    }
    
}
