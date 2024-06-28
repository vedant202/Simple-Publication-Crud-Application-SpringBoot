package com.Publication.Publication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Publication.Publication.Model.PublicationEntity;

@Repository
public interface PublicationRepository extends JpaRepository<PublicationEntity, Integer>  {

}
