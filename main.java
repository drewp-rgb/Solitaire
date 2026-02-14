    import java.util.*;

    public class main
    {
        public static void main(String[] args)
        {
            Scanner input = new Scanner(System.in);

            ArrayList<Card> deck = new ArrayList<>();
            ArrayList<Card> Stock = new ArrayList<>();
            ArrayList<Card> Waste = new ArrayList<>();

            ArrayList<ArrayList<Card>> Foundations = new ArrayList<ArrayList<Card>>();
            for(int lcv = 0;lcv<4;lcv++)
            {
                ArrayList<Card> y = new ArrayList<>();
                Foundations.add(y);
            }


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
            for(int lcv = 0;lcv<4;lcv++)
            {
                gameend = true;
                if(Foundations.get(lcv).size() != 13)
                {
                    gameend = false;
                    lcv = 4;
                }
            }
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
                
            
            System.out.println("Current foundation: ");
            for(int lcv = 0;lcv < 4; lcv++)
            {
                System.out.print("Foundation " + (lcv +1) + ": ");
                if(!Foundations.get(lcv).isEmpty())
                {
                for(Card x : Foundations.get(lcv))
                {
                System.out.print(x.getranknsuits() + "  "); 
                }
                }
                else
                    {
                        System.out.print("Empty");
                    }  
                    System.out.println();     
            }
                System.out.println("Face up card in waste:");
                System.out.println(Waste.get(Waste.size()-1).getranknsuits());

            //GAME
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
                            if(placespot >= 0 && placespot < 7)
                            {

                            
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
                    else
                    {
                        System.out.println("invalid postition");
                        continue;
                    }
                        }
                        //PLACED IN TABLEAU

                        //PLACED IN FOUNDATION
                        else if(grabbed2.equals("f"))
                        {
                            System.out.println("Which foundation pile(1-4)");
                            int fspot = input.nextInt() - 1;
                            if(!Foundations.get(fspot).isEmpty())
                            {
                                if(grabbedCard.getsuit().equals(Foundations.get(fspot).get(Foundations.get(fspot).size()-1).getsuit()) &&
                                grabbedCard.getrank() == Foundations.get(fspot).get(Foundations.get(fspot).size()-1).getrank() + 1)
                                {
                                    Foundations.get(fspot).add(grabbedCard);
                                    board.get(pilespot).remove(board.get(pilespot).get(board.get(pilespot).size()-1));
                                    if(!board.get(pilespot).isEmpty())
                                    {
                                    board.get(pilespot).get(board.get(pilespot).size()-1).showcard();
                                    }
                                }
                            }
                            else
                            {
                                if(grabbedCard.getrank() == 1)
                                {
                                Foundations.get(fspot).add(grabbedCard);
                                    board.get(pilespot).remove(board.get(pilespot).get(board.get(pilespot).size()-1));
                                    if(!board.get(pilespot).isEmpty())
                                    {
                                    board.get(pilespot).get(board.get(pilespot).size()-1).showcard();
                                    } 
                                }
                                else
                                {
                                    System.out.println("can only add ace to empty foundation");
                                }
                            }
                        }
                        
                    }
                    //PULL FROM TABLEAU

                    //PULL FROM WASTE
                    if(grabbed.equals("w"))
                    {
                        Card wasteCard = Waste.get(Waste.size()-1);
                        System.out.println(" place waste card on tableau(t) or foundation(f)");
                        String wastespot = input.next();

                        //PLACED WASTE ON TABLEAU
                        if(wastespot.equals("t"))
                        {
                            System.out.println("which pile(1-7)");
                            int wasteplace = input.nextInt() - 1;

                            if(!board.get(wasteplace).isEmpty())
                            {

                                //checks if rank and color is correct
                            if((wasteCard.getrank() == board.get(wasteplace).get(board.get(wasteplace).size()-1).getrank() - 1) && 
                            wasteCard.getcolor() != board.get(wasteplace).get(board.get(wasteplace).size()-1).getcolor())
                            {
                                board.get(wasteplace).add(wasteCard);
                                Waste.remove(Waste.size()-1);
                                
                            }
                            else
                            {
                                System.out.println("cant add to pile, wrong color or rank");
                            }
                            }
                            else
                            {
                            if(wasteCard.getrank() == 13)
                            {
                                board.get(wasteplace).add(wasteCard);
                                Waste.remove(Waste.size()-1);
                            }
                            else
                            {
                                System.out.println("can only place kings on empty piles");
                            }
                        }   
                                
                        }

                        //PLACED WASTE ON FOUNDATION
                        else if(wastespot.equals("f"))
                        {
                            System.out.println("Which foundation pile(1-4)");
                            int fspot = input.nextInt() - 1;
                            if(!Foundations.get(fspot).isEmpty())
                            {
                                if(wasteCard.getsuit().equals(Foundations.get(fspot).get(Foundations.get(fspot).size()-1).getsuit()) &&
                                wasteCard.getrank() == Foundations.get(fspot).get(Foundations.get(fspot).size()-1).getrank() + 1)
                                {
                                    Foundations.get(fspot).add(wasteCard);
                                    Waste.remove(Waste.size()-1);
                                
                                }
                            }
                            else
                            {
                                if(wasteCard.getrank() == 1)
                                {
                                Foundations.get(fspot).add(wasteCard);
                                    Waste.remove(Waste.size()-1);
                                }
                                else
                                {
                                    System.out.println("can only add ace to empty foundation");
                                }
                            }
                        }
                    }
                } 
                //CHOSE MOVE

                else {
                    System.out.println("Invalid command, try again");
                }
            }
        
        }

    }
