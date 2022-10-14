package service;
import interfaces.*;
import data.*;
import entities.*;
import java.util.Scanner;

public class Implementacion implements interfaz {

    Data data;

    public Implementacion(Data data) {
        this.data = data;
    }

    
 //este metodo genera el ID que debe asignar a cada registro, NO ES  al sub-indice del array
  @Override 
 public int generaId (){
     int id=0;
     int flag=0;
     for (Persona persona  : data.getArrayPersonas()){
            if(persona != null){
                id= persona.getId();  //saco el el ID del ultimo registro y le incremento 10     
                id=id+10;    
                flag=1;
              }else{
               if (flag==0){ //si es el primer registro le asigno 100               
                id=100;         
            }               
        }            
     }      
    return id;  
    
 }    
       
 //metodo para agregar personas 
  @Override
 public void  agregar(int opcionUser){
      int id=  generaId(); //invoco el metodo para generar la secuencia del ID
     switch(opcionUser) {
        
        case 1:  //agregar personal Administrativo      
           Admin admin=new Admin(" ",0," ", " "," ");
           int resp=admin.colectaDatos(id); // invoca el metodo colectar dato clase Admin   
           if (resp ==1){
                data.agregar(admin, maxIndice()); //agrega el registro al arreglo principal
           }else {
               System.out.println("NO SE AGREGA REGISTRO !");
           }
            break;    
        
        case 2:  //agregar profesores
           Profesor profe = new Profesor("",0," ", " ","");
           resp=profe.colectaDatos(id); // invoca el metodo colectar dato clase Profesor   
           if (resp ==1){
                data.agregar(profe,maxIndice() ); //agrega el registro al arreglo principal
            }else {
               System.out.println("NO SE AGREGA REGISTRO !");
           } 
            break;   
            
        case 3: //agregar alumnos                           
           Alumno alumno = new Alumno("",0," ", " ","");
           resp=alumno.colectaDatos(id); // invoca el metodo colectar dato clase Alumno  
           if (resp ==1){
           data.agregar(alumno, maxIndice()); //agrega el registro al arreglo principal
           }else {
               System.out.println("NO SE AGREGA REGISTRO !");
           } 
           break;
        case 4:// salida  
            break;
        default: //valores diferentes es invalido.
            System.out.println(" ");  
            System.out.println("OPCION INVALIDA!");
            System.out.println(" ");         
     }
     
     

 }
 
 //metodo para buscar personas
    @Override
 public int  buscar(String nombre, String apellido){
   int cont=0; //si encuentra registros igualo a 1 , sino es 0 despliego mensaje     
   int reg =0;//utilizo este valor en el main para pasar a eliminar el registro
   System.out.println("============PERSONAS ENCONTRADAS POR COINCIDENCIA =========="); 
   System.out.println( " ");        
      
    // recorro el arreglo principal en busca de todas las coincidencias con el nombre/apellido
   for ( int i =0 ; i < data.getArrayPersonas().length ; i++){
       if(data.getArrayPersonas()[i] != null) {            
           //invoco el metodo data.buscar para las coincidencias en el arreglo
           String[] nombreApellido   = data.buscar( i) ;
           String name_convert     = nombre.toLowerCase(); //convierto a minusculas la cadena
           String lastName_convert = apellido.toLowerCase();//convierto a minusculas la cadena
           
           if (nombreApellido[0].contains(name_convert)) { // busco la coincidencia por nombre
               if(nombreApellido[1].contains(lastName_convert)){//busco la coincidencia apellido
                   System.out.println( "Registros encontrados: " + nombreApellido[0] + " "+nombreApellido[1] +" Indice: "+ i);
                   cont=1;  
                   reg=1;
               }else{
                   if (cont==0){    
                   System.out.println( "Registros encontrados: 0 "); //si no hay coincidencia nombre y apellido
                   cont=1;
                    }
               }
           } else{
                   if (cont==0){    
                   System.out.println( "Registros encontrados: 0 "); //si no hay coincidencia nombre
                   cont=1;
                    }
                 }   
       }else { 
              if(cont==0){
                System.out.println( "Arreglo no cuenta con registros"); //arreglo no tiene registros
                cont=1;
               }
             }
    }
        System.out.println( " ");      
        System.out.println("===========================================================");   
        return reg;



 }
 
 //metodo que actualiza,  se basa en "agregar" el registro  actualizado   y "borrar" el anterior
 //se basa en  "agregar y borrar" usa los
 //metodos agregar()  y  borrar() de la clase data.
  @Override
 public void actualizar(String id){
 
     Scanner opcion = new Scanner (System.in);
      boolean analiza= analizaCadena(id);
        System.out.println( );
        if ( analiza==false ){
            System.out.println("OPCION NO ES NUMERICO !!!.");
        } else {         
                if(data.getArrayPersonas()[ Integer.parseInt(id) ] != null) {
                    Persona persona  = data.getArrayPersonas()[Integer.parseInt(id)];                           
                    System.out.println( persona.retornarDatos());//imprimo el registro a actualizar
                    System.out.println("============================");
                    System.out.println("Seleccione el perfil:"); 
                    System.out.println("1) Admin 2)Catedratico 3) Alumno");  //puede asignar un nuevo perfil
                    String opcionUser = opcion.next();  
                    analiza= analizaCadena(opcionUser);
                    System.out.println( );
                    if ( analiza==false ){
                        System.out.println("OPCION NO ES NUMERICO !!!");
                    } else {
                                if(opcionUser.contentEquals("1")|| 
                                   opcionUser.contentEquals("2")||
                                   opcionUser.contentEquals("3") ){
                                    //agrego el registro actualizado con el metodo agregar() de la clase data        
                                    agregar(Integer.parseInt(opcionUser) ) ;
                                    //borro el registro viejo con el metodo borrar() de la clase data
                                    borrar(id);       
                                    
                                } else {
                                     System.out.println("OPCION NO VALIDA!!");
                                }               
                            }

                }else {
                    System.out.println("NO EXISTE REGISTRO PARA ESE INDICE");
                } 
          } 
 }
 

    @Override
 public void borrar (String id){
    Scanner opcion = new Scanner (System.in);
      boolean analiza= analizaCadena(id);
        System.out.println( );
        if ( analiza==false ){
            System.out.println("INDICE INGRESADO NO ES NUMERICO !!!");
        } else {
         int cont=0;
            Persona arrayPivot[] = new Persona[ data.getArrayPersonas().length   ]; 
            for ( int i =0 ; i < data.getArrayPersonas().length; i++){
                if(data.getArrayPersonas()[i] != null) {  
                         if(i != Integer.parseInt(id)) {
                             for ( int m =0 ; m < arrayPivot.length; m++){
                                 if(arrayPivot[m] == null) {                                      
                                    arrayPivot[m]=data.getArrayPersonas()[i];
                                    m=arrayPivot.length+1;
                                  } 
                              }
                            }
                            cont=1;
                  } else {
                    if (cont==0){
                        System.out.println("ARREGLO SIN ELEMENTOS !!"); 
                        cont=1;
                    }
                }
             }

           
               data.borrar(arrayPivot);// mando a borrar (sobrescribir el arreglo) 
        }
 }


    public void imprimir () {
        int flag=0;
        System.out.println();
        System.out.println();
        System.out.println("================================================================================================================================");
        flag=data.imprimir();
        if (flag==0){
            System.out.println("NO HAY ELEMENTOS EN EL ARREGLO");
        }
        System.out.println("================================================================================================================================");

    }

 
  ///metodo para determinar el siguiente indice disponible del arreglo
 //lo uso para ir insertando nuevos registros
    @Override
 public int maxIndice(){
    int indexFree=0;
    for ( int i =0 ; i < data.getArrayPersonas().length; i++){
        if  (data.getArrayPersonas()[i] ==null){
            indexFree=i;      
            break;
        }     
     }  return indexFree;
    
 }

    
    @Override
  public boolean  analizaCadena (String str ) {
        boolean isNumeric = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isNumeric = false;
            }
        }
        return (isNumeric);
    }

 


  
  
}