package com.rest.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "document")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Document {
	
	
	public Document() {
		
	}
	
	
	public Document(String id, String hash, String format, String url,
			String title, String documentof, String datepublished,
			String datemodified) {
		super();
		this.id = id;
		this.hash = hash;
		this.format = format;
		this.url = url;
		this.title = title;
		this.documentof = documentof;
		this.datepublished = datepublished;
		this.datemodified = datemodified;
	}


	@Id	
	private String id;
    @Column(name = "hash")
	private String hash;
	@Column(name = "format")
	private String format;
	@Column(name = "url")
	private String url;
	@Column(name = "title")
	private String title;
	@Column(name = "documentof")
	private String documentof;
	@Column(name = "datepublished")
	private String datepublished;
	@Column(name = "datemodified")
	private String datemodified;
	
	
	
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;	
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDocumentOf() {
		return documentof;
	}
	public void setDocumentOf(String documentOf) {
		this.documentof = documentOf;
	}
	public String getDatePublished() {
		return datepublished;
	}
	public void setDatePublished(String datePublished) {
		this.datepublished = datePublished;
	}
	public String getDateModified() {
		return datemodified;
	}
	public void setDateModified(String dateModified) {
		this.datemodified = dateModified;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", hash=" + hash + ", format=" + format
				+ ", url=" + url + ", title=" + title + ", documentOf="
				+ documentof + ", datePublished=" + datepublished
				+ ", dateModified=" + datemodified + "]";
	}
	
	

}
