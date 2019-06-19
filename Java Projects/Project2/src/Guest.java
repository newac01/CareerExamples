//Aaron New
//CS161 
// Player Class project 2
public class Guest extends Player {
	Card[] guestHand;
	
	public Guest(Deck currentDeck) {
		super(currentDeck);
		guestHand = super.getCurrentHand();
	}
	// guests stand method
	// guest will stand if value is larger than 16 but less than 18 half of the time
	// guest will stand always when value is larger than 19
	public boolean stand() {
		
		if (super.bust() == false) {
			int temp = valueOf();
			if ((temp >= 16) && (temp <= 18)) {
				// half of the time will stand if value is between the above ^
				if(Math.random() > .5){
					return true;
				}else{
					return false;
				}
			} else if (temp >= 19) {
				return true;
			}
		}
		return false;
	}

	// gets the value of the cards in guests hand
	public int valueOf() {
		int sum = super.getValue();
		return sum;
	}
	
}
