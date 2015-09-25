package uk.co.merlingough.core;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by merling on 24/09/15.
 */
public class Person {
    private long personid;
    private String firstName;
    private String surname;

    public Person(long personid, String firstName, String surname) {
        this.personid = personid;
        this.firstName = firstName;
        this.surname = surname;
    }

    @JsonProperty
    public long getPersonid() {
        return personid;
    }

    @JsonProperty
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty
    public String getSurname() {
        return surname;
    }

}
