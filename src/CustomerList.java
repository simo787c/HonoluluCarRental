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

            if (customer.getCustomerType().equals("COMPANY")){
                Company cCustomer = (Company) customer; //Casting in order to get extra parameters, which somehow works?
                //missing company specific fields to add
                out.write("\n" + cCustomer.getCustomerType() + " // " + cCustomer.getDriverName() + " // " + cCustomer.getAddress() + " // " + cCustomer.getPostalCode() + " // " + cCustomer.getCity() + " // " + cCustomer.getMobilePhone() + " // " + cCustomer.getPhone() + " // " + cCustomer.getEmail() + " // " + cCustomer.getCompanyName() + " // " + cCustomer.getCompanyAddress() + " // " + cCustomer.getCompanyPhone() + " // " + cCustomer.getCompanyRegistrationNumber());
            }else if(customer.getCustomerType().equals("PRIVATE")){
                Private pCustomer = (Private) customer; //Casting in order to get extra parameters, which somehow works?
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String strDate = dateFormat.format(pCustomer.getDriverSinceDate());
                out.write("\n" + pCustomer.getCustomerType() + " // " + pCustomer.getDriverName() + " // " + pCustomer.getAddress() + " // " + pCustomer.getPostalCode() + " // " + pCustomer.getCity() + " // " + pCustomer.getMobilePhone() + " // " + pCustomer.getPhone() + " // " + pCustomer.getEmail() + " // " + pCustomer.getLicenseNumber() + " // " + strDate);
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
