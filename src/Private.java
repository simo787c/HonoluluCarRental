import java.util.Date;
public class Private extends Customer {
    private String licenseNumber;
    private Date driverSinceDate;

    public Private(){}

    public Private(String dN, String a, int pC, String c, int mP, int p, String e, String lN, Date dSD){
        super(dN,a,pC,c,mP,p,e);
        this.licenseNumber = lN;
        this.driverSinceDate = dSD;
    }

    public String getLicenseNumber() {return licenseNumber;}
    public Date getDriverSinceDate() {return driverSinceDate;}

    @Override
    public String toString(){
        return (super.toString() + "\nLicenseNumber: " + licenseNumber + "\nDriver Since: " + driverSinceDate);
    }
}
