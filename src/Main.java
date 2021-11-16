import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);
    private static CustomerList myCustomerList = new CustomerList();
    private static CarList myCarList = new CarList();
    private static ContractList myContractList = new ContractList();

    //private and company customers arraylist
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        System.out.println("Welcome to Honolulu Car Rental");
        myCarList.getCarList(); //populates car arraylist
        myCustomerList.getCustomerList(); //populates customer arraylist
        mainMenu();
    }

    public static void mainMenu() throws FileNotFoundException, ParseException {
        //print out menu
        System.out.println("\n1. Create new entry\n2. Edit existing entries\n3. Entries\n4. End Program");
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
                        createCustomer(false);
                        mainMenu();
                    case 3:
                        System.out.println("*** CREATE CONTRACT ***");
                        System.out.println("Does the customer exist in the registry? Y/n");
                        if (input.nextLine().equalsIgnoreCase("n")) {
                            createCustomer(true);
                        }else{
                            printCustomers();
                            System.out.print("Enter number to select customer: ");
                            createContract(Integer.parseInt(input.nextLine()));
                        }

                    }
            case 2://Edit
                System.out.println("1. Edit Cars\n 2. Edit Customers\n 3. Edit Contracts");
                int editSelect = Integer.parseInt(input.nextLine());
                switch(editSelect){
                    case 1://car
                    case 2://customer

                        System.out.println("\nWhich customer do you wish to modify?: \n");
                        ArrayList<Customer> temp = myCustomerList.getCustomerList();
                        for (int i = 0; i<=temp.size(); i++){
                            System.out.println(i+1 + ": " + (temp.get(i)+"\n"));
                        }
                        int edNum = Integer.parseInt(input.nextLine());

                        System.out.println("Modifying customer..\nPlease enter the following\n-------------------");
                        System.out.println("Name: ");
                        temp.get(edNum).setDriverName(input.nextLine());
                        System.out.println("City: ");
                        temp.get(edNum).setCity(input.nextLine());
                        System.out.println("Address: ");
                        temp.get(edNum).setAddress(input.nextLine());
                        System.out.println("Postal Code: ");
                        temp.get(edNum).setPostalCode(input.nextInt());
                        System.out.println("Mobile/home phone: ");
                        temp.get(edNum).setMobilePhone(input.nextInt());
                        System.out.println("Work phone: ");
                        temp.get(edNum).setPhone(input.nextInt());
                        System.out.println("Email: ");
                        temp.get(edNum).setEmail(input.nextLine());

                        String cCompany="";
                        String cCompanyAddress="";
                        int cCompanyRegNumber;
                        int cCompanyPhone;
                        if(temp.get(edNum).getCustomerType().equals("COMPANY")){
                            ArrayList<Company> ctemp = (ArrayList<Company>) temp;
                            System.out.println("Company name: ");
                            cCompany = input.nextLine();
                            System.out.println("Company address: ");
                            cCompanyAddress = input.nextLine();
                            System.out.println("Company phone: ");
                            cCompanyPhone = Integer.parseInt(input.nextLine());
                            System.out.println("Company registration number: ");
                            cCompanyRegNumber = Integer.parseInt(input.nextLine());
                            Company outputCustomer = new Company(cName, cAddress, cPostal, cCity, cMobile, cWorkPhone, cMail, cCompany, cCompanyAddress, cCompanyPhone, cCompanyRegNumber);
                            myCustomerList.editCustomer(outputCustomer);
                        } else {
                            System.out.println("Licence number: ");
                            String cRegNumber = input.nextLine();
                            System.out.println("Driver since (yyyy-mm-dd): ");
                            Date cDriverSince = new SimpleDateFormat("yyyy-MM-dd").parse(input.nextLine());
                            Private outputCustomer = new Private(cName, cAddress, cPostal, cCity, cMobile, cWorkPhone, cMail, cRegNumber, cDriverSince);
                            myCustomerList.editCustomer(outputCustomer);
                        }
                        mainMenu();
                    case 3://contract
                }

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
                        printContracts();
                        mainMenu();
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
            System.out.println("NUMBER: " + (i+1) + "\n" + temp.get(i)+"\n");
        }
        System.out.println("------------------------------");
    }

    public static void printCustomers() throws FileNotFoundException, ParseException {
        //evt ask user if they wish to only show private or company customers
        ArrayList<Customer> temp = myCustomerList.getCustomerList();
        System.out.println("List of customers from file\n------------------------------");
        for (int i = 0; i < temp.size(); i++){
            System.out.println("NUMBER " + i + ": \n" + temp.get(i)+"\n\n");
        }
        System.out.println("------------------------------");
    }

    public static void printContracts() throws FileNotFoundException, ParseException {
        //evt ask user if they wish to only show private or company customers
        ArrayList<RentalContract> temp = myContractList.getContracts();
        System.out.println("List of customers from file\n------------------------------");
        for (int i = 0; i < temp.size(); i++){
            System.out.println(temp.get(i)+"\n");
        }
        System.out.println("------------------------------");
    }

    public static Date stringToDate(String dateAsString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(dateAsString);
    }

    public static void createCustomer(boolean continueToContract) throws FileNotFoundException, ParseException {
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
        System.out.println("Phone: ");
        int cWorkPhone = input.nextInt();
        input.nextLine();
        System.out.println("Mobile phone: ");
        int cMobile = input.nextInt();
        input.nextLine();
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
            cCompanyPhone = input.nextInt();
            input.nextLine();
            System.out.println("Company registration number: ");
            cCompanyRegNumber = input.nextInt();
            input.nextLine();
            Company outputCustomer = new Company(cName, cAddress, cPostal, cCity, cMobile, cWorkPhone, cMail, cCompany, cCompanyAddress, cCompanyPhone, cCompanyRegNumber);
            myCustomerList.addCustomer(outputCustomer);
            if (continueToContract==true){createContract(myCustomerList.getCustomerList().size()-1);}
        } else {
            System.out.println("Licence number: ");
            String cRegNumber = input.nextLine();
            System.out.println("Driver since (yyyy-mm-dd): ");
            Date cDriverSince = new SimpleDateFormat("yyyy-MM-dd").parse(input.nextLine());
            Private outputCustomer = new Private(cName, cAddress, cPostal, cCity, cMobile, cWorkPhone, cMail, cRegNumber, cDriverSince);
            myCustomerList.addCustomer(outputCustomer);
        }


    }

    public static void createContract(int cxID) throws FileNotFoundException, ParseException {
        printCars();
        Customer tempCustomer = myCustomerList.getCustomerList().get(cxID);
        System.out.print("Enter number to select rental car: ");
        Car tempCar = myCarList.getCarList().get(Integer.parseInt(input.nextLine())-1);
        System.out.println("*** SELECTED CUSTOMER: " + tempCustomer.getDriverName() + " ***");
        System.out.println("*** SELECTED CAR: " + tempCar.getBrandModel() + " ***");
        System.out.print("What is the maximum drive length in KM?: ");
        int maxKM = Integer.parseInt(input.nextLine());
        System.out.println("What is the start date of the rental? (yyyy-mm-dd):");
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(input.nextLine());
        System.out.println("What is the end date of the rental? (yyyy-mm-dd):");
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(input.nextLine());
        RentalContract output = new RentalContract(tempCustomer, tempCar, startDate, endDate, maxKM, tempCar.getOdometerVal());
        myContractList.addCustomer(output);
        System.out.println("Added ");
        mainMenu();
    }
}
