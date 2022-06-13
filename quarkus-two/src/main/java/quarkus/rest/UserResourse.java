package quarkus.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import quarkus.rest.dto.CreateUserRequest;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResourse {

    @POST
    public Response createUser(CreateUserRequest userRequest) {

    	System.out.println(userRequest.getAge());
        return Response.ok(userRequest).build();
    }
    
    @GET
    public Response listAllUsers() {
    	return Response.ok().build();
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