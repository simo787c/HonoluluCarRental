import java.util.Date;
public class Luxury extends Car{
    private String specs = ">3000 ccm, automatic gear, air condition, cruise control, leather seats";
    public Luxury(String brandModel, String fuelType, String plate, Date fRegDate, int odometerVal){
        super(brandModel, fuelType, plate, fRegDate, odometerVal);
    }
}
