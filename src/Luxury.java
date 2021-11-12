import java.util.Date;
public class Luxury extends Car{
    public String specs(){
        return(">3000 ccm, automatic gear, air condition, cruise control, leather seats");
    }
    public Luxury(String brandModel, String fuelType, String plate, Date fRegDate, int odometerVal){
        super(brandModel, fuelType, plate, fRegDate, odometerVal);
    }
}
