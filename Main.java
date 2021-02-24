package lara;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
public class Main {
public static void main(String[] args) {
// Dekommentieren Sie die Zeilen in den jeweiligen Methoden, um Ihre Lösung
// zu überprüfen!
task7();
task8();
task9();
task10();
}
private static void task7() {

VehicleCard peu = new VehicleCard("Peugeot Rifter", VehicleCard.newCategoriesMap(22600, 1899, 186, 7.9, 205, 8.5));
System.out.println(peu);
VehicleCard vw = new VehicleCard("VW Golf", VehicleCard.newCategoriesMap(15400, 1700, 160, 4.7, 220, 5.7));
System.out.println(vw);
VehicleCard bmw = new FoilVehicleCard("BMW G11", VehicleCard.newCategoriesMap(120000, 2500, 200, 6.8, 250,
9.4),Arrays.asList(VehicleCard.Category.CONSUMPTION_L));
System.out.println(bmw);
VehicleCard ast = new FoilVehicleCard("Aston Martin DB5", VehicleCard.newCategoriesMap(590000, 3995, 286, 7.1, 229,
10.4),Arrays.asList(VehicleCard.Category.PRICE_EUR,VehicleCard.Category.ENGINE_POWER_HP,VehicleCard.Category.VELOCITY_KMH));
System.out.println(ast);

/* Erwarteter Output
* - Peugeot Rifter(33280) -> {Hubraum=1899.0, Preis=22600.0, Leistung=186.0, Verbrauch=8.5, Beschleunigung 0=7.9, Geschwindigkeit=205.0
* - VW Golf(24999) -> {Hubraum=1700.0, Preis=15400.0, Leistung=160.0, Verbrauch=5.7, Beschleunigung 1=4.7, Geschwindigkeit=220.0
* - BMW G11(133838) -> {Hubraum=2500.0, Preis=120000.0, Leistung=200.0, *Verbrauch*=9.4, Beschleunigung 2=6.8, Geschwindigkeit=250.0
* - Aston Martin DB5(1203210) -> {Hubraum=3995.0, *Preis*=590000.0, *Leistung*=286.0, Verbrauch=10.4, Beschleunigung 3=7.1, *Geschwindigkeit*=229.0
*/
}
private static void task8() {
/*
VehicleCard peu = new VehicleCard("Peugeot Rifter", VehicleCard.newCategoriesMap(22600, 1899, 186, 7.9, 205, 8.5));
System.out.println(peu.getValue());
VehicleCard vw = new VehicleCard("VW Golf", VehicleCard.newCategoriesMap(15400, 1700, 160, 4.7, 220, 5.7));
System.out.println(vw.getValue());
VehicleCard bmw = new FoilVehicleCard("BMW G11", VehicleCard.newCategoriesMap(120000, 2500, 200, 6.8, 250,
9.4),Arrays.asList(VehicleCard.Category.CONSUMPTION_L));
System.out.println(bmw.getValue());
VehicleCard ast = new FoilVehicleCard("Aston Martin DB5", VehicleCard.newCategoriesMap(590000, 3995, 286, 7.1, 229,
10.4),Arrays.asList(VehicleCard.Category.PRICE_EUR,VehicleCard.Category.ENGINE_POWER_HP,VehicleCard.Category.VELOCITY_KMH));
System.out.println(ast.getValue());
*/
/* Erwarteter Output
* 24906.4
* 17490.4
* 17566.6
* 37157.96875
*/
}
private static void task9() {
/*
List<VehicleCard> l = new ArrayList<>(Arrays.asList(new VehicleCard("Peugeot Rifter", VehicleCard.newCategoriesMap(22600, 1899, 186, 7.9, 205, 8.5)),
new VehicleCard("VW Golf", VehicleCard.newCategoriesMap(15400, 1700, 160, 4.7, 220, 5.7)),
new FoilVehicleCard("BMW G11", VehicleCard.newCategoriesMap(120000, 2500, 200, 6.8, 250,
9.4),Arrays.asList(VehicleCard.Category.CONSUMPTION_L)),
new FoilVehicleCard("Aston Martin DB5", VehicleCard.newCategoriesMap(590000, 3995, 286, 7.1, 229,
10.4),Arrays.asList(VehicleCard.Category.PRICE_EUR,VehicleCard.Category.ENGINE_POWER_HP,VehicleCard.Category.VELOCITY_KMH))
));
List<VehicleCard> test = new ArrayList<>(l);
List<Integer> vals = new ArrayList<>(Arrays.asList(2000000,1000,30000,1000000));
for (Integer v : vals) {
test = new ArrayList<>(l);
select(test, v);
System.out.println(test);
}
*/
/* Erwarteter Output
* [- VW Golf(24999) -> {Preis=15400.0, Hubraum=1700.0, Geschwindigkeit=220.0, Verbrauch=5.7, Leistung=160.0, Beschleunigung 0=4.7, - Peugeot Rifter(33280)
-> {Preis=22600.0, Hubraum=1899.0, Geschwindigkeit=205.0, Verbrauch=8.5, Leistung=186.0, Beschleunigung 1=7.9, - BMW G11(133838) -> {Preis=120000.0, Hubraum=2500.0,
Geschwindigkeit=250.0, *Verbrauch*=9.4, Leistung=200.0, Beschleunigung 2=6.8, - Aston Martin DB5(1203210) -> {*Preis*=590000.0, Hubraum=3995.0, *Geschwindigkeit*=229.0,
Verbrauch=10.4, *Leistung*=286.0, Beschleunigung 3=7.1]
* []
* [- VW Golf(24999) -> {Preis=15400.0, Hubraum=1700.0, Geschwindigkeit=220.0, Verbrauch=5.7, Leistung=160.0, Beschleunigung 4=4.7]
* [- VW Golf(24999) -> {Preis=15400.0, Hubraum=1700.0, Geschwindigkeit=220.0, Verbrauch=5.7, Leistung=160.0, Beschleunigung 5=4.7, - Peugeot Rifter(33280)
-> {Preis=22600.0, Hubraum=1899.0, Geschwindigkeit=205.0, Verbrauch=8.5, Leistung=186.0, Beschleunigung 6=7.9, - BMW G11(133838) -> {Preis=120000.0, Hubraum=2500.0,
Geschwindigkeit=250.0, *Verbrauch*=9.4, Leistung=200.0, Beschleunigung 7=6.8]
*/
}
private static void task10() {

List<VehicleCard> l = new ArrayList<>(Arrays.asList(new VehicleCard("Peugeot Rifter", VehicleCard.newCategoriesMap(22600, 1899, 186, 7.9, 205, 8.5)),
new VehicleCard("VW Golf", VehicleCard.newCategoriesMap(15400, 1700, 160, 4.7, 220, 5.7)),
new FoilVehicleCard("BMW G11", VehicleCard.newCategoriesMap(120000, 2500, 200, 6.8, 250,
9.4),Arrays.asList(VehicleCard.Category.CONSUMPTION_L)),
new FoilVehicleCard("Aston Martin DB5", VehicleCard.newCategoriesMap(590000, 3995, 286, 7.1, 229,
10.4),Arrays.asList(VehicleCard.Category.PRICE_EUR,VehicleCard.Category.ENGINE_POWER_HP,VehicleCard.Category.VELOCITY_KMH)),
new VehicleCard("VW 1", VehicleCard.newCategoriesMap(15401, 1700, 160, 4.7, 220, 5.7)),
new FoilVehicleCard("BMW 1", VehicleCard.newCategoriesMap(120001, 2500, 200, 6.8, 250,
9.4),Arrays.asList(VehicleCard.Category.CONSUMPTION_L)),
new FoilVehicleCard("Aston 1", VehicleCard.newCategoriesMap(590001, 3995, 286, 7.1, 229,
10.4),Arrays.asList(VehicleCard.Category.PRICE_EUR,VehicleCard.Category.ENGINE_POWER_HP,VehicleCard.Category.VELOCITY_KMH)),
new FoilVehicleCard("Aston 2", VehicleCard.newCategoriesMap(590005, 3995, 286, 7.1, 229,
10.4),Arrays.asList(VehicleCard.Category.PRICE_EUR,VehicleCard.Category.ENGINE_POWER_HP,VehicleCard.Category.VELOCITY_KMH))
));
System.out.println(categorize(l));

/* Erwarteter Output
* {2499=[- VW Golf(24999) -> {Preis=15400.0, Hubraum=1700.0, Geschwindigkeit=220.0, Verbrauch=5.7, Leistung=160.0, Beschleunigung 0=4.7], 2500=[- VW
1(25000) -> {Preis=15401.0, Hubraum=1700.0, Geschwindigkeit=220.0, Verbrauch=5.7, Leistung=160.0, Beschleunigung 1=4.7], 3328=[- Peugeot Rifter(33280) -> {Preis=22600.0,
Hubraum=1899.0, Geschwindigkeit=205.0, Verbrauch=8.5, Leistung=186.0, Beschleunigung 2=7.9], 13383=[- BMW G11(133838) -> {Preis=120000.0, Hubraum=2500.0,
Geschwindigkeit=250.0, *Verbrauch*=9.4, Leistung=200.0, Beschleunigung 3=6.8, - BMW 1(133839) -> {Preis=120001.0, Hubraum=2500.0, Geschwindigkeit=250.0, *Verbrauch*=9.4,
Leistung=200.0, Beschleunigung 4=6.8], 120321=[- Aston Martin DB5(1203210) -> {*Preis*=590000.0, Hubraum=3995.0, *Geschwindigkeit*=229.0, Verbrauch=10.4, *Leistung*=286.0,
Beschleunigung 5=7.1, - Aston 1(1203212) -> {*Preis*=590001.0, Hubraum=3995.0, *Geschwindigkeit*=229.0, Verbrauch=10.4, *Leistung*=286.0, Beschleunigung 6=7.1], 120322=[-
Aston 2(1203220) -> {*Preis*=590005.0, Hubraum=3995.0, *Geschwindigkeit*=229.0, Verbrauch=10.4, *Leistung*=286.0, Beschleunigung 7=7.1]}
*/
}

public static void select(List<VehicleCard> l, int limit) {
	List<VehicleCard>help=new ArrayList<>();
	for(VehicleCard card: l) {
		if( card.totalBonus()>limit) {
			help.add(card);
		}
		}
	l.removeAll(help);
	Comparator<VehicleCard> compareByFirstName = (VehicleCard o1, VehicleCard o2) -> o1.getName().compareTo( o2.getName() );
	Collections.sort(l, compareByFirstName.reversed());
	
}

        
public static TreeMap<Integer, List<VehicleCard>> categorize(List<VehicleCard> l){
	
	TreeMap<Integer,List<VehicleCard>>category=new TreeMap<>();
	List<Integer> hilfe = new ArrayList<>();
	List<VehicleCard> list = new ArrayList<>();
	for(VehicleCard cat: l) {
		int n = cat.totalBonus()/10;
		hilfe.add(n);
		}
	for(int i = 0; i < l.size();i++) {
		int a = hilfe.get(i);
		for(VehicleCard card : l) {
		if((a*10)<= card.totalBonus() && card.totalBonus() < (a+1)*10) {
					list.add(card);
	}
	category.put(a, list);
		}
	}
	entriesSortedByValues(category);
	return category;
	}
	


private static SortedSet<Entry<Integer,List<VehicleCard>>> entriesSortedByValues(TreeMap<java.lang.Integer, java.util.List<VehicleCard>> category) {
	// TODO Auto-generated method stub
	
	    SortedSet<Map.Entry<Integer,List<VehicleCard>>> sortedEntries = new TreeSet<Map.Entry<Integer,List<VehicleCard>>>(
	        new Comparator<Map.Entry<Integer,List<VehicleCard>>>() {
	            @Override public int compare(Map.Entry<Integer,List<VehicleCard>> e1, Map.Entry<Integer,List<VehicleCard>> e2) {
	                int res = e1.getKey().compareTo(e2.getKey());
	                return res != 0 ? res : 1;
	            } }
	    	    );
	    	    sortedEntries.addAll((Collection<? extends Entry<Integer, List<VehicleCard>>>) category.entrySet());
	    	    return sortedEntries;
} 
 } 