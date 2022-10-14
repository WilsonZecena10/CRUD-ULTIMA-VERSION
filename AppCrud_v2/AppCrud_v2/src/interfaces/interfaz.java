package interfaces;


public interface interfaz {
   
    void agregar(int opcionUser);
    int buscar(String nombre, String apellido);
    void actualizar(String id);
    boolean  analizaCadena(String str);
    void borrar(String id);
    void imprimir();
    int generaId();
    int maxIndice();
}
