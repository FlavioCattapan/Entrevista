package com.teste.model;

import java.util.Set;

public class DataBase {

    private Set<People> listaPessoas;

    private Planet planet;

    private Vehicle vehicle;

    public Set<People> getListaPessoas() {
        return listaPessoas;
    }

    public void setListaPessoas(Set<People> listaPessoas) {
        this.listaPessoas = listaPessoas;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
