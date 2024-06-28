package com.Publication.Publication.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Publication.Publication.Model.PublicationEntity;
import com.Publication.Publication.dao.PublicationRequestBody;
import com.Publication.Publication.services.PublicationSersvices;


@Controller
public class PublicationController {

	@Autowired
	PublicationSersvices publicationSersvices;

	@GetMapping("/home")
	public String home(Model modelAndView) {
		List<PublicationEntity> entities = publicationSersvices.getAllPublications();
		System.out.println(entities);
		modelAndView.addAttribute("publications", entities);
		return "Home";
	}

	@RequestMapping(
			  path = "/save",
			  method = RequestMethod.POST,
			  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
			 )
	public String savePublication(PublicationRequestBody body) {
		System.out.println(body);
		publicationSersvices.savePublicationData(new PublicationEntity(body.getId(),body.getTitle(),body.getType(),body.getContent()));
		return "redirect:/home";
	}

	@RequestMapping(
			  path = "/delete/{id}",
			  method = RequestMethod.GET
			 )
	public String delete(@PathVariable int id) {
		System.out.println("Deelete Publication by id:- "+id);
		this.publicationSersvices.deletePublicationData(id);
		return "redirect:/home";
	}





}
