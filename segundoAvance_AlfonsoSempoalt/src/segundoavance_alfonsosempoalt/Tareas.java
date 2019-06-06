package segundoavance_alfonsosempoalt;

/**
 *
 * @author Alfonso Sempoalt
 */
public class Tareas {
    
    public static int tareasFinalizadas = 0;
     private String ubicacionMemoria;
    private int tiempo;
     private int tamaño;
    private String estado;

    public Tareas(String ubicacionMemoria, int tiempo, int tamaño, String estado) {
        this.ubicacionMemoria = ubicacionMemoria;
        this.tiempo = tiempo;
        this.tamaño = tamaño;
        this.estado = estado;
    }

    public int getTiempo() {
        return tiempo;
    }
    
    public static int getTareasFinalizadas() {
        return tareasFinalizadas;
    }

    public static void setTareasTerminadas(int tarasFinalizadas) {
        Tareas.tareasFinalizadas = tareasFinalizadas;
    }
    public boolean tareasTerminadas() {
        return tareasFinalizadas == 25;
    }

    public String getUbicacionMemoria() {
        return ubicacionMemoria;
    }

    public void setUbicacionMemoria(String ubicacionMemoria) {
        this.ubicacionMemoria = ubicacionMemoria;
    }

    public void setNumero(String numero) {
        this.ubicacionMemoria = numero;
    }


    public void setTiempo1(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado.equalsIgnoreCase("terminado")) {
            Tareas.tareasFinalizadas++;
        } 
        this.estado = estado;
    }

    public void datos() {
        System.out.printf("%10s %10d %10d %10s \n",
                this.ubicacionMemoria, this.tiempo, this.tamaño, this.estado);
    }

    @Override
    public String toString() {
        return "Tareas{" + "ubicacion=" + ubicacionMemoria + ", tiempo1=" + tiempo + ", tamanio=" + tamaño + ", estado=" + estado + '}';
    }

}
