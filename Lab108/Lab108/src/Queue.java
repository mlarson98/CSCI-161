
/**
 *
 * @author Marie Larson
 * @version 3/21/18
 */
public interface Queue<E> {
    //Returns the number of elements in queue
    int size();
    
    //Checks if queue is empty
    boolean isEmpty();
    
    //Inserts an element at end of the queue
    void enqueue(E e);
    
    //Returns but does not remove the first element of the queue(null if empty).
    E first();
    
    //Removes and returns the first element of the queue(null if empty).
    E dequeue();
}
