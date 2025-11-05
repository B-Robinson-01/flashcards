package flashcards;

/* This class represents a single flash card. Contains two properties:
 *   front: the front side of the card
 *   back: the back side of the card
 */
public class Card {
    private String front;
    private String back;

    public Card(String front, String back)
    {
        this.front = front;
        this.back = back;
    }

    public String getFront()
    {
        return front;
    }

    public String getBack()
    {
        return back;
    }
}
