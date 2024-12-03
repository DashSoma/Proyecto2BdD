package otros;
/**
 * Clase que representa los puestos de trabajo.
 * 
 * @author Crisp 
 */
public class Proveedor2 {
    
    private static int idIncremental = 1;
    private int idPuesto;
    private String nombre;
    private String contacto;
    private String direccion;
   
    public Proveedor2(String nombre, String contacto, String direccion) {
        this.idPuesto = idIncremental++;  // Incrementa el ID solo una vez
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
    }
    
    public Proveedor2() {
        this.idPuesto = idIncremental++;  // Incrementa el ID solo una vez
        this.nombre = "";
        this.contacto = "";
        this.direccion = "";
    }
    
    public static int getIdIncremental() {
        return idIncremental;
    }
    
    public static void setIdIncremental(int idIncremental) {
        Proveedor2.idIncremental = idIncremental;
    }
    
    public int getIdPuesto() {
        return idPuesto;
    }
    
    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getContacto() {
        return contacto;
    }
    
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}