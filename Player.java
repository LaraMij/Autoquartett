package lara;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Player implements Comparable<Player> {
private String name;
private Queue<VehicleCard>deck=new ArrayDeque();
public Player(String name) {
	if(name==null||name.isEmpty()) throw new IllegalArgumentException();
	this.name=name;
}
public String getName() {
	return this.name;
}
public void addCards(Collection<VehicleCard>cards) {
	deck.addAll(cards);
}
public void addCard(VehicleCard card) {
	deck.add(card);
}
public void clearDeck() {
	deck.clear();
}
public VehicleCard playNextCard() {
 return deck.poll();
	}
public int totalBonus() {
	int sum=0;
	for(VehicleCard i:deck) {
		sum+=i.totalBonus();
	} return sum;
}
public int compareTo(Player other) {
	int compareValue = this.name.compareToIgnoreCase(name);
	return compareValue;
}
@Override
public boolean equals(Object o) {
	if (this == o)
		return true;
	if (o == null || getClass() != o.getClass())
		return false;
	Player player = (Player) o;
	return name.equalsIgnoreCase(player.name) && deck.equals(player.deck); // brauchenn wir hier deck
}

@Override
public int hashCode() {
	return Objects.hash(name.toLowerCase());
}
public boolean challengePlayer(Player p) {
	boolean winner=false;
	VehicleCard x=p.deck.peek();
	VehicleCard y=this.deck.peek();
	List<VehicleCard>thiscards=new ArrayList<>();
	List<VehicleCard>pcards=new ArrayList<>();
	if(p==null||p==this) {
		throw new IllegalArgumentException();
	}
	VehicleCard a=p.playNextCard();
	VehicleCard b=this.playNextCard();
	if(a.compareTo(b)>0) {
		if(a.totalBonus()>b.totalBonus()) {
			p.deck.add(b);
			p.deck.add(a);
		}
		else if(b.totalBonus()>a.totalBonus()) {
			this.deck.add(a);
			this.deck.add(b);
		}
		if(this.deck.isEmpty() && !p.deck.isEmpty()) {
			p.deck.addAll(pcards);
			p.deck.addAll(thiscards);
			return false;
		}
		if(p.deck.isEmpty() && !this.deck.isEmpty()) {
			this.deck.addAll(pcards);
			this.deck.addAll(thiscards);
			winner=true;
			return true;
		}
	}
	while(a.compareTo(b)==0) {
		
		thiscards.add(y);
		pcards.add(x);
		this.playNextCard();
		p.playNextCard();
		if(this.deck.isEmpty() || p.deck.isEmpty()) {
			this.deck.addAll(thiscards);
			p.deck.addAll(pcards);
		}
		if(this.deck.isEmpty() && !p.deck.isEmpty()) {
			p.deck.addAll(pcards);
			p.deck.addAll(thiscards);
			return false;
		}
		if(p.deck.isEmpty() && !this.deck.isEmpty()) {
			this.deck.addAll(pcards);
			this.deck.addAll(thiscards);
			winner=true;
			return true;
		}
	}
  return winner;
}
public static Comparator<Player> compareByBonus(){
	return Comparator.comparingInt(Player::totalBonus);
}
public static Comparator<Player> compareByDeckSize(){
	return Comparator.comparingInt(s -> s.deck.size());
}
@Override
public String toString() {
	int myTotalBonus = 0;
	for(VehicleCard card : this.deck) {
		myTotalBonus += card.totalBonus();
	}
	
	String output = name + "(" + myTotalBonus + "):\n";
	
	for(VehicleCard card : this.deck) {
		output += "\t - " + card.toString() + "\n";
	}
	
	return output;
}

}
