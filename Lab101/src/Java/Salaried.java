
/**
 *
 * @author Marie Larson
 * @version 1/18/18
 */
public class Salaried {
    
    private static int salariedEmployeeCount = 0;
    private int salary;
    private String title;

    public Salaried(int salary, String title) {
        this.salary = salary;
        this.title = title;
        salariedEmployeeCount = 0;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static int getSalariedEmployeeCount() {
        return salariedEmployeeCount;
    }
    
    public String toString(){
        return super.toString() + ":" + getClass().getName() + "@" + salariedEmployeeCount + title + salary;
    }
    
    public boolean equals ( Object o){
        Salaried s = (Salaried) o;
        
        return super.equals(o)
                && this.title == s.getTitle()
                && this.salary == s.getSalary();
    }
    
}
