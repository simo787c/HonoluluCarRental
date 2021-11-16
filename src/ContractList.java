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

public class ContractList {
    private CustomerList myCustomerList = new CustomerList();
    private CarList myCarList = new CarList();
    private ArrayList<RentalContract> contracts = new ArrayList<>();

    public ArrayList<RentalContract> getContracts() throws FileNotFoundException, ParseException {
        populateContractList();
        return contracts;
    }

    public void populateContractList() throws ParseException, FileNotFoundException {
        myCustomerList.populateCustomerList();
        myCarList.populateCarList();
        File myObj = new File("files/contracts"); //Gets customer file
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String nextLine = myReader.nextLine();
            String[] parts = nextLine.split(" // "); //Splits

            //Find customer by ID
            Customer tempCustomer = new Customer();
            for (int i = 0; i < myCustomerList.getCustomerList().size(); i++){
                if(myCustomerList.getCustomerList().get(i).getID()==Integer.parseInt(parts[0])){
                    tempCustomer = myCustomerList.getCustomerList().get(i);
                    System.out.println();
                }
            }

            //Find car by Plate
            Car tempCar = new Car();
            for (int i = 0; i < myCarList.getCarList().size(); i++){
                if(myCarList.getCarList().get(i).getPlate().equals(parts[5])){
                    tempCar = myCarList.getCarList().get(i);
                }
            }
            RentalContract output = new RentalContract(tempCustomer, tempCar, stringToDate(parts[1]), stringToDate(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
            contracts.add(output);
        }
        myReader.close();
    }
    public static Date stringToDate(String dateAsString) throws ParseException {
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(dateAsString);
        return date1;
    }
    public void addCustomer(RentalContract contract) throws FileNotFoundException, ParseException {
        try{
            FileWriter appendNE = new FileWriter("files/contracts",true);
            BufferedWriter out = new BufferedWriter(appendNE);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            out.write("\n" + contract.getCustomer().getID() + " // " + dateFormat.format(contract.getFromDateTime()) + " // " + dateFormat.format(contract.getToDate()) + " // " + contract.getMaxKilometer() + " // " + contract.getStartKilometer() + " // " + contract.getCar().getPlate());
            out.close();
        }catch(Exception er){
            System.err.println("Error while printing"+ er.getMessage());
        }
        populateContractList();
    }
}
