package flashcards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Class responsible for all loading before scene (JSON and .xml/.fxml)*/
public class LoadXML extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        JSONLoader();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("Flashcards");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Initialize first card
        SessionData.currCard = SessionData.cards.list.get(0);
        
        SceneManager controller = loader.getController();
        controller.ShowFront(SessionData.currCard);
    }

    private void JSONLoader() {
        Loader loader = new Loader();
        
        String pathToJSON = "src/main/java/flashcards/Cards.json";
        SessionData.cards = loader.loadCards(pathToJSON);
    }
}