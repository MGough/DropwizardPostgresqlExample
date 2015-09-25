package uk.co.merlingough;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import uk.co.merlingough.core.Person;
import uk.co.merlingough.db.dao.PersonDAO;
import uk.co.merlingough.resources.PersonResource;

public class DropwizardPostgresApplication extends Application<DropwizardPostgresConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardPostgresApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropwizardPostgres";
    }

    @Override
    public void initialize(final Bootstrap<DropwizardPostgresConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DropwizardPostgresConfiguration configuration,
                    final Environment environment) {

        final DBIFactory dbiFactory = new DBIFactory();
        final DBI jdbi = dbiFactory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final PersonDAO personDAO = jdbi.onDemand(PersonDAO.class);

        final PersonResource personResource = new PersonResource(personDAO);

        environment.jersey().register(personResource);
    }

}
