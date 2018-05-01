
/**
 *
 * @author Marie Larson
 * @version 3/21/18
 */
public class LinkedQueue<E> implements Queue<E> {
    private final SinglyLinkedList<E> list = new SinglyLinkedList<>();//empty list
    public LinkedQueue(){}
    //new queue relies on initially empty list
    @Override
    public int size(){return list.size();}
    @Override
    public boolean isEmpty(){return list.isEmpty();}
    @Override
    public void enqueue(E element){list.addLast(element);}
    @Override
    public E first(){return list.first();}
    @Override
    public E dequeue(){return list.removeFirst();}
    
}
