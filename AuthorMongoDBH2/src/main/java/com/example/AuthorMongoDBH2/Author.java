package com.example.AuthorMongoDBH2;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("author")
public class Author {
    @Id
	private String id;
	public String name;
	public String country;
	public int dob;
	public int qtyAuthor;
	public Boolean alive;



	public Author() {
		super();
	}

	public Author(String name, String country, int dob, int qtyAuthor, Boolean alive) {
		super();

		this.name = name;
		this.country = country;
		this.dob = dob;
		this.qtyAuthor = qtyAuthor; //??
		this.alive = alive;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
	public int getQtyAuthor() {
		return qtyAuthor;
	}
	public void setQtyAuthor(int qtyAuthor) {
		this.qtyAuthor = qtyAuthor;
	}
	public Boolean getAlive() {
		return alive;
	}
	public void setAlive(Boolean alive) {
		this.alive = alive;
	}

	@Override
	public String toString() {
		return "Author [id=" + 1 + ", name=" + name + ", country=" + country + ", dob=" + dob + ", qtyBooks=" + qtyAuthor
				+ ", Boolean=" + alive + "]";
	}

}

