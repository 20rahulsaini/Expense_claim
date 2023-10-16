package com.example.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



	

@Entity
public class Company {
	
	
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long fixedAmount;
	
    public Company(Long id, Long fixedAmount,String name) {
		super();
		this.id = id;
		this.fixedAmount = fixedAmount;
		this.name = name;
	}
    
    
    


	public Company() {
		
		
	}



	 public String getName() {
			return name;
	}

    public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFixedAmount() {
		return fixedAmount;
	}
	public void setFixedAmount(Long fixedAmount) {
		this.fixedAmount = fixedAmount;
	}
	
	
	
	
    
   

	

}
