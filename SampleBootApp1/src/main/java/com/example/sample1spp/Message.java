package com.example.sample1app;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "msgdata")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@NotNull
	private long id;
	
	@Column(nullable = false)
	@NotBlank
	private String content;
	
	@Column
	private Date datetime;
	
	@ManyToOne
	private Person Person;
	
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Date getDatetime() {
		return this.datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	public Person getPerson() {
		return this.Person;
	}
	public void setPerson(Person Person) {
		this.Person = Person;
	}

}
