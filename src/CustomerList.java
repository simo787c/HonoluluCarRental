import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CustomerList {

    private ArrayList<Customer> customers = new ArrayList<>();
    public ArrayList<Customer> getCustomers() throws FileNotFoundException, ParseException {
        populateCustomerList();
        return customers;
    }
    public void addCustomer(Customer customer) throws FileNotFoundException, ParseException {
        try{
            FileWriter appendNE = new FileWriter("files/customers",true);
            BufferedWriter out = new BufferedWriter(appendNE);
            //appendNE.write("\n"+fn+" "+ln+" "+a+" "+h);
            if (customer.getCustomerType().equals("COMPANY")){
                //missing company specific fields to add
                out.write("\n" + customer.getCustomerType() + " // " + customer.getDriverName() + " // " + customer.getAddress() + " // " + customer.getPostalCode() + " // " + customer.getCity() + " // " + customer.getMobilePhone() + " // " + customer.getPhone() + " // " + customer.getEmail() + " // ");
            }else if(customer.getCustomerType().equals("PRIVATE")){
                //missing private specific fields to add
                out.write("\n" + customer.getCustomerType() + " // " + customer.getDriverName() + " // " + customer.getAddress() + " // " + customer.getPostalCode() + " // " + customer.getCity() + " // " + customer.getMobilePhone() + " // " + customer.getPhone() + " // " + customer.getEmail());
            }
            out.close();
        }catch(Exception er){
            System.err.println("Error while printing"+ er.getMessage());
        }
        populateCustomerList();
    }

    public void populateCustomerList() throws ParseException, FileNotFoundException {
        File myObj = new File("files/customers"); //Gets customer file
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String[] parts = myReader.nextLine().split(" // "); //Splits
            if(parts[0].equals("COMPANY")){
                Company output = new Company(parts[1], parts[2],Integer.parseInt(parts[3]),parts[4],Integer.parseInt(parts[5]),Integer.parseInt(parts[6]),parts[7],parts[8],parts[9],Integer.parseInt(parts[10]),Integer.parseInt(parts[11]));
                customers.add(output);
            }else if(parts[0].equals("PRIVATE")){
                Private output = new Private(parts[1], parts[2],Integer.parseInt(parts[3]),parts[4],Integer.parseInt(parts[5]),Integer.parseInt(parts[6]),parts[7],parts[8],stringToDate(parts[9]));
                customers.add(output);
            }

        }
        myReader.close();
    }
    public static Date stringToDate(String dateAsString) throws ParseException {
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(dateAsString);
        return date1;
    }

}
