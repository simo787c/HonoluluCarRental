import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);
    private static CustomerList myCustomerList = new CustomerList();
    private static CarList myCarList = new CarList();
    private static ContractList myContractList = new ContractList();

    //private and company customers arraylist
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("Welcome to Honolulu Car Rental");
        myCarList.getCarList(); //populates car arraylist
        myCustomerList.getCustomerList(); //populates customer arraylist
        mainMenu();
    }

    public static void mainMenu() throws IOException, ParseException {
        //print out menu
        System.out.println("\n1. Create new entry\n2. Edit existing entries\n3. View entries\n4. End Program");
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
                        createCustomer(false,(Integer.parseInt(input.nextLine())==2));
                        mainMenu();
                    case 3:
                        //Create contract
                        System.out.println("*** CREATE CONTRACT ***");
                        System.out.println("Does the customer exist in the registry? Y/n");
                        if (input.nextLine().equalsIgnoreCase("n")) {
                            System.out.println("1. New private customer\n2. New company customer");
                            myCustomerList.addCustomer(createCustomer(false,(Integer.parseInt(input.nextLine())==2)));
                            myContractList.addCustomer(createContract(myCustomerList.getCustomerList().size()-1));
                            System.out.println("*** Added contract! ***");
                        }else{
                            printCustomers();
                            System.out.print("Enter number to select customer: ");
                            createContract(Integer.parseInt(input.nextLine()));
                        }
                        mainMenu();
                }
            case 2://Edit
                System.out.println("1. Edit Cars\n 2. Edit Customers\n 3. Edit Contracts");
                int editSelect = Integer.parseInt(input.nextLine());
                switch(editSelect){
                    case 1://car
                    case 2://customer
                        ArrayList<Customer> temp = myCustomerList.getCustomerList();
                        for (int i = 0; i<=temp.size()-1; i++){
                            System.out.println(i+1 + ": " + (temp.get(i)+"\n"));
                        }

                        System.out.println("\nWhich customer do you wish to modify?: \n");
                        int cx = Integer.parseInt(input.nextLine()) - 1;
                        System.out.println(temp.get(cx) + "\n");
                        System.out.println("\n1: Delete entry\n2: Edit entry");
                        editSelect = Integer.parseInt(input.nextLine());
                        switch(editSelect) {
                            case 1:
                                Customer removalCx = myCustomerList.getCustomerList().get(cx);
                                myCustomerList.editCustomer(removalCx, true);
                                System.out.println("*** Done! ***");
                                mainMenu();
                            case 2:
                                if (temp.get(cx).getCustomerType().equals("COMPANY")) {
                                    Company outputCustomer = (Company) createCustomer(false, true);
                                    outputCustomer.setID(temp.get(cx).getID());
                                    myCustomerList.editCustomer(outputCustomer, false);
                                } else {
                                    Private outputCustomer = (Private) createCustomer(false, false);
                                    outputCustomer.setID(temp.get(cx).getID());
                                    myCustomerList.editCustomer(outputCustomer, false);
                                }
                                System.out.println("*** Done! ***");
                                mainMenu();
                        }
                    case 3://contract
                        printContracts();
                        System.out.println("\nWhich contract do you wish to modify?: \n");
                        int rc = Integer.parseInt(input.nextLine())-1;
                        System.out.println("\n1: Delete entry\n2: Edit entry");
                        editSelect = Integer.parseInt(input.nextLine());
                        switch(editSelect) {
                            case 1:
                                myContractList.editContract(myContractList.getContracts().get(rc), rc, true);
                                System.out.println("*** Done! ***");
                                mainMenu();
                            case 2:
                                printCustomers();
                                System.out.print("Who should be on the selected contract? Enter number to select customer: ");
                                myContractList.editContract(createContract(Integer.parseInt(input.nextLine()) - 1), rc, false);
                                System.out.println("*** Done! ***");
                                mainMenu();
                        }
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
            System.out.println("NUMBER " + (i+1) + ": \n" + temp.get(i)+"\n\n");
        }
        System.out.println("------------------------------");
    }

    public static void printContracts() throws FileNotFoundException, ParseException {
        //evt ask user if they wish to only show private or company customers
        ArrayList<RentalContract> temp = myContractList.getContracts();
        System.out.println("List of customers from file\n------------------------------");
        for (int i = 0; i < temp.size(); i++){
            System.out.println("NUMBER " + (i+1) + ":\n" + temp.get(i)+"\n");
        }
        System.out.println("------------------------------");
    }

    public static Date stringToDate(String dateAsString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(dateAsString);
    }

    public static Customer createCustomer(boolean continueToContract, boolean company) throws IOException, ParseException {
        //Create customer
        String cType = "";
        if (company==false){
            cType = "PRIVATE";
        }else{
            cType = "COMPANY";
        }
        System.out.println("Please enter the following\n-------------------");
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
        if(company==true){
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
            return new Company(cName, cAddress, cPostal, cCity, cMobile, cWorkPhone, cMail, cCompany, cCompanyAddress, cCompanyPhone, cCompanyRegNumber);

        } else {
            System.out.println("Licence number: ");
            String cRegNumber = input.nextLine();
            System.out.println("Driver since (yyyy-mm-dd): ");
            Date cDriverSince = new SimpleDateFormat("yyyy-MM-dd").parse(input.nextLine());
            return new Private(cName, cAddress, cPostal, cCity, cMobile, cWorkPhone, cMail, cRegNumber, cDriverSince);
        }
    }

    public static RentalContract createContract(int cxID) throws IOException, ParseException {
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
        return new RentalContract(tempCustomer, tempCar, startDate, endDate, maxKM, tempCar.getOdometerVal());
    }
}
