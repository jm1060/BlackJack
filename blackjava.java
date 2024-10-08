import java.util.Arrays;
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
        int playertotal = 0;
        int opponenttotal = 0;
        System.out.println(blackjackgame(playertotal, opponenttotal, "", ""));
        

    }
    private static String blackjackgame(int playertotal, int opponenttotal, String playerresponse, String opponentresponse)
    {
        if(playerresponse.equals("stop") && opponentresponse.equals("stop"))
        {
            return checkwin(playertotal, opponenttotal);
        }
        else
        {
           List<String> list = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "9", "10", "J", "Q", "K");
            Random random = new Random();
            Scanner scanner = new Scanner(System.in);
            if(playertotal == 0 && opponenttotal == 0)
            {
                int number1 = addplayerscores(list.get(random.nextInt(list.size())));
                playertotal+=number1;
                int number2 = addplayerscores(list.get(random.nextInt(list.size())));
                playertotal+= number2;
                System.out.println(playertotal);
                int opnum1 = addopponentscores(opponenttotal, list.get(random.nextInt(list.size())));
                opponenttotal += opnum1;
                int opnum2 = addopponentscores(opponenttotal, list.get(random.nextInt(list.size())));
                opponenttotal += opnum2;
                System.out.println(opponenttotal);
            }
            else{
                if(!(playerresponse.equals("stop")))
                {
                    System.out.println("Would like to hit or stop");
                    playerresponse = scanner.nextLine();
                    if(playerresponse.equals("hit"))
                    {
                        playertotal += addplayerscores(list.get(random.nextInt(list.size())));
                        System.out.println("Player total: "+playertotal);
                        playerresponse = checkplayerscores(playertotal, playerresponse);
                    }
                    else{
                        playertotal += 0;
                        System.out.println("Player total: "+playertotal);
                    }
                }
                else{
                    playertotal += 0;
                    System.out.println("Player total: "+playertotal);
                }
                if(opponenttotal <= 10)
                {
                    opponentresponse = "hit";
                    opponenttotal += addopponentscores(opponenttotal, list.get(random.nextInt(list.size())));
                    System.out.println("Opponent total: "+opponenttotal);
                    
                }
                else
                {
                    List<String>choices = List.of("hit", "stop");
                    opponentresponse = choices.get(random.nextInt(choices.size()));
                    if(opponentresponse.equals("hit"))
                    {
                        opponenttotal += addopponentscores(opponenttotal, list.get(random.nextInt(list.size())));
                        System.out.println("Opponent total: "+opponenttotal);
                        opponentresponse = checkopponentscores(opponenttotal, opponentresponse);
                    }
                    else{
                        opponenttotal += 0;
                        System.out.println("Opponent total: "+opponenttotal);
                    }
                } 
            }

            
        }

        return blackjackgame(playertotal, opponenttotal, playerresponse, opponentresponse);
    }
    private static int addplayerscores(String card)
    {
        int number =0;
        Scanner scanner = new Scanner(System.in);
        List<String>royals = List.of("J", "Q", "K");
        if(royals.contains(card))
        {
            return 10;
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
                number = acenumber;
            }
            else if(acenumber == 11)
            {
                number = acenumber;
            }
            
        }
        else{
            number = Integer.parseInt(card);
        }
        return number;
    }
        
    private static int addopponentscores(int opponenttotal, String card)
    {
        int opnum = 0;
        List<String>royals = List.of("J", "Q", "K");
        if(royals.contains(card))
        {
            return 10;
        }
        else if(card.equals("A"))
        {
            
            if(opponenttotal <= 10)
            {
                int acenumber = 11;
                opnum = acenumber;
            }
            else{
                int acenumber = 1;
                opnum = acenumber;
            }
            
        }
        else{
            opnum = Integer.parseInt(card);
        }
        return opnum;
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
    private static String checkwin(int playertotal, int opponenttotal)
    {
        String finalstatement = "";
        if(playertotal == opponenttotal)
        {
            finalstatement = "We have a tie. Player: "+ playertotal+ " Opponent: "+opponenttotal;
        }
        else if(playertotal > opponenttotal)
        {
            if(playertotal > 21)
            {
                finalstatement = "Busted! You lost! Player: "+ playertotal+ " Opponent: "+opponenttotal;
            }
            else{
                finalstatement = "Congratulations! You've won! Player: "+ playertotal+ " Opponent: "+opponenttotal;
            }
        }
        else{
            if(opponenttotal > 21)
            {
                finalstatement = "Opponent is busted! You've won! Player: "+ playertotal+ " Opponent: "+opponenttotal;
            }
            else{
                finalstatement = "Opponent has won! You've lost! Player: "+ playertotal+ " Opponent: "+opponenttotal;
            }
        }
        return finalstatement;
    }

}