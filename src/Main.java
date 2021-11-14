import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BinaryOperator;

public class Main {
    public static Scanner input = new Scanner(System.in);
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static CarList myCarList = new CarList();
    //private and company customers arraylist
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        myCarList.populateCarList();
        //
        mainMenu();
    }

    public static void mainMenu() throws FileNotFoundException, ParseException {
        //print out menu
        System.out.println("Welcome to Honolulu Car Rental");
        System.out.println("1. Create new entry\n2. Edit existing entries\n3. End Program");
        int select = Integer.parseInt(input.nextLine());
        switch (select){
            case 1://Create cars, customers, or contracts
                System.out.println("1. New Luxury Car\n2. New Family Car\n3. New Sports Car");
                int createSelect = Integer.parseInt(input.nextLine());
                switch (createSelect){
                    case 1: //LUXURY
                        System.out.println("Creating new Luxury..\nPlease enter the following:");
                        String rType = "LUXURY";
                        System.out.println("BrandModel: ");
                        String bModel = input.nextLine();
                        System.out.println("Fuel Type: ");
                        String fType = input.nextLine();
                        System.out.println("License Plate: ");
                        String plate = input.nextLine();
                        System.out.println("First Registration Date (yyyy-mm-dd): ");
                        String tempDate = input.nextLine();
                        Date fRegDate = stringToDate(tempDate);
                        System.out.println("Kilometers driven: ");
                        int km = input.nextInt();

                        createCar(rType,bModel,fType,plate,fRegDate,km);
                        mainMenu();
                    case 2: //FAMILY
                    case 3: //SPORT
                }
            case 2://Edit
            case 3://print lists from files
                printCars();
            case 4://end program
            default://rerun menu
                mainMenu();
        }
    }

    public static void createCar(String rType, String bModel, String fType, String plate, Date fRegDate, int km) throws ParseException, FileNotFoundException {
        if (rType.equals("LUXURY")){
            Car input = new Luxury(bModel, fType, plate, fRegDate, km);
            myCarList.addCar(input);
        }else if (rType.equals("FAMILY")){
            Car input = new Family(bModel, fType, plate, fRegDate, km);
            myCarList.addCar(input);
        }else if (rType.equals("SPORT")){
            Car input = new Sport(bModel, fType, plate, fRegDate, km);
            myCarList.addCar(input);
        }
        System.out.println("Car successfully created!");
    }

    /*public static void populateCarList() throws ParseException, FileNotFoundException {
        File myObj = new File("files/cars"); //Gets file
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String[] parts = myReader.nextLine().split(" // "); //Splits
            if(parts[0].equals("LUXURY")){
                Luxury output = new Luxury(parts[1], parts[2],parts[3],stringToDate(parts[4]),Integer.parseInt(parts[5]));
                myCarList.addCar(output);
            }else if(parts[0].equals("FAMILY")){
                Family output = new Family(parts[1], parts[2],parts[3],stringToDate(parts[4]),Integer.parseInt(parts[5]));
                myCarList.addCar(output);
            }else if(parts[0].equals("SPORT")){
                Sport output = new Sport(parts[1], parts[2],parts[3],stringToDate(parts[4]),Integer.parseInt(parts[5]));
                myCarList.addCar(output);
            }

        }
        myReader.close();
    }*/

    public static void printCars() throws FileNotFoundException, ParseException {
        ArrayList<Car> temp = myCarList.getCars();
        System.out.println("List of cars from file:");
        for (int i = 0; i < temp.size(); i++){
            System.out.println(temp.get(i)+"\n");
        }
    }

    public static Date stringToDate(String dateAsString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(dateAsString);
    }
}
