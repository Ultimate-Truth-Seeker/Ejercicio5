package Ejercicio5;
/**
 * clase para líberos
 * @author Ultimate-Truth-Seeker
 * @version 13-10-2023
 */
public class Sweeper extends Player {
    /**
     * capturas efectivas
     */
    int effectiveCatch;

    /**
     * constructor de la clase
     * @param name
     * @param country
     * @param fails
     * @param aces
     * @param services
     * @param effectiveCatch
     */
    public Sweeper(String name, String country, int fails, int aces, int services, int effectiveCatch) {
        super(name, country, fails, aces, services);
        this.effectiveCatch = effectiveCatch;
    }

    /**
     * getter de capturas efectivas
     * @return capturas efectivas
     */
    public int getEffectiveCatch() {
        return effectiveCatch;
    }
    @Override
    public float efectivity() {
        float e = (this.effectiveCatch - this.fails)*100/(this.effectiveCatch + this.fails) + (100*this.aces/this.services);
        return e;

    }
    
}
