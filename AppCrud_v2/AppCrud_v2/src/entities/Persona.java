package entities;

public class Persona {
    
    //Atributos
    protected int id;
    protected String nombre;
    protected String apellido;
    protected  String   edad;

    public Persona(int id, String nombre, String apellido, String edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    // METODO dummie  que es sobrescrito en cada sub clase
    public String  retornarDatos () {
        
        return "";
    }
    
        // METODO para analizar imput de usuario y validar si son alfanumericos
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
