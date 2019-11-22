package game.backend.services;
import game.backend.models.FormReg;
import game.backend.MangAuthenticationImpl;
import game.backend.models.User;
import game.backend.models.UserTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/authen", description = "Endpoint to Authentucation Service")
@Path("/authent")
public class AuthenticationService {
    public MangAuthenticationImpl tm = new MangAuthenticationImpl();
    public AuthenticationService(){}

    @POST  //OKEY Create a new User
    @ApiOperation(value = "Create a new User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created",response = UserTO.class),
            @ApiResponse(code = 406, message = "Not Acceptable Already exist this user",response = FormReg.class),
            @ApiResponse(code = 400, message = "Bad Request Invalid parameters", response = FormReg.class)


    })

    @Path("/reg")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(FormReg u) {

        if (u.getUsername()==null || u.getPassword()==null || u.getName() == null)  return Response.status(400).entity(u).build();
        User reg = new User(u.getUsername(),u.getPassword(),u.getName());
        int a = tm.addUser(reg);
        UserTO userTO = new UserTO(reg); //We create the UserTO with the parameters of the user to just send the important info
        if (a == 0){return Response.status(201).entity(userTO).build();}
        else{return Response.status(800).entity(userTO).build();}
    }




    @POST  //OKEY Login User
    @ApiOperation(value = "Login a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 403, message = "Forbidden Wrong Login",response = FormReg.class),
            @ApiResponse(code = 400, message = "Bad Reguest Invalid parameters", response = int.class)


    })

    @Path("/log")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logUser(FormReg u) {

        if (u.getUsername()==null || u.getPassword()==null)  return Response.status(400).entity(u).build();
        int a = tm.checkUser(u.getUsername(),u.getPassword());
        if (a == 0){return Response.status(200).entity(u).build();} //return reg
        else{return Response.status(403).entity(u).build();}
    }
}
