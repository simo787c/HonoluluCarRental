import java.util.Date;

public class Car {

    private String brandModel;
    private String fuelType;
    private String plate;
    private Date fRegDate;
    private int odometerVal;
    private String rentalType;

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

    public void setBrandModel(String brandModel) {
        this.brandModel = brandModel;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setfRegDate(Date fRegDate) {
        this.fRegDate = fRegDate;
    }

    public void setOdometerVal(int odometerVal) {
        this.odometerVal = odometerVal;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public Car(String rentalType, String brandModel, String fuelType, String plate, Date fRegDate, int odometerVal){
        this.brandModel = brandModel;
        this.fuelType = fuelType;
        this.plate = plate;
        this.fRegDate = fRegDate;
        this.odometerVal = odometerVal;
        this.rentalType = rentalType;
    }
    public Car(){

    }

    public String toString(){
        return ("Type: " + rentalType + "\nBrand: " + brandModel + "\nFuel Type: " + fuelType + "\nLicense Plate: " + plate + "\nFirst Registration Date: " + fRegDate + "");
    }
}
