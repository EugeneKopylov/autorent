package it.academy.api.dto.car;

public class CarCreationDto {

    private String brand;
    private String carModel;
    private String bodyType;
    private String gearbox;
    private Integer yearOfProd;
    private String fuelType;
    private String engineCapacity;
    private Integer cost;
    private String carDescription;
    private byte[] carPicture;

    public CarCreationDto() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public Integer getYearOfProd() {
        return yearOfProd;
    }

    public void setYearOfProd(Integer yearOfProd) {
        this.yearOfProd = yearOfProd;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    public byte[] getCarPicture() {
        return carPicture;
    }

    public void setCarPicture(byte[] carPicture) {
        this.carPicture = carPicture;
    }
}
