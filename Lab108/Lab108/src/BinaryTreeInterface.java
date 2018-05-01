
/**
 *
 * @author Marie Larson
 * @version 3/21/18
 */
//An interface for a binary tree, in which each node has at most two children.
public interface BinaryTreeInterface<E> extends TreeInterface<E> {
    
    //returns the position of p's left child (or null if no child exists).
    Position<E> left(Position<E> p) throws IllegalArgumentException;
    
    //Returns the position of p's right child (or null if no child exists).
    Position<E> right(Position<E> p) throws IllegalArgumentException;
    //Returns the position of p's sibling (or null if no sibling exists).
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
