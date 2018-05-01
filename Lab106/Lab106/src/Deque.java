
/**
 *
 * @author Marie Larson
 * @version 2/26/18
 */
public interface Deque<E> {
    //returns number of elements in Deque
    int size();
    
    //checks if deque is empty
    boolean isEmpty();
    
    //returns but does not remove first element of deque
    E first();
    
    //returns but does not remove last element of deque
    E last();
    
    //adds an element to beginning of deque
    void addFirst(E e);
    
    //adds an element to end of deque
    void addLast(E e);
    
    //removes and returns the first element of deque
    E removeFirst();
    
    //returns and removes the last element of deque
    E removeLast();
    
}
