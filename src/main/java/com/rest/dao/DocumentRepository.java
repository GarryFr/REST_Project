package com.rest.dao;

import org.springframework.data.repository.CrudRepository;

import com.rest.domain.Document;

public interface DocumentRepository extends CrudRepository<Document, String> {
	
	public Document findByHash(String hash);
	
}
