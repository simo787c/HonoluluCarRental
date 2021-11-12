import java.util.ArrayList;
public class CarList {

    private ArrayList<Car> cars = new ArrayList<>();

    public ArrayList<Car> getCars(){
        return cars;
    }
    public void addCar(Car car){
        cars.add(car);
    }

}
