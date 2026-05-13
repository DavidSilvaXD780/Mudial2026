
package mundial2026;
import entities.Equipos;
import entities.Grupo;
import entities.Torneo;
import java.util.*;

public class Mundial2026 {


    public static void main(String[] args) {
        Equipos[] selecciones = {
            // Grupo A
            new Equipos("Mexico",                "MEX", 15),
            new Equipos("Sudafrica",             "RSA", 60),
            new Equipos("Corea del Sur",         "KOR", 25),
            new Equipos("Chequia",               "CZE", 41),
            // Grupo B
            new Equipos("Canada",                "CAN", 30),
            new Equipos("Bosnia y Herzegovina",  "BIH", 65),
            new Equipos("Catar",                 "QAT", 55),
            new Equipos("Suiza",                 "SUI", 19),
            // Grupo C
            new Equipos("Brasil",                "BRA",  6),
            new Equipos("Marruecos",             "MAR",  8),
            new Equipos("Haiti",                 "HAI", 83),
            new Equipos("Escocia",               "SCO", 43),
            // Grupo D
            new Equipos("Estados Unidos",        "USA", 16),
            new Equipos("Paraguay",              "PAR", 40),
            new Equipos("Australia",             "AUS", 27),
            new Equipos("Turquia",               "TUR", 22),
            // Grupo E
            new Equipos("Alemania",              "GER", 10),
            new Equipos("Curazao",               "CUW", 82),
            new Equipos("Costa de Marfil",       "CIV", 34),
            new Equipos("Ecuador",               "ECU", 23),
            // Grupo F
            new Equipos("Países Bajos",          "NED",  7),
            new Equipos("Japon",                 "JPN", 18),
            new Equipos("Suecia",                "SWE", 38),
            new Equipos("Tunez",                 "TUN", 44),
            // Grupo G
            new Equipos("Belgica",               "BEL",  9),
            new Equipos("Egipto",                "EGY", 29),
            new Equipos("Iran",                  "IRN", 21),
            new Equipos("Nueva Zelanda",         "NZL", 85),
            // Grupo H
            new Equipos("Espana",                "ESP",  2),
            new Equipos("Cabo Verde",            "CPV", 69),
            new Equipos("Arabia Saudita",        "KSA", 61),
            new Equipos("Uruguay",               "URU", 17),
            // Grupo I
            new Equipos("Francia",               "FRA",  1),
            new Equipos("Senegal",               "SEN", 14),
            new Equipos("Irak",                  "IRQ", 57),
            new Equipos("Noruega",               "NOR", 31),
            // Grupo J
            new Equipos("Argentina",             "ARG",  3),
            new Equipos("Argelia",               "ALG", 28),
            new Equipos("Austria",               "AUT", 24),
            new Equipos("Jordania",              "JOR", 63),
            // Grupo K
            new Equipos("Portugal",              "POR",  5),
            new Equipos("RD Congo",              "COD", 46),
            new Equipos("Uzbekistan",            "UZB", 50),
            new Equipos("Colombia",              "COL", 13),
            // Grupo L
            new Equipos("Inglaterra",            "ENG",  4),
            new Equipos("Croacia",               "CRO", 11),
            new Equipos("Ghana",                 "GHA", 74),
            new Equipos("Panama",                "PAN", 33),
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
