package appcrud;
import service.*;
import data.*;
import entities.*;
import java.util.Scanner;

class Main {
    //varibles gloables a la clase main
    static String opcionUser; 
    static String nombre;
    static String apellido;
  
    //metodo local de main para solicitar datos
  public static void ingresaNombre ( ){
        Scanner op = new Scanner (System.in);  
        System.out.println("Ingrese un nombre: ");
         nombre  = op.next();
        System.out.println("Ingrese un apellido: ");
        apellido  = op.next();           
  }
    
  ///MAIN
  public static void main(String[] args) {
   
   Data data = new Data(new Persona[100]); // array principal para almancenar personas
   Implementacion miImpl = new Implementacion(data);    // instancia de la implementacion   
   Menus menu = new Menus(); //instancia de Menus
   Scanner op = new Scanner (System.in);  
     
      do{
            menu.menu(); // imprime el menu principal
            opcionUser = op.next();
            
            switch(opcionUser) {
                case "1":   //AGREGA PERSONA
                    menu.subMenu();//imprime el sub menu para agregar Admin, Profersor, Alumno
                    opcionUser = op.next();
                    // el submenu solo puede ser opciones 1,2,3  
                    boolean analiza= miImpl.analizaCadena(opcionUser); // analizo la entrada del usuario
                     System.out.println( );
                     if ( analiza==false ){
                        System.out.println("OPCION NO ES NUMERICO!!"); //si es alfanumerico evito el crash
                     } else{
                             miImpl.agregar(Integer.parseInt(opcionUser)); // llamo al metodo agregar de la implementacion 
                     }                                
                    break;
                case "2":  //BUSCAR PERSONA  
                    ingresaNombre();// metodo local para solicitar datos
                    miImpl.buscar(nombre, apellido); //invoco metodo buscar de la implementacion
                    break;
                case "3":  //ACTUALIZAR REGISTRO     
                    ingresaNombre();// metodo local para solicitar datos
                    int reg= miImpl.buscar(nombre, apellido); //invoco metodo buscar de la implementacion
                    if (reg>0){// >0 si hay coincidiencias por nombre y apellido
                        System.out.println("Escriba el ID del registro a actualizar: ");
                        String id  = op.next();
                        miImpl.actualizar(id); // invoco el metodo para actualizar parametro indice
                    }
                    break;
                case "4": //BORRAR REGISTRO   
                     ingresaNombre();// metodo local para solicitar datos
                    reg= miImpl.buscar(nombre, apellido); //invoco metodo buscar de la implementacion
                    if (reg>0){// >0 si hay coincidiencias por nombre y apellido
                        System.out.println("Escriba el ID del registro a eliminar: ");
                        String id  = op.next();
                        miImpl.borrar(id); //metodo borrar de la implementacion
                    }
                    break;
                case "5":// IMPRIMIR 
                    miImpl.imprimir();
                    break; //SALIDA
                case "6":
                    break;
                default://CUALQUIER OTRA OPCION NO VALIDA
                    System.out.println();
                    System.out.println();
                    System.out.println("OPCION NO VALIDA !");
                    break;
            }
      }while (  !"6".equals(opcionUser) );           
     }
}
