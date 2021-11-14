package com.gridnine.testing;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class MainTest {
    LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);

    @Test
    public void requieredFilterOrder1_expectedOneFlight_whenInputTestCreateFlights() {
        FilterFlights filterFlights = new FilterFlights(FlightBuilder.createFlights());
        List<Segment> segmentList = new ArrayList<>();
        segmentList.add(new Segment(threeDaysFromNow.minusDays(6), threeDaysFromNow));
        Flight flight = new Flight(segmentList);

        assertEquals(flight.getSegments().toString(), filterFlights.requieredFilterOrder1().toString());
    }

    @Test
    public void requieredFilterOrder2_expectedOneFlight_whenInputTestCreateFlights() {
        FilterFlights filterFlights = new FilterFlights(FlightBuilder.createFlights());
        List<Segment> segmentList = new ArrayList<>();
        segmentList.add(new Segment(threeDaysFromNow, threeDaysFromNow.minusHours(6)));
        Flight flight = new Flight(segmentList);

        assertEquals(flight.getSegments().toString(), filterFlights.requieredFilterOrder2().toString());
    }

    @Test
    public void requieredFilterOrder3_expectedOneFlight_whenInputTestCreateFlights() {
        FilterFlights filterFlights = new FilterFlights(FlightBuilder.createFlights());
        List<Segment> segmentList = new ArrayList<>();
        segmentList.add(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)));
        segmentList.add(new Segment(threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)));
        Flight flight = new Flight(segmentList);

        assertEquals("[" + flight + "]", filterFlights.requieredFilterOrder3().toString());
    }

}
