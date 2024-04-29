/**
 * Game Manager Class
 * Author: Cody Thompson
 * 
 * Takes care of all the Game rules
 */

package logic;

import java.util.List;
import java.util.Scanner;


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


    /**
     * Game Manager Constructor
     * @param players the players in the game
     * @param board the board 
     */
    public GameManager(List<Player> players, Board board){
        this.players = players;
        this.board = board;
        ccDeck = new CommunityChest("Community Chest", 0, 0, 0, Colors.COMMUNITYCHEST);
        chanceDeck = new Chance("Chance", 0, 0, 0, Colors.CHANCE);
        dice = new Dice(2);
    }

    /**
     * Plays the Game
     */
    public void playGame(){
        while(!gameOver()){
            for (Player current : players){
                takeTurn(current);
            }
        }
    }

    /**
     * Checks if the Game is Over
     * 
     * A game is over if all players but one are bankrupt
     * 
     * @return true if the game is over, false otherwise
     */
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

    /**
     * Takes a player's turn
     * 
     * A Player's turn is taken by rolling the dice,
     * moving, and handling the space that is landed on
     * 
     * @param player the player whose turn it is
     */
    public void takeTurn(Player player){
        int roll = dice.roll();
        player.move(roll);
        Tiles landed = board.getTile(player.getPosition());
        handleSpace(player, landed);
    }


    /**
     * Asks if a player wants to buy the tile or continue
     * 
     * If a player buys, the player loses that amount of money,
     * the property is added to the player's list of properties,
     * and the player is set to be the owner of the property
     * 
     * @param player the current player
     * @param tile the tile landed on
     */
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

    /**
     * Asks if a player wants to Trade or Continue
     * 
     * If a Player wants to trade, the player sends an offer to another
     * player
     * 
     * @param player the current player
     */
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

    /**
     * Handles the space a player has landed on
     * @param player the player that landed on the space
     * @param tile the current tile
     */
    public void handleSpace(Player player, Tiles tile){
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
                        System.out.println("You're in Jail!\nRoll Doubles\nPay Bail\nUse Get Out Of Jail Free Card");
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
                        else if(answer.equals("use get out of jail free card")){
                            manager.useGetOutOfJailFreeCard(player);
                        }
                        else{
                            System.out.println("Please choose to Roll doubles, Pay Bail, or Use Get Out Of Jail Free Card!");
                        }
                    }
                }
                else{
                    Jail jail = (Jail) tile;
                    jail.justVisiting();
                    tradeOrContinue(player);
                }

            }
            else if(tile instanceof Chance){
                System.out.println("Chance!");
                chanceDeck.drawCard().completeAction(player);
            }
            else if(tile instanceof CommunityChest){
                System.out.println("Community Chest!");
                ccDeck.drawCard().completeAction(player);
            }
            else if(tile instanceof FreeParking){
                System.out.println("Free Parking");
                FreeParking free = (FreeParking) tile;
                if (free.getMoneyInMiddle() > 0){
                    System.out.println(player.getName() + " collected $" + free.getMoneyInMiddle() +"!");
                    free.collectMoney(player);
                    free.setMoneyInMiddle(0);
                }
                else{
                    tradeOrContinue(player);
                }

            }
            else if(tile instanceof GoToJail){
                System.out.println("Go To Jail!");
                GoToJail goToJail = (GoToJail) tile;
                goToJail.sendToJail(player);
            }
            else if(tile instanceof Utility){
                System.out.println("Landed on " + tile.getName());
                int numUtilities = 0;
                if(tile.owned() && !(tile.getOwner().equals(player))){
                    for (Tiles t : tile.getOwner().getProperties()){
                        if (t instanceof Utility){
                            numUtilities++;
                        }
                    }
                    if(numUtilities == 1){
                        Utility utility = (Utility) tile;
                        utility.setOneUtilityRent(dice);
                        player.payMoney(tile.getOwner(), utility.getOneUtilityRent());
                    }
                    else if (numUtilities == 2){
                        Utility utility = (Utility) tile;
                        utility.setTwoUtilityRent(dice);
                        player.payMoney(tile.getOwner(), utility.getTwoUtilityRent());
                    }
                }
                else if (tile.owned() && tile.getOwner().equals(player)){
                    tradeOrContinue(player);
                }
                else{
                    buyOrContinue(player, tile);
                }
                
            }
            else if (tile instanceof Tax){
                if (tile.getName().equals("LuxuryTax")){
                    System.out.println("Pay Luxury Tax!");
                    Tax luxury = (Tax) tile;
                    luxury.payLuxuryTax(player);
                }
                else{
                    System.out.println("Pay Income Tax!");
                    Tax income = (Tax) tile;
                    income.payIncomeTax(player);
                }
                tradeOrContinue(player);
            }
            else if (tile instanceof Go){
                System.out.println("Landed on Go! Collect $200!");
                Go go = (Go) tile;
                go.addMoney(player);
                tradeOrContinue(player);
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
