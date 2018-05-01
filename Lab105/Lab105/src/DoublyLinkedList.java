
/**
 *
 * @author Marie Larson
 * @version 2/20/2018
 * @param <E>
 */
public class DoublyLinkedList<E> {
    //--------------------------nested node class----------------------------
    public class Node<E>{
        private Node<E> prev;
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n, Node<E> p){
            element = e;
            next = n;
            prev = p;
        }
        public Node<E> getPrev(){
            return prev;
        }
        public Node<E> setPrev(Node<E> p){
            return prev;
        }
        public E getElement(){
            return element;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> n){
            next = n;
        }
        
    }
    //------------------------end of nested node class--------------------------------
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    
    public DoublyLinkedList(){
    head = new Node<>(null,null,null);
    tail = new Node<>(null,head,null);
    head.setNext(tail);
    }
    /**
     * returns size of list
     * @return 
     */
    //access methods
  public int size(){
      return size;
  }
  /**
   * Tests list for emptiness
   * @return 
   */
  public boolean isEmpty(){
      return size == 0;
  }
  /**
   * returns but does not use remove the first element
   * @return 
   */
  public E first(){
      if(isEmpty()) return null;
      return head.getNext().getElement();
  }
  
  /**
   * returns but does not remove the last element.
   * @return
   */
  public E last(){  
      if(isEmpty()) return null;
      return tail.getPrev().getElement();
  }
  
  
  //update methods
  /**
   * adds element e to beginning of list
   * @param e 
   */
  public void addFirst(E e){
      addBetween(e, head, head.getNext());
      size++;
}
  public void addLast(E e){
     addBetween(e, tail, tail.getPrev());
  }
  public E removeFirst(){
      if(isEmpty()) return null;
      return remove(head.getNext());
  }
  public E removeLast(){
      if(isEmpty()) return null;
      return remove(tail.getPrev());
  }
  
  
  
  //adding private methods
  private void addBetween(E e, Node<E> predecessor, Node<E> successor){
      Node<E> newest = new Node<>(e, predecessor, successor);
      predecessor.setNext(newest);
      successor.setPrev(newest);
      size++;
  }
  private E remove(Node<E> node){
      Node<E> predecessor = node.getPrev();
      Node<E> successor = node.getNext();
      predecessor.setNext(successor);
      successor.setPrev(predecessor);
      size--;
      return node.getElement();
  }
  
  
  @Override
  public String toString(){
      String temp = getClass().getName() + "@ size: " + size;
      
      for( int i = 0; i<size;i++){
            E r = removeFirst();
            temp += " : " + r;
            addLast(r);
      }
      return temp;
  }
    
}
