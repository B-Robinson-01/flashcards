package flashcards;

import java.util.*;

/** Wrapper class for JSON conversion to List of Cards */
public class CardList {
    private int size;
    private List<Card> list = new ArrayList<>();

    public CardList()
    {
        this.size = 0;
    }

    public List<Card> getList() 
    {
        return list;
    }

    public void SetList(List<Card> list)
    {
        this.list = list;
        this.size = list.size();
    }

    public int getSize()
    {
        return this.size;
    }
}
