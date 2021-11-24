
package sprint1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dell
 */
public class Ride {
    String source, destination;
    Customer customer;
    HashMap<Driver, Double> driverPrice;
    
    
    public Ride(String source, String destination, Customer customer) {
        this.source = source;
        this.destination = destination;
        this.customer = customer;
        this.driverPrice = new HashMap<Driver, Double>();

    }
    
    public Ride(String source, String destination , double price, Driver driver, Customer customer){
        this.source = source;
        this.destination = destination;
        this.customer = customer;
        driverPrice = new HashMap<>();
        driverPrice.put(driver, price);
    }

    public Ride() {
        this.source = "";
        this.destination = "";
        this.customer = null;
        this.driverPrice = new HashMap<>();
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public HashMap<Driver, Double> getDriverPrice() {
        for (Map.Entry<Driver, Double> entry : driverPrice.entrySet())
        {
            System.out.println(entry.getKey() + ", Price= " + entry.getValue());
        }
        return driverPrice;
    }
    
    
    
    @Override
    public String toString() {
    	String ride = "Ride{" + "source=" + source + ", destination=" + destination +'}';
    	return ride;
    }
    
    
}
