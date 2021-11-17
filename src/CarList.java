import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CarList {

    private ArrayList<Car> cars = new ArrayList<>();
    public ArrayList<Car> getCarList() throws FileNotFoundException, ParseException {
        //for initializing arraylist
        populateCarList();
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

    public void editCar(Car car) throws IOException {
        String output = "";
        //File is read
        File myObj = new File("files/cars"); //First we read the file
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String currentLine = myReader.nextLine();
            if (!currentLine.contains(car.getPlate())){ //if line hasn't been modified
                output+=currentLine+"\n";}
            else { //Save line if it doesn't contain license plate
                if (car.getRentalType().equals("LUXURY")){
                    Luxury lCar = (Luxury) car; //Casting in order to get extra parameters, woohoo
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String strDate = dateFormat.format(lCar.getfRegDate());
                    output+=(lCar.getRentalType() + " // " + lCar.getBrandModel() + " // " + lCar.getFuelType() + " // " + lCar.getPlate() + " // " + strDate + " // " + lCar.getOdometerVal() + "\n");
                }else if(car.getRentalType().equals("FAMILY")){
                    Family fCar = (Family) car; //Casting in order to get extra parameters, woohoo
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String strDate = dateFormat.format(fCar.getfRegDate());
                    output+=(fCar.getRentalType() + " // " + fCar.getBrandModel() + " // " + fCar.getFuelType() + " // " + fCar.getPlate() + " // " + strDate + " // " + fCar.getOdometerVal() + "\n");
                }else if (car.getRentalType().equals("SPORT")){
                    Sport sCar = (Sport) car; //Casting in order to get extra parameters, woohoo
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String strDate = dateFormat.format(sCar.getfRegDate());
                    output+=(sCar.getRentalType() + " // " + sCar.getBrandModel() + " // " + sCar.getFuelType() + " // " + sCar.getPlate() + " // " + strDate + " // " + sCar.getOdometerVal() + "\n");

                }
            }
        }

        myReader.close();
        //New file is written
        FileWriter myWriter = new FileWriter("files/cars");
        myWriter.write(output); //Then we write the whole thing again
        myWriter.close();
    }

    public void populateCarList() throws ParseException, FileNotFoundException {
        File myObj = new File("files/cars"); //Gets car file
        Scanner myReader = new Scanner(myObj);
        cars.clear();
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
