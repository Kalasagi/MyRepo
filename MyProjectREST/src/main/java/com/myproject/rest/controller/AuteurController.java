package com.myproject.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.rest.model.Auteur;

@RestController
@RequestMapping(path = "/auteurs")
public class AuteurController
	extends CRUDGenericController<Auteur> {

}
