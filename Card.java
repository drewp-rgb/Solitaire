public class Card {
private int rank;
private String suit;

public Card(int r, String s)
{
rank = r;
suit = s;
}

public String getrank()
{
    if(rank == 1)
    {
        return "Ace";
    }
}
}
