
/**
 *
 * @author marie
 * @param <E>
 */
public interface Iterator<E> {
    boolean hasNext();
    
    E next();
    
    void remove() throws IllegalStateException;
}
