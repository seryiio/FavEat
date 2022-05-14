package pe.edu.upc.FavEat.model.repository;

import java.util.List;

import pe.edu.upc.FavEat.model.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Integer>{
	List<Food> findByfoodName(String foodName) throws Exception;

}