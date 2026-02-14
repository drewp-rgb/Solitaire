public class Card {
private int rank;
private String suit;
private String color;
private boolean isshown;

public Card(int r, String s)
{
rank = r;
suit = s;
if(suit.equals("C") || suit.equals("S"))
{
    color = "black";
}
else
{
    color = "red";
}
isshown = false;
}
public String getcolor()
{
    return color;
}
public int getrank()
{
    return rank;
}
public String getsuit()
{
    return suit;
}
public String getranknsuits()
{
    if(rank == 1)
    {
        return "A of " + suit;
    }
    else if(rank == 11)
    {
        return "J of " + suit;
    }
    else if(rank == 12)
    {
        return "Q of " + suit;
    }
    else if(rank == 13)
    {
        return "K of " + suit;
    }

    return rank + " of " + suit;
}
public void showcard()
{
    isshown = true;
}
public void hide()
{
    isshown = false;
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
