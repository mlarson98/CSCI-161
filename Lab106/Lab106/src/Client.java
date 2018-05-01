
/**
 *
 * @author marie
 */
public class Client {
    static int teamSize = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Begin");
        
        dequeTest(new ArrayDeque());
        dequeTest(new ListDeque());
    }
    
    public static void dequeTest(Deque q){
        System.out.println("Testing the following deque: " + q.getClass().getName());
        
        System.out.println("Adding 4 players to the front of deque and 4 players to the end of the deque");
        
        for(int i=0;i<4;i++){
            q.addFirst(generatePlayer());
            q.addLast(generatePlayer());
        }
        
        System.out.println("\nTeam Lineup: " + q);
        System.out.println("The following player has been removed from the front of the queue: " + q.removeFirst());
        System.out.println("The following player has been removed from the end of the queue: " + q.removeLast());
        System.out.println("Adding more players");
        
        try{
            q.addLast(generatePlayer());
            q.addLast(generatePlayer());
            q.addFirst(generatePlayer());
            q.addFirst(generatePlayer());
        }
        catch (IllegalArgumentException g){
            System.out.println("\tThe queue is full. No more players may be added");
        }
        
        System.out.println("Size of Queue: " + q.size() + "\nchecking if queue is empty: " + q.isEmpty());
        System.out.println("The First player on the team: " + q.first()+"\nThe last player on the team: " + q.last());
        
        System.out.println("\nPlayers on the team: " + q);
        
        System.out.println("Checking if array equals its self: " + q.equals(q));
    }
    
    //generates a player
    public static Player generatePlayer(){
        teamSize++;
        return new Player("Name" + teamSize, "Position" + teamSize, teamSize);
    }
    
}
