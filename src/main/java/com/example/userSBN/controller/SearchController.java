package com.example.userSBN.controller;

import com.example.userSBN.model.User;
import com.example.userSBN.repository.ISearchService;
import com.example.userSBN.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@EnableAutoConfiguration
@RestController
public class SearchController {

    @Autowired
    SearchRepository searchRepository;

    @Autowired
    ISearchService iSearchService;


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public HashMap<String, List<User>> search(@Param("name") String name,
                                   @Param("vorname") String vorname,
                                   @Param("email") String email,
                                   @Param("telefon") String telefon,
                                   @Param("strasse") String strasse,
                                   @Param("ort") String ort,
                                   @Param("plz") String plz,
                                   @Param("sex") String sex,
                                   @Param("spitzname")String spitzname,
                                   @Param("birthday")String birthday) {

        // COUNT Students
        System.out.println("\nGet count of Studnets");
        System.out.println("Number of Students inserted : " + searchRepository.count());

        //List<List<User>> listen = new ArrayList<>();
        HashMap<String, List<User>> resultMap = new HashMap<>();

        if (name != null){
            resultMap.put("nameResults", iSearchService.findByName(name));
            //listen.add(iSearchService.findByName(name));
        }
        if (vorname != null){
            resultMap.put("vornameResults", iSearchService.findByVorname(vorname));
        }
        if (email != null){
            resultMap.put("emailResults", iSearchService.findByEmail(email));
        }
        if (telefon != null && !telefon.equals("")){
            resultMap.put("telefonResults",  iSearchService.findByTelefon(telefon));
        }
        if (strasse != null && !strasse.equals("")){
            resultMap.put("strasseResults", iSearchService.findByStrasse(strasse));

        }
        if (ort != null && !ort.equals("")){
            resultMap.put("ortResults", iSearchService.findByOrt(ort));
        }

        if (plz != null && !plz.equals("")){
            resultMap.put("plzResults", iSearchService.findBySex(plz));
        }

        if (sex != null && !sex.equals("")){
            resultMap.put("sexResults", iSearchService.findBySex(sex));
        }

        if (spitzname != null && !spitzname.equals("")){
            resultMap.put("spitznameResults", iSearchService.findBySpitzname(spitzname));
        }

        if (birthday != null && !birthday.equals("")){
            resultMap.put("birthdayResults", iSearchService.findByBirthday(birthday));
        }

        return resultMap;

        // List<user> result = List.intersect(userByEmail, userByName, userByNumber);
    }

    @RequestMapping(value = "/searchAll", method = RequestMethod.POST)
    public List<User> searchFindAll(@RequestBody final User findStudent) {

        return searchRepository.findAll(Example.of(findStudent,
                ExampleMatcher.matchingAny()
                        .withIgnoreNullValues()
                        .withIgnorePaths("id")
                        .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)));


    }

    /*ich kann jeder iserviceList in model hinzufugen und model return*/

    @RequestMapping(value = "/searchAll2", method = RequestMethod.POST)
    public List<User> searchAll(@Param("key") String key) {

        return iSearchService.findByStrasse(key);


    }

}