/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agendamunicipios.javafxretrofitmysql;

import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 *
 * @author FP Mañana A
 */
@Root(name = "consulta_provinciero",strict = false)
public class Raiz {
    @ElementList(name = "provinciero")
    List<Provincias> prov;

    public List<Provincias> getProv() {
        return prov;
    }

    public void setProv(List<Provincias> prov) {
        this.prov = prov;
    }

    @Override
    public String toString() {
        return "Raiz{" + "prov=" + prov + '}';
    }
    
    
}
