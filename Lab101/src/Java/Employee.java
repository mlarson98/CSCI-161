
/**
 *
 * @author Marie Larson
 * @version 1/18/18
 * 
 */
public class Employee {
    
    private static int employeeCount = 0;
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        employeeCount++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }
    
    public String toString(){
        
        return getClass().getName() + "@" + employeeCount + ":" + name;
    }
    
    public boolean equals( Object o){
        Employee e = (Employee) o;
        
        return this.employeeCount == e.getEmployeeCount()
                && this.id == e.getId()
                && this.name.equals(e.getName());
    }
}
