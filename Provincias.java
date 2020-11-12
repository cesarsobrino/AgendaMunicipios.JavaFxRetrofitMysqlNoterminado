/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agendamunicipios.javafxretrofitmysql;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *
 * @author FP Mañana A
 */
@Root(strict = false,name="prov")
public class Provincias {
    @Element(name = "np")
    private String nombre;
     @Element(name = "cpine")
    private String pin;

    public Provincias(String nombre, String pin) {
        this.nombre = nombre;
        this.pin = pin;
    }

     
     
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Provincias{" + "nombre=" + nombre + ", pin=" + pin + '}';
    }
     
}
