package com.example.controller;



import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.number.money.MonetaryAmountFormatter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.model.user;
import com.example.repo.UserRepo;
import com.example.repo.CompanyRepo;
import com.example.model.Company;


@RestController
public class controller {
	

	
	@Autowired
	 private UserRepo userRepo;
	
	@Autowired
	 private CompanyRepo companyRepo;
	
	
	
	
	
	//user controllers
	 
	@PostMapping("/user")
	public user newUser(@RequestBody user newUser) {
		return userRepo.save(newUser);
	}
	
	@GetMapping("/alluser")
	public List<user> alluser() {
		return userRepo.findAll();
	}
	
	@GetMapping("/user/{id}")
	public user getuser(@PathVariable Long id) {
		return userRepo.findById(id).orElse(null);
		
	}
	
	 @PutMapping("/user/{id}")
		user updateUser (@RequestBody user newUser,@PathVariable Long id) {
			return userRepo.findById(id)
					.map(user->{
				user.setName(newUser.getName());
			    user.setAge(newUser.getAge());
			    user.setExpenseArea(newUser.getExpenseArea());
			    user.setClaimAmount(newUser.getClaimAmount());
			    return userRepo.save(user);
			}).orElse(newUser);
		}
		
	 
	 @DeleteMapping("/user/{id}")
		String  deleteuser(@PathVariable Long id) {
			if(!userRepo.existsById(id)){
				return "user not found";
			}
			userRepo.deleteById(id);
			return "user with id" + id + "has been deleted succesfully";
		}
		
	 
	 
	 
	 
	 //company related code
	 
	 
	 
	 
	 
	 
	 @PostMapping("/company")
	    public Company createCompany(@RequestBody Company newCompany) {
	        return companyRepo.save(newCompany);
	    }

	 
	 @GetMapping("/allcompany")
	    public List<Company> getAllCompanies() {
	        return companyRepo.findAll();
	    }

	    // Get a company by ID
	    @GetMapping("/company/{id}")
	    public Company getCompanyById(@PathVariable Long id) {
	        return companyRepo.findById(id).orElse(null);
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @PostMapping("/user/claim/{userId}")
	    public String processAndCheckClaim(@PathVariable Long userId, @RequestBody user newUser) {
	        user user = userRepo.findById(userId).orElse(null);
	        if (user == null) {
	            return "User not found.";
	        }

	        Company company = companyRepo.findById(1L).orElse(null); // Assuming one company with ID 1
	        if (company != null) {
	            if (user.getClaimAmount() > company.getFixedAmount()) {
	                return "Claim amount is more than the company policy.";
	            } else {
	                // Refund the user's claim amount
	                Long refundAmount = user.getClaimAmount();
	                user.setClaimAmount(0L); // Reset user's claim amount to 0
	                userRepo.save(user); // Save the updated user

	                return "Claim amount refunded: " + refundAmount;
	            }
	        } else {
	            return "Company not found.";
	        }
	    }
	 
	 
	  @GetMapping("/user/claim/{userId}")
	    public String checkClaimAmount(@PathVariable Long userId) {
	        user user = userRepo.findById(userId).orElse(null);
	        if (user == null) {
	            return "User not found.";
	        }

	        return "User's claim amount: " + user.getClaimAmount();
	    }
	 }
