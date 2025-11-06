package flashcards;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/** This class defines the many functions needed to manage the frontend */
public class SceneManager {
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
        return SessionData.cards.list.get(index);
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
        if (index < SessionData.cards.size - 1)
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
}
