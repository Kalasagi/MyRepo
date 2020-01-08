package com.myproject.rest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myproject.rest.dao.AuteurDAO;
import com.myproject.rest.model.Auteur;

@RestController
@RequestMapping(path = "/auteurs")
public class AuteurController {
	
	@Autowired
    private AuteurDAO auteurDao;
     
    @GetMapping(path="/", produces = "application/json")
    public List<Auteur> getAuteurs() 
    {
        return auteurDao.getAllAuteurs();
    }
     
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addAuteur(@RequestBody Auteur auteur) 
    {
        Integer id = auteurDao.getAllAuteurs().size() + 1;
        auteur.setId(id.longValue());
         
        auteurDao.addAuteur(auteur);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(auteur.getId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }

}
