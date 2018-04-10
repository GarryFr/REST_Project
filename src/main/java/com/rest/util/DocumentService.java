package com.rest.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.dao.DocumentRepository;
import com.rest.domain.Data;
import com.rest.domain.Document;


@Service
public class DocumentService {

	@Autowired
	DocumentRepository documentRepository;

	public void saveDocument(Data documentList) {
		for (Document document : documentList.getData()) {

			documentRepository.save(document);

		}
	}
}

