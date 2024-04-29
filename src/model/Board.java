/**
 * Board Class
 * Author: Cody Thompson
 * 
 * Contains all the methods required for the Board
 */

package model;

import java.util.ArrayList;
import java.util.List;



public class Board {
    private List<Tiles> board;

    /**
     * Board constructor
     */
    public Board(){
        this.board = new ArrayList<>();
        initializeBoard();
    }

    /**
     * Initializes the board with all the tiles
     */
    public void initializeBoard(){
        board.add(new Go("Go", 0, 0, 0, Colors.GO));
        board.add(new Tiles("Mediterranean Avenue", 0, 0, 0, Colors.BROWN));
        board.add(new CommunityChest("Community Chest", 0, 0, 0, Colors.COMMUNITYCHEST));
        board.add(new Tiles("Baltic Avenue", 0, 0, 0, Colors.BROWN));
        board.add(new Tax("Income Tax", 0, 0, 0, Colors.INCOMETAX));
        board.add(new Railroad("Reading Railroad", 0, 0, 0, Colors.RAILROAD));
        board.add(new Tiles("Oriental Avenue", 0, 0, 0, Colors.LIGHTBLUE));
        board.add(new Chance("Chance", 0, 0, 0, Colors.CHANCE));
        board.add(new Tiles("Vermont Avenue", 0, 0, 0, Colors.LIGHTBLUE));
        board.add(new Tiles("Connecticut Avenue", 0, 0, 0, Colors.LIGHTBLUE));
        board.add(new Jail("Jail", 0, 0, 0, Colors.JAIL));
        board.add(new Tiles("St. Charles Place", 0, 0, 0, Colors.MAGENTA));
        board.add(new Utility("Electric Company", 0, 0, 0, Colors.ELECTRICCOMPANY));
        board.add(new Tiles("States Avenue", 0, 0, 0, Colors.MAGENTA));
        board.add(new Tiles("Virginia Avenue", 0, 0, 0, Colors.MAGENTA));
        board.add(new Railroad("Pennsylvania Railroad", 0, 0, 0, Colors.RAILROAD));
        board.add(new Tiles("St. James Place", 0, 0, 0, Colors.ORANGE));
        board.add(new CommunityChest("Community Chest", 0, 0, 0, Colors.COMMUNITYCHEST));
        board.add(new Tiles("Tennesee Avenue", 0, 0, 0, Colors.ORANGE));
        board.add(new Tiles("New York Avenue", 0, 0, 0, Colors.ORANGE));
        board.add(new FreeParking("Free Parking", 0, 0, 0, Colors.FREEPARKING));
        board.add(new Tiles("Kentucky Avenue", 0, 0, 0, Colors.RED));
        board.add(new Chance("Chance", 0, 0, 0, Colors.CHANCE));
        board.add(new Tiles("Indiana Avenue", 0, 0, 0, Colors.RED));
        board.add(new Tiles("Illinois Avenue", 0, 0, 0, Colors.RED));
        board.add(new Railroad("B & O Railroad", 0, 0, 0, Colors.RAILROAD));
        board.add(new Tiles("Atlantic Avenue", 0, 0, 0, Colors.YELLOW));
        board.add(new Tiles("Ventnor Avenue", 0, 0, 0, Colors.YELLOW));
        board.add(new Utility("Water Works", 0, 0, 0, Colors.WATERWORKS));
        board.add(new Tiles("Marvin Gardens", 0, 0, 0, Colors.YELLOW));
        board.add(new GoToJail("Go To Jail", 0, 0, 0, Colors.GOTOJAIL));
        board.add(new Tiles("Pacific Avenue", 0, 0, 0, Colors.GREEN));
        board.add(new Tiles("North Carolina Avenue", 0, 0, 0, Colors.GREEN));
        board.add(new CommunityChest("Community Chest", 0, 0, 0, Colors.COMMUNITYCHEST));
        board.add(new Tiles("Pennsylvania Avenue", 0, 0, 0, Colors.GREEN));
        board.add(new Railroad("Short Line", 0, 0, 0, Colors.RAILROAD));
        board.add(new Chance("Chance", 0, 0, 0, Colors.CHANCE));
        board.add(new Tiles("Park Place", 0, 0, 0, Colors.DARKBLUE));
        board.add(new Tax("Luxury Tax", 0, 0, 0, Colors.LUXURYTAX));
        board.add(new Tiles("Boardwalk", 0, 0, 0, Colors.DARKBLUE));
    }

    /**
     * Get's the tile at the given position
     * @param position the position
     * @return the Tile at the position
     */
    public Tiles getTile(int position){
        return board.get(position);
    }
}
