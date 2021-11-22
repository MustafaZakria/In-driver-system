/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint1;

import java.util.Scanner;


/**
 *
 * @author Dell
 */
public class DriverRegistration implements Registration {
    
    private ApplicationSystem system;

    

    DriverRegistration() {
    }

   
    
    @Override
    public void register() {
        Scanner scan = new Scanner(System.in);
        
        Driver driver;
        System.out.print("Enter your username: ");
        String username = scan.nextLine();
        
        System.out.print("Enter your password: ");
        String password = scan.nextLine();
        
        System.out.print("Enter your mobile: ");
        String mobile = scan.nextLine();
        
        System.out.print("Enter your driving license: ");
        String license = scan.nextLine();
        System.out.print("Enter your national id: ");
        
        String id = scan.nextLine();
        driver = new Driver(username, password, mobile, Type.Driver , license , id);
        //system.addUser(driver);
        //system.addPendingDriver(driver);
    }
    


}
