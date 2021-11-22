/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint1;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class ApplicationSystem {
    
    protected ArrayList<User> users;
    protected ArrayList<Driver> pendingDriverList;
    
    public ApplicationSystem(){
        users = new ArrayList<User>();
        pendingDriverList = new ArrayList<Driver>();
    }
    

    public boolean login(User user) {
        return false;
    }
    
    public void addUser(User user){
        users.add(user);
    }
    
    public void addPendingDriver(Driver driver){
        pendingDriverList.add(driver);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Driver> getPendingDriverList() {
        return pendingDriverList;
    }
    
}

