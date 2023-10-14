package Ejercicio5;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Programa para aplicación de jugadores de volleyball
 * @author Ultimate-Truth-Seeker
 * @version 13-10-2023
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String path = s.nextLine();
        boolean menu = true;
        try (Scanner rd = new Scanner(new File(path))){
            while (rd.hasNextLine()) {
                Scanner sc = new Scanner(rd.nextLine());
                sc.useDelimiter(",");
                String name = sc.next();
                String country = sc.next();
                int fails= sc.nextInt();
                int aces = sc.nextInt();
                int services = sc.nextInt();
                String det = sc.next();
                if (det.length() == 1) {
                    int int1 = (int) det.charAt(0);
                    if (sc.hasNext()) {
                        int feints = sc.nextInt();
                        Feinter f = new Feinter(name, country, fails, aces, services, int1, feints);
                        players.add(f);
                    } else {
                        Sweeper sw = new Sweeper(name, country, fails, aces, services, int1);
                        players.add(sw);
                    }
                } else {
                    boolean OA = false;
                    if (det.equals("true")) {
                        OA = true;
                    } else if (det.equals("false")) {
                        OA = false;
                    }
                    int atacks = sc.nextInt();
                    int bloqued = sc.nextInt();
                    int failedBlock = sc.nextInt();
                    OppositeAuxiliar o = new OppositeAuxiliar(name, country, fails, aces, services, OA, atacks, bloqued, failedBlock);
                    players.add(o);
                }
            }
            
        } catch (Exception FileNotFoundException) {
            menu = false;
        }
        while (menu) {
            int op = s.nextInt();
            switch (op) {
                default:
                break;
                case 1:

                break;
                case 2:
                for (Player ply : players) {
                    if (ply.getClass() == OppositeAuxiliar.class) {
                        OppositeAuxiliar oa = (OppositeAuxiliar) ply;
                        System.out.println(ply.getName() +"," + ply.getCountry()+","+ply.getFails()+","+ply.getAces()+","+ply.getServices()+","+oa.isOA()+","+oa.getAtacks()+","+oa.getBloqued()+","+oa.getFailedBlock());
                    } else if (ply.getClass() == Feinter.class) {
                        Feinter f = (Feinter) ply;
                        System.out.println(ply.getName() +"," + ply.getCountry()+","+ply.getFails()+","+ply.getAces()+","+ply.getServices()+","+f.getPassings()+","+f.getFeints());
                    } else if (ply.getClass() == Sweeper.class) {
                        Sweeper sw = (Sweeper) ply;
                        System.out.println(ply.getName() +"," + ply.getCountry()+","+ply.getFails()+","+ply.getAces()+","+ply.getServices()+","+sw.getEffectiveCatch());
                    }
                }
                break;
                case 3:
                for (Player ply : players) {
                    if (ply.getClass() == Feinter.class && ply.efectivity() > 80) {
                        System.out.println(ply.getName() + ": " + ply.efectivity()+"%");   
                    }
                }
                break;
            }
        }
        try (FileWriter wr = new FileWriter(new File(path))) {
            for (Player ply : players) {
                if (ply.getClass() == OppositeAuxiliar.class) {
                    OppositeAuxiliar oa = (OppositeAuxiliar) ply;
                    wr.write(ply.getName() +"," + ply.getCountry()+","+ply.getFails()+","+ply.getAces()+","+ply.getServices()+","+oa.isOA()+","+oa.getAtacks()+","+oa.getBloqued()+","+oa.getFailedBlock());
                } else if (ply.getClass() == Feinter.class) {
                    Feinter f = (Feinter) ply;
                    wr.write(ply.getName() +"," + ply.getCountry()+","+ply.getFails()+","+ply.getAces()+","+ply.getServices()+","+f.getPassings()+","+f.getFeints());
                } else if (ply.getClass() == Sweeper.class) {
                    Sweeper sw = (Sweeper) ply;
                    wr.write(ply.getName() +"," + ply.getCountry()+","+ply.getFails()+","+ply.getAces()+","+ply.getServices()+","+sw.getEffectiveCatch());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
        s.close();
    }    
}
