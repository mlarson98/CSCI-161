
/**
 *
 * @author Marie Larson
 * @version 2/6/2018
 */
public class SinglyLinkedList<E> {
    //--------Nested Node Class-----------
    private static class Node<E>{
        private E num;
        
        private Node<E> next;
        
        public Node(E e, Node<E> n){
            num = e;
            next = n;
        }
        
        public E getNum(){
            return num;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> n){
            next = n;
        }
    }
    //----------End nested Node class---------
    private Node<E> heads = null;
    private Node<E> tails = null;
    
    private int size = 0;
    
    public SinglyLinkedList(){}
    
    //methods
    public int siz(){
        return size;
    }
    
    public boolean CheckEmpty(){
        return size == 0;
    }
    
    public E first(){
        if(CheckEmpty()) return null;
        return heads.getNum();
    }
    
    public E last(){
        if(CheckEmpty()) return null;
        return tails.getNum();
    }
    
    public void addFirst(E e){
        heads = new Node<>(e, heads);
        if(size==0){
            tails = heads;
            
            size++;
        }
    }
    
    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if(CheckEmpty()){
            heads = newest;
        }
        else{
            tails.setNext(newest);
            tails = newest;
            size++;
        }
    }
    
    public E removeFirst(){
        if(CheckEmpty()) return null;
        
        E anw = heads.getNum();
        heads = heads.getNext();
        size--;
        
        if(size == 0)
            tails = null;
        
        return anw;
    }
}
