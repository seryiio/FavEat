package pe.edu.upc.FavEat.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.FavEat.model.entity.Food;
import pe.edu.upc.FavEat.model.entity.MenuRestaurant;
import pe.edu.upc.FavEat.business.crud.CrudService;
import pe.edu.upc.FavEat.business.crud.FoodService;

@Named("foodView")
@ViewScoped
public class FoodView implements Serializable, EntityView<Food, Integer>{

	private static final long serialVersionUID = 1L;
	
	private List<Food> entities;	
	private Food entitySelected;
	private List<Food> entitiesSelected;
	private Food entitySearch;
	
	@Inject
	private FoodService entityService;
	
	@PostConstruct
	public void init() {
		this.entitiesSelected = new ArrayList<>();
		this.entitySearch = new Food();
		getAllEntities();
	}
	
	
	@Override
	public CrudService<Food, Integer> getCrudService() {
		return this.entityService;
	}

	@Override
	public void createNew() {
		this.entitySelected = new Food();		
		this.entitySelected.setMenuRestaurant(new MenuRestaurant());
	}

	@Override
	public Integer getIdFromEntitySelected() {
		return this.entitySelected.getFoodId();
	}

	@Override
	public void searchEntity() {
		try {	
			this.entities = this.entityService.search(this.entitySearch.getFoodName());
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}


	public List<Food> getEntities() {
		return entities;
	}


	public void setEntities(List<Food> entities) {
		this.entities = entities;
	}


	public Food getEntitySelected() {
		return entitySelected;
	}


	public void setEntitySelected(Food entitySelected) {
		this.entitySelected = entitySelected;
	}


	public List<Food> getEntitiesSelected() {
		return entitiesSelected;
	}


	public void setEntitiesSelected(List<Food> entitiesSelected) {
		this.entitiesSelected = entitiesSelected;
	}


	public Food getEntitySearch() {
		return entitySearch;
	}


	public void setEntitySearch(Food entitySearch) {
		this.entitySearch = entitySearch;
	}


	public FoodService getEntityService() {
		return entityService;
	}


	public void setEntityService(FoodService entityService) {
		this.entityService = entityService;
	}

}
