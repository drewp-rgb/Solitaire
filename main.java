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


           for(int lcv = 0;lcv<7;lcv++)
           {
            System.out.print("Pile " + (lcv+1)+": ");
            for(Card x : board.get(lcv))
            {
                if(x.getsight())
                {
                    System.out.print(x.getranknsuits() + "  ");
                }
                else
                {
                    System.out.print("??  ");
                }
            }
            System.out.println();
           }
            

            System.out.println("Face up card in waste:");
            System.out.println(Waste.get(Waste.size()-1).getranknsuits());


            System.out.println("what would you like to do(draw(d), move card(m))");
            String choice = input.next();


            //CHOSE DRAW
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
                
            } 
            //CHOSE DRAW


            //CHOSE MOVE
            else if (choice.equals("m")) {

                System.out.println("pull from tableau(t) or waste(w)");
                String grabbed = input.next();


                //PULL FROM TABLEAU
                if(grabbed.equals("t"))
                {
                    System.out.println("which pile (1-7)");
                    int pilespot = input.nextInt() -1;
                    int placespot = 0;
                    Card grabbedCard = null;
                    if(!board.get(pilespot).isEmpty())
                    {

                    
                    grabbedCard = board.get(pilespot).get(board.get(pilespot).size()-1);
                    }
                    else
                    {
                        System.out.println("pile is empty");
                        continue;
                    }


                    //where to put
                    System.out.println("place in tableau(t) or foundation(f)");
                    String grabbed2 = input.next();
                    

                    //PLACED IN TABLEAU
                    if(grabbed2.equals("t"))
                    {
                        System.out.println("while pile(1-7)");
                        placespot = input.nextInt() - 1;

                        //checks if pile is empty, if not check if placeable, if is check if it is a king

                        if(!board.get(placespot).isEmpty())
                        {

                            //checks if rank and color is correct
                        if((grabbedCard.getrank() == board.get(placespot).get(board.get(placespot).size()-1).getrank() - 1) && 
                        grabbedCard.getcolor() != board.get(placespot).get(board.get(placespot).size()-1).getcolor())
                          {
                            board.get(placespot).add(grabbedCard);
                            board.get(pilespot).remove(board.get(pilespot).get(board.get(pilespot).size()-1));
                            if(!board.get(pilespot).isEmpty())
                            {
                            board.get(pilespot).get(board.get(pilespot).size()-1).showcard();
                            }
                          }
                        else
                          {
                            System.out.println("cant add to pile, wrong color or rank");
                          }
                        }
                        else
                        {
                        if(grabbedCard.getrank() == 13)
                        {
                            board.get(placespot).add(grabbedCard);
                        }
                        else
                        {
                            System.out.println("can only place kings on empty piles");
                        }
                    }   
                    }
                    //PLACED IN TABLEAU
                }
                //PULL FROM TABLEAU


                if(grabbed.equals("w"))
                {
                    System.out.println(" place waste card on tableau(t) or foundation(f)");
                }
            } 
            //CHOSE MOVE

            else {
                System.out.println("Invalid command, try again");
            }
        }
      
    }

}
