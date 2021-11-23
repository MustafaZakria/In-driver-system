
package sprint1;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    ApplicationSystem system;

    public Admin() {
        
    }

    public Admin(ApplicationSystem system) {
        this.system = system;
    }
    
    public void verify(){
        for(Driver driver: system.pendingDriverList){
            driver.verified = true;
            system.users.add(driver);
            system.verifiedDrivers.add(driver);
            system.pendingDriverList = null;
            system.pendingDriverList = new ArrayList<>();
        }
    }
    
    public void suspendUser(){
        
        system.getUsers();
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the number of the user to suspend: ");
        int indexChoice = scan.nextInt();
        
        system.users.get(indexChoice-1).setSuspend(true);
        
    }
    
    public ArrayList<Driver> getPendingDriverList() {
        return system.getPendingDriverList();
    }
    

}
