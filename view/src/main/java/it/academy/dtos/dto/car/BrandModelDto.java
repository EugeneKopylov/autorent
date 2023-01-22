package it.academy.dtos.dto.car;

import java.util.List;

public class BrandModelDto {

    private String brand;
    private List<String> model;

    public BrandModelDto(String brand, List<String> model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public List<String> getModel() {
        return model;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(List<String> model) {
        this.model = model;
    }
}
