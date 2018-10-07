package ru.gotoqa;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author Muflikhunov Roman
 */

@Getter
@Setter
@ToString
public class ClassRates {
    private String disclaimer;
    private String license;
    private int timestamp;
    private String base;
    private Rates rates;

}
