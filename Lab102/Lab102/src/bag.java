
/**
 *
 * @author Marie Larson
 * @version 1/23/18
 */
public interface bag {
    //returns a count of numbers in the bag
    int getCurrentSize();
    
    //checks if the bag is empty, returns true when empty
    boolean isEmpty();
    
    //adds a new number num to the bag
    void add(int num);
    
    //removes the first occurence of the number num from the bag
    void remove (int num);
    
    //removes randonly selected entry from the bag
    void remove();
    
    //removes all the numbers from the bag
    void Clear();
    
    //returns a count the number of times the number num exists in the bag
    int getFrequencyOf(int num);
    
    //tests whether the bag contains the number num. Returns true when the num is contained in the bag
    boolean contains(int num);
    
    //returns a String of the contents of the bag
    String toString();
    
    //returns a true if the parameter o exactly matches the contents of the bag(i.e. same numbers in the same order)
    boolean equals(Object o);
    
}
