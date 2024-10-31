package CarRentalSystem;
public class Main {

    public static void main(String[] args) {
        CarRentalSystem carRentalSystem = new CarRentalSystem();

        Car car1 =new Car("C1","Camry",60.0,"Toyota");
        Car car2 =new Car("C2","Accord",70.0,"Honda");
        Car car3 =new Car("C3","Civic",85.0,"Honda");
        Car car4 =new Car("C4","Porsee",105.0,"Toyota");
        Car car5 =new Car("C5","X7",120.0,"BMW");
        Car car6 =new Car("C6","X7+",125.0,"BMW");
        Car car7 =new Car("C7","Audi+",80.0,"Audi");
        Car car8 =new Car("C8","YY",120.0,"Laborgini");




        carRentalSystem.addCar(car1);
        carRentalSystem.addCar(car2);
        carRentalSystem.addCar(car3);
        carRentalSystem.addCar(car4);
        carRentalSystem.addCar(car5);
        carRentalSystem.addCar(car6);
        carRentalSystem.addCar(car7);
        carRentalSystem.addCar(car8);

        carRentalSystem.menu();
    }
}
