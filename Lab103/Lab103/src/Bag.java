
/**
 *
 * @author Marie Larson
 * @version 2/3/2018
 */
public interface Bag<E> {
    
    //returns current count of items in bag
    int CurrentCount();
    
    //checks if bag is empty
    boolean CheckEmpty();
    
    //checks if bag is full
    boolean CheckFull();
    
    //adds an item to the bag and returns true when item is added and false if item is not added
    boolean Adder(E num);
    
    //removes a random item from and returns this item
    E remove();
    
    //removes the first occurence of a specific item from bag and returns true if successful and false if it fails.
    boolean remove(E num);
    
    //clears all items from bag
    void clear();
    
    //returns count of occurence of a specific item in bag
    int CountOfOccurence(E num);
    
    //checks if an item exists in a bag
    boolean CheckExistence(E num);
    
    //returns string representation of the contents of the bag
    String toString();
    
    //returns true if the contents of the two bags are equal.
    boolean equals(Object o);
    
}
