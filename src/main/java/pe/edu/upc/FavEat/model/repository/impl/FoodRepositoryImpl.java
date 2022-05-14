package pe.edu.upc.FavEat.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.FavEat.model.entity.Food;
import pe.edu.upc.FavEat.model.repository.FoodRepository;

@Named
@ApplicationScoped
public class FoodRepositoryImpl implements FoodRepository{

	@PersistenceContext(unitName = "FavEatPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public Optional<Food> findById(Integer id) throws Exception {
		return this.findById(id, Food.class);
	}

	@Override
	public List<Food> findAll() throws Exception {
		String jpql = "SELECT foods FROM Food foods";
		return this.findByQuery(Food.class, jpql);
	}

	@Override
	public List<Food> findByData(String data) throws Exception {
		String jpql = "SELECT foods FROM Food foods WHERE foods.foodName LIKE '%" + data + "%'";
		return this.findByQuery(Food.class, jpql);
	}

	@Override
	public List<Food> findByfoodName(String foodName) throws Exception {
		String jpql = "SELECT foods FROM Food foods WHERE foods.foodName = '" + foodName;
		return this.findByQuery(Food.class, jpql);
	}

}
