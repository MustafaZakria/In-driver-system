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
public class Driver extends User{
    
    protected String nationalID;
    protected String license;
    protected boolean verified;
    
    public Driver() {
        super();
        this.nationalID = "";
        this.license = "";
        this.verified = false;

    }
    
    public Driver(String username, String password, String mobile, Type type, String nationalID, String license) {
        super(username, password, mobile, type);
        this.license = license;
        this.nationalID = nationalID;
        this.verified = false;
    
    }
    
    
    
    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getLicense() {
        return license;
    }

    public boolean isVerified() {
        return verified;
    }

    @Override
    public void register() {
        Scanner input = new Scanner (System.in);
        
        System.out.print("Enter Driver Username: ");
        this.username = input.nextLine();
        
        System.out.print("Enter Driver Password: ");
        this.password = input.nextLine();
        
        System.out.print("Enter Driver Mobile: ");
        this.mobile = input.nextLine();
        
        System.out.print("Enter Driver Licence: ");
        this.license = input.nextLine();
        
        System.out.print("Enter Driver National-ID: ");
        this.nationalID = input.nextLine();
        
        this.suspend = false;
        
        this.verified = false;
        
        this.type = Type.Driver;
    }
    
}
