import java.util.Date;

public class Sport extends Car{
    private String specs = "manual  gear, > 200 hp";
    public Sport(String brandModel, String fuelType, String plate, Date fRegDate, int odometerVal){
        super("SPORT", brandModel, fuelType, plate, fRegDate, odometerVal);
    }
}
