import java.util.Date;

public class Family extends Car{
    //fields with default values if new car doesnt have special specs
    private String gear = "Manual gear";
    private String airCondition = "Air condition";
    private String cruiseControl = "Yes";
    private int seatAmount = 7;

    public String getGear(){return gear;}
    public String getAirCondition(){return airCondition;}

    private String specs = "Manual gear, air condition, some with cruise control, 7 seats or more";
    public Family(String brandModel, String fuelType, String plate, Date fRegDate, int odometerVal){
        super("FAMILY", brandModel, fuelType, plate, fRegDate, odometerVal);
    }
}
