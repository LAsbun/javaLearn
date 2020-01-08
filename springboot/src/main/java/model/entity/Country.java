package model.entity;

import javax.persistence.Id;

/**
 * Created by louxiu
 */

public class Country {
    @Id
    private Integer id;
    private String  countryname;
    private String  countrycode;

    //省略 getter 和 setter
}
