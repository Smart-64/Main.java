package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Segment segmentExample = new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(4));
        System.out.println("Реализация класса Segment");
        System.out.println(segmentExample);
        System.out.println(segmentExample.getDepartureDate());
        System.out.println(segmentExample.getArrivalDate());
        System.out.println("---------------------------");

        List<Segment> segmentList = new ArrayList<>();
        segmentList.add(segmentExample);

        System.out.println("Реализация класса Flight");
        Flight flightExample = new Flight(segmentList);
        System.out.println(flightExample.getSegments());
        System.out.println("---------------------------");

        for (Flight flight : FlightBuilder.createFlights()) {
            System.out.println(flight);
            System.out.println();
        }
    }
}
