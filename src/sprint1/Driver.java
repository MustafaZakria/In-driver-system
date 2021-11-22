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
public class Driver extends User{
    
    private String nationalID;
    private String license;
    private boolean verified;
    
    public Driver() {
        super();
        this.nationalID = "";
        this.license = "";
        this.verified = false;
        this.setRegistration(new DriverRegistration());
    }
    
    public Driver(String username, String password, String mobile, Type type, String nationalID, String license) {
        super(username, password, mobile, type);
        this.license = license;
        this.nationalID = nationalID;
        this.verified = false;
        this.setRegistration(new DriverRegistration());
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
    
}
