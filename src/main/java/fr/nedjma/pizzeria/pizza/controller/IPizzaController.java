package fr.nedjma.pizzeria.pizza.controller;

import org.springframework.ui.Model;

import fr.nedjma.pizzeria.pizza.domain.Pizza;

public interface IPizzaController {
public String getAll(Model model);
public String getOne(Model model, Integer id);
public String addOne(Model model);
public String addValidForm(Model model, Pizza pizzas);
public String supprimer(Model model, Integer id);
public String modifierPizza(Model model, Integer id );//c'est un objet pizza qui existe déjà il nous faut son id pour pouvoir le modifier
public String validerModifierPizza(Model model, Pizza pizzas);
}
