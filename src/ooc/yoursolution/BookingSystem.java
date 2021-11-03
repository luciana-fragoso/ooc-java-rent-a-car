package ooc.yoursolution;

import ooc.enums.Make;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookingSystem implements BookingSystemInterface {

    private RentACarInterface rentACar;

    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {

            int aux = 0;
            rentACar = new RentACar();
            rentACar.setName(in.readLine());

            String line = in.readLine();


            List<CarInterface> cars = new ArrayList<>();
            while (line != null){
               String[] parts = line.split(":");
               int numOfCars = Integer.parseInt(parts[parts.length-1]);
               for (int i=0;i<numOfCars;i++) {
                   float dailyRate = Float.parseFloat(parts[1]);
                   String makeString = parts[0];
                   Car c = new Car(aux,Make.valueOf(makeString),dailyRate);
                   c.createAvailability();
                   cars.add(c);
                   aux++;
               }
                line = in.readLine();
            }
            rentACar.setCars(cars);
            return rentACar;
    }

}
