package com.webservice.ExampleRestWs;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	
	AlienRepo arepo = new AlienRepo();
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Alien> getAliens(){
	System.out.println("get Alien Called");
		
		return arepo.getAliens();
	}
	
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien getAlien(@PathParam("id") int id){
	
		
		return arepo.getAlien(id);
	}
	
	@POST
	@Path("alien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien createAlien(Alien a1){
		
		System.out.println(a1);
		
		arepo.create(a1);
		return a1;
		
	}
	
	@PUT
	@Path("alien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien updateAlien(Alien a1){
		
		System.out.println(a1);
		if(arepo.getAlien(a1.getId()).getId()==0){
			arepo.create(a1);
		}
		else{
		
		arepo.update(a1);
		}
		return a1;
		
	}
	

	@DELETE
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien deleteAlien(@PathParam("id") int id){
	
		Alien a = arepo.getAlien(id);
		if(a.getId()!=0)
			arepo.delete(id);
		return a;
	}
}
