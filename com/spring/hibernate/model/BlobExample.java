package com.spring.hibernate.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="BlobExample")
public class BlobExample {

	@Id
	@GeneratedValue
	private int id;	
	@Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "BlobExample [id=" + id + ", photo=" + Arrays.toString(photo) + "]";
	}

	
	
}
