package fr.nedjma.pizzeria.client.service;

import java.util.List;

import fr.nedjma.pizzeria.client.domain.Client;



public interface IClientService {
public List<Client> findAll();
public Client findOne(Integer id);
public void addClient(Client clients);
public void supprimer (Integer id);
public void modifier (Client clients);
}
