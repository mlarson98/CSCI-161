import java.util.ArrayList;
/**
 *
 * @author Marie Larson
 * @version 3/21/18
 */
public class ClientLab108 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Begin Lab108");
        System.out.println("Creating the following equation in a "
                + "linkedBinaryTree: (((5+2)*(2-1)/(2+9)+((7-2)-1))*8) ");
        
        //creating bottom branch
        LinkedBinaryTree<String> LBT1 = new LinkedBinaryTree<>();
        LBT1.addRoot("+");
        LBT1.addLeft(LBT1.root, "5");
        LBT1.addRight(LBT1.root, "2");
        
        LinkedBinaryTree<String> LBT2 = new LinkedBinaryTree<>();
        LBT2.addRoot("-");
        LBT2.addLeft(LBT2.root, "2");
        LBT2.addRight(LBT2.root, "1");
        
        LinkedBinaryTree<String> LBT3 = new LinkedBinaryTree<>();
        LBT3.addRoot("*");
        LBT3.attach(LBT3.root, LBT1, LBT2);
        
        LinkedBinaryTree<String> LBT4 = new LinkedBinaryTree<>();
        LBT4.addRoot("+");
        LBT4.addLeft(LBT4.root, "2");
        LBT4.addRight(LBT4.root, "9");
        
        LinkedBinaryTree<String> LBT5 = new LinkedBinaryTree<>();
        LBT5.addRoot("/");
        LBT5.attach(LBT5.root, LBT3, LBT4);
        
        LinkedBinaryTree<String> LBT6 = new LinkedBinaryTree<>();
        LBT6.addRoot("-");
        LBT6.addLeft(LBT6.root, "7");
        LBT6.addRight(LBT6.root, "2");
        
        LinkedBinaryTree<String> LBT8 = new LinkedBinaryTree<>();
        LBT8.addRoot("1");
        
        LinkedBinaryTree<String> LBT7 = new LinkedBinaryTree<>();
        LBT7.addRoot("-");
        LBT7.attach(LBT7.root, LBT7, LBT8);
        
        LinkedBinaryTree<String> LBT9 = new LinkedBinaryTree<>();
        LBT9.addRoot("+");
        LBT9.attach(LBT9.root, LBT5, LBT7);
        
        LinkedBinaryTree<String> LBT11 = new LinkedBinaryTree<>();
        LBT11.addRoot("8");
        
        LinkedBinaryTree<String> LBT10 = new LinkedBinaryTree<>();
        LBT10.addRoot("*");
        LBT10.attach(LBT10.root, LBT9, LBT11);
        
        System.out.println("\n\nA The preoder traversal of the tree");
        for(Position<String> p : LBT10.preOrder())
            System.out.print(p.getElement());
        
        System.out.println("\n\n The inOrder traversal of the tree");
        for(Position<String> p : LBT10.inOrder())
            System.out.print(p.getElement());
        
        System.out.println("\n\nThe postOrder traversal of the tree");
        for(Position<String> p : LBT10.postOrder())
            System.out.print(p.getElement());
        
        System.out.println("\n\nThe breathFirst traversal of the tree");
        for(Position<String> p : LBT10.breadthfirst())
            System.out.print(p.getElement());
        
        System.out.println("\n\nThe preOrderIndent traversal of the tree");
        printPreOrderIndent(LBT10, LBT10.root, 0);
        
        System.out.println("\n\nA The Parenthesized representation of the tree");
        parenthesize(LBT10, LBT10.root);
        
        System.out.println("\n\nEnd Lab108");
    }
    
    public static <E> void printPreOrderLabeled(TreeInterface<E> T, Position<E> p, ArrayList<Integer> path){
        int d = path.size();
        System.out.print(spaces(2*d));
        for(int i= 0; i<d; i++) System.out.print(path.get(i) + (i == d-1 ? " " : "."));
        System.out.println(p.getElement());
        path.add(1);
        
        for(Position<E> c : T.children(p)){
            printPreOrderLabeled(T, c, path);
            path.set(d, 1 + path.get(d));
        }
        path.remove(d);
    }
    
    private static String spaces(int t){
        String temp = "";
        for(int c = 0; c<t;c++)
            temp +=(" ");
        return temp;
    }
    
    public static int diskSpace(TreeInterface<Integer> T, Position<Integer> p){
        int subtotal = p.getElement();
        for(Position<Integer> c : T.children(p))
            subtotal += diskSpace(T, c);
        return subtotal;
    }
    
    public static <E> void parenthesize(TreeInterface<E> T, Position<E> p){
        System.out.print(p.getElement());
        if(T.isInternal(p)){
            boolean firstTime=true;
            for(Position<E> c : T.children(p)){
                System.out.print((firstTime ? " (" : ", "));
                firstTime = false;
                parenthesize(T, c);
            }
            System.out.print(")");
        }
    }
    
    public static <E> void printPreOrderIndent(TreeInterface<E> T, Position<E> p, int d){
        System.out.println(spaces(2 * d) + p.getElement());
        for(Position<E> c : T.children(p))
            printPreOrderIndent(T, c, d+1);
    }
}
