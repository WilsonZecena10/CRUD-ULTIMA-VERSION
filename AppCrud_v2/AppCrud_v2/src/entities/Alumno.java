package entities;
import java.util.Scanner;

public class Alumno extends Persona {
    
    private String carnet;

    public Alumno(String carnet, int id, String nombre, String apellido, String edad) {
        super(id, nombre, apellido, edad);
        this.carnet = carnet;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
    
    //metodo local de la clase para colectar datos, metodo customizado
    public int colectaDatos(int id){
     this.id = id;
     Scanner opcion = new Scanner (System.in);
     System.out.println("Nombre:");  
     this.nombre  = opcion.nextLine();
     System.out.println("Apellido:");
     this.apellido  = opcion.nextLine();
     System.out.println("Edad:");
     this.edad  = opcion.nextLine();
     boolean analiza=   super.analizaCadena(this.edad );
      if ( analiza==false ){
            System.out.println("LA EDAD NO ES VALIDA !!!");
            return 0;
        }else { 
                System.out.println("No. carnet:");
                this.carnet = opcion.nextLine();
                analiza=   super.analizaCadena(this.carnet );
                if ( analiza==false ){
                     System.out.println("El CARNET NO ES NUMERICO !!!");
                      return 0;
                } else { 
                        return 1;                       
                        }    
              }
  }   
    
    // metodo para retornar datos  sobrescrito y customizado para sub clase alumno.    
    @Override
       public String retornarDatos () {
        return " Perfil: Alumno  => "
                + " ID: "+ this.id
                + " Nombre: " + this.nombre 
                + "; Apellido: " + this.apellido 
                + "; Edad: " + this.edad +
                "; Carnet: "+ this.carnet;
            
    }
    

}
