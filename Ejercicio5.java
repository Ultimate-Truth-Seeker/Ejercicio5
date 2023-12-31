//package Ejercicio5;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Programa para aplicación de jugadores de volleyball
 * Se cargan datos desde un csv al inicio y al salir da opción de guardar los datos del programa en otro o el mismo csv
 * NOTA: se asume que la primera línea contiene datos de un jugador y no nombres del tipo de dato
 * NOTA: Hay que compilarlo desde la carpeta donde está el programa, sino no compila. Usar % java Ejercicio5
 * 
 * @author Ultimate-Truth-Seeker
 * @version 13-10-2023
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        System.out.println("Bienvenido, ingrese el nombre de su csv con datos de jugadores");
        String path = s.nextLine();
        boolean menu = true;
        try (Scanner rd = new Scanner(new File(path))){// Escaneo del archivo csv, catch si ocurre un fallo
            while (rd.hasNextLine()) {
                Scanner sc = new Scanner(rd.nextLine());
                sc.useDelimiter(",");
                String name = sc.next();
                String country = sc.next();
                int fails= Integer.parseInt(sc.next());
                int aces = Integer.parseInt(sc.next());
                int services = Integer.parseInt(sc.next());
                String det = sc.next();
                if (det.charAt(0) != "t".charAt(0) && det.charAt(0) != "f".charAt(0)) {
                    int int1 = Integer.parseInt(det);
                    if (sc.hasNext()) {
                        int feints = Integer.parseInt(sc.next());
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
                    int atacks = Integer.parseInt(sc.next());
                    int bloqued = Integer.parseInt(sc.next());
                    int failedBlock = Integer.parseInt(sc.next());
                    OppositeAuxiliar o = new OppositeAuxiliar(name, country, fails, aces, services, OA, atacks, bloqued, failedBlock);
                    players.add(o);
                }
            }
            
        } catch (Exception FileNotFoundException) {// Error de lectura
            System.out.println("Error al leer archivo, revise que todos los datos estén correctos\nIngresando a menú...");
        }
        while (menu) {// Ingresa a menú independiente de si leyo o no el documento
            System.out.println("Bienvenido, elija una opción:\n1.Añadir jugador al sistema\n2.Mostrar todos los jugadores inscritos\n3.Mejores jugadores\n4.Guardar en csv y salir");
            int op = s.nextInt();
            switch (op) {
                default:
                break;
                case 1:// añadir un jugador más al programa
                System.out.println("Ingrese el nombre del jugador:");
                s.nextLine();
                String name = s.nextLine();
                System.out.println("Ingrese el país del jugador:");
                String country = s.nextLine();
                System.out.println("Ingrese el número de fallos del jugador:");
                int fails = s.nextInt();
                System.out.println("Ingrese el número de aces del jugador:");
                int aces = s.nextInt();
                System.out.println("Ingrese el número de servicios del jugador:");
                int services = s.nextInt();
                while (services < aces) {
                    System.out.println("Los servicios son mayores o iguales a los aces");
                    services = s.nextInt();
                }
                System.out.println("Ingrese 1 si es un líbero, 2 si es un pasador, 3 si es un opuesto, 4 si es un auxiliar");
                int type = s.nextInt();
                while (type < 1 && type > 4) {
                    type = s.nextInt();
                }
                switch (type) {// Campos específicos para cada tipo de jugador
                    case 1:
                    System.out.println("Ingresse las capturas efectivas del líbero:");
                    int effectiveCatch = s.nextInt();
                    Sweeper sweeper = new Sweeper(name, country, fails, aces, services, effectiveCatch);
                    players.add(sweeper);
                    break;
                    case 2:
                    System.out.println("Ingrese los pases del pasador:");
                    int passings = s.nextInt();
                    System.out.println("Ingrese las fintas del pasador:");
                    int feints = s.nextInt();
                    Feinter feinter = new Feinter(name, country, fails, aces, services, passings, feints);
                    players.add(feinter);
                    break;
                    case 3:
                    boolean OA = true;
                    System.out.println("Ingrese los ataques:");
                    int atacks = s.nextInt();
                    System.out.println("Ingrese los bloquos efectivos:");
                    int bloqued = s.nextInt();
                    System.out.println("Ingrese los bloqueos fallidos:");
                    int failedBlock = s.nextInt();
                    OppositeAuxiliar opposite = new OppositeAuxiliar(name, country, fails, aces, services, OA, atacks, bloqued, failedBlock);
                    players.add(opposite);
                    break;
                    case 4:
                    OA = false;
                    System.out.println("Ingrese los ataques:");
                    atacks = s.nextInt();
                    System.out.println("Ingrese los bloqueos efectivos:");
                    bloqued = s.nextInt();
                    System.out.println("Ingrese los bloqueos fallidos:");
                    failedBlock = s.nextInt();
                    OppositeAuxiliar auxiliar = new OppositeAuxiliar(name, country, fails, aces, services, OA, atacks, bloqued, failedBlock);
                    players.add(auxiliar);
                    break;
                }
                break;
                case 2:// Listado de jugadores uno por uno
                System.out.println("Listado de jugadores");
                for (Player ply : players) {
                    System.out.println("Nombre: "+ ply.getName() +", País: " + ply.getCountry()+", Fallos: "+ply.getFails()+", Aces: "+ply.getAces()+", Servicios: "+ply.getServices());
                    if (ply.getClass() == OppositeAuxiliar.class) {
                        OppositeAuxiliar oa = (OppositeAuxiliar) ply;
                        if (oa.isOA()) {
                            System.out.println("Clase: Opuesto, Ataques: "+oa.getAtacks()+", Bloqueos efectivos: "+oa.getBloqued()+", Bloqueos fallidos: "+oa.getFailedBlock());
                        } else {
                            System.out.println("Clase: Auxiliar, Ataques: "+oa.getAtacks()+", Bloqueos efectivos: "+oa.getBloqued()+", Bloqueos fallidos: "+oa.getFailedBlock());
                        }
                    } else if (ply.getClass() == Feinter.class) {
                        Feinter f = (Feinter) ply;
                        System.out.println("Clase: Pasador, Pases: "+f.getPassings()+", Fintas: "+f.getFeints());
                    } else if (ply.getClass() == Sweeper.class) {
                        Sweeper sw = (Sweeper) ply;
                        System.out.println("Clase: Líbero, Capturas efectivas: "+sw.getEffectiveCatch());
                    }
                    System.out.println("Efectividad: " + ply.efectivity());
                }
                break;
                case 3:// Pasadores con efectividad > 80
                System.out.println("Pasadores con más de 80% de efectividad");
                for (Player ply : players) {
                    if (ply.getClass() == Feinter.class && ply.efectivity() > 80) {
                        System.out.println(ply.getName() + ": " + ply.efectivity()+"%");   
                    }
                }// 3 Líberos con mayor efectividad
                System.out.println("Los tres mejores Líberos:");
                int[] indexes = new int[3]; indexes[0] = -1; indexes[1] = -1; indexes[2] = -1;
                for (int x = 0; x < 3; x++) {
                    float max = -101; int newindex = -1;
                    for (Player ply : players) {
                        if (ply.getClass() == Sweeper.class && ply.efectivity() >= max) {
                            int trial = players.indexOf(ply);
                            if (indexes[0] != trial && indexes[1] != trial && indexes[2] != trial) {
                                newindex = trial;
                                max = ply.efectivity();

                            }
                        }
                    }
                    indexes[x] = newindex;
                }
                for (int x : indexes) {
                    if (x != -1) {
                        System.out.println(players.get(x).getName() + ": " + players.get(x).efectivity() + "%");
                    }
                }
                System.out.println("(La efectividad va de -100% a 200%)");
                break;
                case 4:// Salida
                menu = false;
                System.out.println("Ingrese el nombre del archivo en que desea guardar los datos o deje en blanco para no guardar. La extensión .csv se añade automáticamente");
                s.nextLine();
                path = s.nextLine();
                if (path.equals("") == false) {//Si se ingreso nombre de archivo a crear escribir datos en el archivo
                    try (FileWriter wr = new FileWriter(new File(path + ".csv"))) {
                        for (Player ply : players) {
                            if (ply.getClass() == OppositeAuxiliar.class) {
                                OppositeAuxiliar oa = (OppositeAuxiliar) ply;
                                wr.write(ply.getName() +"," + ply.getCountry()+","+ply.getFails()+","+ply.getAces()+","+ply.getServices()+","+oa.isOA()+","+oa.getAtacks()+","+oa.getBloqued()+","+oa.getFailedBlock()+"\n");
                            } else if (ply.getClass() == Feinter.class) {
                                Feinter f = (Feinter) ply;
                                wr.write(ply.getName() +"," + ply.getCountry()+","+ply.getFails()+","+ply.getAces()+","+ply.getServices()+","+f.getPassings()+","+f.getFeints()+"\n");
                            } else if (ply.getClass() == Sweeper.class) {
                                Sweeper sw = (Sweeper) ply;
                                wr.write(ply.getName() +"," + ply.getCountry()+","+ply.getFails()+","+ply.getAces()+","+ply.getServices()+","+sw.getEffectiveCatch()+"\n");
                            }
                        }
                        System.out.println("Escritura exitosa");
                    } catch (Exception e) {
                        System.out.println("Error al escribir csv");
                    }
                }
                break;
            }
        }
        
        s.close();
    }    
}
