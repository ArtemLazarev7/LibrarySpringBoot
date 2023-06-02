package com.lazarev.LibrarySpringBoot.util;



import com.lazarev.LibrarySpringBoot.models.Person;
import com.lazarev.LibrarySpringBoot.service.PeopleService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class PersonValidator implements Validator {

    private final PeopleService peopleService;

    public PersonValidator( PeopleService peopleService) {

        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        if (peopleService.getPersonByFullName(person.getFullName()).isPresent())
            errors.rejectValue("fullName", "", "Человек с таким ФИО уже существует");

    }
}
