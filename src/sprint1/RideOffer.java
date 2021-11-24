
package sprint1;

public class RideOffer {
   
    String source, dest;
    double price;
    Driver driver;
    Customer customer;

   
    public RideOffer(String source, String dest, double price, Driver driver, Customer customer) {
        this.source = source;
        this.dest = dest;
        this.price = price;
        this.driver = driver;
        this.customer = customer;
        notifyCustomer();
    }
    
    
    
    
    public void notifyCustomer(){
       customer.offers.add(this);
    }

    @Override
    public String toString() {
        return "RideOffer{" + "source=" + source + ", dest=" + dest + ", price=" + price + ", driver=" + driver + '}';
    }

    
    
    
}
