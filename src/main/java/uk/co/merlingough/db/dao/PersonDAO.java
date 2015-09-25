package uk.co.merlingough.db.dao;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import uk.co.merlingough.core.Person;
import uk.co.merlingough.db.mapper.PersonMapper;

/**
 * Created by merling on 24/09/15.
 */
public interface PersonDAO {

    @SqlUpdate("insert into people (firstName, surname) values (:firstName, :surname)")
    @GetGeneratedKeys
    long create(@BindBean Person person);

    @SqlQuery("select * from people where personid = :personid LIMIT 1")
    @Mapper(PersonMapper.class)
    Person findById(@Bind("personid") long personid);

}
