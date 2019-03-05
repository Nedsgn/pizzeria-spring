package fr.nedjma.pizzeria.pizza.service;

import java.util.List;

import fr.nedjma.pizzeria.pizza.domain.Pizza;


public interface IPizzaService {

	public List<Pizza> findAll();
	public Pizza getOne(Integer id);//on retourne un objet pizza
	public void ajouter(Pizza pizzas);
	public void supprimer(Integer id);
	public void mofidier(Pizza pizzas);
}
