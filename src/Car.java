import java.util.Date;

public class Car {
    private String brandModel;
    private String fuelType;
    private String plate;
    private Date fRegDate;
    private int odometerVal;

    public Car(String brandModel, String fuelType, String plate, Date fRegDate, int odometerVal){
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
