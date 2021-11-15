import java.util.Date;
public class Luxury extends Car{
    //default fields
    private String ccm = ">3000 ccm";
    private String gear = "Automatic gear";
    private String airCondition = "Air condition";
    private String cruiseControl = "Yes";
    private String seatType = "Leather seats";
    public String specs(){
        return(">3000 ccm, automatic gear, air condition, cruise control, leather seats");
    }

    public String getCcm() {return ccm;}
    public String getGear() {return gear;}
    public String getAirCondition() {return airCondition;}
    public String getCruiseControl() {return cruiseControl;}
    public String getSeatType() {return seatType;}

    public Luxury(String brandModel, String fuelType, String plate, Date fRegDate, int odometerVal){
        super("LUXURY", brandModel, fuelType, plate, fRegDate, odometerVal);
    }
}
