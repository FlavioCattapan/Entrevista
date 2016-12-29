package com.teste.controler;

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

@ManagedBean
@ViewScoped
public class PlanoVooMB implements Serializable{

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
	
	private DataBase dataBase; 
	
	@PostConstruct
	private void initialize(){
		this.listaPlanet = planetSingleton.getPlanetJsonWrapper().getResults();
		this.listaVehicle = vehicleSingleton.getVehicleJsonWrapper().getResults();
		this.listaPeople = peopleSingleton.getPeopleJsonWrapper().getResults();
		this.dataBase = new DataBase(); 
		
	}
	
	
	public void schedule(){
		
		System.out.println(planet);
		
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
	
	
	
	
	
	

	
}