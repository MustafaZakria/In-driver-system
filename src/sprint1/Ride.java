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
public class Ride {
    String source, destination;
    double price;
    Driver driver;
    Customer customer;

    public Ride(String source, String destination, Customer customer) {
        this.source = source;
        this.destination = destination;
        this.price = 0;
        this.customer = customer;
        this.driver = null;
    }

    public Ride() {
        this.source = "";
        this.destination = "";
        this.price = 0;
        this.customer = null;
        this.driver = null;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
    
    @Override
    public String toString() {
    	String driverInfo ="";
    	if(driver!=null) { 
    		driverInfo = "Driver{" + "Name=" + driver.getUsername() + ", Mobile=" + driver.getMobile()+"}\n";
    	}
    	String ride = "Ride{" + "source=" + source + ", destination=" + destination + ", price=" + price +'}';
    	return driverInfo+ride;
    }
    
    
}
