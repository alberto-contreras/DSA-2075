//package game.backend.services;
//
//import game.backend.MangUser;
//import game.backend.MangUserImp;
//import game.backend.models.Game;
//import game.backend.models.Obj;
//import game.backend.models.User;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.GenericEntity;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.List;
//
//@Api(value = "/users", description = "Endpoint to User Service")
//@Path("/users")
//public class UsersService {
//
//    private MangUser um;
//
//    public UsersService() {
//        this.um = new MangUserImp().getInstance();
//        if (um.size() == 0) {
//            this.um.addUser("yooel", "1234", "yoel");
//            this.um.addUser("albeerto", "1234", "alberto");
//            this.um.addUser("daani", "1234", "dani");
//            this.um.addUser("joona", "1234", "jona");
//            this.um.addObjetWithUserName("yooel", "espada", 1, 5, 5);
//            this.um.addObjetWithUserName("yooel", "cofre", 0, 0, 3);
//            this.um.addObjetWithUserName("albeerto", "cofre", 0, 0, 3);
//            this.um.addObjetWithUserName("daani", "escudo", 5, 1, 4);
//            this.um.addObjetWithUserName("joona", "escudo", 5, 1, 4);
//            this.um.addGamesWithUserName("yooel", "1", "14/08/2019", 1, 1, 1, 1);
//            this.um.addGamesWithUserName("yooel", "2", "15/08/2019", 1, 2, 2, 2);
//        }
//    }
//
//    @GET
//    @ApiOperation(value = "Objetos de un usuario", notes = "Introduce el userName para objetener sus objetos")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Obj.class, responseContainer = "List"),
//            @ApiResponse(code = 404, message = "Usuario not found")
//    })
//    @Path("/{userName}/objetos")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getObjetoDeUnUsuario(@PathParam("userName") String userName) {
//        User u = this.um.getUserByUserName(userName);
//        if (u == null) return Response.status(404).build();
//        else {
//            List<Obj> objects = u.getMyObject();
//            GenericEntity<List<Obj>> entity = new GenericEntity<List<Obj>>(objects) {
//            };
//            return Response.status(201).entity(entity).build();
//        }
//    }
//
////    @GET
////    @ApiOperation(value = "Partidas de un usuario", notes = "Introduce el userName para objetener sus partidas")
////    @ApiResponses(value = {
////            @ApiResponse(code = 201, message = "Successful", response = Game.class, responseContainer = "List"),
////            @ApiResponse(code = 404, message = "Usuario not found")
////    })
////    @Path("/{userName}/partidas")
////    @Produces(MediaType.APPLICATION_JSON)
////    public Response getPartidasDeUnUsuario(@PathParam("userName") String userName) {
////        User u = this.um.getUserByUserName(userName);
////        if (u == null) return Response.status(404).build();
////        else {
////            List<Game> games = u.getMyGames();
////            GenericEntity<List<Game>> entity = new GenericEntity<List<Game>>(games) {
////            };
////            return Response.status(201).entity(entity).build();
////        }
////    }
//}


