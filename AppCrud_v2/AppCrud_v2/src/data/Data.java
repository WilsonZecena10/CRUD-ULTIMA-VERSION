package data;
import entities.*;
import java.util.Scanner;

public class Data {
    
   private  Persona arrayPersonas[] = new Persona[100];
      
   public Data(Persona personas[]) {
        this.arrayPersonas =personas;
    }

    public Persona[] getArrayPersonas() {
        return arrayPersonas;
    }

    public void setArrayPersonas(Persona[] arrayPersonas) {
        this.arrayPersonas = arrayPersonas;
    }    

    
// metodos manejo de datos    


    //agrega persona
 public void  agregar(Persona persona,int indice ){   
      arrayPersonas[indice ]=persona;
 }

    //busca persona por nombre y apellido retorna un arreglo de dos posiciones [nombre, apellido]
 public String [] buscar( int indice ){
      String nombre_convert   = getArrayPersonas()[indice].getNombre().toLowerCase() ;
      String apellido_convert = getArrayPersonas()[indice].getApellido().toLowerCase(); 
      String[] nombre = {nombre_convert, apellido_convert};
      return nombre;
 }
 
 // hago un remplazo del array SIN el registro borrado
 public void borrar (  Persona [] persona ){
    for ( int p =0 ; p < persona.length; p++){
      arrayPersonas[p]=persona[p];                                        
    }
 }
    //Metodo para impresion, retorna 0 si no hay datos en arreglo
    public int  imprimir (){
        int flag=0;
        for (Persona persona  : arrayPersonas){
            if(persona != null){
                System.out.println( persona.retornarDatos());
                flag=1;
            }else {
                if (flag==0){
                    break;
                }
            }
        }
        return flag;
    }

}

    
    
    
