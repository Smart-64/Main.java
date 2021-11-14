package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        outputFlights(new ArrayList<>(FlightBuilder.createFlights()));
        FilterFlights filterFlights = new FilterFlights(FlightBuilder.createFlights());

        System.out.println("-----------------------------------");
        outputFlights(filterFlights.requieredFilterOrder1());
        System.out.println("-----------------------------------");
        outputFlights(filterFlights.requieredFilterOrder2());
        System.out.println("-----------------------------------");
        outputFlights(filterFlights.requieredFilterOrder3());
    }

    public static void outputFlights(List<Flight> flight) {
        for (Flight flights : flight) {
            System.out.println(flights);
            System.out.println();
        }
    }
}
