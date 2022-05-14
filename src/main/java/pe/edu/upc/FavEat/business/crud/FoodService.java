package pe.edu.upc.FavEat.business.crud;

import java.util.List;

import pe.edu.upc.FavEat.model.entity.Food;

public interface FoodService extends CrudService<Food, Integer>{
	List<Food> findByfoodName(String foodName) throws Exception;

}
