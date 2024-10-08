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
            Scanner scanner = new Scanner(System.in);
            if(playertotal == 0 && opponenttotal == 0)
            {
                playertotal+=addplayerscores(playertotal, list.get(random.nextInt(list.size())));
                playertotal+=addplayerscores(playertotal, list.get(random.nextInt(list.size())));
                opponenttotal += addopponentscores(opponenttotal, list.get(random.nextInt(list.size())));
                opponenttotal += addopponentscores(opponenttotal, list.get(random.nextInt(list.size())));
            }
            else{
                if(!(playerresponse.equals("stop")))
                {
                    System.out.println("Would like to hit or stop");
                    playerresponse = scanner.nextLine();
                    if(playerresponse.equals("hit"))
                    {
                        playertotal += addplayerscores(playertotal, list.get(random.nextInt(list.size())));
                    }
                }
                else{
                    playertotal += 0;
                }
                if(opponenttotal <= 10)
                {
                    opponentresponse = "hit";
                    opponenttotal = addopponentscores(opponenttotal, list.get(random.nextInt(list.size())));
                }
                else
                {
                    List<String>choices = List.of("hit", "stop");
                    opponentresponse = choices.get(random.nextInt(choices.size()));
                    if(opponentresponse.equals("hit"))
                    {
                        opponenttotal = addopponentscores(opponenttotal, list.get(random.nextInt(list.size())));
                    }
                    else{
                        opponenttotal += 0;
                    }
                } 
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
    private static int addopponentscores(int opponenttotal, String card)
    {
        
        List<String>royals = List.of("J, Q, K");
        if(royals.contains(card))
        {
            opponenttotal += 10;
        }
        else if(card.equals("A"))
        {
            
            if(opponenttotal <= 10)
            {
                int acenumber = 11;
                opponenttotal += acenumber; 
            }
            else{
                int acenumber = 1;
                opponenttotal += acenumber;
            }
            
        }
        else{
            opponenttotal += Integer.parseInt(card);
        }
        return opponenttotal;
    }
    private static String checkplayerscores(int playertotal,String playerresponse)
    {
        if(playertotal < 21)
        {
            playerresponse = "hit";
        }
        else
        {
            playerresponse = "stop";
        }
        return playerresponse;
        
    }
    private static String checkopponentscores(int opponenttotal, String opponentresponse)
    {
        if(opponenttotal < 21)
        {
            opponentresponse = "hit";
        }
        else
        {
            opponentresponse = "stop";
        }
        return opponentresponse;
    }

}