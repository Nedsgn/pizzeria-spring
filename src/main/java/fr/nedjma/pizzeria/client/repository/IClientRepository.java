package fr.nedjma.pizzeria.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.nedjma.pizzeria.client.domain.Client;



@Repository
public interface IClientRepository extends JpaRepository<Client, Integer>  {
	 
}
