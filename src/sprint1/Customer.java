/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint1;

/**
 *
 * @author Dell
 */
public class Customer extends User{
    
    public Customer(String username, String password, String mobile, Type type) {
        super(username, password, mobile, type);
        this.setRegistration(new CustomerRegistration());
    }
    
    public Customer(){
        super();
        this.setRegistration(new CustomerRegistration());
    }
    
}
