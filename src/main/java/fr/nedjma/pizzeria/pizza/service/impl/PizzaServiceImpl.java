package fr.nedjma.pizzeria.pizza.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.nedjma.pizzeria.pizza.domain.Pizza;
import fr.nedjma.pizzeria.pizza.repository.IPizzaRepository;
import fr.nedjma.pizzeria.pizza.service.IPizzaService;

@Service
public class PizzaServiceImpl implements IPizzaService {

	@Autowired
	IPizzaRepository pizzaRepository;

	@Override
	public List<Pizza> findAll() {
		List<Pizza> liste=pizzaRepository.findAll();
		return liste;
	}

	@Override
	public Pizza getOne(Integer id) {
		Pizza pi =	pizzaRepository.getOne(id);
		return pi;
	}

	@Override
	public void ajouter(Pizza pizzas) {
		pizzaRepository.save(pizzas);		
	}

	@Override
	public void supprimer(Integer id) {
		pizzaRepository.deleteById(id);
		
	}

	@Override
	public void mofidier(Pizza pizzas) {
		pizzaRepository.save(pizzas);
		
	}



}
