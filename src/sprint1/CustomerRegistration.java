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
public class CustomerRegistration implements Registration{
    
    private ApplicationSystem system;

    @Override
    public void register() {
        Scanner scan = new Scanner(System.in);
        
        Customer customer;
        System.out.print("Enter your username: ");
        String username = scan.nextLine();
        
        System.out.print("Enter your password: ");
        String password = scan.nextLine();
        
        System.out.print("Enter your mobile: ");
        String mobile = scan.nextLine();
        
        
        customer = new Customer(username, password, mobile, Type.Customer);
        //system.addUser(customer);
    }
    
    
}
