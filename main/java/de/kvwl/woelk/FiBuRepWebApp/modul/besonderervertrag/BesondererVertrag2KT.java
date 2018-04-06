package de.kvwl.woelk.FiBuRepWebApp.modul.besonderervertrag;

import java.io.Serializable;
import java.sql.SQLException;

import javax.activation.DataSource;
import javax.persistence.*;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import oracle.jdbc.datasource.OracleDataSource;

@Entity
@Table(name = "BESONDERERVERTRAG2KT")
public class BesondererVertrag2KT implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
//	@Column(name = "BESONDERERVERTRAGID")
	private Besonderervertrag bsv;
	
	@Column(name = "EIGENE")
	private double eigene;
	
	@Column(name = "FREMD")
	private double fremd;
	
	@Column(name = "GESAMT")
	private double gesamt;
	
	@Column(name = "VKNR")
	private String vknr;

	public BesondererVertrag2KT(int id, Besonderervertrag bsv, double eigene, double fremd, double gesamt, String vknr) {
		this.id = id;
		this.bsv = bsv;
		this.eigene = eigene;
		this.fremd = fremd;
		this.gesamt = gesamt;
		this.vknr = vknr;
	}
	
	public BesondererVertrag2KT() {
//		this.eigene = 0;
//		this.fremd = 0;
//		this.gesamt = 0;
		this.vknr = "";
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
