package com.CrimeReport.services;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

public class LocationService {
    private GeoApiContext context;

    public LocationService(String apiKey) {
        this.context = new GeoApiContext.Builder().apiKey(apiKey).build();
    }

    public String getLocation(String address) throws Exception {
        GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
        return results[0].formattedAddress;
    }
}

