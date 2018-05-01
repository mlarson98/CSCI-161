import java.util.Random;
/**
 *
 * @author marie
 * @version 2/6/2018
 */
public class LinkedBag<E> implements Bag{
    
    SinglyLinkedList<E> list;
    int count;

    public LinkedBag() {
        this.list = new SinglyLinkedList();
        this.count=0;
    }
    
    @Override
    public int CurrentCount(){
        return count;
    }
    
    @Override
    public boolean CheckEmpty(){
        return (count == 0);
    }
    
    @Override
    public boolean CheckFull(){
        return false;
    }
    
    @Override
    public boolean Adder(Object num){
        list.addLast((E)num);
        count++;
        return true;
    }
    
    @Override 
    public E remove(){
        Random random = new Random();
        int num = random.nextInt(count);
        int var=0;
        for(int i=0;i<count; i++){
            E first = list.removeFirst();
            if(var==num){
                count--;
                return first;
            }
            
            list.addLast(first);
            var++;
        }
        return null;
    }
    
    @Override
    public boolean remove(Object num){
        for(int i=0;i<count;i++){
            E first = list.removeFirst();
            if(num.equals(first)){
                count--;
                return true;
            }
            else{
                list.addLast(first);
            }
        }
        return false;
    }
    
    @Override
    public void clear(){
        for(int i = 0;i<count;i++){
            list.removeFirst();
        }
        count=0;
    }
    
    @Override
    public int CountOfOccurence(Object num){
        int freq = 0;
        E f;
        for(int i = 0; i<count; i++){
            f = list.removeFirst();
            if(num.equals(f)){
                freq++;
            }
            list.addLast(f);
        }
        return freq;
    }
    
    @Override
    public boolean CheckExistence(Object num){
        E e;
        for(int i=0;i<count;i++){
            e=list.removeFirst();
            if(num.equals(e)){
                return true;
            }
            list.addLast(e);
        }
        return false;
    }
    
    public E get(int i){
        if(i < count){
            E e;
            int p=0;
            for(int c =0; c<count;c++){
                e=list.removeFirst();
                if(p==i){
                    return e;
                }
                list.addLast(e);
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        String value = getClass().getName()+"@";
        
        E e;
        for(int i =0; i<count;i++){
            e=list.removeFirst();
            value = value + e + ":";
            list.addLast(e);
        }
        return value;
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof LinkedBag)){
            return false;
        }
        boolean comp = true;
        LinkedBag b = (LinkedBag)o;
        
        E eList;
        E eBag;
        
        for(int i = 0;i<count;i++){
            eList = list.removeFirst();
            eBag = (E)b.list.removeFirst();
            
            if(!eBag.equals(eList)){
                comp = false;
            }
            list.addLast(eList);
            b.list.addLast(eBag);
        }
        return comp;
    }
}
