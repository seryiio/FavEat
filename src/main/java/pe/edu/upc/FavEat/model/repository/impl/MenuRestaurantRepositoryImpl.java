package pe.edu.upc.FavEat.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.FavEat.model.entity.MenuRestaurant;
import pe.edu.upc.FavEat.model.repository.MenuRestaurantRepository;

@Named
@ApplicationScoped
public class MenuRestaurantRepositoryImpl implements MenuRestaurantRepository{

	@PersistenceContext(unitName = "FavEatPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public Optional<MenuRestaurant> findById(Integer id) throws Exception {
		return this.findById(id, MenuRestaurant.class);
	}

	@Override
	public List<MenuRestaurant> findAll() throws Exception {
		String jpql = "SELECT menu_restaurants FROM MenuRestaurant menu_restaurants";
		return this.findByQuery(MenuRestaurant.class, jpql);
	}

	@Override
	public List<MenuRestaurant> findByData(String data) throws Exception {
		String jpql = "SELECT menu_restaurants FROM MenuRestaurant menu_restaurants WHERE menu_restaurants.type LIKE '%" + data + "%'";
		return this.findByQuery(MenuRestaurant.class, jpql);
	}

}
