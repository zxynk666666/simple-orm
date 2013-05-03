package com.house.service;

import com.house.model.House;

public interface HouseService {
    public House create (House pet);

    House get(String id);
}
