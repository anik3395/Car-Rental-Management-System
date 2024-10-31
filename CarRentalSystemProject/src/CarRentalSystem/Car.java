package CarRentalSystem;

public class Car {

    //Declear instance variable.
    private String carId;
    private String model;
    private double basePricePerDay;
    private String brand;
    private boolean isAvailable;

    //Constructor use for initialiaz variable's value with the help of getter and setter..
    public Car(String carId, String model, double basePricePerDay, String brand) {
        this.carId = carId;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.brand = brand;
        this.isAvailable = true;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public void setBasePricePerDay(double basePricePerDay) {
        this.basePricePerDay = basePricePerDay;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double calculatePricePerDay( int rentalsDay) {
        double totalCost = basePricePerDay * rentalsDay;
        return totalCost;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent(){
        this.isAvailable = false;
    }

    public void returnCar(){
        this.isAvailable = true;
    }


}
