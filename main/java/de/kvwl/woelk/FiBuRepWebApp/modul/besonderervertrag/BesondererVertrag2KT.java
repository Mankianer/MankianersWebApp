package de.kvwl.woelk.FiBuRepWebApp.modul.besonderervertrag;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BesondererVertrag2KT implements Serializable{
	
	private int id;
	private Besonderervertrag bsv;
	private double eigene;
	private double fremd;
	private double gesamt;
	private String vknr;

	public BesondererVertrag2KT(int id, Besonderervertrag bsv, double eigene, double fremd, double gesamt, String vknr) {
		this.id = id;
		this.bsv = bsv;
		this.eigene = eigene;
		this.fremd = fremd;
		this.gesamt = gesamt;
		this.vknr = vknr;
	}

	public Besonderervertrag getBsv() {
		return bsv;
	}

	public void setBsv(Besonderervertrag bsv) {
		this.bsv = bsv;
	}

	public double getEigene() {
		return eigene;
	}

	public void setEigene(double eigene) {
		this.eigene = eigene;
	}

	public double getFremd() {
		return fremd;
	}

	public void setFremd(double fremd) {
		this.fremd = fremd;
	}

	public double getGesamt() {
		return gesamt;
	}

	public void setGesamt(double gesamt) {
		this.gesamt = gesamt;
	}

	public String getVknr() {
		return vknr;
	}

	public void setVknr(String vknr) {
		this.vknr = vknr;
	}

	public int getId() {
		return id;
	}
}
