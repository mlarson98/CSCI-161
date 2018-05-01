
/**
 *
 * @author Marie Larson
 * @version 1/18/18
 * 
 */
public class Hourly extends Employee {
    
    private static int hourlyEmployeeCount = 0; 
    private String position;
    private double hourlyRate;

    public Hourly(String position, double hourlyRate, int id, String name) {
        super(id, name);
        this.position = position;
        this.hourlyRate = hourlyRate;
        hourlyEmployeeCount++;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public static int getHourlyEmployeeCount() {
        return hourlyEmployeeCount;
    }
    
    public String toString(){
        return super.toString() + ":" + getClass().getName() + "@" + hourlyEmployeeCount + position + hourlyRate; 
    }
    
    public boolean equals ( Object o){
        Hourly h = (Hourly) o;
        
        return super.equals(o)
                && this.position == h.getPosition()
                && Math.abs(hourlyRate - h.hourlyRate) < 0.01;
    }
        
    
}
