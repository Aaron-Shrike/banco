/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa_datos;

import basicas.Consola;
import capa_logica.Cliente;
import capa_logica.Cuenta;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sh
 */
public class ListadoClientes {
      private static ArrayList<Cliente> Clientes=new ArrayList();
    static Consola objC=new Consola();
    
    public static void agregar(Cliente objC){
        Clientes.add(objC);
    }
    public static ArrayList obtener(){
        return Clientes;
    }
    public static ArrayList devolverClientes(){
         ArrayList Aux=new ArrayList();
       
        Iterator it=Clientes.iterator();
        while(it.hasNext()){
            Cliente objCl=(Cliente) it.next();
            if(objCl instanceof Cliente){
                Aux.add(objCl);
            }
        }
        return Aux;
    }
       public static boolean validaCliente(String auxDNI){
       boolean band=false;
        Iterator it=Clientes.iterator();
        while(it.hasNext()){
            Cliente objCl=(Cliente) it.next();
            if(objCl instanceof Cliente){
                if(objCl.getDni().equalsIgnoreCase(auxDNI))
                  band=true;
            }
        }
       return band;
    }    
}
