package com.example.userSBN.services;

import com.example.userSBN.model.User;

import java.util.List;

public interface ISearchService {


    List<User> findByName(String name);

    List<User> findByVorname(String vorname);

    List<User> findByEmail(String email);

    List<User> findByTelefon(String telefon);

    List<User> findByStrasse(String strasse);

    List<User> findByOrt(String ort);

    List<User> findByPlz(String plz);

    List<User> findBySex(String sex);

    List<User> findBySpitzname(String spitzname);

    List<User> findByBirthday(String birthday);

    List<User> findByCourses(String courses);

    /**

     List<User> findByNameEnding(String ending);

     List<User> findByLastnameEnding(String ending);

     List<User> findByEmailEnding(String ending);

     List<User> findByTelefonEnding(String ending);

     List<User> findByStrasseEnding(String ending);

     List<User> findByOrtEnding(String ending);

     List<User> findByPlzEnding(String ending);

     List<User> findBySexEnding(String ending);

     List<User> findBySpitznameEnding(String ending);

     List<User> findByBirthdayEnding(String ending);

     */


}
