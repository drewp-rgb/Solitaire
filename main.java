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
            System.out.println(Waste.get(Waste.size()-1).getranknsuits());
            System.out.println("what would you like to do(draw(d), move card(m))");
            String choice = input.next();
            if (choice.equals("d")) {
                if(!Stock.isEmpty())
                {
                    Waste.add(Stock.get(Stock.size()-1));
                    Stock.remove(Stock.size()-1);
                }
                else
                {
                    System.out.println("End of waste, recycling");
                    for(int lcv = Waste.size() - 1; lcv>=0;lcv--)
                    {
                        Stock.add(Waste.get(lcv));
                        
                    }
                    Waste.clear();
                    Waste.add(Stock.get(Stock.size()-1));
                    Stock.remove(Stock.size()-1);
                }
                
            } else if (choice.equals("m")) {
                System.out.println("pull from tableau(t) or waste(w)");
                String grabbed = input.next();

                //if tableau is chosen
                if(grabbed.equals("t"))
                {
                    System.out.println("which pile (1-7)");
                    int pilespot = input.nextInt();
                    Card grabbedCard = board.get(pilespot).get(board.get(pilespot).size()-1);
                    board.get(pilespot).remove(board.get(pilespot).get(board.get(pilespot).size()-1));
                    //where to put
                    System.out.println("place in tableau(t) or foundation(f)");

                }
                //if tableau is chosen
            } else {
                System.out.println("Invalid command, try again");
            }
        }
      
    }

}
