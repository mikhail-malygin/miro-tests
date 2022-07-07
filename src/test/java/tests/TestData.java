package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    private final static Faker fakerEnglish = new Faker(new Locale("en")),
                               fakerRussian = new Faker(new Locale("ru"));

    protected final static String ID_JOB_TITLE = "5234556002"; // JOB_TITLE = "qa automation engineer"
    protected final static String FIRST_NAME = fakerEnglish.name().firstName(),
                                  LAST_NAME = fakerEnglish.name().lastName(),
                                  EMAIL = fakerEnglish.internet().emailAddress(),
                                  PHONE_NUMBER = fakerRussian.number().digits(10);
}
