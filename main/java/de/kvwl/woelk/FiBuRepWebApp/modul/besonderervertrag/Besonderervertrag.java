package de.kvwl.woelk.FiBuRepWebApp.modul.besonderervertrag;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Besonderervertrag implements Serializable{
	
	private int id;
	private String name;
	private String quartal;
	private String kontext;
	private String lG;
	private String lUG;
	private String sachkonto;

	public Besonderervertrag(int id, String name, String quartal, String kontext, String LG, String LUG, String sachkonto) {
		this.id = id;
		this.name = name;
		this.quartal = quartal;
		this.kontext = kontext;
		lG = LG;
		lUG = LUG;
		this.sachkonto = sachkonto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuartal() {
		return quartal;
	}

	public void setQuartal(String quartal) {
		this.quartal = quartal;
	}

	public String getKontext() {
		return kontext;
	}

	public void setKontext(String kontext) {
		this.kontext = kontext;
	}

	public String getlG() {
		return lG;
	}

	public void setlG(String lG) {
		this.lG = lG;
	}

	public String getlUG() {
		return lUG;
	}

	public void setlUG(String lUG) {
		this.lUG = lUG;
	}

	public String getSachkonto() {
		return sachkonto;
	}

	public void setSachkonto(String sachkonto) {
		this.sachkonto = sachkonto;
	}
}
