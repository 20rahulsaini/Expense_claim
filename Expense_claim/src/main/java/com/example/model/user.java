package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.domain.EntityScan;




@Entity
public class user {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    private String expenseArea;
    private Long claimAmount;
    
    
    
    public user(Long id, String name, int age, String expenseArea, Long claimAmount) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.expenseArea = expenseArea;
		this.claimAmount = claimAmount;
	}
    
    
 
	public user() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getExpenseArea() {
		return expenseArea;
	}
	public void setExpenseArea(String expenseArea) {
		this.expenseArea = expenseArea;
	}

	
	public Long getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(Long claimAmount) {
		this.claimAmount = claimAmount;
	}
    
    
}
