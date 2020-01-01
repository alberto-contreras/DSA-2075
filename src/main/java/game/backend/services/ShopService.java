package game.backend.services;
import game.backend.MangShop;
import game.backend.MangShopImpl;
import game.backend.MangUserImpl;
import game.backend.models.FormReg;
import game.backend.models.User;
import game.backend.models.Obj;
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
 * Service that provide all the operations related with the Shop
 */

@Api(value = "/shop", description = "Endpoint to Shop Service")
@Path("/shop")

public class ShopService {
    MangShopImpl tm = new MangShopImpl();

    public ShopService() {
    }

    @POST
    @ApiOperation(value = "Add objects", notes = "Shop")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Added"),
            @ApiResponse(code = 400, message = "Bad Request EMPTY LIST")


    })

    @Path("/purchase")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newPurchase(List<Obj> myObj) {

        if (myObj.size() == 0) return Response.status(400).build();
        int res = tm.addPurchase(myObj);
        if (res == 0) {
            return Response.status(200).build();
        } else {
            return Response.status(406).build();
        }
    }
}

