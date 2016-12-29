package com.teste.controler;

import com.teste.constants.utils.Utils;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.teste.model.DataBase;
import com.teste.model.People;
import com.teste.model.Planet;
import com.teste.model.Vehicle;
import com.teste.services.PeopleSingleton;
import com.teste.services.PlanetSingleton;
import com.teste.services.VehicleSingleton;
import java.util.ArrayList;
import java.util.HashSet;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class PlanoVooMB implements Serializable {

    private List<Planet> listaPlanet;

    private List<Vehicle> listaVehicle;

    private List<People> listaPeople;

    @EJB
    private PlanetSingleton planetSingleton;

    @EJB
    private VehicleSingleton vehicleSingleton;

    @EJB
    private PeopleSingleton peopleSingleton;

    private Vehicle vehicle;

    private Planet planet;

    private People people;

    private List<DataBase> listaDataBase;

    private DataBase dataBase;

    private DataBase dataBaseView;

    private Planet lastPlanet;

    @PostConstruct
    private void initialize() {
//		this.listaPlanet = planetSingleton.getPlanetJsonWrapper().getResults();
//		this.listaVehicle = vehicleSingleton.getVehicleJsonWrapper().getResults();
//		this.listaPeople = peopleSingleton.getPeopleJsonWrapper().getResults();

        FacesContext.getCurrentInstance().getExternalContext().getSession(true);

        listaDataBase = new ArrayList<DataBase>();
        dataBase = new DataBase();
        dataBase.setListaPessoas(new HashSet<People>());
        dataBaseView = new DataBase();
        dataBaseView.setListaPessoas(new HashSet<People>());

        this.listaPlanet = new ArrayList<Planet>();
        Planet planet1 = new Planet();
        planet1.setName("Alderaan");
        planet1.setDiameter("12500");
        planet1.setClimate("temperate");
        planet1.setTerrain("grasslands");
        planet1.setPopulation("2000000000");
        this.listaPlanet.add(planet1);

        Planet planet2 = new Planet();
        planet2.setName("Yavin IV");
        planet2.setDiameter("10200");
        planet2.setClimate("temperate, tropical");
        planet2.setTerrain("jungle, rainforests");
        planet2.setPopulation("1000");
        this.listaPlanet.add(planet2);

        Planet planet3 = new Planet();
        planet3.setName("Hoth");
        planet3.setDiameter("7200");
        planet3.setClimate("frozen");
        planet3.setTerrain("tundra, ice caves, mountain ranges");
        planet3.setPopulation("unknown");
        this.listaPlanet.add(planet3);

        this.listaPeople = new ArrayList<People>();
        People people1 = new People();
        people1.setName("Luke Skywalker");
        people1.setGender("male");
        this.listaPeople.add(people1);

        People people2 = new People();
        people2.setName("C-3PO");
        people2.setGender("n/a");
        this.listaPeople.add(people2);

        People people3 = new People();
        people3.setName("R2-D2");
        people3.setGender("n/a");
        this.listaPeople.add(people3);

        People people4 = new People();
        people4.setName("Darth Vader");
        people4.setGender("male");
        this.listaPeople.add(people4);

        this.listaVehicle = new ArrayList<Vehicle>();
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setName("Sand Crawler");
        vehicle1.setModel("Digger Crawler");
        vehicle1.setPassengers("30");
        this.listaVehicle.add(vehicle1);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setName("T-16 skyhopper");
        vehicle2.setModel("T-16 skyhopper");
        vehicle2.setPassengers("1");
        this.listaVehicle.add(vehicle2);

        Vehicle vehicle3 = new Vehicle();
        vehicle3.setName("X-34 landspeeder");
        vehicle3.setModel("X-34 landspeeder");
        vehicle3.setPassengers("1");
        this.listaVehicle.add(vehicle3);

    }

    public void viewData(DataBase data) {

        dataBaseView = data;

    }

    public void removePeople(People people) {
        dataBase.getListaPessoas().remove(people);
    }

    public void insertPeople() {

        dataBase.getListaPessoas().add(people);

    }

    public void schedule() {

        if (dataBase.getListaPessoas().size() > Integer.valueOf(vehicle.getPassengers())) {
            Utils.addWarnMessage("A quantidade de tripulantes não pode ser maior que a capacidade da Nave.");
            return;
        }

        if (lastPlanet != null) {
            if (lastPlanet.getName().equals(planet.getName())) {
                Utils.addWarnMessage("O Planeta destino não pode ser o mesmo que o voo anterior.");
                return;
            }

        }

        dataBase.setPlanet(planet);
        dataBase.setVehicle(vehicle);
        listaDataBase.add(dataBase);

        lastPlanet = new Planet();
        lastPlanet.setName(planet.getName());

        dataBase = new DataBase();
        dataBase.setListaPessoas(new HashSet<People>());

    }

    public List<Planet> getListaPlanet() {
        return listaPlanet;
    }

    public void setListaPlanet(List<Planet> listaPlanet) {
        this.listaPlanet = listaPlanet;
    }

    public List<Vehicle> getListaVehicle() {
        return listaVehicle;
    }

    public void setListaVehicle(List<Vehicle> listaVehicle) {
        this.listaVehicle = listaVehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public List<People> getListaPeople() {
        return listaPeople;
    }

    public void setListaPeople(List<People> listaPeople) {
        this.listaPeople = listaPeople;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public List<People> getListaPeopleCadastro() {
        return new ArrayList<People>(dataBase.getListaPessoas());
    }

    public List<DataBase> getListaDataBase() {
        return listaDataBase;
    }

    public void setListaDataBase(List<DataBase> listaDataBase) {
        this.listaDataBase = listaDataBase;
    }

    public DataBase getDataBaseView() {
        return dataBaseView;
    }

    public void setDataBaseView(DataBase dataBaseView) {
        this.dataBaseView = dataBaseView;
    }

    public List<People> getListaPeopleBaseView() {
        return new ArrayList<People>(dataBaseView.getListaPessoas());
    }

}
