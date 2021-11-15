import java.util.Date;

public class Sport extends Car{
    //default fields
    private String gear = "Manual gear";
    private String horsePower = ">200 hp";
    private String specs = "manual  gear, > 200 hp";

    public String getGear(){return gear;}
    public String getHorsePower(){return horsePower;}
    public Sport(String brandModel, String fuelType, String plate, Date fRegDate, int odometerVal){
        super("SPORT", brandModel, fuelType, plate, fRegDate, odometerVal);
    }
}
