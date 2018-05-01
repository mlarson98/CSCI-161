
/**
 *
 * @author Marie Larson
 * @version 2/21/2018
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Begin Lab105");
        
        SinglyLinkedList ten;
        ten = new SinglyLinkedList<>();
        
        System.out.println("Making a SinglyLinkedList");
        for(int i = 1; i<=10;i++){
            ten.addLast(i);
        }
        
        System.out.println("Print out SinglyLinkedList: \n" + ten);
        
        System.out.println("\nFirst Element is removed: " + ten.removeFirst());
        
        System.out.println("\nPrint updated list: \n" + ten);
        
        System.out.println("Begin Part 1/B");
        
        
        //making doublylinkedlist
        DoublyLinkedList ten_double;
        ten_double = new DoublyLinkedList();
        
        //populate list
        
        /**for(int i = 1; i<=10; i++){
            ten_double.addLast(i);
        }*/
        
        System.out.println("Print doublylinkedlist: \n" + ten_double);
        
        System.out.println("\nRemoving first element which is: " + ten_double.removeFirst());
        
        System.out.println("\nRemoving last element which is: " + ten_double.removeLast());
        
        System.out.println("\nPrinting updated DoublyLinkedList: \n" + ten_double);
        
        
        //Starting part 2
        //setting limit
        long limit = 100000000;
        
        SinglyLinkedList test_s = new SinglyLinkedList();
        long start = System.currentTimeMillis();
        for(int i = 0;i<limit;i++){
            test_s.addFirst(i);
        }
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - start;
        
        String n = String.format("N = %,d", limit);
        String time = String.format("Time(msec) = %,6d", timeElapsed);
        System.out.printf("\nSinglyLinked \t%s \t%s\n", n, time);
        
        
        //testing doublylinkedlist
        DoublyLinkedList test_d = new DoublyLinkedList();
        start = System.currentTimeMillis();
        for(int i = 0;i<limit;i++){
            test_d.addFirst(i);
        }
        
        currentTime = System.currentTimeMillis();
        timeElapsed = currentTime - start;
        
        time = String.format("Time(msec) = %,6d", timeElapsed);
        System.out.printf("DoublyLinked \t%s \t%s\n", n, time);
        
        System.out.println("End Lab105");
    }
    
}
