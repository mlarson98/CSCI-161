
/**
 *
 * @author marie
 */
public class SinglyLinkedList<E> {
 //--------------------------nested Node class----------------------------
  private static class Node<E>{
   private E element;
   private Node<E> next;
   public Node(E e, Node<E> n){
       element = e;
       next = n;
   }
   public E getElement() {
       return element;
   }
   public Node<E> getNext(){
       return next;
   }
   public void setNext(Node<E> n){
       next = n;
   }
  }
  //---------------------End of nested Node Class-----------------------------
  
  //instance variables of the SinglyLinkedList
  private Node<E> head = null; //head node of the list (or null if empty)
  private Node<E> tail = null; //last node of the list (or null if empty)
  private int size = 0; //number of nodes in the list
  public SinglyLinkedList(){
      
  }
  
  //access methods
  public int size(){
      return size;
  }
  public boolean isEmpty(){
      return size == 0;
  }
  //returns but does not use remove the first element
  public E first(){
      if(isEmpty()) return null;
      return head.getElement();
  }
  
  //returns but does not remove the last element.
  public E last(){  
      if(isEmpty()) return null;
      return tail.getElement();
  }
  
  
  //update methods
  public void addFirst(E e){
      head = new Node<>(e, head);
      if(size==0){
          tail = head;
      }
      size++;
  }
  public void addLast(E e){
      Node<E> newest = new Node<>(e, null);
      if(isEmpty())
          head = newest;
      else
          tail.setNext(newest);
      tail = newest;
      size++;
  }
  public E removeFirst(){
      if(isEmpty()) return null;
      E answer = head.getElement();
      head = head.getNext();
      size--;
      if(size==0)
          tail = null;
      return answer;
  }
  
  //string method
  public String toString(){
      String temp = getClass().getName()+ "@ size: " + size;
      
      for(int i =0;i<size;i++){
          E r = removeFirst();
          temp += " : " + r;
          addLast(r);
      }
      return temp;
  }
}