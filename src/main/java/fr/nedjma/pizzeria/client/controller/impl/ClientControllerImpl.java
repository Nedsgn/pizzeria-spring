package fr.nedjma.pizzeria.client.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.nedjma.pizzeria.client.controller.IClientController;
import fr.nedjma.pizzeria.client.domain.Client;
import fr.nedjma.pizzeria.client.service.impl.ClientServiceImpl;



@Controller



public class ClientControllerImpl implements IClientController {

	Logger log = LoggerFactory.getLogger(ClientControllerImpl.class);


	@Autowired
	ClientServiceImpl clientService;

	@Override
	@GetMapping("client-accueil")
	public String findAll(Model model) {
		List<Client> clients = clientService.findAll();
		log.info("taille du tableau de Client ===> {}", clients.size() );
		model.addAttribute("client", clients);
		return "client/clientAccueil";
	}

	@Override
	@GetMapping("client-info")
	public String findOne(Model model, @RequestParam("id") Integer id) {
		Client cli = clientService.findOne(id);
		model.addAttribute("clientInfos", cli);
		return "client/clientInfo";
	}

	@Override
	@GetMapping("client-ajouter")
	public String addClient(Model model, Integer id) {
		Client cli = new Client ();//on crée un objet vide qu'on va transmettre à la vue, ce dernier sera le nom du th:object qui pert de recup les données avec th:field
		model.addAttribute("clientAdd", cli);// model.addAttribute : ça transmet à la vue
		return "client/clientAjouter";
	}

	
	@Override
	@PostMapping("add-client")
	public String AddValidForm(Model model, @ModelAttribute("clientAdd") Client clientAdd) {
		clientService.addClient(clientAdd);	
	
		return  "redirect:client-accueil";
	}

	@Override
	@GetMapping("client-supprimer")
	public String supprClient(Model model, Integer id) {
		clientService.supprimer(id);
		return "redirect:client-accueil";
	}



	@Override
	@GetMapping("/client-modifier")
	public String modifClient(Model model, Integer id) {
		Client cli = clientService.findOne(id);
		model.addAttribute("clientInfo", cli);
		return "client/clientModifier";
	}

	@Override
	@PostMapping("/modifier-client")
	public String modifClientValid(Model model, Client clients) {
		clientService.modifier(clients);
		return "redirect:client-accueil";
	}

}
