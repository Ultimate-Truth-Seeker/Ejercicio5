package Ejercicio5;
/**
 * superclase para todos los tipos de jugadores
 * @author Ultimate-Truth-Seeker
 * @version 13-10-2023
 */

public abstract class Player {
    /**
     * nombre del jugador
     */
    protected String name;
    /**
     * país del jugador
     */
    protected String country;
    /**
     * fallos del jugador
     */
    protected int fails;
    /**
     * aces del jugador
     */
    protected int aces;
    /**
     * servicios del jugador
     */
    protected int services;
    /**
     * Constructor de la clase
     * @param name
     * @param country
     * @param fails
     * @param aces
     * @param services
     */
    public Player(String name, String country, int fails, int aces, int services) {
        this.name = name;
        this.country = country;
        this.fails = fails;
        this.aces = aces;
        this.services = services;
    }
    /**
     * getter de nombre
     * @return nombre
     */
    public String getName() {
        return name;
    }
    /**
     * getter de país
     * @return país
     */
    public String getCountry() {
        return country;
    }
    /**
     * getter de fallos
     * @return fallos
     */
    public int getFails() {
        return fails;
    }
    /**
     * getter de aces
     * @return aces
     */
    public int getAces() {
        return aces;
    }
    /**
     * getter de servicios
     * @return servicios
     */
    public int getServices() {
        return services;
    }
    /**
     * Métodos abstracto de effectividad. 
     * @return el cálculo específico de efectividad de cada jugador
     */
    protected abstract float efectivity();
}
