
/**
 *
 * @author Marie Larson
 * @version 2/26/18
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
    
    //return name of player
    public String getName(){
        return name;
    }
    
    //set name of player
    public void setName(String name){
        this.name = name;
    }
    
    //return position of player
    public String getPosition(){
        return position;
    }
    
    //set position of player
    public void setPosition(String position){
        this.position = position;
    }
    
    //get the player number
    public int getNumber(){
        return number;
    }
    
    //set player number
    public void setNumber(){
        this.number = number;
    }
    
    //string method
    @Override
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
