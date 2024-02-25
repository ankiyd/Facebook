package com.facebook.media.entity;

import com.facebook.media.dto.PlaceDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Place {
    private String placeName;

    public static Place convertPlaceDtoToPlace(PlaceDto placeDto){
        Place place = new Place();
        place.setPlaceName(placeDto.getPlaceName());
        return place;
    }

    public static List<Place> convertPlaceDtosToPlaces(List<PlaceDto> placeDtos){
        List<Place> ListOfPlaces = new ArrayList<>();
        for (PlaceDto place : placeDtos) {
            ListOfPlaces.add(convertPlaceDtoToPlace(place));
        }
        return ListOfPlaces;
    }
}
