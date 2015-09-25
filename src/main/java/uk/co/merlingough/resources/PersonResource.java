package uk.co.merlingough.resources;

import com.codahale.metrics.annotation.Timed;
import uk.co.merlingough.core.Person;
import uk.co.merlingough.db.dao.PersonDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by merling on 24/09/15.
 */
@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {
    private final PersonDAO personDAO;

    public PersonResource(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GET
    @Timed
    @Path("/{id}")
    public Person getPersonByID(@PathParam("id") long id) {
        return personDAO.findById(id);
    }
}
