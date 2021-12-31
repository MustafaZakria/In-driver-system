package sprint1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Discount {

    final double discountPercentage10 = 0.1;
    final double discountPercentage5 = 0.05;

    public void discountAreas(ArrayList<String> discountAreas, Ride ride) {
        if (discountAreas.contains(ride.destination)) {
            ride.getCustomer().balance += discountPercentage10 * ride.getPrice();
        }
    }

    public void discountTwoPassengers(Ride ride) {
        if (ride.numOfPassengers >= 2) {
            ride.getCustomer().balance += discountPercentage5 * ride.getPrice();
        }
        
    }

    public void firstRideDiscount(Ride ride) {
        if (ride.getCustomer().Rides.isEmpty()) {
            ride.getCustomer().balance += discountPercentage10 * ride.getPrice();
        }
    }

    public void birthDayDiscount(Ride ride) {
        LocalDate date = LocalDate.parse(ride.getCustomer().bithDate);
        if (date.getDayOfMonth() == LocalDate.now().getDayOfMonth() && date.getMonthValue() == LocalDate.now().getMonthValue()) {
            ride.getCustomer().balance += discountPercentage10 * ride.getPrice();
        }
    }

    public void holidaysDiscount(ArrayList<LocalDate> publicHolidays, Ride ride) {
        for (LocalDate date : publicHolidays) {
            if (date.getDayOfMonth() == LocalDate.now().getDayOfMonth() && date.getMonthValue() == LocalDate.now().getMonthValue()) {
                ride.getCustomer().balance += discountPercentage5 * ride.getPrice();
                break;
            }
        }
    }

}
