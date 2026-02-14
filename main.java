import java.util.*;

public class main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        ArrayList<Card> deck = new ArrayList<>();

        ArrayList<Card> Stock = new ArrayList<>();
        ArrayList<Card> Waste = new ArrayList<>();

        ArrayList<Card> Foundation1 = new ArrayList<>();
        ArrayList<Card> Foundation2 = new ArrayList<>();
        ArrayList<Card> Foundation3 = new ArrayList<>();
        ArrayList<Card> Foundation4 = new ArrayList<>();

        ArrayList<ArrayList<Card>> board = new ArrayList<ArrayList<Card>>();

        // deck init
        while (deck.size() < 52) {
            String[] suits = { "H", "D", "C", "S" };

            Card x = new Card((int) (Math.random() * 13) + 1, suits[(int) (Math.random() * 4)]);
            boolean check = true;
            for (Card y : deck)
                {
                if (x.getranknsuits().equals(y.getranknsuits())) {
                    check = false;
                }
            }
            if (check)
            {
                deck.add(x);
            }

        }
        // deck init
      

        // tableau
        for (int lcv = 0; lcv < 7; lcv++)
        {
            ArrayList<Card> y = new ArrayList<>();
            board.add(y);
        }

        for (int lcv = 0; lcv < 7; lcv++)
        {

            for (int lcv2 = 0; lcv2 < lcv + 1; lcv2++)
            {

                int spot = (int) (Math.random() * deck.size());
                board.get(lcv).add(deck.get(spot));
                deck.remove(deck.get(spot));
            }
            board.get(lcv).get(board.get(lcv).size() - 1).showcard();
        }
        // tableau
        
       

        // pile
        Stock.addAll(deck);
        Card initwaste = Stock.get(Stock.size()-1);
        initwaste.showcard();
        Stock.remove(Stock.size()-1);
        Waste.add(initwaste);

        boolean gameend = false;
        while (gameend == false) {
            System.out.println("Current board:");
            int biggesttab = 0;
            for(ArrayList<Card> x : board)
            {
                if(x.size() > biggesttab)
                {
                    biggesttab = x.size();
                }
            }

            for(int r = 0; r <biggesttab; r++)
            {
            
                for(int c = 0;c <7;c++)
                {
                    if(r < board.get(c).size())
                    {
                        Card card = board.get(c).get(r);

                        if(card.getsight() == true)
                        {
                            System.out.print(card.getranknsuits());
                        }
                        else
                        {
                            System.out.print(" ??   ");
                        }
                    }
                    
                }
                System.out.println();
                
            }
            
            System.out.println("Face up card in waste:");
            {
        
            }
            System.out.println("what would you like to do(draw(d), move card(m))");
            if (input.next().equals("d")) {
                System.out.println("Next waste card: " /* whatever */);
            } else if (input.next().equals("m")) {
                System.out.println("which pile would you like to take from? (1-7) ");
                int grabbed = input.nextInt();
                System.out.println("where do you want to put it? (1-7) ");
                /* check it and place it there */
            } else {
                System.out.println("Invalid command, try again");
            }
        }
      
    }

}
