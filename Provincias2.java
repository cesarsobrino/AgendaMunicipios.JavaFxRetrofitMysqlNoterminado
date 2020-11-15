/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agendamunicipiosprovinciasretrofitjavafxmysql;

/**
 *
 * @author cesar
 */
public class Provincias2 {
    
    private String nombre,codigo;

    public Provincias2(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Provincias2{" + "nombre=" + nombre + ", codigo=" + codigo + '}';
    }
    
}
