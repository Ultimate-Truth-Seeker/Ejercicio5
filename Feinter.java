package Ejercicio5;
/**
 * clase para pasadores
 * @author Ultimate-Truth-Seeker
 * @version 13-10-2023
 */
public class Feinter extends Player {
    /**
     * pases del jugador
     */
    int passings;
    /**
     * fintas del jugador
     */
    int feints;
    
    /**
     * getter de pases
     * @return pases
     */
    public int getPassings() {
        return passings;
    }

    /**
     * getter de fintas
     * @return fintas
     */
    public int getFeints() {
        return feints;
    }

    /**
     * constructor de la clase
     * @param name
     * @param country
     * @param fails
     * @param aces
     * @param services
     * @param passings
     * @param feints
     */
    public Feinter(String name, String country, int fails, int aces, int services, int passings, int feints) {
        super(name, country, fails, aces, services);
        this.passings = passings;
        this.feints = feints;
    }
    @Override
    public float efectivity() {
        float e = (this.passings + this.feints - this.fails)*100/(this.passings + this.feints + this.fails) + (100*this.aces/this.services);
        return e;
    }
    
}
