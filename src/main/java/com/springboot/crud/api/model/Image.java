package com.springboot.crud.api.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String type;
	
	@Column(length = 50000000)
	private byte[] picBytes;
	
	public Image() {
		
	}

	public Image(Long id, String name, String type, byte[] picBytes) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.picBytes = picBytes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicBytes() {
		return picBytes;
	}

	public void setPicBytes(byte[] picBytes) {
		this.picBytes = picBytes;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", type=" + type + ", picBytes=" + Arrays.toString(picBytes)
				+ "]";
	}
	
}
