package com.Publication.Publication.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Publication.Publication.Model.PublicationEntity;
import com.Publication.Publication.services.PublicationSersvices;

@RestController
public class RestPublicationController {

	@Autowired
	PublicationSersvices publicationSersvices;

	@PostMapping("/update")
	public String update(@RequestParam int id) {
		System.out.println("update Publication by id:- "+id);
		PublicationEntity entity = this.publicationSersvices.getPublicationById(id);
		JSONObject obj = new JSONObject();
		obj.put("id",entity.getId());
		obj.put("title",entity.getTitle());
		obj.put("type", entity.getType());
		obj.put("content",entity.getContent());
		return obj.toString();
	}

}
