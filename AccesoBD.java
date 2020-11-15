/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agendamunicipiosprovinciasretrofitjavafxmysql;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FP Mañana A
 */
class AccesoBD {

    private static Connection conexcion=null;
    private static Statement stmt=null;
    
    //conectaBBDD
    static void conectar() {
        try {
            conexcion=DriverManager.getConnection("jdbc:mysql://localhost:3306/espanita", "root", "");
            stmt= conexcion.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    //Saber si hay provincias en mysql
    static boolean mirarProvincias() {
            Boolean n = null;
        String sql="SELECT COUNT(*) as numero FROM provincias;";
        
		try {
                    int nprovincias=0;
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
                        {
			 nprovincias=rs.getInt("numero");
                        }
                        if (nprovincias!=0) {
                        n=true;
                    }else{
                        n=false;    
                        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
    }

    static ArrayList introducirProvincias(Raiz a) {
       ArrayList<Provincias2> array_pro=new ArrayList<>();
       try {
             String sql="INSERT INTO provincias(pin,nombre) VALUES ('01','Incio')";
        for (Provincias p : a.getProv()) {
            sql=sql+",('"+p.getPin()+"','"+p.getNombre()+"')";
            Provincias2 pr2=new Provincias2(p.getNombre(),p.getPin());
            array_pro.add(pr2);
            
        }
           stmt.executeUpdate(sql);
            System.out.println(sql);
        } catch (SQLException ex) {
           Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array_pro;
    }

    static ArrayList<String> recogerDatosProvincias() {
        
        ArrayList<String> lista_provincias=new ArrayList<String>();
		
		String sql="SELECT * FROM provincias;";
		try {
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				String nombre_pro=rs.getString("nombre");			
				lista_provincias.add(nombre_pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_provincias;
        
        
    }
    
}