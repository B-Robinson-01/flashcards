package flashcards;

import java.util.Collections;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/** This class defines the many functions needed to manage the frontend */
public class SceneManager {
    /**
     * This method declares what it means to create a new stage 
     *   that runs in addition to the stages already running
     *   @param - the path to the .fxml file to load
     */
    private void NewStage(String path) 
    {
        Stage newStage = new Stage();
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource(path));
            Scene scene = new Scene(root);
    
            newStage.setTitle("Flashcards");
            newStage.setScene(scene);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new data entry window
     */
    public void newDataEntry()
    {
        NewStage("/CardEntry.fxml");
    }

    

    // Data Manipulation - button functionality
    @FXML
    private Label CardText;

    private int index;

    /** 
     * Flips Card to the other Side
     *    - if already showing Front: flip to back
     *    - if already showing Back: flip to front
     */
    public void FlipCard()
    {
        if (SessionData.isFrontShowing)
        {
            ShowBack(getCurrCard());
        } else
        {
            ShowFront(getCurrCard());
        }
    }

    /**
     * Gets the current card from Session Data based on an index 
     * @return current card 
     */
    private Card getCurrCard()
    {
        return SessionData.cards.getList().get(index);
    }

    /** 
     * A helper method to define what it means to flip to front
     *  - Note: this is called at the very beginning 
     */
    public void ShowFront(Card card)
    {
        CardText.setText(card.getFront());
        SessionData.isFrontShowing = true;
    }

    /** 
     * A helper method to define what it means to flip to front
     *  - Note: this is called at the very beginning 
     */
    public void ShowBack(Card card)
    {
        CardText.setText(card.getBack());
        SessionData.isFrontShowing = false;
    }

    // Next
    public void NextCard()
    {
        if (index < SessionData.cards.getSize() - 1)
        {
            index++;
    
            ShowFront(getCurrCard());
        }
    }

    // Prev
    public void PrevCard()
    {
        if (index > 0)
        {
            index--;
    
            ShowFront(getCurrCard());
        }
    }


    // Shuffle???
    public void ShuffleDeck()
    {
        List<Card> temp = SessionData.cards.getList();
        Collections.shuffle(temp);

        SessionData.cards.SetList(temp);
    }
}
