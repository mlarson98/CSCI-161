
/**
 *
 * @author marie
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Begin Lab107");
        
        String names[] = {"Bobbie", "Fred", "Karen", "Linda", "Gale", "Rick", "Sharon", "Frankie", "Vance", "Lori"};
        LuckyNumberList list = new LuckyNumberList();
        for(int i=0;i<10;i++){
            list.addLuckyNumber(new LuckyNumberList(names[i]));
        }
        
        Iterator<Position<LuckyNumber>> ListIterator = list.positions().Iterator();
        
        System.out.print("Using ListIterator in lucky number list = ");
        while(ListIterator.hasNext()){
            LuckyNumber temp = ListIterator.next().getElement();
            String even = "odd";
            if(temp.getLuckyNumber() % 2 == 0)
                even = "even";
            
            String prime = "not prime";
            int n = temp.getLuckyNumber();
            if(n==2 || n==3 || n==5 || n==7)
                prime = "prime";
            
            System.out.printf("\n%10s %6d %10s %10s", temp.getName(), temp.getLuckyNumber(), even, prime);
        }
        System.out.print("\n\n");
        Iterator<Position<LuckyNumber>> primeIterator = list.primePositions().iterator();
        
            System.out.print("Using Prime iterator in lucky number list = ");
        while(primeIterator.hasNext()){
            LuckyNumber temp = primeIterator.next().getElement();
            
            String even = "odd";
            if(temp.getLuckyNumber() % 2 == 0)
                even = "even";
            
            String prime = "not prime";
            int n = temp.getLuckyNumber();
            if(n==2 || n==3 || n==5 || n==7)
                prime = "prime";
            
            System.out.printf("\n%10s %6d %10s %10s", temp.getName(), temp.getLuckyNumber(), even, prime);
        }
        System.out.print("\n\n");
        
        Iterator<Position<LuckyNumber>> evenIterator = list.EvenPosition().iterator();
        
        System.out.print("Using Even iterator in lucky number list = ");
        while(evenIterator.hasNext()){
            LuckyNumber temp = evenIterator.next().getElement();
            String even = "odd";
            if(temp.getLuckyNumber() % 2 == 0)
                even = "even";
            
            String prime = "not prime";
            int n = temp.getLuckyNumber();
            if(n==2 || n==3 || n==5 || n==7)
                prime = "prime";
            
            System.out.printf("\n%10s %6d %10s %10s", temp.getName(), temp.getLuckyNumber(), even, prime);
        }
        System.out.print("\n\n"
            + "End Lab107");
    }
    
}
