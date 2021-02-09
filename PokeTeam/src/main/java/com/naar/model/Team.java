package com.naar.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
	
	private int id;
	private int userid;
	private List<Integer> pokeId = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public List<Integer> getPokeId() {
		return pokeId;
	}
	public void setPokeId(List<Integer> pokeId) {
		this.pokeId = pokeId;
	}
	
	
}
