package com.rest.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rest.domain.Data;
import com.rest.domain.Document;
import com.rest.util.HTTPClient;
import com.rest.util.JsonService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { JsonService.class, HTTPClient.class })
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonSeviceTest {

	@Autowired
	JsonService jsonService;
	@Autowired
	HTTPClient httpClient;

	@Test
	public void jsonMustBeDeserialisedInObject() throws IOException {

		Document document1 = new Document("3c3326ca4c234a828f892cc5716cd10b","md5:d6bd9bb606ad860ff141526b5c81b5d8",
				"application/vnd.openxmlformats-officedocument.wordprocessingml.document","https://public.docs-sandbox.openprocurement.org/get/499160aad8ea4b6281bc15a155f5a81b?KeyID=1331dc52&Signature=Un0Hs0DjdXKnefSEbbP7O38lHHOUZjcbmDObH4idj6pHfeniocqB3v7l0lVhID3fwGL0H9UpJIswjnIM%252BFrYCg%253D%253D",
				"Документация по лоту 5.docx","tender","2017-09-15T16:08:34.036357+03:00","2017-09-15T16:08:34.036392+03:00");
		Document document2 = new Document("a8573bbd1d994eafb52baa673286963f","md5:bfb564cb53aac844da0adcee220f9412",
				"application/vnd.openxmlformats-officedocument.wordprocessingml.document","https://public.docs-sandbox.openprocurement.org/get/403955e65e7349079d19aa8af453dc14?KeyID=1331dc52&Signature=JULfRpGCmKaUjasK82W7eG5RCBHGxdqP3Pif2Oz4Vxx0n7gEou54RZgQZl6JPAex95zigm77mcoXDon5UwhBCg%253D%253D",
				"sign.p7s","tender","2017-09-15T16:08:35.822523+03:00","2017-09-15T16:08:35.822559+03:00");
		List<Document> documentList = new ArrayList<Document>();
		documentList.add(document1);
		documentList.add(document2);
		
        Data  expectedData= new Data();
        expectedData.setData(documentList);
        
		String jsonData = httpClient
				.doGetRequest("https://lb.api-sandbox.openprocurement.org/api/2.4/contracts/6aa21ab58b0f402591ef4cc6abebe6c3/documents");
		
		Data data = jsonService.JsonDeserialisation(jsonData);

		assertTrue(expectedData.equals(data));

	}

}
