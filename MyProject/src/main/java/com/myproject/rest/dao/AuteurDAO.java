package com.myproject.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.rest.model.Auteur;


 
@Repository
public class AuteurDAO 
{
    private static List<Auteur> list = new ArrayList<>();
     
    static
    {
        list.add(new Auteur(1L, "Lokesh", "Gupta"));
        list.add(new Auteur(2L, "Alex", "Kolenchiskey"));
        list.add(new Auteur(3L, "David", "Kameron"));
    }
     
    public List<Auteur> getAllAuteurs() 
    {
        return list;
    }
     
    public void addAuteur(Auteur auteur) {
        list.add(auteur);
    }
}
