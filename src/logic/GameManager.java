package logic;

import java.util.List;

import model.Board;
import model.Chance;
import model.Colors;
import model.CommunityChest;
import model.Dice;
import model.Player;
import model.Tiles;

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

        //implement game over conditions 


        return false;
    }

    public void takeTurn(Player player){
        int roll = dice.roll();
        player.move(roll);
        Tiles landed = board.getTile(player.getPosition());
        handleSpace(player, landed);
    }

    public void handleSpace(Player player, Tiles tile){

    }


    //to call draw Card do ccDeck.drawCard().completeAction()

    
    
}
