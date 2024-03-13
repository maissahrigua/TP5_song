package com.maissa.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// pour autoincrement
	private int code;
	private String nomsinger;
	private String nomsong;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNomsinger() {
		return nomsinger;
	}

	public void setNomsinger(String nomsinger) {
		this.nomsinger = nomsinger;
	}

	public String getNomsong() {
		return nomsong;
	}

	public void setNomsong(String nomsong) {
		this.nomsong = nomsong;
	}

	@Override
	public String toString() {
		return "Song [code=" + code + ", nomsinger=" + nomsinger + ", nomsong=" + nomsong + "]";
	}
}

