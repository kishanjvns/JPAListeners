package com.example.demo;


import java.util.Date;

import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UpdatedAtListener {
	
	//@PrePersist
	//@PreUpdate
	@PostUpdate
	public void setUpdatedAt(final Updatable entity) {
		entity.setUpdatedAt(new Date());
	}
	
	
}