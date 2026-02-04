public class Card {
private int rank;
private String suit;

public Card(int r, String s)
{
rank = r;
suit = s;
}

public String getranknsuits()
{
    if(rank == 1)
    {
        return "Ace of " + suit;
    }
    else if(rank == 11)
    {
        return "Jack of " + suit;
    }
    else if(rank == 12)
    {
        return "Queen of " + suit;
    }
    else if(rank == 13)
    {
        return "King of " + suit;
    }

    return rank + " of " + suit;
}

public String toString()
{
    return getranknsuits();
}
}
