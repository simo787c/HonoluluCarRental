public class Customer {

    private String driverName;
    private String address;
    private int postalCode;
    private String city;
    private int mobilePhone;
    private int phone;
    private String email;

    public Customer(){

    }

    public Customer(String driverName,String address,int postalCode,String city,int mobilePhone,int phone,String email){
        this.driverName = driverName;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.mobilePhone = mobilePhone;
        this.phone = phone;
        this.email = email;
    }

    public String getDriverName(){return driverName;}
    public String getAddress(){return address;}
    public int getPostalCode(){return postalCode;}
    public String getCity(){return city;}
    public int getMobilePhone(){return mobilePhone;}
    public int getPhone(){return phone;}
    public String getEmail(){return email;}
}
