package clases;

/**
 * Clase que representa la relación entre un colaborador (empleado) y los pluses asignados.
 * 
 * @author Cristian y Reyman 
 */
public class PlusesColab {

   
    private int cedula;
    private String nombresPluses;

    /**
     * Constructor que inicializa los atributos con los valores proporcionados.
     * 
     * @param cedula Cédula del colaborador.
     * @param nombresPluses Nombres de los pluses asignados al colaborador.
     */
    public PlusesColab(int cedula, String nombresPluses) {
        this.cedula = cedula;
        this.nombresPluses = nombresPluses;
    }

    /**
     * Constructor por defecto que inicializa los atributos con valores predeterminados.
     */
    public PlusesColab() {
        this.cedula = 0;
        this.nombresPluses = "";
    }

    /**
     * Obtiene la cédula del colaborador.
     * 
     * @return la cédula del colaborador.
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * Establece la cédula del colaborador.
     * 
     * @param cedula la nueva cédula del colaborador.
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene los nombres de los pluses asignados al colaborador.
     * 
     * @return los nombres de los pluses asignados.
     */
    public String getNombresPluses() {
        return nombresPluses;
    }

    /**
     * Establece los nombres de los pluses asignados al colaborador.
     * 
     * @param nombresPluses los nuevos nombres de los pluses asignados.
     */
    public void setNombresPluses(String nombresPluses) {
        this.nombresPluses = nombresPluses;
    }
}
