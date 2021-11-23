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
        users = new ArrayList<>();
        pendingDriverList = new ArrayList<>();
    }
    

    public User login(String username, String password) {
        for (User user: users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            } 
        } 
        return null;
    }
    
    public void addUser(User user){
        users.add(user);
    }
    
    public void addPendingDriver(Driver driver){
        pendingDriverList.add(driver);
    }

    public ArrayList<User> getUsers() {
        System.out.println(users);
        return users;
    }

    public ArrayList<Driver> getPendingDriverList() {
        System.out.println(pendingDriverList);
        return pendingDriverList;
    }
    
}

