package logic;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class CardUtil {
	
	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		for(UnitCard uc:list){
			if(uc.equals(card)){
				return true;
			}
		}
		return false;

	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		for(UnitDeck ud:list){
			if(ud.equals(deck)){
				return true;
			}
		}
		return false;

	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		for (UnitDeck ud : deckList) { if (ud.existsInDeck(cardToTest)) { return true; } } return false;
	}
	
	public static ArrayList<UnitCard> getCardsFromFile(String filename){
		
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();
		InputStream inputStream = CardUtil.class.getClassLoader().getResourceAsStream(filename);
          	if (inputStream == null) {
                	System.out.println("Cannot find file!");
                	return null;
            	}

            	Scanner myReader = new Scanner(inputStream);
		try {
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				String[] parts = line.split(",");

				if (parts.length != 5) {
					System.out.println("Text file isn’t properly formatted");
					myReader.close();
					return null;
				}

				try {
					String name = parts[0].trim();
					int bloodCost = Integer.parseInt(parts[1].trim());
					int power = Integer.parseInt(parts[2].trim());
					int health = Integer.parseInt(parts[3].trim());
					String flavorText = parts[4].trim();

					UnitCard card = new UnitCard(name, bloodCost, power, health, flavorText);

					cardsFromFile.add(card);
				} catch (NumberFormatException e) {
					System.out.println("File contains string with incorrect format!");
					myReader.close();
					return null;
				}
			}
		}finally {myReader.close(); }

		return cardsFromFile;
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}
}
