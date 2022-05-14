package pe.edu.upc.FavEat.business.crud.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.FavEat.business.crud.MenuRestaurantService;
import pe.edu.upc.FavEat.model.entity.MenuRestaurant;
import pe.edu.upc.FavEat.model.repository.JpaRepository;
import pe.edu.upc.FavEat.model.repository.MenuRestaurantRepository;

@Named
@ApplicationScoped
public class MenuRestaurantServiceImpl implements MenuRestaurantService{

	@Inject
	private MenuRestaurantRepository menuRestaurantRepository;
	
	@Override
	public JpaRepository<MenuRestaurant, Integer> getJpaRepository() {
		return menuRestaurantRepository;
	}

}
