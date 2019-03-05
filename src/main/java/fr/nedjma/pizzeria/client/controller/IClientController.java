package fr.nedjma.pizzeria.client.controller;

import org.springframework.ui.Model;

import fr.nedjma.pizzeria.client.domain.Client;

public interface IClientController {
	public String findAll(Model model);
	public String findOne(Model model, Integer id);
	public String addClient(Model model,Integer id);
	public String AddValidForm(Model model, Client client);
	public String supprClient(Model model, Integer id);
	public String modifClient(Model model, Integer id);
	public String modifClientValid(Model model, Client client);

}
