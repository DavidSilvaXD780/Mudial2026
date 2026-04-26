
package entities;
import java.util.*;

public class Grupo {
    //atributos
    private String nombre;
    private Equipos[] equipos;
    private int[][] matrizResultados;
    private List<Partido> partidos;
    
    //construcctor

    public Grupo(String nombre, Equipos[] equipos, int[][] matrizResultados, List<Partido> partidos) {
        this.nombre = nombre;
        this.equipos = equipos;
        this.matrizResultados = new int[4][4];
        this.partidos = new ArrayList<>();
        if (equipos == null || equipos.length != 4){
            System.out.println("Cada grupo debe tener 4 equipos");
        }
        for(int[] fila : matrizResultados){
            Arrays.fill(fila, -1);
        }
    }

    public Grupo() {
        if (equipos == null || equipos.length != 4){
            System.out.println("Cada grupo debe tener 4 equipos");
        }
    }

    public Grupo(String nombre, Equipos[] equipos) {
        this.nombre = nombre;
        this.equipos = equipos;
        this.matrizResultados = new int[4][4];
        this.partidos = new ArrayList<>();
        if (equipos == null || equipos.length != 4){
            System.out.println("Cada grupo debe tener 4 equipos");
        }
        for(int[] fila : matrizResultados){
            Arrays.fill(fila, -1);
        }
    }
    
    
    
    //getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Equipos[] getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipos[] equipos) {
        this.equipos = equipos;
    }

    public int[][] getMatrizResultados() {
        return matrizResultados;
    }

    public void setMatrizResultados(int[][] matrizResultados) {
        this.matrizResultados = matrizResultados;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }
    
    //metodos de orden
    private int indice(Equipos x){
        for(int i = 0; i < equipos.length; i++){
            if(equipos[i] == x){
                return i;
            }
        }
        return -1;
    }
    
    public void simularGrupos (Random rnd){
        for(int i = 0; i < equipos.length; i++){
            for(int j = i + 1; j < equipos.length; j++){
                Partido partido = new Partido(equipos[i], equipos[j]);
                partido.simular(rnd);
                matrizResultados[i][j] = partido.getGolesLocal();
                matrizResultados[j][i] = partido.getGolesVisitante();
                partidos.add(partido);
            }
        }
    }
        
    public List<Equipos> getClasificados(){
      List<Equipos> lista = new ArrayList<>(Arrays.asList(equipos));
      lista.sort((a, b) -> {
          if(b.getPuntos() != a.getPuntos()){
              return b.getPuntos() - a.getPuntos();
          }
          if(b.getDiferenciaGoles() != a.getDiferenciaGoles()){
              return b.getDiferenciaGoles() - a.getDiferenciaGoles();
          }
          return b.getGoles() - a.getGoles();
      });
      return lista.subList(0, 2);
    }
    
    public void imprimirTabla (){
        System.out.println("\n Grupo " + nombre);
        System.out.println(" " +"-".repeat(65));
        System.out.printf(" %-22s | PJ | Pts | GF | GC | DG%n", "Equipo");
        System.out.println(" "+"-".repeat(65));
        List<Equipos> orden = new ArrayList<>(Arrays.asList(equipos));
        orden.sort((a, b) -> b.getPuntos() - a.getPuntos());
        for (Equipos x : orden){
            System.out.println(" "+x);
        }
        System.out.println(" "+"-".repeat(65));
    }
    
    private String abrev (String nombre){
        return nombre.length() > 12 ? nombre.substring(0, 12) : nombre;
    }
    
    public void mostrarMatriz(){
        System.out.println("\n Matriz de Resultados - Grupo "+nombre+" (fila=local, col=visitante:)");
        System.out.printf(" %-14s", "");
        for(Equipos x : equipos){
            System.out.printf(" %-14s", abrev(x.getNombre()));
        }
        System.out.println();
        for(int i = 0; i < equipos.length; i++){
            System.out.printf(" %-14s", abrev(equipos[i].getNombre()));
            for (int j = 0; j < equipos.length; j++){
                if(i == j){
                    System.out.printf("%-14s", " ---");
                }else if(matrizResultados[i][j] == -1){
                    System.out.printf("%-14s", " -");
                }else{
                    System.out.printf("%-14s", " "+ matrizResultados[i][j]);
                }
                System.out.println();
            }
        }
    }
}
