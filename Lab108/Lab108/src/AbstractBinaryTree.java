import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Marie Larson
 * @version 3/21/18
 * @param <E>
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTreeInterface<E> {
    @Override
    //Returns the Position of p's sibling(or null if no sibling exists).
    public Position<E> sibling(Position<E> p){
        Position<E> parent = parent(p);
        if(parent == null) return null; //p must be root
        if(p==left(parent)) //p is a left child
            return right(parent);   //(right child might be null)
        else    //p is a right child
            return left(parent);    //(left child might be null)
    }
    @Override
    //Returns the number of children of Position p.
    public int numChildren(Position<E> p){
        int count = 0;
        if(left(p) != null)
            count++;
        if(right(p) != null)
            count++;
        return count;
    }
    @Override
    //Returns an iterable collection of the Positions representing p's children.
    public Iterable<Position<E>> children(Position<E> p){
        List<Position<E>> snapshot = new ArrayList<>(2); //max capacity of 2
        if(left(p) != null)
            snapshot.add(left(p));
        if(right(p) != null)
            snapshot.add(right(p));
        return (Iterable<Position<E>>) snapshot;
    }

    //Adds positions of the subtree rooted at position p to the given snapshot.
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot){
        snapshot.add(p);
        for (Position<E> c : children(p)){
            preorderSubtree(c, snapshot);
        }
    }
    
    //Returns an iterable collection of positions for the tree, reported in preorder.
    public Iterable<Position<E>> preOrder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty()){
            preorderSubtree(root(), snapshot);
        }
        return (Iterable<Position<E>>) snapshot;
    }
    
    //Adds positions of the subtree rooted at Position p to the given snapshot.
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot){
        for(Position<E> c : children(p))
            postorderSubtree(c, snapshot);
        snapshot.add(p);
    }
    
    //Returns an iterable collection of positions of the tree, reported in postorder.
    public Iterable<Position<E>> postOrder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
            postorderSubtree(root(), snapshot);
        return(Iterable<Position<E>>) snapshot;
    }
    
    //Returns an iterable colection of positions for the tree in breadth-first order.
    public Iterable<Position<E>> breadthfirst(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty()){
            Queue<Position<E>> fringe = new LinkedQueue<Position<E>>();
            fringe.enqueue(root());
            while(!fringe.isEmpty()){
                Position<E> p = fringe.dequeue();
                snapshot.add(p);
                for(Position<E> c : children(p))
                    fringe.enqueue(c);
            }
        }
        return snapshot;
    }
    
    //Adds positions of the subtree rooted at Postion p to the given snapshot.
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot){
        if(left(p) != null)
            inorderSubtree(left(p), snapshot);
        snapshot.add(p);
        if(right(p) != null)
            inorderSubtree(right(p), snapshot);
    }
    
    //Returns an iterable collection of positions of the tree, reported in inorder.
    public Iterable<Position<E>> inOrder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
            inorderSubtree(root(), snapshot);
        return snapshot;
    }
    
    //Overrides positions to make inorder the default order for binary trees.
    @Override
    public Iterable<Position<E>> positions(){
        return inOrder();
    }
}
