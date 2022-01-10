/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa_datos;

import basicas.Consola;
import capa_logica.Cuenta;
import capa_logica.Estado;
import capa_logica.Moneda;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Sh
 */
public class ListadoCuentas {
    private static ArrayList<Cuenta> Cuentas=new ArrayList();
    static Consola objC=new Consola();
    
    public static void agregar(Cuenta objC){
        Cuentas.add(objC);
    }
    public static ArrayList obtener(){
        return Cuentas;
    }
    public static ArrayList devolverCuentas(){
         ArrayList Aux=new ArrayList();
       
        Iterator it=Cuentas.iterator();
        while(it.hasNext()){
            Cuenta objCu=(Cuenta) it.next();
            if(objCu instanceof Cuenta){
                Aux.add(objCu);
            }
        }
        return Aux;
    }
     public static ArrayList devolverCuentasXCliente(String auxDNI){
         ArrayList Aux=new ArrayList();
        boolean band=false;
        Iterator it=Cuentas.iterator();
        while(it.hasNext()){
            Cuenta objCu=(Cuenta) it.next();
            if(objCu instanceof Cuenta){
                if(objCu.getDniCliente().equalsIgnoreCase(auxDNI)){
                    band=true;
                Aux.add(objCu);
                }
            }
        }
        if(!band)
             System.out.println("Cliente sin cuentas o no registrado..");
        return Aux;
    }
     public static void DepositarCuenta(String auxNum){
        boolean band=false;
        Iterator it=Cuentas.iterator();
        while(it.hasNext()){
            Cuenta objCu=(Cuenta) it.next();
            if(objCu instanceof Cuenta){
                if(objCu.getNumeroCuenta().equalsIgnoreCase(auxNum)){
                    double montoDepositar=objC.leer("Ingrese monto a depositar",0,20000);
                    objCu.setMontoInicial(montoDepositar+objCu.getMontoInicial());
                    band=true;
                    System.out.println("Deposito realizado exitosamente");
                }
            }
        }
       if(!band)
             System.out.println("Cuenta no registrada");
    }
     public static void RetirarCuenta(String auxNum){
        boolean band=false;
        Iterator it=Cuentas.iterator();
        while(it.hasNext()){
            Cuenta objCu=(Cuenta) it.next();
            if(objCu instanceof Cuenta){
                if(objCu.getNumeroCuenta().equalsIgnoreCase(auxNum)){
                    double montoRetirar=objC.leer("Ingrese monto a retirar",0,objCu.getMontoInicial());
                    objCu.setMontoInicial(objCu.getMontoInicial()-montoRetirar);
                    band=true;
                    System.out.println("Retiro realizado exitosamente");
                }
            }
        }
       if(!band)
             System.out.println("Cuenta no registrada");
    }
     public static void CerrarCuenta(String auxNum){
        boolean band=false;
        Iterator it=Cuentas.iterator();
        while(it.hasNext()){
            Cuenta objCu=(Cuenta) it.next();
            if(objCu instanceof Cuenta){
                if(objCu.getNumeroCuenta().equalsIgnoreCase(auxNum)){
                    objCu.setTipoEstado(Estado.CERRADA);
                    band=true;
                    System.out.println("Cuenta Cerrada");
                }
            }
        }
       if(!band)
             System.out.println("Cuenta no registrada");
    }
     public static ArrayList CuentaxAño(Date fComparacion){
         ArrayList Aux=new ArrayList();
        boolean band=false;
        Iterator it=Cuentas.iterator();
        while(it.hasNext()){
            Cuenta objCu=(Cuenta) it.next();
            if(objCu instanceof Cuenta){
                if(objCu.getFechaApertura().getYear()==fComparacion.getYear()){
                    band=true;
                    Aux.add(objCu);
                }
            }
        }
       if(!band)
             System.out.println("Cuenta no registradas en ese año");
       return Aux;
    }
     public static ArrayList devolverCuentasCerradas(){
         ArrayList Aux=new ArrayList();
       
        Iterator it=Cuentas.iterator();
        while(it.hasNext()){
            Cuenta objCu=(Cuenta) it.next();
            if(objCu instanceof Cuenta){
                if(objCu.getTipoEstado().equals(Estado.CERRADA))
                Aux.add(objCu);
            }
        }
        return Aux;
    }
     public static int[] CantidadCuentasxMoneda(){
     int c[]=new int[3];
     Iterator it=Cuentas.iterator();
    while(it.hasNext()){
        Cuenta objCu=(Cuenta) it.next();
          if(objCu instanceof Cuenta){
           if(objCu.getTipoMoneda().equals(Moneda.DOLARES))  
               c[0]++;
          if(objCu.getTipoMoneda().equals(Moneda.EUROS))  
               c[1]++;
          if(objCu.getTipoMoneda().equals(Moneda.SOLES))  
               c[2]++;
          }
              
     }
    return c;
 }
}
