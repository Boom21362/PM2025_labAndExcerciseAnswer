package logic;

public class CardCounter {
	
	private UnitCard card;
	private int count;
	


	public CardCounter(UnitCard card, int count){
		this.setCard(card);
		this.setCount(count);
	}

	public 	void setCount(int newCount){
		this.count = Math.max(newCount, 0);
	}

	public void setCard(UnitCard card){
		this.card = card;
	}

	public int getCount(){
		return count;
	}

	public UnitCard getCard() {
		return card;
	}
	public String toString() {
		return  this.getCard() + " x " + this.getCount();
	}
}
