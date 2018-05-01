
import java.util.Scanner;
/**
 *
 * @author Marie Larson
 * @version 1/18/18
 * 
 */
public class Client {
    
    public static void main(String[] args){
    
        boolean test = false;
        
        Employee[] employeeList;
       // employeeList = keyboardInput();
        
        if(test){
            employeeList = testData();
        }
        else{
            employeeList = keyboardInput();
        }
        
        System.out.println("List of employees:\n ");
        for(int c =0; c< 10; c++){
            System.out.println(employeeList[c]);
        }
    

 System.out.println("\ngive employees a 10% raise \n");
        for(int c = 0; c<10; c++){
            
            if(employeeList[c] instanceof Hourly){
                
                Hourly tmpHour = (Hourly)employeeList[c];
                tmpHour.setHourlyRate(tmpHour.getHourlyRate()*1.10);
                employeeList[c] = tmpHour;
            }
            else if(employeeList[c] instanceof Salaried){
                
                Salaried tmpSalary = (Salaried)employeeList[c];
                tmpSalary.setSalary((int)(tmpSalary.getSalary() * 1.10));
                employeeList[c] =tmpSalary;
            }
            else{
                continue;
            }
            
        }
        
        System.out.println("after the raise");
        System.out.println("List of employees: ");
    
        
        for(int c =0; c< 10; c++){
            if(!(employeeList[c] == null))
            System.out.println(employeeList[c]);
        }
        
        
    }
    
    /***
     * 
     * @return Employee[]
     */
    public static Employee[] keyboardInput(){

        boolean getData = true;
        Employee[] employeeList = new Employee[10];
        int c = 0;

        Scanner keyboard = new Scanner(System.in);

        while( getData ){
            String name;
            int id;
            String position;
            int salary;
            double hourlyRate;
            
            
            System.out.println("Is the employee Salaried? enter y/n.");
                String response = keyboard.next(); 
            if(response.equals("y")){
                //salary
                
                //Ask for name
                System.out.println("Enter employee name");
                name = keyboard.next();
                
                //ask for Id
                System.out.println("Enter employee id");
                id = keyboard.nextInt();
                
                //ask for job title
                System.out.println("Enter employee title");
                position = keyboard.next();
                
                //ask for salary
                System.out.println("Enter employee Salary");
                salary = keyboard.nextInt();
                
                //employeeList[c] = new Salaried(position, salary, id, name);
                
            }
            else if(response.equals("n")){
                //hourly
                
                //ask for name
                System.out.println("Enter employee name");
                name = keyboard.next();
                
                //ask for ID
                System.out.println("Enter employee id");
                id = keyboard.nextInt();
                
                //ask for position
                System.out.println("Enter employee position");
                position = keyboard.next();
                
                //ask for pay rate
                System.out.println("Enter employee hourly pay rate");
                hourlyRate = keyboard.nextDouble();
                
               // employeeList[c] = new Hourly(id, name, position, hourlyRate);
                
            }
            else {
                
                continue;
            }
            
            c++;
            
            System.out.println("Number of Employees: " + employeeList[0].getEmployeeCount());
            System.out.println("Would you like to enter another employee? enter y/n.");
            response = keyboard.next();
            
            if(response.equals("y")){
                getData = true;  
            }
            else{
                getData = false;
            }
                        
        }
            return employeeList;
    }
}
