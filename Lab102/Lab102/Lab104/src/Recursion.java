import java.io.File;
import java.io.FileNotFoundException;
/**
 *
 * @author Marie Larson
 * @version 2/12/2018
 */
public class Recursion {
    public static double var(int i){
        if(i==1){
            return 1;
        }
        else{
            return (double)(1.0/i)+var(i-1);
        }
    }
    
    public static int IsabelTechnique(int[] Arr) throws Array2{
        if(!Base2(Arr.length)){
            throw new Array2("The Array is not base 2.");
        }
        
        int[] Brr = new int[Arr.length/2];
        
        for(int i=0;i<(Arr.length/2); i++){
            Brr[i] = (Arr[2*i]+Arr[2*i+1]);
        }
        
        if(Brr.length==1){
            return Brr[0];
        }
        return IsabelTechnique(Brr);
    }
    
    public static void List(File path){
        System.out.println("\nStart of Path Recursion File Folder" + path.getAbsoluteFile());
        if(path.isDirectory()){
            String[] contents = path.list();
            
            for(int i=0;i<contents.length;i++){
                File test = new File(path + File.separator + contents[i]);
                if(test.isDirectory()){
                    List(test);
                }
                else{
                    System.out.println(test.getAbsolutePath());
                }
            }
        }
        if(path.isFile()){
            System.out.println(path.getAbsolutePath());
        }
    }
        private static boolean Base2(int length){
            int temp = 2;
            while(temp <= length){
                if(temp == length){
                    return true;
                }
            temp *= 2;
            }
            return false;
        }

}
