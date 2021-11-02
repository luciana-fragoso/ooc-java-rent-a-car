package ooc.yoursolution;

import ooc.enums.Make;
import ooc.enums.Month;
import ooc.yoursolution.CarInterface;

import java.util.Map;

public class Car implements CarInterface {

    private int id;
    private Make make;
    private Month month;
    private double dailyRate;


    @Override
    public Map<Month, boolean[]> createAvailability() {
        return null;
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
        return null;
    }

    @Override
    public void setAvailability(Map<Month, boolean[]> availability) {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isAvailable(Month month, int day) {
        return false;
    }

    @Override
    public boolean book(Month month, int day) {
        return false;
    }
}