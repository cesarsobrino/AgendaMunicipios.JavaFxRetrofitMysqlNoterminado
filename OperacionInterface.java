/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agendamunicipiosprovinciasretrofitjavafxmysql;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 *
 * @author FP Mañana A
 */
public interface OperacionInterface {
    @GET("ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/ConsultaProvincia")
    Call<Raiz> estaciones();    
}