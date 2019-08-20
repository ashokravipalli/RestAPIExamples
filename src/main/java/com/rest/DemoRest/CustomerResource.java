package com.rest.DemoRest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cust")
public class CustomerResource {

	CustomerRepository repo = new CustomerRepository();

	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})	
	public List<Customer> getCust() {

		System.out.println("calling GET call!!!!");

		return repo.getAllCust();		
	}
	
	@GET
	@Path("/cust/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})	
	public Customer getCust(@PathParam("id") int id) {

		System.out.println("calling GET call!!!!");
		
		return repo.getCust(id);
	}
	
	
	@POST
	@Path("/newcust")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})	
	public Customer createNewCust(Customer cust) {

		System.out.println("Creating new cutomer call!!!!" + cust);

		repo.create(cust);
		return cust;
	}

}
