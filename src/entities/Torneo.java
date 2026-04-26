
package entities;
import java.util.*;

public class Torneo {
    
    //atributos
    private String nombre;
    private List<Grupo> grupos;
    private List<Equipos> clasificados;
    private List<Partido> partidosElim;
    private Random rnd;
    
    //constructores

    public Torneo(String nombre, long semilla) {
        this.nombre = nombre;
        this.grupos = new ArrayList<>();
        this.clasificados = new ArrayList<>();
        this.clasificados = new ArrayList<>();
        this.partidosElim = new ArrayList<>();
        this.rnd = new Random(semilla);
    }

    public Torneo(String nombre, List<Grupo> grupos, List<Equipos> clasificados, List<Partido> partidosElim, Random rnd) {
        this.nombre = nombre;
        this.grupos = grupos;
        this.clasificados = clasificados;
        this.partidosElim = partidosElim;
        this.rnd = rnd;
    }

    public Torneo() {
    }
    
    
    
    //getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public List<Equipos> getClasificados() {
        return clasificados;
    }

    public void setClasificados(List<Equipos> clasificados) {
        this.clasificados = clasificados;
    }

    public List<Partido> getPartidosElim() {
        return partidosElim;
    }

    public void setPartidosElim(List<Partido> partidosElim) {
        this.partidosElim = partidosElim;
    }

    public Random getRnd() {
        return rnd;
    }

    public void setRnd(Random rnd) {
        this.rnd = rnd;
    }
    
    //metodos de orden
    public void agregarGrupo(Grupo g){
        grupos.add(g);
    }
    
    public void simularFaseGrupos(){
        System.out.println("\n"+"=".repeat(70));
        System.out.println(" FASE DE GRUPOS - "+nombre);
        System.out.println("=".repeat(70));
        
        for(Grupo g : grupos){
            g.simularGrupos(rnd);
            g.imprimirTabla();
            
            System.out.println("\n Resultados");
            for(Partido p : g.getPartidos()){
                System.out.println(p);
            }
            g.mostrarMatriz();
            
            List<Equipos> cls = g.getClasificados();
            clasificados.addAll(cls);
            System.out.println("\n Clasificados al grupo "+g.getNombre()+":");
            for(Equipos x : cls){
                System.out.println("  ->"+x.getNombre()+"("+x.getPuntos()+"pts)");
            }
            
        }
        System.out.println("\n"+"=".repeat(70));
        System.out.println(" EQUIPOS CLASIFICADOS A ELIMINICACION DIRECTA ("+clasificados.size()+"):");
        System.out.println("=".repeat(70));
        for(int i = 0; i<clasificados.size(); i++){
            System.out.printf(" %2d. %s%n", i+1, clasificados.get(i).getNombre());
        }
    }
    
    private String nombreRonda(int equipos){
        switch (equipos){
            case 32:
                return "Dieciseisavos de Final";
            case 16:
                return "Octavos de Final";
            case 8:
                return "Cuartos de Final";
            case 4:
                return "Semifinal";
            case 2:
                return "Gran Final";
            default:
                return "Ronda de "+equipos;
        }
    }
    public void simularFaseEliminatoria(){
        System.out.println("\n"+"=".repeat(70));
        System.out.println(" FASE ELIMINATORIA");
        System.out.println("=".repeat(70));
        
        List<Equipos> ronda = new ArrayList<>(clasificados);
        int numeroRonda =1;
       
        while(ronda.size()>1){
            String nombreRonda = nombreRonda(ronda.size());
            System.out.println("\n --"+nombreRonda+" --");
            
            List<Equipos> ganadores = new ArrayList<>();
            for(int i = 0; i < ronda.size()-1; i+=2){
                Equipos local = ronda.get(i);
                Equipos visit = ronda.get(i+1);
                Partido partido = new Partido(local, visit);
                do{
                    partido = new Partido(local, visit); 
                    partido.simular(rnd);
                }while(partido.getGanador() == null);
                
                partidosElim.add(partido);
                System.out.println(partido);
                System.out.println("  -> Avanza: "+partido.getGanador().getNombre());
                ganadores.add(partido.getGanador());
            }
            ronda = ganadores;
            numeroRonda++;
        }
        
        System.out.println("CAMPEON DEL MUNDIAL "+nombre+": "+ronda.get(0).getNombre().toUpperCase());

    }
    
}
