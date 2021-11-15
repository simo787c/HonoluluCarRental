import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CarList {

    private ArrayList<Car> cars = new ArrayList<>();
    public ArrayList<Car> createCars() throws FileNotFoundException, ParseException {
        //for initializing arraylist
        populateCarList();
        return cars;
    }
    public ArrayList<Car> getCarList() {
        //for printing out existing list
        return cars;
    }
    public void addCar(Car car) throws FileNotFoundException, ParseException {
            try{
                FileWriter appendNE = new FileWriter("files/cars",true);
                BufferedWriter out = new BufferedWriter(appendNE);
                //appendNE.write("\n"+fn+" "+ln+" "+a+" "+h);
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String strDate = dateFormat.format(car.getfRegDate());
                out.write("\n" + car.getRentalType() + " // " + car.getBrandModel() + " // " + car.getFuelType() + " // " + car.getPlate() + " // " + strDate + " // " + car.getOdometerVal());
                out.close();
            }catch(Exception er){
                System.err.println("Error while printing"+ er.getMessage());
            }
            populateCarList();
    }

    public void populateCarList() throws ParseException, FileNotFoundException {
        File myObj = new File("files/cars"); //Gets car file
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String[] parts = myReader.nextLine().split(" // "); //Splits
            if(parts[0].equals("LUXURY")){
                Luxury output = new Luxury(parts[1], parts[2],parts[3],stringToDate(parts[4]),Integer.parseInt(parts[5]));
                cars.add(output);
            }else if(parts[0].equals("FAMILY")){
                Family output = new Family(parts[1], parts[2],parts[3],stringToDate(parts[4]),Integer.parseInt(parts[5]));
                cars.add(output);
            }else if(parts[0].equals("SPORT")){
                Sport output = new Sport(parts[1], parts[2],parts[3],stringToDate(parts[4]),Integer.parseInt(parts[5]));
                cars.add(output);
            }

        }
        myReader.close();
    }
    public static Date stringToDate(String dateAsString) throws ParseException {
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(dateAsString);
        return date1;
    }

}
