import java.util.Date;

public class Car {
    public String getBrandModel() {
        return brandModel;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getPlate() {
        return plate;
    }

    public Date getfRegDate() {
        return fRegDate;
    }

    public int getOdometerVal() {
        return odometerVal;
    }

    public String getRentalType() {
        return rentalType;
    }

    private String brandModel;
    private String fuelType;
    private String plate;
    private Date fRegDate;
    private int odometerVal;



    private String rentalType;

    public Car(String rentalType, String brandModel, String fuelType, String plate, Date fRegDate, int odometerVal){
        this.brandModel = brandModel;
        this.fuelType = fuelType;
        this.plate = plate;
        this.fRegDate = fRegDate;
        this.odometerVal = odometerVal;
    }
    public Car(){

    }

    public String toString(){
        return ("Brand: " + brandModel + "\nFuel Type: " + fuelType + "\nLicense Plate: " + plate + "\nFirst Registration Date: " + fRegDate + "");
    }
}
