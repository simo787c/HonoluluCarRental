import java.util.Date;

public class Family extends Car{
    private String specs = "Manual gear, air condition, some with cruise control, 7 seats or more";
    public Family(String brandModel, String fuelType, String plate, Date fRegDate, int odometerVal){
        super(brandModel, fuelType, plate, fRegDate, odometerVal);
    }
}
