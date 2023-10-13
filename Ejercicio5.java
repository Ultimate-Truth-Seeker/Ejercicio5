package Ejercicio5;

import java.util.ArrayList;
import java.util.List;
/**
 * Programa para aplicación de jugadores de volleyball
 * @author Ultimate-Truth-Seeker
 * @version 13-10-2023
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Sweeper("n", "c", 0, 10, 10, 10));
        players.add(new Feinter("n", "c", 0, 10, 10, 10, 10));
        for (Player p : players) {
            
            System.out.println(p.efectivity());
        }
    }    
}
