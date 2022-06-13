package quarkus.rest;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import quarkus.rest.dto.CreateUserRequest;
import quarkus.rest.entities.User;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResourse {

    @POST
    @Transactional
    public Response createUser(CreateUserRequest userRequest) {

    	User user = new User();
    	user.setAge(userRequest.getAge());
    	user.setName(userRequest.getName());
    	
    	user.persist();
    	System.out.println(user.getAge());
        return Response.ok(user).build();
    }
    
    @GET
    public Response listAllUsers() {
    	PanacheQuery<User> query = User.findAll();
    	return Response.ok(query.list()).build();
    }
    
    @Transactional
    @PUT
    @Path("{id}")
    public Response updateUser(@PathParam("id") Long id, CreateUserRequest userData) {
    	User user = User.findById(id);
    	if(user != null) {
    		user.setAge(userData.getAge());
    		user.setName(userData.getName());
    		return Response.ok(user).build();
    	}
    	return Response.status(Response.Status.NOT_FOUND).build();
    	
    }
    
    @Transactional
    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Long id) {
    	User user = User.findById(id);
    	if(user != null) {
    		user.delete();
    		return Response.ok().build();
    	}
    	return Response.status(Response.Status.NOT_FOUND).build();
    	
    }
}

//controlador 
//@Path("/users")
//public class UserResourse {
//
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response createUser(CreateUserRequest userRequest) {
//		return Response.ok().build();
//	}
//}