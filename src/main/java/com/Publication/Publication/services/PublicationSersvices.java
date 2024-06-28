package com.Publication.Publication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Publication.Publication.Model.PublicationEntity;
import com.Publication.Publication.repository.PublicationRepository;

@Service
public class PublicationSersvices implements PublicationInterface {

	@Autowired
	PublicationRepository repository;

	@Override
	public List<PublicationEntity> getAllPublications() {
		// TODO Auto-generated method stub

		return repository.findAll();
	}

	@Override
	public void savePublicationData(PublicationEntity entity) {
		// TODO Auto-generated method stub
		repository.findById(entity.getId()).ifPresentOrElse(items->{
			items.setId(entity.getId());
			items.setTitle(entity.getTitle());
			items.setType(entity.getType());
			items.setContent(entity.getContent());
			repository.save(items);
		}, ()->{
			repository.save(entity);
		});

	}

	@Override
	public void deletePublicationData(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	public PublicationEntity getPublicationById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public PublicationEntity updatePublicationData(int id,PublicationEntity entity) {
		// TODO Auto-generated method stub
		return repository.findById(id).map(i->{
			i.setTitle(entity.getTitle());
			i.setContent(entity.getContent());
			i.setType(entity.getType());
			return repository.save(i);
		}).orElseThrow(() -> new RuntimeException("Item not found with id " + id));
	}


}
