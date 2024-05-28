package com.ltsoftwaresupport.analyticalflow.model;

import lombok.Getter;

/**
 * @author Lucas Tropardi
 * 26 de Mai. de 2024
 */
public enum AuthorType {
	BOOK("Livros"),
    MOVIE("Filmes"),
    MUSIC("Músicas"),
    SERIE("Series");

	@Getter
	private String authorType;
	
	AuthorType(String authorType) {
		this.authorType = authorType;
	}
	
	@Override
    public String toString() {
        return this.authorType;
    }
}
