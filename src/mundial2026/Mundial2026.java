
package mundial2026;
import entities.Equipos;
import entities.Grupo;
import entities.Torneo;
import java.util.*;

public class Mundial2026 {


    public static void main(String[] args) {
        Equipos[] selecciones = {
            // Grupo A
            new Equipos("Argentina",     "ARG",  1),
            new Equipos("Ecuador",       "ECU", 44),
            new Equipos("Canada",        "CAN", 47),
            new Equipos("Peru",          "PER", 37),
            // Grupo B
            new Equipos("Francia",       "FRA",  2),
            new Equipos("Mexico",        "MEX", 15),
            new Equipos("Polonia",       "POL", 26),
            new Equipos("Chile",         "CHL", 33),
            // Grupo C
            new Equipos("Inglaterra",    "ENG",  5),
            new Equipos("Iran",          "IRN", 22),
            new Equipos("Estados Unidos","USA", 13),
            new Equipos("Bolivia",       "BOL", 85),
            // Grupo D
            new Equipos("Holanda",       "NED",  7),
            new Equipos("Senegal",       "SEN", 20),
            new Equipos("Ecuador",       "ECU2",40),
            new Equipos("Qatar",         "QAT", 58),
            // Grupo E
            new Equipos("Portugal",      "POR",  6),
            new Equipos("Ghana",         "GHA", 60),
            new Equipos("Uruguay",       "URU", 14),
            new Equipos("Corea del Sur", "KOR", 23),
            // Grupo F
            new Equipos("Belgica",       "BEL",  8),
            new Equipos("Marruecos",     "MAR", 12),
            new Equipos("Croacia",       "CRO", 10),
            new Equipos("Suecia",      "SUE",38),
            // Grupo G
            new Equipos("Brasil",        "BRA",  4),
            new Equipos("Serbia",        "SRB", 27),
            new Equipos("Suiza",         "SUI", 19),
            new Equipos("Camerun",       "CMR", 43),
            // Grupo H
            new Equipos("Espana",        "ESP",  8),
            new Equipos("Costa Rica",    "CRC", 50),
            new Equipos("Japon",         "JPN", 21),
            new Equipos("Alemania",      "GER", 16),
            // Grupo I
            new Equipos("Colombia",      "COL", 11),
            new Equipos("Australia",     "AUS", 25),
            new Equipos("Tunez",         "TUN", 30),
            new Equipos("Arabia Saudita","KSA", 56),
            // Grupo J
            new Equipos("Italia",        "ITA",  9),
            new Equipos("Venezuela",     "VEN", 70),
            new Equipos("Dinamarca",     "DEN", 18),
            new Equipos("Turquia",       "TUR", 35),
            // Grupo K
            new Equipos("Uzbekistan",      "USK",50),
            new Equipos("Nueva Zelanda", "NZL", 90),
            new Equipos("Nigeria",       "NGA", 38),
            new Equipos("Argelia",       "ALG", 45),
            // Grupo L
            new Equipos("Ucrania",       "UKR", 22),
            new Equipos("Egipto",        "EGY", 34),
            new Equipos("Paraguay",      "PAR", 49),
            new Equipos("Indonesia",     "IDN",130),
        };
        
        long semilla = 2026L;
        Torneo mundial = new Torneo("MUNDIAL DE FUTBOL 2026", semilla);
        
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
        for(int g = 0; g<12; g++){
            Equipos[] cuarto ={
                selecciones[g * 4],
                selecciones[g * 4 + 1],
                selecciones[g * 4 + 2],
                selecciones[g * 4 + 3]
            };
            mundial.agregarGrupo(new Grupo(letras[g], cuarto));
        }
        
        mundial.simularFaseGrupos();
        mundial.simularFaseEliminatoria();
    }
    
}
