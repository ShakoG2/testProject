package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "AUTH_USER_GROUP")
@Getter
@Setter
public class AuthGroup {

	@javax.persistence.Id
	@Column(name = "AUTH_USER_GROUP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@Column(name = "USERNAME")
	private String userName;
	@Column(name = "AUTH_GROUP")
	private String authGroup;

}
