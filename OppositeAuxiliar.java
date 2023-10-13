package Ejercicio5;
/**
 * clase para opuesstos y auxiliares
 * @author Ultimate-Truth-Seeker
 * @version 13-10-2023
 */
public class OppositeAuxiliar extends Player{
    /**
     * verdadero si es opuesto, falso si es auxiliar
     */
    boolean OA;
    /**
     * ataques del jugador
     */
    int atacks;
    /**
     * bloqueos efectivos del jugador
     */
    int bloqued;
    /**
     * bloques fallidos del jugador
     */
    int failedBlock;
    /**
     * constructor de la clase
     * @param name
     * @param country
     * @param fails
     * @param aces
     * @param services
     * @param oA
     * @param atacks
     * @param bloqued
     * @param failedBlock
     */
    public OppositeAuxiliar(String name, String country, int fails, int aces, int services, boolean oA, int atacks,
            int bloqued, int failedBlock) {
        super(name, country, fails, aces, services);
        OA = oA;
        this.atacks = atacks;
        this.bloqued = bloqued;
        this.failedBlock = failedBlock;
    }
    /**
     * getter de OA
     * @return true si es opuesto, false si es auxiliar
     */
    public boolean isOA() {
        return OA;
    }
    /**
     * getter de ataques
     * @return ataques
     */
    public int getAtacks() {
        return atacks;
    }
    /**
     * getter de bloqueos efectivos
     * @return bloqueos efectivos
     */
    public int getBloqued() {
        return bloqued;
    }
    /**
     * getter de bloqueos fallidos
     * @return bloqueos fallidos
     */
    public int getFailedBlock() {
        return failedBlock;
    }
    @Override
    public float efectivity() {
        float e = (this.atacks + this.bloqued -this.failedBlock- this.fails)*100/(this.atacks + this.bloqued + this.failedBlock+this.fails) + (100*this.aces/this.services);
        return e;
    }
    
}
