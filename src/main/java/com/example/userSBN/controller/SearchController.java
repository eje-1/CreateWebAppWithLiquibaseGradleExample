package com.example.userSBN.controller;

import com.example.userSBN.model.Faecher;
import com.example.userSBN.model.QFaecher;
import com.example.userSBN.model.QUser;
import com.example.userSBN.model.User;
import com.example.userSBN.repository.FaecherRepository;
import com.example.userSBN.repository.MyStudentQueryDSLRepository;
import com.example.userSBN.repository.SearchRepository;
import com.example.userSBN.services.ISearchService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@Controller
public class SearchController {

    @Autowired
    SearchRepository searchRepository;

    @Autowired
    FaecherRepository faecherRepository;

    @Autowired
    ISearchService iSearchService;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    MyStudentQueryDSLRepository studentQueryDSLRepository;

    private String appMode;

    public static final QUser user = new QUser("user");
    public static final QFaecher faecher = new QFaecher("faecher");

    @Autowired
    public SearchController(Environment environment) {
        appMode = environment.getProperty("app-mode");
    }


    @RequestMapping(value = "/searchAll", method = RequestMethod.GET)
    public String searchAllStudnets(User findStudent, Model model) {

        List<User> findAll = searchRepository.findAll(Example.of(findStudent,
                ExampleMatcher.matchingAny()
                        .withIgnoreNullValues()
                        .withIgnorePaths("id")
                        .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)));

        List<Faecher> allFeacher = faecherRepository.findAll();//get all entries from Entry table into a list

        model.addAttribute("users", findAll);
        model.addAttribute("courses", allFeacher);
        model.addAttribute("mode", appMode);

        return "/searchAll";
    }


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@Param("name") String name,
                         @Param("vorname") String vorname,
                         @Param("email") String email,
                         @Param("telefon") String telefon,
                         @Param("strasse") String strasse,
                         @Param("ort") String ort,
                         @Param("plz") String plz,
                         @Param("sex") String sex,
                         @Param("spitzname") String spitzname,
                         @Param("birthday") String birthday,
                         Model model) {

        // COUNT Students
        System.out.println("\nGet count of Studnets");
        System.out.println("Number of Students inserted : " + searchRepository.count());

        List<User> result = new ArrayList<>();
        List<Faecher> allFaecher = faecherRepository.findAll();

        if (name != null && !name.equals("")) {
            for (User user : iSearchService.findByName(name)) {
                result.add(user);
            }
        }
        if (vorname != null && !vorname.equals("")) {
            for (User user : iSearchService.findByVorname(vorname)) {
                result.add(user);
            }
        }
        if (email != null && !email.equals("")) {
            for (User user : iSearchService.findByEmail(email)) {
                result.add(user);
            }
        }
        if (telefon != null && !telefon.equals("")) {
            for (User user : iSearchService.findByTelefon(telefon)) {
                result.add(user);
            }
        }
        if (strasse != null && !strasse.equals("")) {
            for (User user : iSearchService.findByStrasse(strasse)) {
                result.add(user);
            }
        }
        if (ort != null && !ort.equals("")) {
            for (User user : iSearchService.findByOrt(ort)) {
                result.add(user);
            }
        }

        if (plz != null && !plz.equals("")) {
            for (User user : iSearchService.findByPlz(plz)) {
                result.add(user);
            }
        }

        if (sex != null && !sex.equals("")) {
            for (User user : iSearchService.findBySex(sex)) {
                result.add(user);
            }
        }

        if (spitzname != null && !spitzname.equals("")) {
            for (User user : iSearchService.findBySpitzname(spitzname)) {
                result.add(user);
            }
        }

        if (birthday != null && !birthday.equals("")) {
            for (User user : iSearchService.findByBirthday(birthday)) {
                result.add(user);
            }
        }
        model.addAttribute("result", result);
        model.addAttribute("courses", allFaecher);

        return "/searchAll";

    }

    @RequestMapping(value = "/searchwithcourses", method = RequestMethod.POST)
    public String searchAll(Model model,
                            @Param("courses") String key) {

        List<User> resultOnCourses = new ArrayList<>();
        List<Faecher> allCourses = faecherRepository.findAll();//get all entries from Entry table into a list

        if (key != null) {

            JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
            QFaecher qFaecher = QFaecher.faecher;
            QUser user = QUser.user;
            resultOnCourses = queryFactory.selectFrom(user)
                    .innerJoin(user.courses, qFaecher)
                    .on(qFaecher.name.eq(key))
                    .fetch();

        } else if (key == null) {
            System.out.println("error");
        }

        model.addAttribute("search", resultOnCourses);
        model.addAttribute("courses", allCourses);

        return "/searchAll";


    }

}