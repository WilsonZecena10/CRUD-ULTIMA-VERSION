package entities;
import java.util.Scanner;

public class Admin extends Persona {
    
    private String depto;
    
    public Admin(String depto, int id, String nombre, String apellido, String edad) {
        super(id, nombre, apellido, edad);
        this.depto = depto;
      
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }


    @Override
    public String getEdad() {
        return edad;
    }
    
 
    public String getDepto() {
        return depto;
    }
   

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public void setEdad(String edad) {
        this.edad = edad;
    }
 
    
    public void setDepto(String depto) {
        this.depto = depto;
    }

 //metodo local de la clase para colectar datos, metodo customizado
    public int  colectaDatos(int id){
        this.id = id;
        Scanner opcion = new Scanner (System.in);
        System.out.println("Nombre:");  
        this.nombre  = opcion.nextLine();
        System.out.println("Apellido:");
        this.apellido  = opcion.nextLine();
        System.out.println("Edad:");
        this.edad  = opcion.nextLine();
        boolean analiza=  super.analizaCadena(this.edad );
        if ( analiza==false ){
            System.out.println("LA EDAD NO ES VALIDA !!!");
            return 0;
        }else { 
             //this.edad  = opcion.nextLine();
            System.out.println("Depto admin:");
            this.depto  = opcion.nextLine();
            return 1;
              }
        
 
}    
    
     // metodo para retornar datos  sobrescrito y customizado para sub clase alumno.   
    @Override
    public String retornarDatos () {
        return " Perfil: Administrativo  => "
                + " ID: "+ this.id
                + " Nombre: " + this.nombre 
                + "; Apellido: " + this.apellido 
                + "; Edad: " + this.edad +
                "; Depto: "+ this.depto;
                
    }

    
}
