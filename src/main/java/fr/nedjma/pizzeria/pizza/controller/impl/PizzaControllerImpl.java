package fr.nedjma.pizzeria.pizza.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.nedjma.pizzeria.pizza.controller.IPizzaController;
import fr.nedjma.pizzeria.pizza.domain.Pizza;
import fr.nedjma.pizzeria.pizza.service.impl.PizzaServiceImpl;

@Controller

public class PizzaControllerImpl implements IPizzaController{

	Logger log = LoggerFactory.getLogger(PizzaControllerImpl.class);
	@Autowired
	PizzaServiceImpl pizzaService;
	
	@Override
	@RequestMapping("pizza/pizza-accueil")
	public String getAll(Model model) {
List<Pizza> liste =pizzaService.findAll();
model.addAttribute("pizzas",liste);
return "pizzaAccueil";
	}

	@Override
	@RequestMapping("/pizza/pizza-info")
	public String getOne(Model model, @RequestParam("id")Integer id) {
		log.info("ID= {} ",id);//pour voir si on a recuperé l'id, si c'sst noté : null c'est qu'on la pas
		Pizza pizzas = pizzaService.getOne(id);
		log.info("pizza: " + pizzas.getLibelle());
		log.debug("Description: {}",pizzas.getDescription());//les accolades sont un emplacement pour accueillir le getdescription
		log.warn("url de la pizza :{}", pizzas.getUrlImg());
		model.addAttribute("pizzaInfos",pizzas);

		return "pizzaInfo";
	}

	@Override
	@GetMapping("/pizza-ajouter")//on recupere ce qu'il y a dans le formulaire 
	public String addOne(Model model) {
		Pizza piz = new Pizza();
		model.addAttribute("pizzas", piz);
		return "pizzaAjouter";
	}

	@Override
	@PostMapping("pizza-add")
	public String addValidForm(Model model, Pizza pizzas) {
		 pizzaService.ajouter(pizzas);
		return "redirect:/pizza-accueil";
	}

	@Override
	@GetMapping("/pizza-supprimer")
	public String supprimer(Model model, Integer id) {
		 pizzaService.supprimer(id);
		return "redirect:/pizza-accueil";
	}

	@Override
	@GetMapping("/pizza-modifier")
	public String modifierPizza(Model model, Integer id) {
		Pizza pizzas = pizzaService.getOne(id);
		model.addAttribute("pizzaInfos",pizzas);	
		return "pizzaModifier";
	}

	@Override
	@PostMapping("/modifier")
	public String validerModifierPizza(Model model, Pizza pizzas) {
pizzaService.mofidier(pizzas);		
return "redirect:/pizza-accueil";
	}

}
