package fi.lleevi.urbanminigolf.game.objects;

/**
 * Liikuvan objektin rajapinta.
 * 
 * @author lleevi
 */
public interface Movable {
    /**
     * Päivitetään liikkuvia objekteja.
     * 
     * @param delta päivitysten välinen aika
     */
    void update(double delta);
}
