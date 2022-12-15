package com.bezkoder.spring.oracle.model;

import javax.persistence.*;

@Entity
@Table(name = "lager")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)


	@Column(name = "ID")
	private Number id;
	
	@Column(name = "ZERBRECHLICH")
	private Number zerbrechlich;

	@Column(name = "GEWICHT")
	private float gewicht;

	@Column(name = "CREATE_TIME")
	private String create_time;
	
	@Column(name = "NAME")
	private String name;

	public Inventory() {

	}

	public Inventory(long id, Number zerbrechlich, float gewicht, String create_time, String name) {
		this.id = id;
		this.zerbrechlich = zerbrechlich;
		this.gewicht = gewicht;
		this.create_time = create_time;
		this.name = name;
	}

	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id;
	}

	public Number getZerbrechlich() {
		return zerbrechlich;
	}

	public void setZerbrechlich(Number zerbrechlich) {
		this.zerbrechlich = zerbrechlich;
	}

	public float getGewicht() {
		return gewicht;
	}

	public void setGewicht(float gewicht) {
		this.gewicht = gewicht;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", zerbrechlich=" + zerbrechlich + ", gewicht=" + gewicht + ", create_time="
				+ create_time + ", name=" + name + "]";
	}

}
