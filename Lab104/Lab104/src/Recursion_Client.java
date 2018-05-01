import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *
 * @author Marie Larson
 * @version 2/12/2018
 * 
 */
public class Recursion_Client {
    public static void main(String[] args){
        System.out.println("Begin");
        if(showconfirmDialog("Starting lab104")==0){
            boolean run = true;
            while(run){
                run = options();
            }
        }
        System.out.println("End");
    }
    private static void callVar(){
        String response = JOptionPane.showInputDialog( null, "Enter an integer", "Var Method", 0);
        System.out.println("run var method.user input = " + response);
        double result = Recursion.var(Integer.parseInt(response));
        showMessageDialog("result of var method " + result);
    }
    
    private static void callIsabel(){
        String response = JOptionPane.showInputDialog( null, "Enter path to file of integers", "Isabel's technique", 0);
        int[] temp = getArrayForFile(response);
        if(!(temp==null)){
            System.out.println("Run Isabel's technique. user input = " +response);
            
            try {
                int result = Recursion.IsabelTechnique(temp);
                showMessageDialog("Result of var method " +result);
            }
            catch (Array2 e){
                System.out.println("Array is not of base 2");
                showMessageDialog("The data in the file is not base 2.\n"
                                            + "Check file");
            }
        }
    }
    
    public static void showMessageDialog(String response){
        JOptionPane.showMessageDialog(null, response, response, 0);
    }
    
    public static int showconfirmDialog(String response){
        System.out.println(response);
        return JOptionPane.showConfirmDialog(null, response, response, 0);
    }
    
    private static boolean options(){
        String response;
        String optionString = "Arr) run var method\n"
                + "Brr) to run Isabel's method\n"
                + "Crr) to run the list method\n"
                + "Drr) to exit program";
        response = JOptionPane.showInputDialog(null, optionString, "Recursive Class", 0);
        
        switch (response){
            case "arr":
            case "Arr":
                System.out.println("Calling var method");
                callVar();
                break;
            case "brr":
            case "Brr":
                System.out.println("Calling Isabel's Technique\n");
                callIsabel();
                break;
            case "crr":
            case "Crr":
                System.out.println("Call method 3");
                callList();
                break;
            case "drr":
            case "Drr":
                System.out.println("Setting flag to exit loop");
                
                if(showconfirmDialog("Would you like to exit the program?")==0){
                    return false;
                }
                break;
            default :
                showMessageDialog("Enter one of the following options: 'Arr', 'Brr', 'Crr', or 'Drr'\n");
                System.out.println("Enter one of the following options: 'Arr', 'Brr', 'Crr', or 'Drr'\n");
                break;
        }
        return true;
    }
    private static int[] getArrayForFile(String response){
        File file = new File(response);
        Scanner in;
        try{
            in = new Scanner(file);
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            showMessageDialog("ERROR: File not found.\n");
            return null;
        }
        
        ArrayBag Bag = new ArrayBag();
        while(in.hasNext()){
            if(in.hasNextInt()){
                Bag.add(in.nextInt());
            }
            else{
                in.next();
            }
        }
        int[] result = new int[Bag.getSize()];
        for(int i=0;i<Bag.getSize();i++){
            result[i] = (int)Bag.get(i);
        }
        return result;
    }
    private static void callList(){
        String response = JOptionPane.showInputDialog(null, "Enter the path to the file folder", "List method", 0);
        File file = new File(response);
        System.out.println("Run list method. user input = " + response);
        Recursion.List(file);
    }
}
