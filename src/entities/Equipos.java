
package entities;

public class Equipos {
    //atributos
    private String nombre;
    private String pais;
    private int rankingFifa;
    private int puntos;
    private int goles;
    private int golesContra;
    
    //construcctor

    public Equipos(String nombre, String pais, int rankingFifa, int puntos, int goles, int golesContra) {
        this.nombre = nombre;
        this.pais = pais;
        this.rankingFifa = rankingFifa;
        this.puntos = 0;
        this.goles = 0;
        this.golesContra = 0;
    }

    public Equipos() {
    }

    public Equipos(String nombre, String pais, int rankingFifa) {
        this.nombre = nombre;
        this.pais = pais;
        this.rankingFifa = rankingFifa;
        this.puntos = 0;
        this.goles = 0;
        this.golesContra = 0;
    }
    
    

    
    //getters and setters

    public int getDiferenciaGoles(){
        return goles - golesContra;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getRankingFifa() {
        return rankingFifa;
    }

    public void setRankingFifa(int rankingFifa) {
        this.rankingFifa = rankingFifa;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }
    
    //metodos de orden
    public void resultado(int golesHechos, int golesRecibidos){
        if(golesHechos < 0 || golesRecibidos < 0){
            System.out.println("Los goles no pueden ser negativos");
        }
        this.goles += golesHechos;
        this.golesContra += golesRecibidos;
        if(golesHechos > golesRecibidos) this.puntos += 3;
        else if(golesHechos == golesRecibidos) this.puntos += 1;
    }
    
    public void reset (){
        puntos = goles = golesContra = 0;
    }
    
    //toString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipos{");
        sb.append("nombre=").append(nombre);
        sb.append(", pais=").append(pais);
        sb.append(", rankingFifa=").append(rankingFifa);
        sb.append(", puntos=").append(puntos);
        sb.append(", goles=").append(goles);
        sb.append(", golesContra=").append(golesContra);
        sb.append('}');
        return String.format("%-22s | Pts:%-3d | GF:%-3d | GC:%-3d | DG:%-3d", nombre, puntos,goles,golesContra,getDiferenciaGoles());
    }
    
}

