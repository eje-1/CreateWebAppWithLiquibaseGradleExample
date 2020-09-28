package com.example.userSBN.controller;

import com.example.userSBN.model.Faecher;
import com.example.userSBN.model.User;
import com.example.userSBN.repository.ISearchService;
import com.example.userSBN.repository.SearchRepository;
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

import java.util.*;

@EnableAutoConfiguration
@Controller
public class SearchController {

    @Autowired
    SearchRepository searchRepository;

    @Autowired
    ISearchService iSearchService;

    private String appMode;

    @Autowired
    public SearchController(Environment environment){
        appMode = environment.getProperty("app-mode");
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
                         @Param("spitzname")String spitzname,
                         @Param("birthday")String birthday,
                         @Param("courses") String courses,
                         Model model) {

        // COUNT Students
        System.out.println("\nGet count of Studnets");
        System.out.println("Number of Students inserted : " + searchRepository.count());

        //List<List<User>> listen = new ArrayList<>();
        HashMap<String, List<User>> resultMap = new HashMap<>();
        List<User> result = new ArrayList<>();

        if (name != null && !name.equals("")){
            for (User user : iSearchService.findByName(name)) {
                result.add(user);
            }
            //resultMap.put("nameResults", iSearchService.findByName(name));
            //resultMap.put("endNameResult", iSearchService.findByNameEnding(name));
            //listen.add(iSearchService.findByName(name));
        }
        if (vorname != null && !vorname.equals("")){
            for (User user : iSearchService.findByVorname(vorname)) {
                result.add(user);
            }
            //resultMap.put("vornameResults", iSearchService.findByVorname(vorname));
            //resultMap.put("endVornameResults", iSearchService.findByLastnameEnding(vorname));
        }
        if (email != null && !email.equals("")){
            for (User user: iSearchService.findByEmail(email)) {
                result.add(user);
            }
            //resultMap.put("emailResults", iSearchService.findByEmail(email));
            //resultMap.put("endEmailResults", iSearchService.findByEmailEnding(email));
        }
        if (telefon != null && !telefon.equals("")){
            for (User user: iSearchService.findByTelefon(telefon)) {
                result.add(user);
            }
            //resultMap.put("telefonResults",  iSearchService.findByTelefon(telefon));
            //resultMap.put("endTelefonResults",  iSearchService.findByTelefonEnding(telefon));
        }
        if (strasse != null && !strasse.equals("")){
            for (User user: iSearchService.findByStrasse(strasse)) {
                result.add(user);
            }
            //resultMap.put("strasseResults", iSearchService.findByStrasse(strasse));
            //resultMap.put("endStrasseResult", iSearchService.findBySpitznameEnding(strasse));

        }
        if (ort != null && !ort.equals("")){
            for (User user: iSearchService.findByOrt(ort)) {
                result.add(user);
            }
            //resultMap.put("ortResults", iSearchService.findByOrt(ort));
            //resultMap.put("endOrtResults", iSearchService.findByOrtEnding(ort));
        }

        if (plz != null && !plz.equals("")){
            for (User user: iSearchService.findByPlz(plz)) {
                result.add(user);
            }
            //resultMap.put("plzResults", iSearchService.findByPlz(plz));
            //resultMap.put("endPlzResults", iSearchService.findByPlzEnding(plz));
        }

        if (sex != null && !sex.equals("")){
            for (User user: iSearchService.findBySex(sex)) {
                result.add(user);
            }
            //resultMap.put("sexResults", iSearchService.findBySex(sex));
            //resultMap.put("endSexResult", iSearchService.findBySexEnding(sex));
        }

        if (spitzname != null && !spitzname.equals("")){
            for (User user: iSearchService.findBySpitzname(spitzname)) {
                result.add(user);
            }
            //resultMap.put("spitznameResults", iSearchService.findBySpitzname(spitzname));
            //resultMap.put("endSpitznameResults", iSearchService.findBySpitznameEnding(spitzname));
        }

        if (birthday != null && !birthday.equals("")){
            for (User user: iSearchService.findByBirthday(birthday)) {
                result.add(user);
            }
            //resultMap.put("birthdayResults", iSearchService.findByBirthday(birthday));
            //resultMap.put("endBirthdayResults", iSearchService.findByBirthdayEnding(birthday));
        }

        if (courses != null){
            for (User user : iSearchService.findByCourses(courses)) {
               result.add(user);
            }
        }


        model.addAttribute("result", result);

        return "/searchAll";

        // List<user> result = List.intersect(userByEmail, userByName, userByNumber);
    }

    @RequestMapping(value = "/searchAll", method = RequestMethod.GET)
    public String searchFindAll(User findStudent, Model model) {

        List<User> findAll = searchRepository.findAll(Example.of(findStudent,
                ExampleMatcher.matchingAny()
                        .withIgnoreNullValues()
                        .withIgnorePaths("id")
                        .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)));

        model.addAttribute("users", findAll);
        model.addAttribute("mode", appMode);

        return "/searchAll";


    }

    /*ich kann jeder iserviceList in model hinzufugen und model return*/

    @RequestMapping(value = "/searchAll2", method = RequestMethod.POST)
    public List<User> searchAll(@Param("key") Set<Faecher> key) {

        return null;


    }

}