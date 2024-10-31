package CarRentalSystem;

public class Rental {
    private Customer customer;
    private Car car;
    private int days;

    public Rental(Customer customer, Car car, int days) {
        this.customer = customer;
        this.car = car;
        this.days = days;
    }
    public Rental() {
    }


    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public int getDays() {
        return days;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
