package com.kyungmin.exampleSpringSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyungmin.exampleSpringSecurity.dao.OfferDao;
import com.kyungmin.exampleSpringSecurity.model.Offer;

@Service
public class OfferService {
	
	@Autowired
	private OfferDao offerDao;
	
	public List<Offer> getCurrent() {
		return offerDao.getAllOffer();
	}
	
	public void insert(Offer offer) {
		offerDao.insert(offer);
	}

}
