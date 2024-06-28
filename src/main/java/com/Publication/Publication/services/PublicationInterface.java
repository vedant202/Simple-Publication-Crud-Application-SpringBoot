package com.Publication.Publication.services;

import java.util.List;

import com.Publication.Publication.Model.PublicationEntity;

interface PublicationInterface {
	 void savePublicationData(PublicationEntity entity);
	 List<PublicationEntity> getAllPublications();
	 public void deletePublicationData(int entity);
	 public PublicationEntity updatePublicationData(int id,PublicationEntity entity);


}
