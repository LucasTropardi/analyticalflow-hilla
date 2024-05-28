package com.ltsoftwaresupport.analyticalflow.builder;

import com.ltsoftwaresupport.analyticalflow.model.Author;
import com.ltsoftwaresupport.analyticalflow.model.AuthorType;

/**
 * @author Lucas Tropardi
 * 26 de Mai. de 2024
 */
public class AuthorBuilder {
	
	private Author author;

	public static AuthorBuilder build() {
		AuthorBuilder authorBuilder = new AuthorBuilder();
		authorBuilder.author = new Author();
		authorBuilder.author.setId(0L);
		authorBuilder.author.setName("Juvenilson");
		authorBuilder.author.setType(AuthorType.BOOK);
		return authorBuilder;
	}

	public AuthorBuilder addName(String name) {
		author.setName(name);
		return this;
	}

	public AuthorBuilder addType(AuthorType type) {
		author.setType(type);
		return this;
	}

	public Author now() {
		return author;
	}

}
