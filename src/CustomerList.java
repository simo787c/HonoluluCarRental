import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CustomerList {
    public String getListToString() {
        return listToString;
    }

    private String listToString;
    private ArrayList<Customer> customers = new ArrayList<>();
    public ArrayList<Customer> getCustomerList() throws FileNotFoundException, ParseException {
        populateCustomerList();
        return customers;
    }
    /*public ArrayList<Customer> getCustomerList() throws FileNotFoundException, ParseException {
        return customers;
    }*/

    public void addCustomer(Customer customer) throws FileNotFoundException, ParseException {
        try{
            FileWriter appendNE = new FileWriter("files/customers",true);
            BufferedWriter out = new BufferedWriter(appendNE);

            if (customer.getCustomerType().equals("COMPANY")){
                Company cCustomer = (Company) customer; //Casting in order to get extra parameters, woohoo
                out.write("\n" + cCustomer.getCustomerType() + " // " + cCustomer.getDriverName() + " // " + cCustomer.getAddress() + " // " + cCustomer.getPostalCode() + " // " + cCustomer.getCity() + " // " + cCustomer.getMobilePhone() + " // " + cCustomer.getPhone() + " // " + cCustomer.getEmail() + " // " + cCustomer.getCompanyName() + " // " + cCustomer.getCompanyAddress() + " // " + cCustomer.getCompanyPhone() + " // " + cCustomer.getCompanyRegistrationNumber() + " // ID:" + cCustomer.getID());
            }else if(customer.getCustomerType().equals("PRIVATE")){
                Private pCustomer = (Private) customer; //Casting in order to get extra parameters, woohoo
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String strDate = dateFormat.format(pCustomer.getDriverSinceDate());
                out.write("\n" + pCustomer.getCustomerType() + " // " + pCustomer.getDriverName() + " // " + pCustomer.getAddress() + " // " + pCustomer.getPostalCode() + " // " + pCustomer.getCity() + " // " + pCustomer.getMobilePhone() + " // " + pCustomer.getPhone() + " // " + pCustomer.getEmail() + " // " + pCustomer.getLicenseNumber() + " // " + strDate + " // ID:" + pCustomer.getID());
            }
            out.close();
        }catch(Exception er){
            System.err.println("Error while printing"+ er.getMessage());
        }
        populateCustomerList();
    }

    /*public ArrayList<Customer> editCustomer(ArrayList<Customer> customers, int delNum, String customerType, String driverName,String address,int postalCode,String city,int mobilePhone,int phone,String email, int ID) throws IOException, ParseException {
        //find id/index and replace in file with new entry
        //customers.set(delNum,)
        //customers.get(delNum).setDriverName(driverName);
        //overwrite previous file replacing the index of edited item with new info into same spot in file

        for(int i = 0; i<customers.size(); i++){
            //for every item in the array
            try{
                File file = new File("files/customers");
                Scanner out = new Scanner(file);
                String outputString = "";
                while(out.hasNextLine()){
                    if(i == delNum){
                        //ignore previous and insert new info via parameter, but how do we get private and company specific fields since its an arraylist now?
                        if (customers.get(i).getCustomerType().equals("COMPANY")){
                            //Company cCustomer = (Company) customer; //Casting in order to get extra parameters, woohoo
                            outputString += ("\n" + customerType + " // " + driverName + " // " + address + " // " + postalCode + " // " + city + " // " + mobilePhone + " // " + phone + " // " + email + " // " + cCustomer.getCompanyName() + " // " + cCustomer.getCompanyAddress() + " // " + cCustomer.getCompanyPhone() + " // " + cCustomer.getCompanyRegistrationNumber() + " // ID:" + cCustomer.getID());
                        }else if(customers.get(i).getCustomerType().equals("PRIVATE")){
                            //Private pCustomer = (Private) customer; //Casting in order to get extra parameters, woohoo
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String strDate = dateFormat.format(pCustomer.getDriverSinceDate());
                            out.write("\n" + pCustomer.getCustomerType() + " // " + pCustomer.getDriverName() + " // " + pCustomer.getAddress() + " // " + pCustomer.getPostalCode() + " // " + pCustomer.getCity() + " // " + pCustomer.getMobilePhone() + " // " + pCustomer.getPhone() + " // " + pCustomer.getEmail() + " // " + pCustomer.getLicenseNumber() + " // " + strDate + " // ID:" + pCustomer.getID());
                        }
                    }else{
                        //add unchanged items to file
                        if (customers.get(i).getCustomerType().equals("COMPANY")){
                            //Company cCustomer = (Company) customer; //Casting in order to get extra parameters, woohoo
                            out.write("\n" + customers.getCustomerType() + " // " + cCustomer.getDriverName() + " // " + cCustomer.getAddress() + " // " + cCustomer.getPostalCode() + " // " + cCustomer.getCity() + " // " + cCustomer.getMobilePhone() + " // " + cCustomer.getPhone() + " // " + cCustomer.getEmail() + " // " + cCustomer.getCompanyName() + " // " + cCustomer.getCompanyAddress() + " // " + cCustomer.getCompanyPhone() + " // " + cCustomer.getCompanyRegistrationNumber() + " // ID:" + cCustomer.getID());
                        }else if(customers.get(i).getCustomerType().equals("PRIVATE")){
                            //Private pCustomer = (Private) customer; //Casting in order to get extra parameters, woohoo
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String strDate = dateFormat.format(pCustomer.getDriverSinceDate());
                            out.write("\n" + pCustomer.getCustomerType() + " // " + pCustomer.getDriverName() + " // " + pCustomer.getAddress() + " // " + pCustomer.getPostalCode() + " // " + pCustomer.getCity() + " // " + pCustomer.getMobilePhone() + " // " + pCustomer.getPhone() + " // " + pCustomer.getEmail() + " // " + pCustomer.getLicenseNumber() + " // " + strDate + " // ID:" + pCustomer.getID());
                        }
                    }
                }
                out.close();

            }catch(Exception er){
                System.err.println("Error while printing"+ er.getMessage());
            }
            getCustomerList();
        }
    }*/

    public void populateCustomerList() throws ParseException, FileNotFoundException {
        File myObj = new File("files/customers"); //Gets customer file
        Scanner myReader = new Scanner(myObj);
        listToString = "";
        customers.clear(); //gets rid of old objects as to not have double entries
        while (myReader.hasNextLine()) {
            String nextLine = myReader.nextLine();
            listToString += nextLine + "\n";
            String[] parts = nextLine.split(" // "); //Splits
            if(parts[0].equals("COMPANY")){
                Company output = new Company(parts[1], parts[2],Integer.parseInt(parts[3]),parts[4],Integer.parseInt(parts[5]),Integer.parseInt(parts[6]),parts[7],parts[8],parts[9],Integer.parseInt(parts[10]),Integer.parseInt(parts[11]));
                output.setID(Integer.parseInt(parts[12].substring(3, 6)));
                customers.add(output);
            }else if(parts[0].equals("PRIVATE")){
                Private output = new Private(parts[1], parts[2],Integer.parseInt(parts[3]),parts[4],Integer.parseInt(parts[5]),Integer.parseInt(parts[6]),parts[7],parts[8],stringToDate(parts[9]));
                output.setID(Integer.parseInt(parts[10].substring(3,6)));
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
