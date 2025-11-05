package flashcards;

/** This is the main managing class for the app */
public class Main {
    public static void main(String args[]) {
        Loader loader = new Loader();

        CardList cards = new CardList();
        
        String pathToJSON = "src/main/java/flashcards/Cards.json";
        cards = loader.loadCards(pathToJSON);

        for (Card card : cards.list)
        {
            System.out.println(card);
        }
    }
}
