public class Card {
private int rank;
private String suit;
private String coolair;
private boolean isshown;

public Card(int r, String s)
{
rank = r;
suit = s;
if(suit == "clubs" || suit == "spades")
{
    coolair = "black";
}
else
{
    coolair = "red";
}
isshown = false;
}
public String getcolor()
{
    return coolair;
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
public void showcard()
{
    isshown = true;
}
public boolean getsight()
{
    return isshown;
}
public String toString()
{
    return getranknsuits();
}
}
