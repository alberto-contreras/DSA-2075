package game.backend.services;
import game.backend.MangUserImpl;
import game.backend.models.FormReg;
import game.backend.MangAuthenticationImpl;
import game.backend.models.User;
import game.backend.models.Obj;
import game.backend.models.Game;
import game.backend.models.UserTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.eclipse.persistence.oxm.annotations.XmlParameter;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Service that provide all the operations related with the stats of a User
 */

@Api(value = "/stats", description = "Endpoint to User Service")
@Path("/stats")
public class UserService {
    MangUserImpl tm = new MangUserImpl();
    public UserService(){}
    @GET
    @ApiOperation(value = "Get all User Objects", notes = "Stats")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = Obj.class, responseContainer="List" ),
            @ApiResponse(code = 400, message = "Bad Request Invalid parameters"),
            @ApiResponse(code = 404, message = "Not Found")


    })

    @Path("/myObj/{idUser}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getmyObjs(@PathParam("idUser") String idUser) {

        if (idUser == null)  return Response.status(400).build();
        List<Obj> myObj = this.tm.getAllMyObjects(idUser);

        GenericEntity<List<Obj>> entity = new GenericEntity<List<Obj>>(myObj) {};

        if (myObj.size() != 0){return Response.status(201).entity(entity).build();}
        else{return Response.status(404).build();}
    }
    @GET
    @ApiOperation(value = "Get all User Games", notes = "Stats")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = Game.class, responseContainer="List" ),
            @ApiResponse(code = 400, message = "Bad Request Invalid parameters"),
            @ApiResponse(code = 404, message = "Not Found")


    })

    @Path("/myGame/{idUser}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getmyGames(@PathParam("idUser") String idUser) {

        if (idUser == null)  return Response.status(400).build();
        List<Game> myGame = this.tm.getAllMyGames(idUser);

        GenericEntity<List<Game>> entity = new GenericEntity<List<Game>>(myGame) {};

        if (myGame.size() != 0){return Response.status(201).entity(entity).build();}
        else{return Response.status(404).build();}
    }
}
