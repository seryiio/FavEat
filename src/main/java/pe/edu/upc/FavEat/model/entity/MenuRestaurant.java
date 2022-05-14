package pe.edu.upc.FavEat.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "menu_restaurants", indexes = {@Index(columnList = "type_menu_restaurant", name = "menu_restaurants_index_type_menu_restaurant")})
public class MenuRestaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "type_menu_restaurant", length = 20, nullable = false)
	private String type;

	@Column(name = "descriptions", length = 40, nullable = false)
	private String description;
	
	@OneToMany(mappedBy = "menuRestaurant")
	private List<Food> foods;
	
	public MenuRestaurant() {
		foods = new ArrayList<>();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
