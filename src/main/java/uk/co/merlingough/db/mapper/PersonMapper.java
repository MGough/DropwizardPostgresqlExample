package uk.co.merlingough.db.mapper;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import uk.co.merlingough.core.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by merling on 24/09/15.
 */
public class PersonMapper implements ResultSetMapper<Person> {
    public Person map(int index, ResultSet r, StatementContext ctx) throws SQLException
    {
        return new Person(r.getInt("personid"), r.getString("firstName"), r.getString("surname"));
    }
}
