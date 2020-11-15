/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agendamunicipiosprovinciasretrofitjavafxmysql;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author FP Mañana A
 */
public class ClasePrincipal extends Application{
    ChoiceBox cb1;
    ChoiceBox cb2;
    boolean provincias;
    ArrayList<Provincias2> array_provincias;
    ArrayList<String> strings_provincias;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Aplicaion interfaz
        //1.Conectar BBDD
        AccesoBD.conectar();
        //2.Comprobar si la tabla de provincias de mysql esta vacia o llena
          
            
        provincias=AccesoBD.mirarProvincias();
        if (provincias==false){
            
        //2.1 Si provincias no es distinto de 0 entonces que lo rellene en mysql con retrofit
        array_provincias=AccesoDatos.recogerProvincias();
       
        }
       
       strings_provincias=AccesoBD.recogerDatosProvincias();
        
        
        //4.Creo la escena con todo
        VBox v=new VBox(30);
        Label lb1=new Label("Provincias");
        cb1=new ChoiceBox();
        cb1.setItems(FXCollections.observableList(strings_provincias));
        
        Label lb2=new Label("Municipios");
        cb2=new ChoiceBox();
        
        Button btn=new Button("NOSE");
        v.getChildren().addAll(lb1,cb1,lb2,cb2,btn);
        

        ChangeListener ch=new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               
            }
        };


        
       //4.1 Creo la escena
       Scene escena=new Scene(v,300,600);
       stage.setScene(escena);
       stage.show();
        
        
        System.out.println("Terminado final");
    }
    
}