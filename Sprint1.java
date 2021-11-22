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
public class Sprint1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationSystem system = new ApplicationSystem();
        System.out.println("For driver enter 1 , for customer enter 2");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        User user;
        while(true){
            if(choice == 1){
                Driver driver = new Driver();
                driver.register();
                system.addUser(driver);
            }
            else{
                Customer customer = new Customer();
                customer.register();
                system.addUser(customer);
            }
            System.out.println(system.getUsers());
            System.out.println(system.getPendingDriverList());
            
        }
    }
    
}
