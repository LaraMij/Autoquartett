package lara;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class VehicleCard implements Comparable<VehicleCard>, Valuable{
public enum Category {
//values:
PRICE_EUR("Preis",1), 
CYLINDER_CAPACITY_CM3("Hubraum",5), 
ENGINE_POWER_HP("Leistung",4), 
ACCELERATION_SEC("Beschleunigung",3){
	int counter=0;
	@Override
	public String toString() {
		
		return "Beschleunigung "+counter++;
	}
},
VELOCITY_KMH("Geschwindigkeit",2), 
CONSUMPTION_L("Verbrauch",0){
	@Override
	public int bonus(Double value) {
		int sum=(int)(value+getFactor());
		return sum;
	}
};
final private String categoryName;
final private int factor;
private Category(String categoryName,int factor) {
	
	if(categoryName==null ||categoryName.isEmpty()|| factor<0) {
		throw new IllegalArgumentException();
	}
	this.categoryName=categoryName;
	this.factor=factor;
   }
public int getFactor() {
	return this.factor;
}
public int bonus(Double value) {
	int sum=(int)(value*getFactor());
	return sum;
}
@Override
public String toString() {
	return categoryName;
}
}
private String name;
private Map<Category,Double>categories;
EnumSet<Category>help=EnumSet.allOf(Category.class);
public VehicleCard(String name, Map<Category, Double> categories) {
	
	if(name == null) {
		throw new IllegalArgumentException("Name ist null!");
	}
	if(name=="") throw new IllegalArgumentException("Name ist leer!");
	this.name = name;
	
	if(categories == null) {
		throw new IllegalArgumentException("Categories are null!");
	}
	
	if(categories.size() < 6) {
		throw new IllegalArgumentException("Not every Category exists in categories!");
	}
	
	for(Category c : categories.keySet()) {
		if(c == null) {
			throw new IllegalArgumentException("Category doesn't exists.");
		}
	}
	
	for (Double c : categories.values()) {
		if(c == null || c < 0) {
			throw new IllegalArgumentException("Categorys value is less than zero.");
		}
	}
	
	this.categories = categories;
	this.name = name;
	//throws IllegalArgumentException if categories any null value or values less than 0
	// set member variables
}

public String getName() {
	return this.name;
}
public Map<Category,Double>getCategories(){
	return this.categories;
}
@Override
public int compareTo(VehicleCard other) {
	if (this.totalBonus() > other.totalBonus())
		return 1;
	if (this.totalBonus() < other.totalBonus())
		return -1;

	return 0;
}
protected int getBonus(Category category) {
	for(Category cat:categories.keySet()) {
		if(cat==category) {
			double a=categories.get(cat);
			return category.bonus(a);
		}
	} return 0;
}
public int totalBonus() {
	double result = 0;
	
	for(Map.Entry<Category, Double> e: categories.entrySet()) {
		result += e.getKey().bonus(e.getValue());
		// result += ENUM_Type.bonus(Map_Value);
	}		
	return (int)(result);
}
public static Map<Category, Double> newCategoriesMap(double velo, double pwr, double price, double capa, double cons,
		double acc) {

	Map<Category,Double> ret = new HashMap<>();

	ret.put(Category.PRICE_EUR, price);
	ret.put(Category.CYLINDER_CAPACITY_CM3, capa);
	ret.put(Category.ENGINE_POWER_HP, pwr);
	ret.put(Category.ACCELERATION_SEC, acc);
	ret.put(Category.VELOCITY_KMH, velo);
	ret.put(Category.CONSUMPTION_L, cons);

	return ret;
}
protected String categoryToString(Category category) {
	return category.toString();
}
@Override
public String toString() {
	int cnt = 0;
	String ret =  "- " + name + "(" + totalBonus() + ") -> {";
	for (Map.Entry<Category, Double> i : categories.entrySet()){
		ret += (categoryToString(i.getKey()) + "=" + i.getValue());
		cnt++;
		if (categories.size() > cnt) {
			ret += ", ";
		}
	}
	ret += "}";

	return ret;
}

@Override
public double getValue() {
	double sum=0;
	for(Category a:categories.keySet()) {
		double b=categories.get(a);
		sum+=b;
	} return sum;
}
}


