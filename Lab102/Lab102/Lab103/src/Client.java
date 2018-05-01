import java.util.Scanner;
/**
 *
 * @author Marie Larson
 * @version 1/3/2018
 * 
 */
public class Client {
    public static void main(String[] args){
        System.out.println("Client Class: \n\n");
        ArrayBag footballTeam = new ArrayBag(2);
        
        boolean e = false;
        
        
            keyboardInput(footballTeam);
        
        
        //step 2- Remove random player
        System.out.println("Removing Random football player from team\n\n");
        
        footballTeam.remove();
        
        //Step 3- add made up member
        System.out.println("Add a new player format: Tj, quarterback, 56\n");
        Player tmpFootball = new Player("Tj", "quarterback", 56);
        footballTeam.Adder(tmpFootball);
        
        //Step 4- Display size of team
        System.out.println("size of team: " + footballTeam.CurrentCount());
        
        //Step 5- Remove made up member
        System.out.println("Remove Tj from team\n");
        
        footballTeam.remove(tmpFootball);
        
        //Step 6- Display new size of team
        System.out.println("Size of team after removing player: " + footballTeam.CurrentCount());
        
        //Step 7- List of classes
        System.out.println("\nCreate a Course List");
        //Step 7a- object of ArrayBag
        ArrayBag courses = new ArrayBag(6);
        //Step 7b- populate object
        courses.Adder("ECE 320");
        courses.Adder("Engr 402");
        courses.Adder("ECE 374");
        courses.Adder("MATH 266");
        courses.Adder("Engl 320");
        courses.Adder("CSCI 161");
        //Step 7c- Remove random course
        System.out.println("Dropping random class");
        courses.remove();
        //Step 7d- print course IDs
        System.out.println("\n\nPrint Course List: ");
        for(int i=0;i<courses.CurrentCount();i++){
            System.out.println("\t"+courses.get(i));
        }
        
        //Create object of LinkedBag to store NDSU's Women's Basketball Team
        System.out.println("\n\nCreating NDSU Women's Basketball Team");
        LinkedBag basketballTeam = new LinkedBag();
        
        
        basketballTeam = keyboardInputLinked();
        
        //Step 2- Remove random player
        System.out.println("\nRemove a player from the team");
        basketballTeam.remove();
        //Step 3- Add new player
        System.out.println("Add a new player");
        Player Michelle = new Player("Michelle","guard", 32);
        basketballTeam.Adder(Michelle);
        //Step 4- Display size of team
        System.out.println("Current size of team: " + basketballTeam.CurrentCount());
        //Step 5- Remove Michelle from team
        System.out.println("Removing Michelle from Team\n");
        basketballTeam.remove(Michelle);
        //Step 6- Display size of team
        System.out.println("Current size of team without Michelle: "+ basketballTeam.CurrentCount());
        
        System.out.println("\n\n\nEND");
    }
    public static void keyboardInput(ArrayBag team){
        boolean getData = true;
        
        Scanner keyboard = new Scanner(System.in);
        
        while( getData ){
            String name = null;
            String position = null;
            int number = 0;
            
            System.out.println("Enter next player");
            
            System.out.println("player name");
            name = keyboard.nextLine();
            
            System.out.println("player position");
            position = keyboard.nextLine();
            
            System.out.println("player number");
            number = Integer.parseInt(keyboard.nextLine());
            
            team.Adder(new Player(name, position, number));
            
            System.out.println("team size: " + team.CurrentCount());
            System.out.println("Would you like to enter another player? enter Y/N.");
            String response = keyboard.nextLine();
            
            getData = response.equals("Y");
        }
    }
    
    public static LinkedBag keyboardInputLinked(){
        boolean getData = true;
        LinkedBag b = new LinkedBag();
        int i = 0;
        
        Scanner keyboard = new Scanner(System.in);
        
        while( getData ){
            String name = null;
            String position = null;
            int number = 0;
            
            System.out.println("Enter Player Information:");
            
            //player name
            System.out.println("Name");
            name = keyboard.nextLine();
            
            //player position
            System.out.println("Position");
            position = keyboard.nextLine();
            
            //player number
            System.out.println("Number");
            number = Integer.parseInt(keyboard.nextLine());
            
            b.Adder(new Player(name, position, number));
            
            //size of team
            System.out.println("Size of team: "+b.CurrentCount());
            System.out.println("Would you like to enter another player? enter Y/N.");
            String response = keyboard.nextLine();
            
            getData = response.equals("Y");
        }
        return b;
    } 
}
