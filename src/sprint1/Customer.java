
package sprint1;

import java.util.Scanner;

public class Customer extends User{
    
    public Customer(String username, String password, String mobile, Type type) {
        super(username, password, mobile, type);
    }
    
    public Customer(){
        super();
    } 

    @Override
    public void register() {
        Scanner input = new Scanner (System.in);
        System.out.print("Enter Customer Username: ");
        this.username = input.nextLine();
        
        System.out.print("Enter Customer Password: ");
        this.password = input.nextLine();
        
        System.out.print("Enter Customer Mobile: ");
        this.mobile = input.nextLine();
        
        
        this.suspend = false;
        this.type = Type.Customer;
    }
    
}
