package ooc.yoursolution;

import java.io.BufferedReader;
import java.io.IOException;

public class BookingSystem implements BookingSystemInterface {

    private RentACarInterface rentACar;

    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
        rentACar = new RentACar();
        return rentACar;
    }
}
