package com.example.sample1app;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="people")
@NamedQueries ( {
		@NamedQuery(
				name="findWithName",
				query="from Person where name like :fname"
		),
		@NamedQuery(
				name="findByAge",
				query="from Person where age >= :min and age < :max"
		)
})
public class Person {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column
//	@NotNull
//	private long id;
//	
//	@Column(length = 50, nullable = false)
//	@NotBlank(message="名前は書かないとダメ！")
//	private String name;
//	
//	@Column(length = 200, nullable = true)
//	@Email(message="メールアドレスを教えて♡")
//	private String mail;
//	
//	@Column(nullable = true)
//	@Min(value=0, message="いやいや、マイナスの歳ってないでしょ？")
//	@Max(value=200, message="200歳以上って、魔女ですか？")
//	private Integer age;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@NotNull
	private long id;
	
	@Column(length = 50, nullable = false)
	@NotBlank
	private String name;
	
	@Column(length = 200, nullable = true)
	@Email
	private String mail;
	
	@Column(nullable = true)
	@Min(0)
	@Max(200)
	private Integer age;
	
	@Column(nullable = true)
//	@Phone(onlyNumber=true)
	private String memo;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@OneToMany(mappedBy="Person")
	@Column(nullable = true)
	private List<Message> messages;
	
	public List<Message> getMessages() {
		return this.messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
}
