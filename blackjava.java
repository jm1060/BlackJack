import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class blackjava
{
    public static void main(String[]args)
    {
        System.out.println("Welcome a game of BlackJack.");
        System.out.println("The rules are you take two cards you can decide to hit or stop.");
        System.out.println("However, if you get over 21, you are out then your opponent wins");
        System.out.println("Let's play.");
        
        // System.out.println(blackjackgame(0, 0, "", ""));
    }
    private static String blackjackgame(int playertotal, int opponenttotal, String playerresponse, String opponentresponse)
    {
        if(playerresponse.equals("stop") && opponentresponse.equals("stop"))
        {

        }
        else
        {
            List<String> list = List.of("A", "2", "3", "4", "5", "6", "7", "9", "10", "J", "Q", "K");
            Random random = new Random();
            if(playertotal == 0 && opponenttotal == 0)
            {
                playertotal=addplayerscores(playertotal, list.get(random.nextInt(list.size())));
            }
        }

        return "";
    }
    private static int addplayerscores(int playertotal, String card)
    {
        Scanner scanner = new Scanner(System.in);
        List<String>royals = List.of("J, Q, K");
        if(royals.contains(card))
        {
            playertotal += 10;
        }
        else if(card.equals("A"))
        {
            System.out.println("Would like A to be 1 or 11?");
            int acenumber = scanner.nextInt();
            while(acenumber != 1 && acenumber != 11)
            {
                System.out.println("Invalid number try again:");
                acenumber = scanner.nextInt();
            }
            if(acenumber == 1)
            {
                playertotal +=1;
            }
            else if(acenumber == 11)
            {
                playertotal+=11;
            }
            
        }
        else{
            playertotal += Integer.parseInt(card);
        }
        return playertotal;
    }

}