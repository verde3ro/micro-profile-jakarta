package upq.edu.mx.rest;

import org.jboss.logging.Logger;
import upq.edu.mx.model.UserResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
public class UserResource {

	private static final Logger LOG = Logger.getLogger(UserResource.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserResponse getUser() {
		LOG.info("Solicitud GET /user recibida");

		return new UserResponse("admin", "admin@ejemplo.com", "Administrador del Sistema");
	}
}
