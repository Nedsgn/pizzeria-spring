package fr.nedjma.pizzeria.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.nedjma.pizzeria.client.domain.Client;
import fr.nedjma.pizzeria.client.repository.IClientRepository;
import fr.nedjma.pizzeria.client.service.IClientService;

@Service

public class ClientServiceImpl implements IClientService{

	@Autowired
	IClientRepository clientRepository;
	
	@Override
	public List<Client> findAll() {
		List<Client> clients = 	clientRepository.findAll();
				
				return clients;
	}

	@Override
	public Client findOne(Integer id) {
		Client cli = clientRepository.getOne(id);
		return cli;
	}

	@Override
	public void addClient(Client clients) {
clientRepository.save(clients);		
	}

	@Override
	public void supprimer(Integer id) {
		clientRepository.deleteById(id);
		
	}

	@Override
	public void modifier(Client clients) {
		clientRepository.save(clients);	
		
	}

	
	

}
