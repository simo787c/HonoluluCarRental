import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Main {
    public static Scanner input = new Scanner(System.in);
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static CarList myCarList = new CarList();
    //private and company customers arraylist
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        //
        mainMenu();
    }

    public static void mainMenu(){
        //print out menu
        int select = Integer.parseInt(input.nextLine());
        switch (select){
            case 1://Create car, customers, or contracts
            case 2://Edit
            case 3://print lists from files
            case 4://end program
            default://rerun menu
        }
    }

    public static void createCars(ArrayList<Car> list){

        //eventually get cars from file and add them to array list
    }



    public static void createCustomers(ArrayList<Customer> list){
        //eventually get customers from file and add them to array list
    }

    public static void createRentals(){
        //populate arraylist with contracts
    }


}
