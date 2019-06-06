/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoavance_alfonsosempoalt;

/**
 *
 * @author Alfonso Sempoalt
 */
public class Memoria {
    public static int memoriaOcupada = 0;  
    private String estado;
    private String ubicacion;
    private int tamaño;
    private String proceso;
    protected int tiempo;
    public static int memoriaTotal=50000;
    public Memoria(String ubicacion, int tamaño, String proceso, int tiempo) {
        this.ubicacion = ubicacion;
        this.tamaño = tamaño;
        this.proceso = proceso;
        this.tiempo = tiempo;
          }

    public static int getMemoriaOcupada() {
        return memoriaOcupada;
    }

    public static void setMemoriaOcupada(byte memoriaOcupada) {
        Memoria.memoriaOcupada = memoriaOcupada;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public boolean memoriaLlena() {
        return memoriaOcupada == 10;
    }


    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getTamanio() {
        return tamaño;
    }

    public void setTamanio(int tamanio) {
        this.tamaño = tamanio;
    }



    public int procesoInt() {
        return Integer.parseInt(proceso);
    }

    public int getTiempo() {      
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado.equalsIgnoreCase("ocupado")) {
            Memoria.memoriaOcupada++;
        } else {
            if (estado.equalsIgnoreCase("libre")) {
                Memoria.memoriaOcupada--;
            }
        }
      this.estado = estado;
    }

    public void datos() {
        System.out.printf("%14s %6s %10d %10s %10s %2s  \n",
                "|", this.ubicacion, this.tamaño, this.proceso, this.tiempo, "|");
    }

    @Override
    public String toString() {
        return "Memoria{" + "ubicacion=" + ubicacion + ", tamanio=" + tamaño + ", proceso=" + proceso + ", tiempo=" + tiempo + '}';
    }
    
}
