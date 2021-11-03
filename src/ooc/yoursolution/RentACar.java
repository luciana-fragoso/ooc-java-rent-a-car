package ooc.yoursolution;

import ooc.enums.Make;
import ooc.enums.Month;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RentACar implements RentACarInterface {

    private List<CarInterface> cars;
    private String name;

    public RentACar(){
        cars = new ArrayList<CarInterface>();
    }

    public RentACar(List<CarInterface> cars) {
        this.cars = cars;
    }
    public RentACar(String name) {
        this.name = name;
    }

    public RentACar(List<CarInterface> cars, String name) {
        this.cars = cars;
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
        boolean isAvailable;
        for (CarInterface c : cars) {
            if (c.getMake() == make) {
                isAvailable = true;
                for (int i=day;i<=(day+lengthOfRent); i++) {
                    if (!c.isAvailable(month,day)) {
                        isAvailable = false;
                    }
                }
                if (isAvailable) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
        boolean isCarAvailable;
        for (CarInterface c : cars) {
            if (c.getMake() == make) {
                isCarAvailable = true;
                for (int i=day;i<(day+lengthOfRent); i++) {
                    if (!c.isAvailable(month,i)) {
                       isCarAvailable = false;
                       break;
                    }
                }

                if (isCarAvailable) {
                    return c.getId();
                }
            }
        }

        return -1;
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {

        int carId = getCarAvailable(month,day,make,lengthOfRent);
        if (carId != -1){
            for (CarInterface c : cars) {
                if (c.getId() == carId) {

                    for (int i=day;i<(day+lengthOfRent);i++){
                      c.book(month,i);
                    }

                  return true;


                }
            }
        }

        return false;
    }

    @Override
    public int getNumberOfCars() {
        return cars.size();
    }
}
