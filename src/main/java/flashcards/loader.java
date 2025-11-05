package flashcards;

import java.io.*;
import com.google.gson.Gson;
/** This class loads the provided Cards from a JSON file */
public class loader {
    public CardList loadCards() {
        Gson gson = new Gson();

        // load a list of Cards 
        CardList cards = new CardList();

        String pathToJSON = "/Cards.json";
        FileReader reader;

        try {
            reader = new FileReader(pathToJSON);
            cards = gson.fromJson(reader, CardList.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cards;
    }
}
