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


    public void buyOrContinue(Player player, Tiles tile){
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("What would you like to do?\nBuy\nContinue\n");
                        while (true){
                            String action = in.nextLine();
                            action.toLowerCase();
                            if (action.equals("buy")){
                                if(player.getMoney() > tile.getCost()){
                                    tile.setOwner(player);
                                    player.addProperty(tile);
                                    player.loseMoney(tile.getCost());
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

    }

    public void tradeOrContinue(Player player){
        try (Scanner in = new Scanner(System.in)) {
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

    }

    public void handleSpace(Player player, Tiles tile){
        //int position = player.getPosition();
        try (Scanner in = new Scanner(System.in)) {
            if (tile instanceof Railroad){
                Railroad handled = (Railroad) tile;
                if (tile.owned()){
                    if (!tile.getOwner().equals(player)){
                        int numRailroads = 0;
                        for(Tiles railroads : tile.getOwner().getProperties()){
                            if (railroads instanceof Railroad){
                                numRailroads++;
                            }
                        }
                        switch (numRailroads){
                            case 2: player.payMoney(tile.getOwner(), handled.getTwoRailroadsRent());
                            break; 
                            case 3: player.payMoney(tile.getOwner(), handled.getThreeRailroadsRent());
                            break;
                            case 4: player.payMoney(tile.getOwner(), handled.getFourRailroadsRent());
                            break;
                            default: player.payMoney(tile.getOwner(), handled.getOneRailroadRent());
                            break;
                        }
                    }
                    else{
                        System.out.println("You own this Railroad!");
                        tradeOrContinue(player);
                    }
                }
                else{
                    buyOrContinue(player, tile);
                }
            }
            else if(tile instanceof Jail){
                if (player.isInJail()){
                    JailManager manager = new JailManager();
                    while (true){
                        System.out.println("You're in Jail!\nRoll Doubles\nPay Bail");
                        String answer = in.nextLine();
                        answer.toLowerCase();
                        if(answer.equals("roll doubles")){
                            manager.takeTurnInJail(player, dice);
                            break;
                        }
                        else if(answer.equals("pay bail")){
                            manager.payBail(player);
                            break;
                        }
                        else{
                            System.out.println("Please choose to Roll doubles or Pay Bail!");
                        }
                    }
                }
                else{
                    Jail jail = (Jail) tile;
                    jail.justVisiting();
                    tradeOrContinue(player);
                    //figure out get out of jail free cards 
                }

            }
            else if(tile instanceof Chance){

            }
            else if(tile instanceof CommunityChest){

            }
            else if(tile instanceof FreeParking){

            }
            else if(tile instanceof GoToJail){
                
            }
            else if(tile instanceof Utility){

            }
            else if (tile instanceof Tax){
                
            }
            else if (tile instanceof Go){
                
            }
            else {
                if (player.getProperties().contains(tile)){
                    tradeOrContinue(player);
                }
                else if (!tile.owned()){
                    buyOrContinue(player, tile);
                }
                else{
                    player.payMoney(tile.getOwner(), tile.getRent());
                }
            }
        }
    }


    //to call draw Card do ccDeck.drawCard().completeAction()

    
    
}
