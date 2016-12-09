package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import main.entity.Bank;
import main.entity.Client;
import main.repository.BankRepository;
import main.repository.ClientRepository;

@Controller
public class AppController {
	@Autowired
	private BankRepository bankRepository;
	@Autowired
	private ClientRepository clientRepository;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String printWelcome(ModelMap model){
		model.addAttribute("title","Spring MVC + MVN + @JavaConfig");
		return "index";
	}
	
	@RequestMapping(value="/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name){
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("msg", name);
		return model;
	}
	
	@RequestMapping(value="/addbank", method = RequestMethod.GET)
	public ModelAndView addBank(@ModelAttribute("Bank")Bank bank, BindingResult result){
			
		//test block
		Bank bank1 = new Bank("Bank");
		bankRepository.save(bank1);
		Client client = new Client();
		client.setAddress("Adress");
		client.setBank(bank1);
		client.setEmail("test@email.com");
		client.setFirstName("first name");
		client.setLastName("last name");
		clientRepository.save(client);
		//
		
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
}
