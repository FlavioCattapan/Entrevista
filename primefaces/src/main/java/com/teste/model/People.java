package com.teste.model;



import java.io.Serializable;
import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Oleur on 21/12/2014.
 * People model represents an individual person or character within the Star Wars universe.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class People implements Serializable, BaseEntity {
    public String name;

    @JsonProperty("birth_year")
    public String birthYear;

    @JsonProperty("films")
    public ArrayList<String> filmsUrls;

    public String gender;

    @JsonProperty("hair_color")
    public String hairColor;

    public String height;

    @JsonProperty("homeworld")
    public String homeWorldUrl;

    public String mass;

    @JsonProperty("skin_color")
    public String skinColor;

    public String created;
    public String edited;
    public String url;
    @JsonProperty("species")
    public ArrayList<String> speciesUrls;

    @JsonProperty("starships")
    public ArrayList<String> starshipsUrls;

    @JsonProperty("vehicles")
    public ArrayList<String> vehiclesUrls;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public ArrayList<String> getFilmsUrls() {
		return filmsUrls;
	}

	public void setFilmsUrls(ArrayList<String> filmsUrls) {
		this.filmsUrls = filmsUrls;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getHomeWorldUrl() {
		return homeWorldUrl;
	}

	public void setHomeWorldUrl(String homeWorldUrl) {
		this.homeWorldUrl = homeWorldUrl;
	}

	public String getMass() {
		return mass;
	}

	public void setMass(String mass) {
		this.mass = mass;
	}

	public String getSkinColor() {
		return skinColor;
	}

	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ArrayList<String> getSpeciesUrls() {
		return speciesUrls;
	}

	public void setSpeciesUrls(ArrayList<String> speciesUrls) {
		this.speciesUrls = speciesUrls;
	}

	public ArrayList<String> getStarshipsUrls() {
		return starshipsUrls;
	}

	public void setStarshipsUrls(ArrayList<String> starshipsUrls) {
		this.starshipsUrls = starshipsUrls;
	}

	public ArrayList<String> getVehiclesUrls() {
		return vehiclesUrls;
	}

	public void setVehiclesUrls(ArrayList<String> vehiclesUrls) {
		this.vehiclesUrls = vehiclesUrls;
	}

	@Override
	public String toString() {
		return name;
	}
    
    
    
    
    
    
}
