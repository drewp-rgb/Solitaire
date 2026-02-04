import java.util.*;
public class main
{
    public static void main(String [] args)
    {
        Scanner output = new Scanner(System.in);
        boolean gameend = false;
        ArrayList<Card> deck = new ArrayList<>();
        while(gameend = false)
        {
            System.out.println("what would you like to do(draw(d), move card(m))");
            if(output.next().equals("d"))
            {
                System.out.println("you drew a " /*whatever*/);
            }
            else if(output.next().equals("m"))
            {
                System.out.println("which pile would you like to take from");
                int grabbed = output.nextInt();
                System.out.println("where do you want to put it");
                /*check it and place it there */
            }
            else
            {
                System.out.println("invaild command try harder");
            }
        }
        
    }
}
