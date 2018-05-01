import java.util.Random;
/**
 *
 * @author Marie Larson
 * @version 2/12/2018
 */
public class ArrayBag<E> implements Bag<E> {
    private E[] list;
    
    private int count;
    
    //constructor
    public ArrayBag(){
        this.list = (E[]) new Object[50];
        count = 0;
    }
    
    //overloaded constructor
    public ArrayBag(int size){
        this.list = (E[]) new Object[size];
        count = 0;
    }
    
    //gets size of bag
    @Override
    public int getSize(){
        return count;
    }
    
    //checks if bag is empty
    @Override
    public boolean Empty(){
        return (count==0);
    }
    
    //checks if bag is full
    @Override
    public boolean Full(){
        return list.length == count;
    }
    
    //removes an item from the bag
    @Override
    public boolean remove(E num){
        E rid = num;
        for(int i = 0; i<count; i++){
            if(list[i].equals(rid)){
                count--;
                return true;
            }
        }
        return false;
    }
    
    //adds an item to the bag
    @Override
    public boolean add(E num){
        if(list.length == count){
            E[] newList = (E[]) new Object[count*2];
            for(int i = 0; i<count;i++){
                newList[i] = list[i];
            }
            list=newList;
        }
        list[count++] = num;
        
        return true;
    }
    
    //removes a random item from the bag
    @Override
    public E remove(){
        //checks if there are items in the bag
        if(count==0){
            return null;
        }
        
        Random random = new Random();
        int i = random.nextInt(count);
        E rid = list[i];
        
        for(int n=0;n<count-1;n++){
            list[n] = list[n-1];
        }
        count--;
        return rid;
    }
    
    //check how often an item shows up in bag
    @Override
    public int getFrequency(E var){
        int counter=0;
        for(int i = 0; i<count;i++){
            if(var.equals(list[i])){
                counter++;
            }
        }
        return counter;
    }
    
    //checks if an item is contained in the bag
    @Override
    public boolean contains(E var){
        for(int i = 0;i<count;i++){
            if(var.equals(list[i])){
                return true;
            }
        }
        return false;
    }
    
    //clears contents of bag
    public void clear(){
        this.count = 0;
    }
    
    public E get(int i){
        if(i<=count){
            return list[i];
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    //returns name of class and list of all items in the bag
    @Override
    public String toString(){
        String temp = new String();
        
        temp = temp + getClass().getName() + "@";
        
        for(int i=0;i<count;i++){
            temp+=list[i] + ":";
        }
        return temp;
    }
    
    //returns true if function is equal
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
