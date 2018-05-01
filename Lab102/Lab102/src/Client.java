
import java.util.Random;
/**
 *
 * @author Marie Larson
 * @version 1/28/18
 * 
 */
public class Client {
    
    /**
     * @param args 
     */
    
    public static void main(String[] args) {
       //object creation
        Scores name = new Scores(100); 
       
       Random random = new Random();
       for(int i=0;i<=100;i++){
           name.add(random.nextInt(199)-100);  
       }
       //print contents of Scores object
       System.out.println(name);
       
       //call add method and add 86 to the bag
       name.add(86);
       
       //print the current size of the list in the Scores object
       System.out.println("Current size of name object: "+ name.getCurrentSize());
       
       //call the remove method to remove a random number
       name.remove();
       
       //get the number in 75th index position
       int ip = name.get(75);
       
       //print the frequency of this number now occuring in the bag
       System.out.println("Frequency of number contained in 75th index: " + name.getFrequencyOf(ip));
       
       //remove the number in the 75th index
       name.remove(ip);
       
       //print the frequency of number that was just deleted
       System.out.println("Frequency of the number after being removed from the 75 index: " + name.getFrequencyOf(ip));
       //print the frequency of number 86
       System.out.println("Frequency of number 86: " + name.getFrequencyOf(85));
       
       //check if array in Scores object contains 86
       if(name.contains(86)){
           System.out.println("Number 86 is contained in the bag\n");
       }
       else{
           System.out.println("Number 86 is not contained in the bag\n");
       }
    }
    
}
