import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Customer {

    private static CustomerList myCustomerList = new CustomerList();

    public void setDriverName(String driverName) {this.driverName = driverName;}

    public void setAddress(String address) {this.address = address;}

    public void setPostalCode(int postalCode) {this.postalCode = postalCode;}

    public void setCity(String city) {this.city = city;}

    public void setMobilePhone(int mobilePhone) {this.mobilePhone = mobilePhone;}

    public void setPhone(int phone) {this.phone = phone;}

    public void setEmail(String email) {this.email = email;}

    public void setCustomerType(String customerType) {this.customerType = customerType;}

    private String driverName;
    private String address;
    private int postalCode;
    private String city;
    private int mobilePhone;
    private int phone;
    private String email;
    private String customerType;

    public void setID(int ID) {
        this.ID = ID;
    }

    private int ID;
    public Customer(){

    }

    public Customer(String customerType, String driverName,String address,int postalCode,String city,int mobilePhone,int phone,String email){
        this.driverName = driverName;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.mobilePhone = mobilePhone;
        this.phone = phone;
        this.email = email;
        this.customerType = customerType;
        this.ID = generateID();
    }

    public String getDriverName(){return driverName;}
    public String getAddress(){return address;}
    public int getPostalCode(){return postalCode;}
    public String getCity(){return city;}
    public int getMobilePhone(){return mobilePhone;}
    public int getPhone(){return phone;}
    public String getEmail(){return email;}
    public String getCustomerType() {return customerType;}
    public int getID() {return ID;}
    public String toString(){
        return ("Driver: " + driverName + "\nAddress: " + address + "\nPostalCode: " + postalCode + "\nCity: " + city + "\nMobilePhone: " + mobilePhone + "\nPhone: " + phone + "\nEmail: " + email);
    }

    public static int generateID(){
        int randomID = (ThreadLocalRandom.current().nextInt(100, 999 + 1)); // Generate random number between 100-999));

        try{
            while(myCustomerList.getListToString().contains(" // ID:" + String.valueOf(randomID))) {
                randomID = (ThreadLocalRandom.current().nextInt(100, 999 + 1)); // Generate random number between 100-999));
            }
        }catch (Exception e){

        }
        return(randomID);
    }

}
