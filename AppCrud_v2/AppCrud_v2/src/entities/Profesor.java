package entities;
import java.util.Scanner;

public class Profesor extends Persona {
    
    private String colegiado;
    
    public Profesor(String colegiado, int id, String nombre, String apellido, String edad) {
        super(id, nombre, apellido, edad);
        this.colegiado = colegiado;
    }

    public String getColegiado() {
        return colegiado;
    }

    public void setColegiado(String colegiado) {
        this.colegiado = colegiado;
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
                System.out.println("No. colegiado:");
                this.colegiado = opcion.nextLine();
                analiza=   super.analizaCadena(this.colegiado );
                if ( analiza==false ){
                    System.out.println("EL NUMERO DE COLEGIADO NO ES NUMERICO !!!");
                    return 0;
                }else {               
                    return 1;
                    }
              }        
     }   
    
     // metodo para retornar datos  sobrescrito y customizado para sub clase profesor.    
    @Override
        public String retornarDatos () {
        return " Perfil: Profesor  => "
               +  " ID: "+ this.id
                + " Nombre: " + this.nombre 
                + "; Apellido: " + this.apellido 
                + "; Edad: " + this.edad +
                "; Colegiado: "+ this.colegiado;
              
    }
        
        
    
}
