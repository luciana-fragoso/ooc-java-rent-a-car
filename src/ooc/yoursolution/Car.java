package ooc.yoursolution;

import ooc.enums.Make;
import ooc.enums.Month;
import ooc.yoursolution.CarInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Car implements CarInterface {

    private int id;
    private Make make;
    private Map<Month, boolean[]> availability;
    private double dailyRate;

    public Car(int id,Make make,double dailyRate) {
        this.id = id;
        this.make = make;
        this.dailyRate = dailyRate;
    }



    @Override
    public Map<Month, boolean[]> createAvailability() {
        availability = new HashMap<>();
        for (Month month : Arrays.asList(Month.values())) {

            boolean[] myAvailability = new boolean[month.getNumberOfDays()];
            // filling the entire array to true, meaning the all the days are available
            Arrays.fill(myAvailability,true);
            availability.put(month,myAvailability);

        }


        return availability;
    }

    @Override
    public Make getMake() {
        return make;
    }

    @Override
    public void setMake(Make make) {
        this.make = make;
    }

    @Override
    public double getRate() {
        return dailyRate;
    }

    @Override
    public void setRate(double rate) {
        this.dailyRate = rate;
    }

    @Override
    public Map<Month, boolean[]> getAvailability() {
        return this.availability;
    }

    @Override
    public void setAvailability(Map<Month, boolean[]> availability) {
        this.availability = availability;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isAvailable(Month month, int day) {
        return availability.get(month)[day-1];
    }

    @Override
    public boolean book(Month month, int day) {

        if (availability.get(month)[day-1]) {
            this.availability.get(month)[day-1] = false;
            return true;
        }


        return  false;
    }
}
