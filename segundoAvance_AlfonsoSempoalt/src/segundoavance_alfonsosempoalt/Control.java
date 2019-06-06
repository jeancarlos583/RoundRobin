package segundoavance_alfonsosempoalt;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Alfonso Sempoalt
 */
public class Control {

    private String procesoAtendido;
    private String siguienteProceso;
    private String contextoGuardado;
    private String contextoCargado;
    private int memoriaTotal= 50000;
    //asigna los valores a las respectivas clases 
    Scanner reader = new Scanner(System.in);
    Tareas tareas[] = {new Tareas("1", 15, 5460, "Retenido"), new Tareas("2", 14, 4190, "Retenido"), new Tareas("3", 18, 3290, "Retenido"),
        new Tareas("4", 12, 2030, "Retenido"), new Tareas("5", 12, 2550, "Retenido"), new Tareas("6", 16, 6990, "Retenido"), new Tareas("7", 18, 8940, "Retenido"),
        new Tareas("8", 20, 740, "Retenido"), new Tareas("9", 17, 3990, "Retenido"), new Tareas("10", 16, 6890, "Retenido"), new Tareas("11", 15, 6580, "Retenido"),
        new Tareas("12", 18, 3820, "Retenido"), new Tareas("13", 19, 9140, "Retenido"), new Tareas("14", 20, 420, "Retenido"), new Tareas("15", 20, 220, "Retenido"),
        new Tareas("16", 17, 7540, "Retenido"), new Tareas("17", 13, 3210, "Retenido"), new Tareas("18", 11, 1380, "Retenido"), new Tareas("19", 19, 9350, "Retenido"),
        new Tareas("20", 13, 3610, "Retenido"), new Tareas("21", 17, 7540, "Retenido"), new Tareas("22", 12, 2710, "Retenido"), new Tareas("23", 18, 8390, "Retenido"),
        new Tareas("24", 15, 5990, "Retenido"), new Tareas("25", 20, 760, "Retenido")};
    Memoria memorias[] = {new Memoria("1", 9500, "", 0), new Memoria("2", 7000, "", 0), new Memoria("3", 4500, "", 0), new Memoria("4", 8500, "", 0),
        new Memoria("5", 3000, "", 0), new Memoria("6", 9000, "", 0), new Memoria("7", 1000, "", 0), new Memoria("8", 5500, "", 0), new Memoria("9", 1500, "", 0), new Memoria("10", 500, "", 0)};
    /**
     * método que se encarga de imprimir y mostrarnos los valores 
     */
    public void imprimir() {
        System.out.printf("\033[34m %22S %2s %20S %65s \n", "                 Trabajos ", "                            -|-", "                       memoria", "primeros 10 procesos(tareas)");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10S %8S %10S %10S %8S %14S %13S  %10S %10S %3S \n", "|", "posición", "tiempo", "tamaño", "estado", "|", "bloque", "tamaño", "proceso", "|");
        for (int i = 0; i < tareas.length; i++) {
            try {
                System.out.printf(" %10s %4s %10s %15d %15s %1s %12s %10s %10s %10s %10s \n",
                        "|", tareas[i].getUbicacionMemoria(), tareas[i].getTiempo(), tareas[i].getTamaño(), tareas[i].getEstado(), "|", memorias[i].getUbicacion(), memorias[i].getTamanio(), memorias[i].getProceso(), "|");
            } catch (RuntimeException e) {
                System.out.printf("%10s %4s %10s %15d %15s %3s \n", "|", tareas[i].getUbicacionMemoria(), tareas[i].getTiempo(), tareas[i].getTamaño(), tareas[i].getEstado(), "|");
            }
        }
        System.out.printf("%55s\n", "\033[34mBloque de control de procesos");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("%14s %6s %10s  %10s %10s %1s\n", "|", "bloque", "tamanio", "proceso", "tiempo", "|");
        for (Memoria memoria : memorias) {
            memoria.datos();
        }
        System.out.printf("%96s \n", "\033[34mCambio contexto ");
        System.out.println("                                                                   ----------------------------------------");
        System.out.printf("%87s %16s %1s %1s %85s %17s %1s %1s %94s %8s %1s %1s %93s %9s %1s %1s ", "|Atendinedo:", this.procesoAtendido, "|", "\n",
                "|Siguiente:", this.siguienteProceso, "|", "\n",
                "|Guardando Contexto:", this.contextoGuardado, "|", "\n",
                "|Cargando Contexto:", this.contextoCargado, "|", "\n");
        System.out.println(""); 
        System.out.println("Memoria Total: "+ memoriaTotal);
    }
    /**
     * método que se encarga de liberar y asignar 
     */
    public void ejecutar() {
        String qtm;
        for (int i = 0; i < memorias.length && !tareas[0].tareasTerminadas(); i++) {
            if (i >= 9) {
                this.procesoAtendido = memorias[i].getProceso();
                this.siguienteProceso = memorias[i].getProceso();
            } else {
                if (i < 9) {
                    this.procesoAtendido = memorias[i].getUbicacion();
                    
                    this.siguienteProceso = memorias[i + 1].getUbicacion();
                }
            }
            if (memorias[i].getTiempo() <= 5 && memorias[i].getTiempo() != 0) {
                imprimir();
                do {
                    qtm = String.valueOf(memorias[i].getTiempo() - 1);
                    memorias[i].setTiempo(Integer.parseInt(qtm));
                    imprimir();
                    System.out.println("\033[31m Pulse le tecla <ENTER> para continuar");
                    reader.nextLine();
                } while (memorias[i].getTiempo() > 0);
                //en esta parte libera y también le suma a la memoria por lo del espacio perdido de la memoriaTotal
                tareas[memorias[i].procesoInt() - 1].setEstado("\033[31m Terminado");
                memorias[i].setProceso("");
                memorias[i].setTiempo(0);
                memoriaTotal= memoriaTotal+memorias[i].getTamanio();
                memorias[i].setEstado("libre");
                imprimir();
                refe(i);
            } else {
                if (memorias[i].getTiempo() > 5 && memorias[i].getTiempo() != 0) {
                    imprimir();
                    int res = memorias[i].getTiempo() - 5;
                    do {
                        qtm = String.valueOf(memorias[i].getTiempo() - 1);
                        memorias[i].setTiempo(Integer.parseInt(qtm));
                        imprimir();
                        System.out.println("\033[31m Pulse le tecla <ENTER> para continuar");
                        reader.nextLine();
                    } while (memorias[i].getTiempo() > res);
                    //cambio de contexto
                    if (i == 9 && 1 == 1) {
                        this.contextoGuardado = memorias[i].getProceso();
                        this.contextoCargado = memorias[i].getProceso();
                    } else {
                        if (i < 9 && 1 == 1) {
                            this.contextoGuardado = memorias[i].getProceso();
                            contextoCargado = memorias[i + 1].getProceso();
                        }
                    }
                }
            }
            if (tareas[0].tareasTerminadas()) {
                imprimir();
            } else {
                if (i >= 9) {
                    i = -1;
                }
            }
            System.out.println("\033[31m Pulse le tecla <ENTER> para continuar");
            reader.nextLine();
        }
    }
/**
 * Asigna
 */
    public void asignacion() {
        for (int i = 0; i < memorias.length; i++) {
            for (int k = 0; k < tareas.length && !memorias[8].memoriaLlena(); k++) {
                if (tareas[k].getTamaño() <= memorias[i].getTamanio() && (tareas[k].getEstado().equalsIgnoreCase("en espera")
                        || tareas[k].getEstado().equalsIgnoreCase("Retenido")) && memorias[i].getProceso().equalsIgnoreCase("")) {
                    //se encarga de asignar y poner en espera o ocupado
                    tareas[k].setEstado("Ejecutando");
                    memorias[i].setProceso(tareas[k].getUbicacionMemoria());
                    memorias[i].setTiempo(tareas[k].getTiempo());
                    memorias[i].setEstado("Ocupado");
                    memoriaTotal= memoriaTotal-memorias[i].getTamanio();
                    imprimir();
                    i++;
                    System.out.println("");
                } else {
                    tareas[k].setEstado("En espera");
                    imprimir();
                    System.out.println("");
                }
                System.out.println("\033[31m Pulse le tecla <ENTER> para continuar");
                reader.nextLine();
            }
        }
        System.out.println("");
    }
/**
 * asigna y pone en espera al igual que regresa un valor de tipo boolean
 * @param c
 * @return 
 */
    public boolean refe(int c) {
        boolean finProceso = !true;
        for (int i = 0; i < tareas.length && !finProceso; i++) {
            if (tareas[i].getTamaño() <= memorias[c].getTamanio() && (tareas[i].getEstado().equals("En espera")
                    || tareas[i].getEstado().equalsIgnoreCase("Retenido"))) {
                tareas[i].setEstado("Ejecutando");
                //se encarga de asignar y poner en espera 
                memorias[c].setProceso(tareas[i].getUbicacionMemoria());
                memorias[c].setTiempo(tareas[i].getTiempo());
                memorias[c].setEstado("Ocupado");
                memoriaTotal= memoriaTotal- memorias[c].getTamanio();
                imprimir();
                finProceso = true;
            } else {
                if (tareas[i].getEstado().equalsIgnoreCase("Retenido")) {
                    tareas[i].setEstado("En espera");
                    imprimir();
                    System.out.println("\033[31m Pulse le tecla <ENTER> para continuar");
                    reader.nextLine();
                }
            }
        }
        return true;
    }

}
