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
        populateCarList();
        //
        mainMenu();
    }

    public static void mainMenu() throws FileNotFoundException, ParseException {
        //print out menu
        int select = Integer.parseInt(input.nextLine());
        switch (select){
            case 1://Create car, customers, or contracts
            case 2://Edit
            case 3://print lists from files
                printCars();
            case 4://end program
            default://rerun menu
        }
    }

    public static void createCars(ArrayList<Car> list){
        //eventually get cars from file and add them to array list
    }

    public static void populateCarList() throws ParseException, FileNotFoundException {
        File myObj = new File("files/cars"); //Gets pizza menu file
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String[] parts = myReader.nextLine().split(" // "); //Splits pizzas by number, name, ingredients, and price
            if(parts[0]=="LUXURY"){
                Luxury output = new Luxury(parts[1], parts[2],parts[3],stringToDate(parts[4]),Integer.parseInt(parts[5]));
                myCarList.addCar(output);
            }else if(parts[0]=="FAMILY"){
                Family output = new Family(parts[1], parts[2],parts[3],stringToDate(parts[4]),Integer.parseInt(parts[5]));
                myCarList.addCar(output);
            }else if(parts[0]=="SPORT"){
                Sport output = new Sport(parts[1], parts[2],parts[3],stringToDate(parts[4]),Integer.parseInt(parts[5]));
                myCarList.addCar(output);
            }

        }
        myReader.close();
    }

    public static void printCars() throws FileNotFoundException, ParseException {
        ArrayList<Car> temp = myCarList.getCars();
        for (int i = 0; i < temp.size(); i++){
            System.out.println(temp.get(i)+"\n");
        }
    }

    public static Date stringToDate(String dateAsString) throws ParseException {
        String sDate1=dateAsString;
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        return date1;
    }
}
