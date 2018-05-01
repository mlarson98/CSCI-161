import java.util.Random;
/**
 *
 * @author marie
 */
public class LuckyNumber {
    private String name;
    private int luckyNumber;
    
    public LuckyNumber(String name){
        this.name = name;
        Random random = new Random();
        this.luckyNumber = random.nextInt(9);
    }
    
    public String getName(){
        return name;
    }
    
    public int getLuckyNumber(){
        return luckyNumber;
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof LuckyNumber)){
            return false;
        }
    
    LuckyNumber IN = (LuckyNumber) o;
        return IN.luckyNumber == this.luckyNumber && name.equals(IN.name);
    }
    
    @Override
    public String toString(){
        return getClass().getName() + "@ " + name + ":" + luckyNumber;
    }
}
