package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterFlights {

    private List<Flight> flightList;

    FilterFlights(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Flight> requieredFilterOrder1() {
        List<Flight> flightList1 = new ArrayList<>();
        for (Flight flight : flightList) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isBefore(LocalDateTime.now())) {
                    flightList1.add(flight);
                }
            }
        }
        return flightList1;
    }

    public List<Flight> requieredFilterOrder2() {
        List<Flight> flightList2 = new ArrayList<>();
        for (Flight flight : flightList) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                    flightList2.add(flight);
                }
            }
        }
        return flightList2;
    }

    public List<Flight> requieredFilterOrder3() {
        List<Flight> flightList3 = new ArrayList<>();
        for (Flight flight : flightList) {
            int hours = 0;
            if (flight.getSegments().size() > 1) {
                for (int i = 1; i < flight.getSegments().size(); i++) {
                    hours = hours + flight.getSegments().get(i).getDepartureDate().getHour()
                            - flight.getSegments().get(i - 1).getArrivalDate().getHour();
                }
                if (hours > 2) {
                    flightList3.add(flight);
                }
            }
        }
        return flightList3;
    }
}
