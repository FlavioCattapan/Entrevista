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
		this.listaPlanet = planetSingleton.getPlanetJsonWrapper().getResults();
		this.listaVehicle = vehicleSingleton.getVehicleJsonWrapper().getResults();
		this.listaPeople = peopleSingleton.getPeopleJsonWrapper().getResults();

        FacesContext.getCurrentInstance().getExternalContext().getSession(true);

        listaDataBase = new ArrayList<DataBase>();
        dataBase = new DataBase();
        dataBase.setListaPessoas(new HashSet<People>());
        dataBaseView = new DataBase();
        dataBaseView.setListaPessoas(new HashSet<People>());

      
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
