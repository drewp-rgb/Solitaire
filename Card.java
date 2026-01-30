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
        return "Ace of ";
    }
    else if(rank == 11)
    {
        return "Jack of ";
    }
    else if(rank == 12)
    {
        return "Queen of ";
    }
    else if(rank == 13)
    {
        return "King of ";
    }

    return rank + "of ";
}
}
