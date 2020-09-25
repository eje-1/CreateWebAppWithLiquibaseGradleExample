package com.example.userSBN.services;

import com.example.userSBN.model.User;
import com.example.userSBN.repository.ISearchService;
import com.example.userSBN.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService implements ISearchService {

    @Autowired
    SearchRepository repository;


    @Override
    public List<User> findByName(String name) {

        List<User> list;

        User findName = new User();
        findName.setName(name);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id");

        Example<User> example = Example.of(findName, exampleMatcher);
        list = repository.findAll(example);

        return list;

    }

    @Override
    public List<User> findByVorname(String vorname) {

        List<User> list;

        User findLastName = new User();
        findLastName.setVorname(vorname);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id", "name")
                .withIgnoreCase();

        Example<User> example = Example.of(findLastName,exampleMatcher);
        list = repository.findAll(example);

        return list;
    }

    @Override
    public List<User> findByEmail(String email) {

        List<User> list;

        User findEmail = new User();
        findEmail.setEmail(email);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id", "name", "vorname")
                .withIgnoreCase();

        Example<User> example = Example.of(findEmail,exampleMatcher);

        list = repository.findAll(example);

        return list;
    }

    @Override
    public List<User> findByTelefon(String telefon) {

        List<User> list;

        User findTel = new User();
        findTel.setTelefon(telefon);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id","name","vorname","email")
                .withIgnoreCase();

        Example<User> example = Example.of(findTel,exampleMatcher);

        list = repository.findAll(example);

        return list;

    }

    @Override
    public List<User> findByStrasse(String strasse) {

        List<User> list;

        User findStreet = new User();
        findStreet.setStrasse(strasse);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id", "name", "vorname", "email", "telefon")
                .withIgnoreCase();

        Example<User> example = Example.of(findStreet,exampleMatcher);

        list = repository.findAll(example);

        return list;
    }

    @Override
    public List<User> findByOrt(String ort) {

        List<User> list;

        User findOrt = new User();
        findOrt.setOrt(ort);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withIgnoreCase();

        Example<User> example = Example.of(findOrt, matcher);

        list = repository.findAll(example);

        return list;

    }

    @Override
    public List<User> findByPlz(String plz) {

        List<User> list;

        User findPlz = new User();
        findPlz.setPlz(plz);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("id", "name", "vorname", "email", "telefon", "strasse", "ort")
                .withIgnoreCase();

        Example<User> example = Example.of(findPlz, matcher);

        list = repository.findAll(example);

        return list;
    }

    @Override
    public List<User> findBySex(String sex) {

        List<User> list;

        User findSex = new User();
        findSex.setSex(sex);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("id", "name", "vorname", "email", "telefon", "strasse", "ort", "plz")
                .withIgnoreCase();

        Example<User> example = Example.of(findSex, matcher);

        list = repository.findAll(example);

        return list;
    }

    @Override
    public List<User> findBySpitzname(String spitzname) {

        List<User> list;

        User findSpitzname = new User();
        findSpitzname.setSpitzname(spitzname);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id", "name", "vorname", "email", "telefon", "strasse", "ort", "plz", "sex")
                .withIgnoreCase();

        Example<User> example = Example.of(findSpitzname, exampleMatcher);

        list = repository.findAll(example);

        return list;
    }

    @Override
    public List<User> findByBirthday(String birthday) {

        List<User> list;

        User findBirthday = new User();
        findBirthday.setBirthday(birthday);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id", "name", "vorname", "email", "telefon", "strasse", "ort", "plz", "sex", "spitzname")
                .withIgnoreCase();

        Example<User> example = Example.of(findBirthday, exampleMatcher);

        list = repository.findAll(example);

        return list;
    }

    @Override
    public List<User> findByNameEnding(String ending) {

        List<User> userList;

        //Filter Criteria
        User findByNameEnd = new User(); //Create a new instance of the domain object.
        findByNameEnd.setName(ending);  //Set properties

        //Create an ExampleMatcher to expect all values to match.
        //It is usable at this stage even without further configuration.
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")  //Construct a new ExampleMatcher to ignore the id property path.
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING) // Construct a new ExampleMatcher to ignore the id property path, to include null values, and to perform suffix string matching
                .withMatcher("name", match -> match.endsWith());

        Example<User> userExample;
        userExample = Example.of(findByNameEnd,exampleMatcher); //Create a new Example based on the domain object and the configured ExampleMatcher.

        userList = repository.findAll(userExample);

        return userList;

    }

    @Override
    public List<User> findByLastnameEnding(String ending) {

        List<User> userList;

        //Filter Criteria
        User findByLastnameEnd = new User();
        findByLastnameEnd.setVorname(ending);

        //ExampleMatcher
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)
                .withMatcher("vorname", match -> match.endsWith());

        Example<User> example;
        example = Example.of(findByLastnameEnd,exampleMatcher);

        userList = repository.findAll(example);

        return userList;

    }

    @Override
    public List<User> findByEmailEnding(String ending) {

        // List of Studnets
        List<User> userList;

        //Filter Criteria
        User findByEmailEnding = new User();
        findByEmailEnding.setEmail(ending);

        //Example Matcher
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)
                .withMatcher("email", match -> match.endsWith());

        Example<User> userExample = Example.of(findByEmailEnding,exampleMatcher);

        // result
        userList = repository.findAll(userExample);

        return userList;

    }

    @Override
    public List<User> findByTelefonEnding(String ending) {

        List<User> list;

        User findTelEnd = new User();
        findTelEnd.setTelefon(ending);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)
                .withMatcher("telefon", match -> match.endsWith());

        Example<User> example = Example.of(findTelEnd,exampleMatcher);

        list = repository.findAll(example);

        return list;
    }

    @Override
    public List<User> findByStrasseEnding(String ending) {

        List<User> list;

        User findStrasseEnd = new User();
        findStrasseEnd.setTelefon(ending);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)
                .withMatcher("strasse", match -> match.endsWith());

        Example<User> example = Example.of(findStrasseEnd,exampleMatcher);

        list = repository.findAll(example);

        return list;
    }

    @Override
    public List<User> findByOrtEnding(String ending) {

        List<User> list;

        User findOrtEnd = new User();
        findOrtEnd.setOrt(ending);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)
                .withMatcher("ort", match -> match.endsWith());

        Example<User> example = Example.of(findOrtEnd,exampleMatcher);

        list = repository.findAll(example);

        return list;
    }

    @Override
    public List<User> findByPlzEnding(String ending) {

        List<User> list;

        User findPlzEnd = new User();
        findPlzEnd.setPlz(ending);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)
                .withMatcher("plz", matcher -> matcher.endsWith());

        Example<User> example = Example.of(findPlzEnd, exampleMatcher);
        list = repository.findAll(example);

        return list;
    }

    @Override
    public List<User> findBySexEnding(String ending) {

        List<User> list;
        User findSexEnd = new User();
        findSexEnd.setSex(ending);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)
                .withMatcher("sex", matcher -> matcher.endsWith());

        Example<User> example = Example.of(findSexEnd, exampleMatcher);

        list = repository.findAll(example);

        return list;
    }

    @Override
    public List<User> findBySpitznameEnding(String ending) {

        List<User> list;

        User findSpitznameEnd = new User();
        findSpitznameEnd.setSpitzname(ending);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)
                .withMatcher("spitzname", matcher -> matcher.endsWith());

        Example<User> example = Example.of(findSpitznameEnd, exampleMatcher);
        list = repository.findAll(example);

        return list;
    }

    @Override
    public List<User> findByBirthdayEnding(String ending) {

        List<User> list;

        User findBirthdayEnd = new User();
        findBirthdayEnd.setBirthday(ending);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)
                .withMatcher("birthday", matcher -> matcher.endsWith());

        Example<User> example = Example.of(findBirthdayEnd, exampleMatcher);
        list = repository.findAll(example);

        return list;
    }
}
