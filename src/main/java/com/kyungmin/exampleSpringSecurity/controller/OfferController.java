package com.kyungmin.exampleSpringSecurity.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kyungmin.exampleSpringSecurity.model.Offer;
import com.kyungmin.exampleSpringSecurity.service.OfferService;

@Controller
public class OfferController {
	
	@Autowired
	private OfferService offerService;
	
	//현재 DB에 저장된 offer 출력
	@RequestMapping(value="/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offerService.getCurrent();
		
		model.addAttribute("offers", offers);
		
		return "offers";
	}
	
	//새로운 offer 생성
	@RequestMapping(value="/createoffer")
	public String createOffer(Model model) {
		
		model.addAttribute("offer", new Offer());
		
		return "createoffer";
	}
	
	@RequestMapping(value="/docreate")
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		
		//Offer 객체에 대한 검증
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			
			//콘솔에 에러 메시지 출력
			for(ObjectError error: errors)
				System.out.println(error.getDefaultMessage());
			
			return "createoffer";
		}
		
		offerService.insert(offer);
		
		return "offercreated";
	}

}
