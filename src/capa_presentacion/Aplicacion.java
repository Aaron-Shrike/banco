/*
 * To change this license header, choose License Headers in Project Properties.1

 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa_presentacion;

import LibMenu.Menu;
import LibMenu.Opcion;
import basicas.Consola;
import capa_datos.ListadoClientes;
import capa_datos.ListadoCuentas;
import capa_logica.Cliente;
import capa_logica.Cuenta;
import capa_logica.Moneda;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sh
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Menu  objMenu = new Menu();
        Consola objC = new Consola();
        
        int opc;
        definirmenu(objMenu);       
        do{
            opc = objMenu.display();
            switch(opc)
            {
                case 11:Cliente objCl=new Cliente();
                        String dni=objC.leer("Ingrese DNI : ");
                        objCl.setDni(dni);
                        String nombre=objC.leer("Ingrese nombre : ");
                        objCl.setNombre(nombre);
                        String apellidoPaterno=objC.leer("Ingrese apellido Paterno : ");
                        objCl.setApellidoPaterno(apellidoPaterno);
                        String apellidoMaterno=objC.leer("Ingrese apellido materno : ");
                        objCl.setApellidoMaterno(apellidoMaterno);
                        
                            int dia=objC.leer("Ingrese dia nacimiento[1-31] : ",1,31);
                            int mes=objC.leer("Ingrese mes nacimiento[1-12] : ",1,12);
                            int año=objC.leer("Ingrese año nacimiento[1900-2020] : ",1900,2020);
                        objCl.setFNacimiento(new Date(año,mes,dia));  
                        String direccion=objC.leer("Ingrese direccion : ");
                        objCl.setDireccion(direccion);
                        String telefono=objC.leer("Ingrese telefono : ");
                        objCl.setTelefono(telefono);
                        ListadoClientes.agregar(objCl);
                        System.out.println("\t* Cliente registrado.");
                        break;      
                case 12:  Cuenta objCu=new Cuenta();
                          String numeroCuenta=objC.leer("Ingrese num cuenta : ");
                          objCu.setNumeroCuenta(numeroCuenta);
                         
                           int diaa=objC.leer("Ingrese dia[1-31] : ",1,31);
                            int mess=objC.leer("Ingrese mes[1-12] : ",1,12);
                            int añoo=objC.leer("Ingrese año[1900-2020] : ",1900,2020);
                        objCu.setFechaApertura(new Date(añoo,mess,diaa));   
                         double monto=objC.leer("Ingrese monto inicial[0-200.000] : ",0,200000);
                         objCu.setMontoInicial(monto);
                       
                           System.out.println("1."+Moneda.DOLARES.name()+"\n2."+Moneda.EUROS.name()+"\n3."+Moneda.SOLES.name());int op1=objC.leer("Ingrese tipo moneda[1-3] : ", 1, 3);
                                   switch(op1){
                                      case 1: ((Cuenta) objCu).setTipoMoneda(Moneda.DOLARES); break;
                                      case 2: ((Cuenta) objCu).setTipoMoneda(Moneda.EUROS); break;
                                      case 3: ((Cuenta) objCu).setTipoMoneda(Moneda.SOLES); break;}
                          String dniCliente=objC.leer("Ingrese Dni Cliente : ");
                          if( ListadoClientes.validaCliente(dniCliente)){
                              objCu.setDniCliente(dniCliente);
                              ListadoCuentas.agregar(objCu);
                              System.out.println("\t* Cuenta registrada.");
                          }else{
                              System.out.println("\t* Cliente no registrado");
                          }
                        break;   
                case 21:String auxdni=objC.leer("Ingrese numero de cuenta : ");
                        ListadoCuentas.DepositarCuenta(auxdni);         
                        break; 
                case 22:String auxdnii=objC.leer("Ingrese numero de cuenta : ");
                        ListadoCuentas.RetirarCuenta(auxdnii);
                        break;
                case 23: String auxdniii=objC.leer("Ingrese numero de cuenta : ");
                        ListadoCuentas.CerrarCuenta(auxdniii);
                        break;
                case 31:ArrayList T1=ListadoClientes.devolverClientes();
                        Iterator it1=T1.iterator();
                        
                        //String dni, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String direccion, String telefono
                        System.out.println("");
                        while(it1.hasNext()){
                             Cliente C=(Cliente) it1.next();
                             System.out.println("Dni: "+C.getDni());
                             System.out.println("nombre: "+C.getNombre());
                             System.out.println("apellidoPaterno: "+C.getApellidoPaterno());
                             System.out.println("apellidoMaterno: "+C.getApellidoMaterno());
                             System.out.println("fechaNacimiento: "+C.getFNacimiento().getDate()+"/"+C.getFNacimiento().getMonth()+"/"+C.getFNacimiento().getYear());
                             System.out.println("direccion: "+C.getDireccion());
                             System.out.println("telefono: "+C.getTelefono());
                        }
                        
                        break;
               
                case 32://String numeroCuenta, Date fechaApertura, double montoInicial, Moneda tipoMoneda, Estado tipoEstado, String dniCliente
                        ArrayList T2=ListadoCuentas.devolverCuentas();
                        Iterator it2=T2.iterator();
                        System.out.println("");
                        while(it2.hasNext()){
                             Cuenta C=(Cuenta) it2.next();
                             System.out.println("numeroCuenta: "+C.getNumeroCuenta());
                             System.out.println("fechaApertura: "+C.getFechaApertura().getDate()+"/"+C.getFechaApertura().getMonth()+"/"+C.getFechaApertura().getYear());
                             System.out.println("montoInicial: "+C.getMontoInicial());
                             System.out.println("tipoMoneda: "+C.getTipoMoneda().name());
                             System.out.println("tipoEstado: "+C.getTipoEstado().name());
                             System.out.println("dniCliente: "+C.getDniCliente());
                        }
                        break;
                case 33: 
                         int d=objC.leer("Ingrese dia[1-31] : ",1,31);
                         int m=objC.leer("Ingrese mes[1-12] : ",1,12);
                         int a=objC.leer("Ingrese año[1900-2020] : ",1900,2020);
                         Date fComparacion=new Date(a,m,d);
                         ArrayList T3=ListadoCuentas.CuentaxAño(fComparacion);
                         Iterator it3=T3.iterator();
                         System.out.println("");
                        while(it3.hasNext()){
                             Cuenta C=(Cuenta) it3.next();
                             System.out.println("numeroCuenta: "+C.getNumeroCuenta());
                             System.out.println("fechaApertura: "+C.getFechaApertura().getDate()+"/"+C.getFechaApertura().getMonth()+"/"+C.getFechaApertura().getYear());
                             System.out.println("montoInicial: "+C.getMontoInicial());
                             System.out.println("tipoMoneda: "+C.getTipoMoneda().name());
                             System.out.println("tipoEstado: "+C.getTipoEstado().name());
                             System.out.println("dniCliente: "+C.getDniCliente());
                        }
                        break;
                 case 34:
                        String Auxdni=objC.leer("Ingrese Dni Cliente : ");
                        ArrayList T4=ListadoCuentas.devolverCuentasXCliente(Auxdni);
                        Iterator it4=T4.iterator();
                        System.out.println("");
                        while(it4.hasNext()){
                             Cuenta C=(Cuenta) it4.next();
                             System.out.println("numeroCuenta: "+C.getNumeroCuenta());
                             System.out.println("fechaApertura: "+C.getFechaApertura().getDate()+"/"+C.getFechaApertura().getMonth()+"/"+C.getFechaApertura().getYear());
                             System.out.println("montoInicial: "+C.getMontoInicial());
                             System.out.println("tipoMoneda: "+C.getTipoMoneda().name());
                             System.out.println("tipoEstado: "+C.getTipoEstado().name());
                             System.out.println("dniCliente: "+C.getDniCliente());
                        }
                        break;
                 case 35:  int c[]=ListadoCuentas.CantidadCuentasxMoneda();
                          
                        System.out.println("Moneda Dolares: "+c[0]);
                        System.out.println("Moneda Euros: "+c[1]);
                        System.out.println("Moneda Soles: "+c[2]);
                        break;
                case 36:ArrayList T5=ListadoCuentas.devolverCuentasCerradas();
                        Iterator it5=T5.iterator();
                        System.out.println("");
                        while(it5.hasNext()){
                             Cuenta C=(Cuenta) it5.next();
                             System.out.println("numeroCuenta: "+C.getNumeroCuenta());
                             System.out.println("fechaApertura: "+C.getFechaApertura().getDate()+"/"+C.getFechaApertura().getMonth()+"/"+C.getFechaApertura().getYear());
                             System.out.println("montoInicial: "+C.getMontoInicial());
                             System.out.println("tipoMoneda: "+C.getTipoMoneda().name());
                             System.out.println("tipoEstado: "+C.getTipoEstado().name());
                             System.out.println("dniCliente: "+C.getDniCliente());
                        }
                        
                        break;    
                    
            }            
        }while(opc != 99);
        System.out.println("\tFIN DEL SISTEMA");
    }
      public static void definirmenu(Menu objMenu)
    {
        objMenu.agregar(new Opcion(11,"Registrar Cliente"));
        objMenu.agregar(new Opcion(12,"Registar Cuenta"));
        
        objMenu.agregar(new Opcion(21,"Depositar dinero en una cuenta"));
        objMenu.agregar(new Opcion(22,"Retirar dinero de una cuenta"));
        objMenu.agregar(new Opcion(23,"Cerrar una Cuenta"));
        
        objMenu.agregar(new Opcion(31,"Listado de clientes"));
        objMenu.agregar(new Opcion(32,"Listado de cuentas")); 
        objMenu.agregar(new Opcion(33,"Mostrar las cuentas creadas en un año especifico")); 
        objMenu.agregar(new Opcion(34,"Listado de las cuentas de un cliente especifico")); 
        objMenu.agregar(new Opcion(35,"Mostrar la cantidad cuentas por tipo de moneda.")); 
        objMenu.agregar(new Opcion(36,"Listado de las cuentas cerradas.")); 
        
        objMenu.agregar(new Opcion(99,"Salir"));
    }
}
