
import java.util.Random;
/**
 *
 * @author Marie Larson
 * @version 1/23/18
 * 
 */
public class Scores implements bag{
    private int[] list;
    private int count;
    //private int fnum=0;
    
    //Constructor:        
    public Scores() {
        this.list = new int[50];
        count = 0;
    }
    //overloaded constructor:
    public Scores(int c){
        this.list = new int[c];
        count=0;
    }
    
    @Override
    public String toString(){
        String tmp = new String();
        
        tmp = tmp+getClass().getName() + "@";
        
        for(int i = 0;i<count;i++){
            tmp+=list[i] + ":";
        }
        return tmp;
    }
    
    //return current value of count
    public int getCurrentSize(){  
        return count-2;
    }
    
    //return whether list is empty or not
    @Override
    public boolean isEmpty(){
        if (count==0){
            return true;
        }
        else
            {return false;}
    }
    
    //clear out list
    @Override
   public void Clear(){
        this.list = null;
        this.count = 0;
    }
    
    //add number to end of list
   @Override
    public void add(int num){
        //add a new number to the end of list if list is not full
        if (count != list.length){
        list[count]= num;
        count++;
        }
        //if list is full, create new array called temp and set size to 100
        else{
            int[] temp = new int[count*2];
            for (int c=0;c<count;c++){
                temp[c]=list[c];
            }
            //assign reference of tmep to list and set temp to null
            list = temp;
            //temp = null;
        }
        list[count++] = num;
    }
    
    //count the frequency of num in the bag
    @Override
    public int getFrequencyOf(int num){
        if(count==0){
            return 0;
        }
        int fnum=0;
        for(int c=0;c<count;c++){
            if(list[c]==num){
                fnum++;
            }
        }
        return fnum; 
    }
    
    
    //test if list contains num
    @Override
    public boolean contains(int num){
        if (count==0){
            return false;
        }
        
        //
        for(int i=0;i<count;i++){
            if(list[i]==num){
                return true;
            }
        }
        return false;
    }
    
    @Override
    //remove first occurence of num in list. Do nothing if num does not exist in list
    public void remove(int num){
        for(int i=0;i<count;i++){
            if(list[i]==num){
                for(int c=i;c<=count-1;c++){ //shift elements by one place left in the list.
                    list[c]=list[c+1];
                }
                count--;
                break;
            }   
        }
    }   
    
    @Override
    //remove a random number from list
    public void remove(){
        //generate random number greater than or equal to 0 and less than 50
        Random random = new Random();
        int randomInt = random.nextInt(count);
        
        //remove random number and shift other numbers over to fill the gap
        for(int c=randomInt;c<=count;c++){
        list[c] = list[c+1];
        }
    }
    
    
    //returns ith index position in list
    public int get(int i){
        if(i<=count){
            return list[i];
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }     
    }

    //equals
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Scores)){
            return false;
        }
        Scores s = (Scores) o;
        
        if(this.count != s.count){
            return false;
        }
        for(int i=0;i<count;i++){
            if(this.list[i] != s.list[i]){
                return false;
            }
        }
        return true;
    }
}
   

