import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);
    private static CustomerList myCustomerList = new CustomerList();
    private static CarList myCarList = new CarList();
    //private and company customers arraylist
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        myCarList.getCars();
        myCustomerList.getCustomers();
        mainMenu();
    }

    public static void mainMenu() throws FileNotFoundException, ParseException {
        //print out menu
        System.out.println("Welcome to Honolulu Car Rental");
        System.out.println("1. Create new entry\n2. Edit existing entries\n3. Entries\n4. End Program");
        int select = Integer.parseInt(input.nextLine());
        switch (select){
            case 1://Create cars, customers, or contracts
                System.out.println("Create new..");
                System.out.println("1. Cars\n2. Customers\n3. Contracts");
                int createSelect = Integer.parseInt(input.nextLine());
                switch (createSelect){
                    case 1:
                        //Create car
                        System.out.println("1. New Luxury Car\n2. New Family Car\n3. New Sports Car");
                        int carSelect = Integer.parseInt(input.nextLine());
                        String rType = "";
                        if (carSelect == 1){
                            rType = "LUXURY";
                        }else if (carSelect == 2){
                            rType = "FAMILY";
                        }else if (carSelect == 3){
                            rType = "SPORT";
                        }
                        String bModel;
                        String fType;
                        String plate;
                        String tempDate;
                        Date fRegDate;
                        int km;

                        System.out.println("Creating new Car..\nPlease enter the following\n-------------------");
                        System.out.println("BrandModel: ");
                        bModel = input.nextLine();
                        System.out.println("Fuel Type: ");
                        fType = input.nextLine();
                        System.out.println("License Plate: ");
                        plate = input.nextLine();
                        System.out.println("First Registration Date (yyyy-mm-dd): ");
                        tempDate = input.nextLine();
                        fRegDate = stringToDate(tempDate);
                        System.out.println("Kilometers driven: ");
                        km = input.nextInt();

                        createCar(rType,bModel,fType,plate,fRegDate,km);
                        mainMenu();
                    case 2:
                        //Create Customer
                    case 3:
                        //Create Contract
                }
            case 2://Edit

            case 3://print lists from files
                System.out.println("1. Cars\n2. Customers\n3. Contracts");
                int printSelect = Integer.parseInt(input.nextLine());
                switch (printSelect){
                    case 1:
                        printCars();
                        mainMenu();
                    case 2:
                        printCustomers();
                        mainMenu();
                    case 3:
                }
            case 4://end program
                break;
            default://rerun menu
                mainMenu();
        }
    }

    public static void createCar(String rType, String bModel, String fType, String plate, Date fRegDate, int km) throws ParseException, FileNotFoundException {
        if (rType.equals("LUXURY")){
            Car newCar = new Luxury(bModel, fType, plate, fRegDate, km);
            myCarList.addCar(newCar);
        }else if (rType.equals("FAMILY")){
            Car newCar = new Family(bModel, fType, plate, fRegDate, km);
            myCarList.addCar(newCar);
        }else if (rType.equals("SPORT")){
            Car newCar = new Sport(bModel, fType, plate, fRegDate, km);
            myCarList.addCar(newCar);
        }
        System.out.println("Car successfully created!");
    }

    public static void printCars() throws FileNotFoundException, ParseException {
        ArrayList<Car> temp = myCarList.getCars();
        System.out.println("List of cars from file\n------------------------------");
        for (int i = 0; i < temp.size(); i++){
            System.out.println(temp.get(i)+"\n");
        }
        System.out.println("------------------------------");
    }

    public static void printCustomers() throws FileNotFoundException, ParseException {
        ArrayList<Customer> temp = myCustomerList.getCustomers();
        System.out.println("List of customers from file\n------------------------------");
        for (int i = 0; i < temp.size(); i++){
            System.out.println(temp.get(i)+"\n");
        }
        System.out.println("------------------------------");
    }

    public static Date stringToDate(String dateAsString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(dateAsString);
    }
}
