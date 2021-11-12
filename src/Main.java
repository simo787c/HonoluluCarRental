import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Main {
    public static Scanner input = new Scanner(System.in);
    private static ArrayList<Car> cars = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    //private and company customers arraylist
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        populateCarList();
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

    public static void populateCarList() throws ParseException, FileNotFoundException {
        File myObj = new File("files/cars.txt"); //Gets pizza menu file
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String[] parts = myReader.nextLine().split(" // "); //Splits pizzas by number, name, ingredients, and price
            if(parts[0]=="LUXURY"){
                Luxury output = new Luxury(parts[1], parts[2],parts[3],stringToDate(parts[4]),Integer.parseInt(parts[5]));
                cars.add(output);
            }else if(parts[0]=="FAMILY"){
                Family output = new Family(parts[1], parts[2],parts[3],stringToDate(parts[4]),Integer.parseInt(parts[5]));
                cars.add(output);
            }else if(parts[0]=="SPORT"){
                Sport output = new Sport(parts[1], parts[2],parts[3],stringToDate(parts[4]),Integer.parseInt(parts[5]));
                cars.add(output);
            }

        }
        myReader.close();
    }

    public static void createCustomers(ArrayList<Customer> list){
        //eventually get customers from file and add them to array list
    }

    public static void createRentals(){
        //populate arraylist with contracts
    }

    public static Date stringToDate(String dateAsString) throws ParseException {
        String sDate1=dateAsString;
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        return date1;
    }
}
