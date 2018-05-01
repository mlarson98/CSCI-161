import java.util.NoSuchElementException;
/**
 *
 * @author marie
 * @param <E>
 */
public class LinkedPositionalList<E> extends Position implements Position<E> {
    //---------------------Nested Node Class-------------------------
    private static class Node<E> extends Position implements Position<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
    
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }
        
        @Override
        public E getElement() throws IllegalStateException{
            if(next == null)
                throw new IllegalStateException("Position invalid");
            return element;
        }
        
        public Node<E> getPrev(){
            return prev;
        }
        
        public Node<E> getNext(){
            return next;
        }
        
        public void setElement(E e){
            element = e;
        }
        
        public void setPrev(Node<E> p){
            prev = p;
        }
        
        public void setNext(Node<E> n){
            next = n;
        }
    }
    //----------------------End Nested Node Class----------------------
    
    
    //--------------------Begin Nested PositionIterator class--------------------
    private class PositionIterator extends Iterator implements Iterator<Position<E>>{
        private Position<E> cursor = first();
        private Position<E> recent = null;
        
        @Override
        public Position<E> hasNext(){
            return (cursor != null);
        }
        @Override 
        public Position<E> next() throws NoSuchElementException{
            if(cursor == null) throw new NoSuchElementException("There isn't anything else");
            LinkedPositionalList.this.remove(recent);
            recent = null;
        }
    }
    //-------------------End Nested PositionIterator class-----------------
    
    //--------------------Nested PositionIterable Class-----------------------
    private class PositionIterable extends Iterable implements Iterable<Position<E>>{
        @Override
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }
    //---------------------End Nested PositionIterable Class----------------------
    
    public Iterable<Position<E>> positions(){
        return new PositionIterable();
    }
    
    //-------------------Begin Nested ElementIterator class-------------------
    private class ElementIterator extends Iterator implements Iterator<E>{
        Iterator<Position<E>> pIterator = new PositionIterator();
        @Override
        public boolean hasNext(){
            return pIterator.hasNext();
        }
        @Override
        public E next(){
            return pIterator.next().getElement();
        }
        @Override
        public void remove(){
            pIterator.remove();
        }
    }
        public Iterator<E> iterator(){
            return new ElementIterator();
        }
        
        private Node<E> head;
        private Node<E> tail;
        private int size = 0;
        
        public LinkedPositionalList(){
            head = new Node<> (null,null,null);
            tail = new Node<> (null, head, null);
            head.setNext(tail);
        }
        
        private Node<E> validate(Position<E> p) throws IllegalArgumentException{
            if(!(p instanceof Node)) throw new IllegalArgumentException("p invalid");
            Node<E> node = (Node<E>) p;
            if(node.getNext() == null)
                throw new IllegalArgumentException("p isn't in the list anymore");
            return node;
        }
        
        private Position<E> position(Node<E> node){
            if(node == head || node == tail)
                return null;
            return node;
        }
        
        public int size(){
            return size;
        }
        
        public boolean isEmpty(){
            return (size == 0);
        }
        
        public Position<E> first(){
            return position(head.getNext());
        }
        
        public Position<E> last(){
            return position(tail.getPrev());
        }
        
        public Position<E> before(Position<E> p) throws IllegalArgumentException{
            Node<E> node = validate(p);
            return position(node.getPrev());
        }
        
        public Position<E> after(Position<E> p) throws IllegalArgumentException{
            Node<E> node = validate(p);
            return position(node.getNext());
        }
        
        private Position<E> addBetween(E e, Node<E> pred, Node<E> var){
            Node<E> newest = new Node<>(e, pred, var);
            pred.setNext(newest);
            var.setPrev(newest);
            size++;
            return newest;
        }
        
        public Position<E> addFirst(E e){
            return addBetween(e, head, head.getNext());
        }
        
        public Position<E> addLast(E e){
            return addBetween(e, tail.getPrev(), tail);
        }
        
        public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException{
            Node<E> node = validate(p);
            return addBetween(e, node.getPrev(), node);
        }
        
        public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException{
            Node<E> node = validate(p);
            return addBetween(e, node, node.getNext());
        }
        
        public E set(Position<E> p, E e) throws IllegalArgumentException{
            Node<E> node = validate(p);
            E answer = node.getElement();
            node.setElement(e);
            return answer;
        }
        
        public E remove(Position<E> p) throws IllegalArgumentException{
            Node<E> node = validate(p);
            Node<E> predecessor = node.getPrev();
            Node<E> successor = node.getNext();
            predecessor.setNext(successor);
            successor.setPrev(predecessor);
            size--;
            E answer = node.getElement();
            node.setElement(null);
            node.setNext(null);
            node.setPrev(null);
            return answer;
        }
    
}
