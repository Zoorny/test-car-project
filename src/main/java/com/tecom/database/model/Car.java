package com.tecom.database.model;

import com.tecom.database.model.enumerations.Body;
import com.tecom.database.model.enumerations.DriveUnit;
import com.tecom.database.model.enumerations.Transmission;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long carId;
    private String brand;
    private String model;
    private int releaseYear;
    private int releaseMonth;
    private int engineVolume;
    private boolean turbocharger;
    private int enginePower;
    private Enum<Transmission> transmission;
    private Enum<DriveUnit> driveUnit;
    private Enum<Body> body;
    private String color;

    public Car() {

    }

    public Car(String brand, String model, int releaseYear, int releaseMonth, int engineVolume, boolean turbocharger, int enginePower, Enum<Transmission> transmission, Enum<DriveUnit> driveUnit, Enum<Body> body, String color) {
        this.brand = brand;
        this.model = model;
        this.releaseYear = releaseYear;
        this.releaseMonth = releaseMonth;
        this.engineVolume = engineVolume;
        this.turbocharger = turbocharger;
        this.enginePower = enginePower;
        this.transmission = transmission;
        this.driveUnit = driveUnit;
        this.body = body;
        this.color = color;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getReleaseMonth() {
        return releaseMonth;
    }

    public void setReleaseMonth(int releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }

    public boolean isTurbocharger() {
        return turbocharger;
    }

    public void setTurbocharger(boolean turbocharger) {
        this.turbocharger = turbocharger;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public Enum<Transmission> getTransmission() {
        return transmission;
    }

    public void setTransmission(Enum<Transmission> transmission) {
        this.transmission = transmission;
    }

    public Enum<Body> getBody() {
        return body;
    }

    public void setBody(Enum<Body> body) {
        this.body = body;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Enum<DriveUnit> getDriveUnit() {
        return driveUnit;
    }

    public void setDriveUnit(Enum<DriveUnit> driveUnit) {
        this.driveUnit = driveUnit;
    }
}
