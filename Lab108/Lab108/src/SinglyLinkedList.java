
/**
 *
 * @author Marie Larson
 * @version 3/21/18
 */
public class SinglyLinkedList<E> {
    //--------------------------nested node class--------------------------------
    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
        public E getElement(){return element;}
        public Node<E> getNext(){return next;}
        public void setNext(Node<E> n){next = n;}
    }
    //----------------------end of nested Node Class----------------------------
    
    //Instance variables of SinglyLinkedList
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    
    //constructs an initially empty list
    public SinglyLinkedList(){}
    
    //returns the size of the list
    public int size(){
        return size;
    }
    
    //determines if the list is empty
    public boolean isEmpty(){return size == 0;}
    
    //returns but does not remove first element
    public E first(){
        if(isEmpty()) {return null;}
        return head.getElement();
    }
    
    //Returns but does not remove the last element
    public E last(){
        if(isEmpty()){return null;}
        return tail.getElement();
    }
    
    //Adds an element to front of the list
    public void addFirst(E e){
        head = new Node<>(e, head);
        if(size==0)
            tail = head;
        size++;
    }
    
    //Adds an element to the end of the list
    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if(isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        
        tail = newest;
        size++;
    }
    
    //Returns and removes the first element
    public E removeFirst(){
        if(isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(size==0)
            tail = null;
        return answer;
    }
    
    //returns a formatted string regarding curent instance of the class
    public String toString(){
        String result = getClass().getName() + "@ size: " + size;
        for(int i = 0; i<size; i++){
            E temp = removeFirst();
            result += " : " + temp;
            addLast(temp);
        }
        return result;
    }
}
