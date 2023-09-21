package com.be.model.dto;

import com.be.model.House;
import com.be.model.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDTO {
    private House house;
    private List<Image> images;
}
