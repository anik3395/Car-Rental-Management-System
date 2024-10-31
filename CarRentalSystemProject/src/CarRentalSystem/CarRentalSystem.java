package CarRentalSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> cars = new ArrayList<Car>();
    private List<Rental> rentals = new ArrayList<Rental>();
    private List<Customer> customers = new ArrayList<Customer>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car,Customer customer,int days) {
        if( car.isAvailable()){
            car.rent();
            rentals.add(new Rental(customer, car,days));
            displayAvailableCarCount();
        }
        else {
            System.out.println("Car is not available for rent.");
        }
    }

    public void returnCar(Car car) {
        car.returnCar();
        Rental rentalToRemove = null;
        for (Rental i : rentals) {
            if (i.getCar()==car){
                rentalToRemove = i;
                break;
            }
        } if (rentalToRemove !=null){
            rentals.remove(rentalToRemove);
            System.out.println("Car returned successfully.");
            displayAvailableCarCount();
        }
        else {
            System.out.println("Car was not returned.");

        }
    }

    // Display Rentals cars

    public void displayRentals() {
        if (rentals.isEmpty()) {
            System.out.println("No cars are currently rented.");
        }else {
            System.out.println("===Rentals car list:===");
            int rentalCount = 0;
            // protome rentals car teika sob car ke i er moddo raklam then kon car ta rent korha hoise seitha deklam then kon car kon model kon car id ei gula oi car object teika print out korlam
            for(Rental i : rentals){
                rentalCount++;
                Car car = i. getCar();
                Customer customer = i. getCustomer();
                int days = i. getDays();
                double totalPrice = car.calculatePricePerDay(days);



                System.out.println("Customer Name: " + customer.getName());
                System.out.println("Customer ID: " + customer.getCustomerID());
                System.out.println("Car ID: " + car.getCarId());
                System.out.println("Brand: " + car.getBrand());
                System.out.println("Model: " + car.getModel());
                System.out.println("Rental Days: " + days);
                System.out.println("Total Price: $" + totalPrice);
                System.out.println("-----------------------------");
            }
            System.out.println("Total rented numbers of car is : " + rentalCount);
            System.out.println();
            System.out.println();
        }
    }

    public void displayAvailableCarCount() {
        int availableCount = 0;

        for (Car car : cars) {
            if (car.isAvailable()) { // Check if the car is available
                availableCount++;
            }
        }

        System.out.println("Total Number of Available Cars: " + availableCount);
    }


    public void menu(){
        Scanner scanner =new Scanner(System.in);
        while(true){
            System.out.println(" ===Welcome to the Car Rental System!===");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Display Rental Car List");
            System.out.println("4. Display Available Cars");
            System.out.println("5. Exit from here");
            System.out.println("Enter your choice of following above options:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("\nHi How are You! Please going our Website and Rent a Car as your choice:\n");
                System.out.println("Enter the customer name: ");
                String customerName = scanner.nextLine();

                System.out.println("===Available Cars:===");

                for(Car car : cars){

                    
                    if (car.isAvailable()){
                        System.out.println(car.getCarId() + " " + car.getBrand() + " " + car.getModel());
                    }
                }


                System.out.println("Enter the car id you want to rent: ");
                String carId = scanner.nextLine();

                System.out.println("Enter the number of days you want to rent: ");
                int rentalDays = scanner.nextInt();
                scanner.nextLine();

                Customer newCustomer = new Customer(customerName, "CUS" + customers.size() + 1);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for (Car car : cars) {
                    if( car.getCarId().equals(carId) && car.isAvailable()){
                        selectedCar = car;
                        break;
                    }
                }
                if (selectedCar != null) {
                    double totalPrice = selectedCar.calculatePricePerDay(rentalDays);

                    System.out.println("Rental All Information in here : ");
                    System.out.println("Car Id: " + selectedCar.getCarId());

                    System.out.println("Customer Id:" + newCustomer.getCustomerID());
                    System.out.println("Customer Name:" + newCustomer.getName());
                    System.out.println("Car Brand: " + selectedCar.getBrand());
                    System.out.println("Car Model: " + selectedCar.getModel());
                    System.out.println("Rental Days: " + rentalDays);
                    System.out.println("Total Price: $" + totalPrice);

                    System.out.println("Confirm rental (Y/N) : ");
                    String confirm = scanner.nextLine();

                    if(confirm.equalsIgnoreCase("Y")){
                        rentCar(selectedCar,newCustomer,rentalDays);
                        System.out.println("**Rent car successfully.**");
                    }else if(confirm.equalsIgnoreCase("N")){
                        System.out.println("Oppss! Rental cancelled.");
                    }else {
                        System.out.println("Invalid car selection or car is not available for renting.");
                    }

                }

            }

            else if (choice == 2) {
                System.out.println("===Return a Car===");
                System.out.println("Enter the car id you want to return: ");
                String carId = scanner.nextLine();

                Car carToReturn = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carId) && !car.isAvailable()) { // Check only rented cars
                        carToReturn = car;
                        break;
                    }
                }

                if (carToReturn != null) {
                    Rental rentalToRemove = null;
                    Customer customer = null;

                    // Find the associated rental and customer
                    for (Rental rental : rentals) {
                        if (rental.getCar() == carToReturn) {
                            rentalToRemove = rental;
                            customer = rental.getCustomer();
                            break;
                        }
                    }

                    if (rentalToRemove != null) {
                        returnCar(carToReturn);  // Return the car (sets isAvailable to true)
                        rentals.remove(rentalToRemove);  // Remove the rental record
                        System.out.println("Car returned successfully by " + customer.getName());
                    } else {
                        System.out.println("Rental record not found for this car.");
                    }
                } else {
                    System.out.println("Car not found or is already available.");
                }
            }

            else if (choice == 3) {
                displayRentals(); // Call new method
            } else if (choice==4) {
                displayAvailableCarCount();
            } else if (choice == 5) {
                break;
            }else {
                System.out.println("Invalid choice. please enter valid option:");
            }
        }
        System.out.println("*****Thank you for using Car Rental System.*****");
    }
}
