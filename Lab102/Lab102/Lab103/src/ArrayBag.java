import java.util.Random;
/**
 *
 * @author Marie Larson
 * @version 2/3/2018
 */
public class ArrayBag<E> implements Bag<E>{
    private E[] list;
    private int count;

    public ArrayBag() {
        this.list = ( E[] ) new Object[50];
        count = 0;
    }
    public ArrayBag(int size){
        this.list = ( E[] ) new Object[size];
        count = 0;
    }
    
    @Override
    public int CurrentCount(){
        return count;
    }
    
    @Override
    public boolean CheckEmpty(){
        if(count==0)
            {return true;}
        else
            {return false;}
    }
    
    @Override
    public boolean CheckFull(){
        return list.length == count;
    }
    
    
    @Override
    public boolean Adder(E num){
        if(count==list.length){
            E[] newList = (E[]) new Object[count*2];
            
            for(int i = 0;i<count;i++){
                newList[i]=list[i];
            }
            
            list = newList;
        }
        
        list[count++] = num;
        return true;
    }
    
    //Finish Later
    @Override
    public E remove(){
        if(count!=0){
            Random random = new Random();
            int RandomInt = random.nextInt(count);
            E num = list[RandomInt];
            
            for(int i=RandomInt;i<count-1;i++){
                list[i]=list[i+1];
            }
            count--;
            return num;
        }
        else{
            return null;
        }
    }
    
    //
    @Override
    public boolean remove(E num){
        E rmv = num;
        
        for(int i=0;i<=count;i++){
            if(list[i].equals(rmv)){
                count--;
                return true;
            }
        }
        return false;
    }
   
    
    
    @Override
    public void clear(){
        this.list = null;
        this.count=0;
    }
    
    @Override
    public int CountOfOccurence(E num){
        int freq = 0;
        for(int i=0;i<count;i++){
            if(num.equals(list[i])){
                freq++;
            }
        }
        return freq;
    }
    
    //finish later
    @Override
    public boolean CheckExistence(E num){
        for(int i=0;i<count;i++){
            if(num.equals(list[i])){
                return true;
            }
        }
        
        return false;
    }
    
    
    public E get(int i){
        if(i <= count){
            return list[i];
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    @Override
    public String toString(){
        String tmp=new String();
        tmp=tmp+getClass().getName() + '@';
        
        for(int i = 0;i<count;i++){
            tmp+=list[i] + ":";
        }
        return tmp;
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof ArrayBag)){
            return false;
        }
        ArrayBag b = (ArrayBag) o;
        
        if(this.count != b.count){
            return false;
        }
        for(int i=0;i<count;i++){
            if(this.list[i] != b.list[i]){
                return false;
            }
        }
        return true;
    }
}
