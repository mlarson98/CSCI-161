
/**
 *
 * @author marie
 */
public class ListDeque<E> implements Deque<E> {
    private DoublyLinkedList<E> list;
    
    //constructor
    public ListDeque(){
        list = new DoublyLinkedList<>();
    }
    
    //returns size of the double ended queue
    @Override
    public int size(){
        return list.size();
    }
    
    //returns true if queue is empty
    @Override 
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    //returns the first element in queue
    @Override
    public E first(){
        return list.first();
    }
    
    //returns last element of queue
    @Override
    public E last(){
        return list.last();
    }
    
    //add an element to the beginning of queue
    @Override
    public void addFirst(E e){
        list.addFirst(e);
    }
    
    //adds an element to the end of queue
    @Override
    public void addLast(E e){
        list.addLast(e);
    }
    
    //return and remove the last element of queue
    @Override
    public E removeLast(){
        return list.removeLast();
    }
    
    //return and remove the first element of queue
    @Override
    public E removeFirst(){
        return list.removeFirst();
    }
    
    //equals method
    @Override
    public boolean equals(Object o){
        if(!(o instanceof ListDeque)){
            return false;
        }
        
        ListDeque test = (ListDeque<E>) o;
        for(int i = 0;i<size(); i++){
            E temp1 = this.removeFirst();
            E temp2 = (E) test.removeFirst();
            this.addLast(temp1);
            test.addLast(temp2);
            if(!temp1.equals(temp2)){
                return false;
            }
        }
        return true;
    }
    
    //toString method
    @Override
    public String toString(){
        String temp = getClass().getName() + "@";
        E hold;
        for(int i = 0; i<size(); i++){
            hold = this.removeFirst();
            temp += " : " + hold;
            this.addLast(hold);
        }
        return temp;
    }
}
