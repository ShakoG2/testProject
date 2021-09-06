package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "users")
@SequenceGenerator(name = "usersSeq", sequenceName = "users_id_seq", allocationSize = 1)
public class User {

	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "user_name")
	private String userName;


	public void setId(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "usersSeq")
	@Column(name = "id")
	public Long getId() {
		return id;
	}
}
