package com.example.demo;

import java.util.Date;

import javax.persistence.PostUpdate;

public class TitleListener {
	@PostUpdate
	public void setTitle(final Updatable entity) {
		System.out.println("I have been modified");
	}	
}
