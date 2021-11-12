import java.util.*;
public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        //private and company customers arraylist
        //
        mainMenu();

    }

    public static void mainMenu(){
        //print out menu
        int select = Integer.parseInt(input.nextLine());
        switch (select){
            case 1://Create car, customers, or rentals
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
