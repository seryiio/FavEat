package pe.edu.upc.FavEat.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

import pe.edu.upc.FavEat.business.crud.CrudService;
import pe.edu.upc.FavEat.business.crud.MenuRestaurantService;
import pe.edu.upc.FavEat.model.entity.MenuRestaurant;

@Named("menuRestaurantView")
@ViewScoped
public class MenuRestaurantView implements Serializable, EntityView<MenuRestaurant, Integer>{
		
	private static final long serialVersionUID = 1L;
	
	private List<MenuRestaurant> entities;	
	private MenuRestaurant entitySelected;
	private List<MenuRestaurant>entitiesSelected;
	private MenuRestaurant entitySearch;
	
	@Inject
	private MenuRestaurantService entityService;
	
	@PostConstruct
	public void init() {
		this.entitiesSelected = new ArrayList<>();
		this.entitySearch = new MenuRestaurant();
		getAllEntities();
	}
	
	@Override
	public CrudService<MenuRestaurant, Integer> getCrudService() {
		return this.entityService;
	}

	@Override
	public void createNew() {
		this.entitySelected = new MenuRestaurant();		
	}

	@Override
	public Integer getIdFromEntitySelected() {
		return this.entitySelected.getId();
	}

	@Override
	public void searchEntity() {
		try {	
			this.entities = this.entityService.search(this.entitySearch.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}


	@Override
	public List<MenuRestaurant> getEntities() {
		return entities;
	}


	@Override
	public void setEntities(List<MenuRestaurant> entities) {
		this.entities = entities;
		
	}

	@Override
	public List<MenuRestaurant> getEntitiesSelected() {
		return entitiesSelected;
	}


	@Override
	public MenuRestaurant getEntitySelected() {
		return entitySelected;
	}


	@Override
	public void setEntitySelected(MenuRestaurant entitySelected) {
		this.entitySelected = entitySelected;
		
	}


	public MenuRestaurant getEntitySearch() {
		return entitySearch;
	}


	public void setEntitySearch(MenuRestaurant entitySearch) {
		this.entitySearch = entitySearch;
	}


	public MenuRestaurantService getEntityService() {
		return entityService;
	}


	public void setEntityService(MenuRestaurantService entityService) {
		this.entityService = entityService;
	}


	public void setEntitiesSelected(List<MenuRestaurant> entitiesSelected) {
		this.entitiesSelected = entitiesSelected;
	}

}
