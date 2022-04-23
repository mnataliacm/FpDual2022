package edu.fpdual.jdbc.ejemplojdbc.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CountryLanguage {
    //En la BD dice CountryCode importa? o este se refiere al nombre y no al id?
    Country country;
    String language;
    boolean isOficial;
    Double percentage;

}
