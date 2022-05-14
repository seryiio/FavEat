package pe.edu.upc.FavEat.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.FavEat.business.crud.FoodService;
import pe.edu.upc.FavEat.model.entity.Food;
import pe.edu.upc.FavEat.model.repository.FoodRepository;
import pe.edu.upc.FavEat.model.repository.JpaRepository;

@Named
@ApplicationScoped
public class FoodServiceImpl implements FoodService{

	@Inject
	private FoodRepository foodRepository;
	
	@Override
	public JpaRepository<Food, Integer> getJpaRepository() {
		return foodRepository;
	}

	@Override
	public List<Food> findByfoodName(String foodName) throws Exception {
		return this.foodRepository.findByfoodName(foodName);
		}

}
