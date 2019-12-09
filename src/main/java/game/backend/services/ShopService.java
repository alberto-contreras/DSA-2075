//package game.backend.services;
//
//import game.backend.MangShop;
//import game.backend.MangShopImp;
//import game.backend.models.Obj;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.GenericEntity;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.List;
//
//@Api(value = "/Shop", description = "Endpoint to Shop Service")
//@Path("/Shop")
//public class ShopService {
//
//    private MangShop ms;
//
//    public ShopService() {
//        this.ms = new MangShopImp().getInstance();
//        if (ms.size() == 0) {
//            this.ms.addObject("Espada", 1, 5, 5);
//            this.ms.addObject("Cofre", 0, 0, 3);
//            this.ms.addObject("Escudo", 5, 1, 4);
//            this.ms.addObject("Hacha", 1, 5, 5);
//        }
//    }
//
//    @GET
//    @ApiOperation(value = "Get all objects", notes = "Objetos de la tienda")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Obj.class, responseContainer="List"),
//    })
//    @Path("/Objetos de la tienda")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getObjectos() {
//
//        List<Obj> objects = this.ms.allObjects();
//        GenericEntity<List<Obj>> entity = new GenericEntity<List<Obj>>(objects) {
//        };
//        return Response.status(201).entity(entity).build();
//    }
//
//}
//
//
