
/**
 *
 * @author Marie Larson
 * @version 2/26/18
 */
public class ArrayDeque<E> implements Deque<E> {
    private E[] queue;
    private int size;
    private int start;
    
    //constructor
    public ArrayDeque(){
        this.queue = (E[]) new Object[16];
        this.size = 0;
        this.start = 0;
    }
    
    //returns number of elements in queue
    @Override
    public int size(){
        return size;
    }
    
    //checks if queue is empty
    @Override
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    //returns the first element in queue
    @Override
    public E first(){
        return queue[start];
    }
    
    //returns the last element in queue
    @Override
    public E last(){
        return queue[(start + size-1)%queue.length];
    }
    
    //adds an item to the front of queue
    @Override
    public void addFirst(E e){
        if(queue.length == size()){
            throw new IllegalArgumentException("ERROR: Queue is full");
        }
        if(start-- <= 0){
            start = queue.length -1;
        }
        if(size==0){
            start = 0;
        }
        queue[start] = e;
        size++;
    }
    
    //add an element to the end of queue
    @Override
    public void addLast(E e){
        if(queue.length == size()){
            throw new IllegalArgumentException("ERROR: Queue is full");
        }
        queue[(start + size++)%queue.length] = e;
    }
    
    //removes first element of queue
    @Override
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        E temp = first();
        queue[start++] = null;
        return temp;
    }
    
    //removes last element of queue
    @Override
    public E removeLast(){
        if(isEmpty()){
            return null;
        }
        E temp = last();
        queue[(start + --size)%queue.length] = null;
        return temp;
    }
    
    //equals method
    public boolean equal(Object o){
        if(!(o instanceof ArrayDeque)){
            return false;
        }
        
        ArrayDeque test = (ArrayDeque) o;
        
        if((this.size != test.size) || (this.start != test.start)){
            return false;
        }
        for(int i =0; i<size; i++){
            if(!queue[this.start+i].equals(test.queue[test.start+i])){
                return false;
            }
        }
        return true;
    }
    
    //string method
    @Override
    public String toString(){
        String temp = getClass().getName() + "@ size:" + size + " Start:" + start;
        for(int i=0;i<queue.length;i++){
            if(queue[i] != null){
                temp += ":" + queue[i];
            }
        }
        return temp;
    }
    
}
