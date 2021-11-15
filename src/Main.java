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
        myCarList.createCars(); //populates car arraylist
        myCustomerList.createCustomers(); //populates customer arraylist
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
                        System.out.println("Creating new Car..\nPlease enter the following\n-------------------");
                        System.out.println("BrandModel: ");
                        String bModel = input.nextLine();
                        System.out.println("Fuel Type: ");
                        String fType = input.nextLine();
                        System.out.println("License Plate: ");
                        String plate = input.nextLine();
                        System.out.println("First Registration Date (yyyy-mm-dd): ");
                        Date fRegDate = new SimpleDateFormat("yyyy-MM-dd").parse(input.nextLine());
                        System.out.println("Kilometers driven: ");
                        int km = Integer.parseInt(input.nextLine());
                        createCar(rType,bModel,fType,plate,fRegDate,km);
                        mainMenu();
                    case 2:
                        //Create customer
                        System.out.println("1. New private customer\n2. New company customer");
                        int customerSelect = Integer.parseInt(input.nextLine());
                        String cType = "";
                        if (customerSelect == 1){
                            cType = "PRIVATE";
                        }else{
                            cType = "COMPANY";
                        }
                        System.out.println("Creating new customer..\nPlease enter the following\n-------------------");
                        System.out.println("Name: ");
                        String cName = input.nextLine();
                        System.out.println("City: ");
                        String cCity = input.nextLine();
                        System.out.println("Address: ");
                        String cAddress = input.nextLine();
                        System.out.println("Postal Code: ");
                        int cPostal = Integer.parseInt(input.nextLine());
                        System.out.println("Mobile/home phone: ");
                        int cMobile = Integer.parseInt(input.nextLine());
                        System.out.println("Work phone: ");
                        int cWorkPhone = Integer.parseInt(input.nextLine());
                        System.out.println("Email: ");
                        String cMail = input.nextLine();

                        String cCompany="";
                        String cCompanyAddress="";
                        int cCompanyRegNumber;
                        int cCompanyPhone;
                        if(customerSelect==2){
                            System.out.println("Company name: ");
                            cCompany = input.nextLine();
                            System.out.println("Company address: ");
                            cCompanyAddress = input.nextLine();
                            System.out.println("Company phone: ");
                            cCompanyPhone = Integer.parseInt(input.nextLine());
                            System.out.println("Company registration number: ");
                            cCompanyRegNumber = Integer.parseInt(input.nextLine());
                            Company outputCustomer = new Company(cName, cAddress, cPostal, cCity, cMobile, cWorkPhone, cMail, cCompany, cCompanyAddress, cCompanyPhone, cCompanyRegNumber);
                            myCustomerList.addCustomer(outputCustomer);
                        } else {
                            System.out.println("Licence number: ");
                            String cRegNumber = input.nextLine();
                            System.out.println("Driver since (yyyy-mm-dd): ");
                            Date cDriverSince = new SimpleDateFormat("yyyy-MM-dd").parse(input.nextLine());
                            Private outputCustomer = new Private(cName, cAddress, cPostal, cCity, cMobile, cWorkPhone, cMail, cRegNumber, cDriverSince);
                            myCustomerList.addCustomer(outputCustomer);
                        }
                        mainMenu();
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
        Car newCar = new Car();
        if (rType.equals("LUXURY")){
            newCar = new Luxury(bModel, fType, plate, fRegDate, km);
        }else if (rType.equals("FAMILY")){
            newCar = new Family(bModel, fType, plate, fRegDate, km);
        }else if (rType.equals("SPORT")){
            newCar = new Sport(bModel, fType, plate, fRegDate, km);
        }
        myCarList.addCar(newCar);
        System.out.println("Car successfully created!");
    }

    public static void printCars() throws FileNotFoundException, ParseException {
        ArrayList<Car> temp = myCarList.getCarList();
        System.out.println("List of cars from file\n------------------------------");
        for (int i = 0; i < temp.size(); i++){
            System.out.println(temp.get(i)+"\n");
        }
        System.out.println("------------------------------");
    }

    public static void printCustomers() throws FileNotFoundException, ParseException {
        //evt ask user if they wish to only show private or company customers
        ArrayList<Customer> temp = myCustomerList.getCustomerList();
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
