package it.academy.api.dto.car;

public class CarDto {

    private String brand;
    private String carModel;
    private String bodyType;
    private String gearbox;
    private Integer yearOfProd;
    private String fuelType;
    private String engineCapacity;
    private Integer cost;
    private String carDescription;
    private int carIdPicture;

    public CarDto(String brand, String carModel, String bodyType, String gearbox,
                  Integer yearOfProd, String fuelType, String engineCapacity,
                  Integer cost, String carDescription, int carIdPicture) {
        this.brand = brand;
        this.carModel = carModel;
        this.bodyType = bodyType;
        this.gearbox = gearbox;
        this.yearOfProd = yearOfProd;
        this.fuelType = fuelType;
        this.engineCapacity = engineCapacity;
        this.cost = cost;
        this.carDescription = carDescription;
        this.carIdPicture = carIdPicture;
    }

    public String getBrand() {
        return brand;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getGearbox() {
        return gearbox;
    }

    public Integer getYearOfProd() {
        return yearOfProd;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public Integer getCost() {
        return cost;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public int getCarIdPicture() {
        return carIdPicture;
    }
}
