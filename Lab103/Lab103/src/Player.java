
/**
 *
 * @author Marie Larson
 * @version 2/6/2018
 */
public class Player {
    private String name;
    private String position;
    private int number;
    
    public Player(){
        
    }
    
    public Player(String name, String position, int number){
        this.name = name;
        this.position = position;
        this.number = number;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getPosition(){
        return position;
    }
    
    public void setPosition(String name){
        this.position = position;
    }
    
    public int getNumber(){
        return number;
    }
    
    public void setNumber(int number){
        this.number = number;
    }
    
    public String toString(){
        return getClass().getName() + "@" + name + ":" + position + ":" + number;
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Player)){
            return false;
        }
        
        Player p = (Player) o;
        
        return ((p.name.equals(this.name))
                && (p.position.equals(this.position))
                && (p.number == this.number));
    }
}
