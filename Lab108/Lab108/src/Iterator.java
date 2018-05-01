
/**
 *
 * @author Marie Larson
 * @version 3/21/18
 */
public interface Iterator<E> {
    boolean hasNext();
    E next();
    void remove() throws IllegalStateException;
}
