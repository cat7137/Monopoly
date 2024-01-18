package logic;

import java.util.List;
import java.util.Scanner;

import javax.swing.text.Utilities;

import model.Board;
import model.Chance;
import model.Colors;
import model.CommunityChest;
import model.Dice;
import model.FreeParking;
import model.Go;
import model.GoToJail;
import model.Jail;
import model.Player;
import model.Railroad;
import model.Tax;
import model.Tiles;
import model.Utility;

public class GameManager {

    private List<Player> players;
    private Board board;
    private CommunityChest ccDeck;
    private Chance chanceDeck;
    private Dice dice;


    public GameManager(List<Player> players, Board board){
        this.players = players;
        this.board = board;
        ccDeck = new CommunityChest("Community Chest", 0, 0, 0, Colors.COMMUNITYCHEST);
        chanceDeck = new Chance("Chance", 0, 0, 0, Colors.CHANCE);
        dice = new Dice(2);
    }

    public void playGame(){
        while(!gameOver()){
            for (Player current : players){
                takeTurn(current);
            }
        }
    }

    public boolean gameOver(){

        int numBankrupt = 0;
        int numPlayers = players.size();
        for (Player player : players){
            if (player.isBankrupt()){
                numBankrupt++;
            }
        }
        if (numBankrupt == numPlayers-1){
            return true; 
        }



        return false;
    }

    public void takeTurn(Player player){
        int roll = dice.roll();
        player.move(roll);
        Tiles landed = board.getTile(player.getPosition());
        handleSpace(player, landed);
    }

    public void handleSpace(Player player, Tiles tile){
        int position = player.getPosition();
        Scanner in = new Scanner(System.in);
        Tiles handle = tile;
        if (handle instanceof Railroad){

        }
        else if(handle instanceof Jail){

        }
        else if(handle instanceof Chance){

        }
        else if(handle instanceof CommunityChest){

        }
        else if(handle instanceof FreeParking){

        }
        else if(handle instanceof GoToJail){
            
        }
        else if(handle instanceof Utility){

        }
        else if (handle instanceof Tax){
            
        }
        else if (handle instanceof Go){
            
        }
        else {

            if (player.getProperties().contains(handle)){
                System.out.println("Trade or continue?");
                while (true){
                    String answer = in.nextLine();
                    answer.toLowerCase();
                    if (answer.equals("trade")){
                        System.out.println("Pick a player to trade with");
                        while (true){
                            String chosen = in.nextLine();
                            chosen.toLowerCase();
                            for (Player p : players){
                                if (p.getName().toLowerCase().equals(chosen)){
                                    if (p.isInJail() || p.isBankrupt()){
                                        System.out.println("Cannot trade with this Player!");
                                    }
                                    System.out.println(player.getName() + "chose to trade with " + chosen);
                                    Tiles wantedTile = null;
                                    Tiles tradingTile = null;
                                    while(true){
                                        System.out.println("Choose a property to trade!");
                                        String trading = in.nextLine();
                                        trading.toLowerCase();
                                        for(Tiles t : player.getProperties()){
                                            if(t.getName().toLowerCase().equals(trading)){
                                                tradingTile = t;
                                            }
                                        }
                                        if (tradingTile != null){
                                            break;
                                        }
                                        else{
                                            System.out.println("Please choose a tile you own!");
                                        }
                                    }
                                    while (true){
                                        System.out.println("Choose a property to trade for!");
                                        String tileWanted = in.nextLine();
                                        tileWanted.toLowerCase();
                                        for (Tiles t : p.getProperties()){
                                            if (t.getName().toLowerCase().equals(tileWanted)){
                                                wantedTile = t;
                                            }
                                        }
                                        if(wantedTile != null){
                                            break;
                                        }
                                        else{
                                            System.out.println("Please choose a property " + p.getName() + " owns!");
                                        }
                                        
                                    }
                                    player.offerTrade(player, p, tradingTile, wantedTile);
                                    boolean accepted = player.acceptTrade(p);
                                    if (accepted){
                                        player.removeProperty(tradingTile);
                                        p.addProperty(tradingTile);
                                        p.removeProperty(wantedTile);
                                        player.addProperty(wantedTile);
                                    }
                                    else{
                                        System.out.println(p.getName() + " rejected the trade!");
                                    }
                                    break;
                                }
                                else{
                                    System.out.println("Please select an actual player");
                                    break;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    else if (answer.equals("continue")){
                        break;
                    }
                    System.out.println("please choose to trade or continue");
                }
            }
            else if (!handle.owned()){
                System.out.println("What would you like to do?\n Buy\nContinue\n");
                while (true){
                    String action = in.nextLine();
                    action.toLowerCase();
                    if (action.equals("buy")){
                        if(player.getMoney() > handle.getCost()){
                            handle.setOwner(player);
                            player.addProperty(handle);
                            player.loseMoney(handle.getCost());
                        }
                        else{
                            System.out.println("You don't have enough money!");
                        }
                        break;
                    }
                    else if(action.equals("continue")){
                        break;
                    }
                    System.out.println("Please choose to Buy or Continue");
                }
            }
            else{
                player.payMoney(handle.getOwner(), handle.getRent());
            }
        }
    }


    //to call draw Card do ccDeck.drawCard().completeAction()

    
    
}
