
/**
 *
 * @author Marie Larson
 * @version 2/12/2018
 */
public interface Bag<E> {
    
    //Finds current size of the array
    int getSize();
    
    //Checks if bag is empty
    boolean Empty();
    
    //checks if bag is full
    boolean Full();
    
    //adds an item to the bag
    boolean add( E num);
    
    //removes a random item of the bag
    E remove();
    
    //clears contents of bag
    void clear();
    
    //finds the frequency of an item in the bag
    int getFrequency( E var );
    
    //removes the first occurence of var E
    boolean remove( E var );
    
    //checks if an item is contained in the bag
    boolean contains( E var);
    
    //returns the String representation of the contents of the bag
    @Override
    String toString();
    
    //returns true if the contents of the two bags are equal
    @Override
    boolean equals(Object o);
}
