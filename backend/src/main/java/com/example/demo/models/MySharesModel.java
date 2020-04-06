package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "my_shares")
public class MySharesModel {

	@Id
	@Column(name="sno")
	private int sno;

	@Column(name="company_id")
	private int company_id;
	
	@Column(name="name")
	private String name;	

	@Column(name="user_id")
	private String user_id;	
	
	@Column(name="open_rate")
	private int open_rate;
	
	@Column(name="close_rate")
	private int close_rate;
	
	@Column(name="peak_rate")
	private int peak_rate;
	
	@Column(name="least_rate")
	private int least_rate;
	
	@Column(name="current_rate")
	private int current_rate;	

	@Column(name="quantity")
	private int quantity;

	@Column(name="bought_rate")
	private int bought_rate;
	
	@Column(name="year_low")
	private int year_low;
	
	@Column(name="year_high")
	private int year_high;
	
	@Column(name="market_cap")
	private float market_cap;
	
	@Column(name="p_e_ratio")
	private float p_e_ratio;
	
	@Column(name="volume")
	private int volume;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getOpen_rate() {
		return open_rate;
	}

	public void setOpen_rate(int open_rate) {
		this.open_rate = open_rate;
	}

	public int getClose_rate() {
		return close_rate;
	}

	public void setClose_rate(int close_rate) {
		this.close_rate = close_rate;
	}

	public int getPeak_rate() {
		return peak_rate;
	}

	public void setPeak_rate(int peak_rate) {
		this.peak_rate = peak_rate;
	}

	public int getLeast_rate() {
		return least_rate;
	}

	public void setLeast_rate(int least_rate) {
		this.least_rate = least_rate;
	}

	public int getCurrent_rate() {
		return current_rate;
	}

	public void setCurrent_rate(int current_rate) {
		this.current_rate = current_rate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getBought_rate() {
		return bought_rate;
	}

	public void setBought_rate(int bought_rate) {
		this.bought_rate = bought_rate;
	}

	public int getYear_low() {
		return year_low;
	}

	public void setYear_low(int year_low) {
		this.year_low = year_low;
	}

	public int getYear_high() {
		return year_high;
	}

	public void setYear_high(int year_high) {
		this.year_high = year_high;
	}

	public float getMarket_cap() {
		return market_cap;
	}

	public void setMarket_cap(float market_cap) {
		this.market_cap = market_cap;
	}

	public float getP_e_ratio() {
		return p_e_ratio;
	}

	public void setP_e_ratio(float p_e_ratio) {
		this.p_e_ratio = p_e_ratio;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public MySharesModel(int company_id, String name, String user_id, int open_rate, int close_rate,
			int peak_rate, int least_rate, int current_rate, int quantity, int bought_rate, int year_low, int year_high,
			float market_cap, float p_e_ratio, int volume) {
		super();
		this.company_id = company_id;
		this.name = name;
		this.user_id = user_id;
		this.open_rate = open_rate;
		this.close_rate = close_rate;
		this.peak_rate = peak_rate;
		this.least_rate = least_rate;
		this.current_rate = current_rate;
		this.quantity = quantity;
		this.bought_rate = bought_rate;
		this.year_low = year_low;
		this.year_high = year_high;
		this.market_cap = market_cap;
		this.p_e_ratio = p_e_ratio;
		this.volume = volume;
	}
	
	public MySharesModel()
	{
		
	}

}
