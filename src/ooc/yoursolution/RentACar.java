package ooc.yoursolution;

import ooc.enums.Make;
import ooc.enums.Month;

import java.util.ArrayList;
import java.util.List;

public class RentACar implements RentACarInterface {

    private List<CarInterface> cars;
    private String name;

    public RentACar(){
        cars = new ArrayList<CarInterface>();
    }

    public RentACar(String name) {
        this.name = name;
    }

    @Override
    public List<CarInterface> getCars() {
        return cars;
    }

    @Override
    public void setCars(List<CarInterface> cars) {
        this.cars = cars;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
        return false;
    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
        return 0;
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        return false;
    }

    @Override
    public int getNumberOfCars() {
        return cars.size();
    }
}
