import java.util.Date;

public class RentalContract {
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(Date fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public int getMaxKilometer() {
        return maxKilometer;
    }

    public void setMaxKilometer(int maxKilometer) {
        this.maxKilometer = maxKilometer;
    }

    public int getStartKilometer() {
        return startKilometer;
    }

    public void setStartKilometer(int startKilometer) {
        this.startKilometer = startKilometer;
    }

    private Car car;
    private Customer customer;
    private Date fromDateTime;
    private Date toDate;
    private int maxKilometer;
    private int startKilometer;

    public RentalContract(Customer customer, Car car, Date fromDateTime, Date toDate, int maxKilometer, int startKilometer){
        this.car = car;
        this.customer = customer;
        this.fromDateTime = fromDateTime;
        this.toDate = toDate;
        this.maxKilometer = maxKilometer;
        this.startKilometer = startKilometer;
    }
    public RentalContract(){

    }
    public String toString(){
        return ("**************\nCUSTOMER FILE:\n"+customer.toString() + "\n\nCAR RENTED: \n" + car.toString() + "\n\nRENT FROM/TO DATE: " + fromDateTime.toString() + " - " + toDate.toString() + "\n\nMAX KM: " + maxKilometer + "\n\nODOMETER VALUE AT RENT: " + startKilometer);
    }
}
