package lara;

import java.util.List;
import java.util.Map;

import lara.VehicleCard.Category;

public class FoilVehicleCard extends VehicleCard implements Valuable{
	private List<Category> specials;
public FoilVehicleCard(String name, Map<Category, Double> categories,List<Category>specials) {
		super(name, categories);
		if(specials==null || specials.contains(null) || specials.size()>3) throw new IllegalArgumentException();
		this.specials=specials;
		
	}
/*
@Override
public int totalBonus() {
	int specialTotalBonus = super.totalBonus();
	
	Map<Category, Double> categories = super.getCategories();
	
	// Special Categories bonus points are doubled.
	for(Category cat : this.specials) {
		Double normalCategory = categories.get(cat);
		specialTotalBonus += cat.bonus(normalCategory);
	}
	
	return specialTotalBonus;
} */
@Override
protected int getBonus(Category category) {
	int specialTotalBonus = super.totalBonus();
	Map<Category, Double> categories = super.getCategories();
	for(Category cat : this.specials) {
		Double normalCategory = categories.get(cat);
		specialTotalBonus += cat.bonus(normalCategory);
	} return specialTotalBonus;
}
@Override
protected String categoryToString(Category category) {
	 String strn = "";

     if(specials.contains(category)){
         strn += ("*" + category.toString() + "*");
     }else{
         strn += category.toString();
     }

     return strn;

}
@Override
public double getValue() {
	double sum=0;
	double help=super.getValue();
	double help2=this.getName().length();
	sum=help/help2;
	return sum;
}
/*
public double getValue() {
	double sum=0;
	sum=super.getValue()/this.getName().length();
	return sum;
}*/

}
