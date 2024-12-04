package clases;

/**
 * Clase que representa el plus que se le puede asignar a un empleado.
 *
 * 
 * @author Cristian y Reyman 
 */
public class Pluses {

    private int idPlus;
   private String titulo;
    private int porIncremento;

    /**
     * Constructor que inicializa todos los atributos de la clase con los valores proporcionados.
     * 
     * @param idPlus Identificador único del plus.
     * @param titulo Título descriptivo del plus.
     * @param porIncremento Porcentaje de incremento salarial que representa el plus.
     */
    public Pluses(int idPlus, String titulo, int porIncremento) {
        this.idPlus = idPlus;
        this.titulo = titulo;
        this.porIncremento = porIncremento;
    }

    /**
     * Constructor por defecto que inicializa los atributos con valores predeterminados.
     */
    public Pluses() {
        this.idPlus = 0;
        this.titulo = "";
        this.porIncremento = 0;
    }

    /**
     * Obtiene el identificador único del plus.
     * 
     * @return el idPlus del plus.
     */
    public int getIdPlus() {
        return idPlus;
    }

    /**
     * Establece el identificador único del plus.
     * 
     * @param idPlus el nuevo idPlus del plus.
     */
    public void setIdPlus(int idPlus) {
        this.idPlus = idPlus;
    }

    /**
     * Obtiene el título descriptivo del plus.
     * 
     * @return el título del plus.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título descriptivo del plus.
     * 
     * @param titulo el nuevo título del plus.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el porcentaje de incremento salarial que representa el plus.
     * 
     * @return el porcentaje de incremento del plus.
     */
    public int getPorIncremento() {
        return porIncremento;
    }

    /**
     * Establece el porcentaje de incremento salarial que representa el plus.
     * 
     * @param porIncremento el nuevo porcentaje de incremento del plus.
     */
    public void setPorIncremento(int porIncremento) {
        this.porIncremento = porIncremento;
    }
}
