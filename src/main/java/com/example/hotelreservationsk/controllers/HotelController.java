package com.example.hotelreservationsk.controllers;

import com.example.hotelreservationsk.controllers.entities.Hotel;
import com.example.hotelreservationsk.controllers.entities.Hotelslist;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    public static List<Hotel> CSVReader() {
        List<Hotel> hotelList = new ArrayList<>();
        String path = "C:/Users/sivak/IdeaProjects/Hotel Reservation SK/src/main/resources/static/Hotel.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            boolean header = true;
            while ((line = br.readLine()) != null) {
                if (header) {
                    header = false;
                    continue;
                }
                String[] values = line.split(",");
                if (values[0].contains("\"")) {
                    values[0] = values[0].replace("\"", "");
                }
                Hotel tempHotel = new Hotel();
                tempHotel.setHotel_name(values[0]);
                tempHotel.setAvailability(Boolean.parseBoolean(values[2]));
                tempHotel.setPrice(Integer.parseInt(values[1]));
                hotelList.add(tempHotel);
                tempHotel = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hotelList;
    }

    @RequestMapping("/siva")
    public Hotelslist nammaFunction() {
        Hotelslist hotelList = new Hotelslist();
        hotelList.setHotels_list(CSVReader());
        return hotelList;
    }
}

