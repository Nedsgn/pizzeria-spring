package fr.nedjma.pizzeria.pizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.nedjma.pizzeria.pizza.domain.Pizza;

@Repository
public interface IPizzaRepository extends JpaRepository<Pizza, Integer> {//on met le nom de la class Bean(domain) plus la clé primaire qui est en Integer

}
