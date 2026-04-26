
package entities;
import java.util.*;
public class Partido {
    //atributos
    private Equipos local;
    private Equipos visitante;
    private int golesLocal;
    private int golesVisitante;
    private boolean jugado;
    
    //constructores

    public Partido(Equipos local, Equipos visitante, int golesLocal, int golesVisitante, boolean jugado) {
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.jugado = jugado;
        if(local == null || visitante == null){
            System.out.println("Los Equipos no pueden estar vacios");
        }
        if (local == visitante){
            System.out.println("No pueden ser el mismo equipo");
        }      
    }

    public Partido() {
        if(local == null || visitante == null){
            System.out.println("Los Equipos no pueden estar vacios");
        }
        if (local == visitante){
            System.out.println("No pueden ser el mismo equipo");
        }      
    }

    public Partido(Equipos local, Equipos visitante) {
        this.local = local;
        this.visitante = visitante;
        if(local == null || visitante == null){
            System.out.println("Los Equipos no pueden estar vacios");
        }
        if (local == visitante){
            System.out.println("No pueden ser el mismo equipo");
        }      
    }
    
    
    
    
    
    //getters and setters

    public Equipos getLocal() {
        return local;
    }

    public void setLocal(Equipos local) {
        this.local = local;
    }

    public Equipos getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipos visitante) {
        this.visitante = visitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public boolean isJugado() {
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }
    
    //metodos de orden
    public void registarResultado(int golesLoc, int golesVisit){
        if (golesLoc < 0 || golesVisit < 0){
            System.out.println("Los goles no pueden ser negativos");
        }
        this.golesLocal = golesLoc;
        this.golesVisitante = golesVisit;
        this.jugado = true;
        local.resultado(golesLoc, golesVisit);
        visitante.resultado(golesLoc, golesVisit);
    }
    
    public void simular(Random rnd){
        int maxGoles = 7;
        double pesoLocal = 1.0 / local.getRankingFifa();
        double pesoVisitante = 1.0 / visitante.getRankingFifa();
        double total = pesoLocal + pesoVisitante;
        
        int golesLocal = (int) Math.round((pesoLocal / total) * (rnd.nextInt(maxGoles + 1)));
        int golesVisitante = (int) Math.round((pesoVisitante / total) * (rnd.nextInt(maxGoles + 1)));
        registarResultado(golesLocal, golesVisitante);
    }
    
    public Equipos getGanador(){
        if(!jugado){
            return null;
        }
        if(golesLocal > golesVisitante){
            return local;
        }
        if(golesVisitante > golesLocal){
            return visitante;
        }
        return null;
    }
    
    //toString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Partido{");
        sb.append("local=").append(local);
        sb.append(", visitante=").append(visitante);
        sb.append(", golesLocal=").append(golesLocal);
        sb.append(", golesVisitante=").append(golesVisitante);
        sb.append(", jugado=").append(jugado);
        sb.append('}');
        if (!jugado)
            return String.format(" %s vs %s (pendiente)", local.getNombre(), visitante.getNombre());
        return String.format(" %-22s %d = %d %s", local.getNombre(), golesLocal, golesVisitante, visitante.getNombre());
    }
    
    
}
