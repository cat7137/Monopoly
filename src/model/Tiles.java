package model;

/**
 * Class for Tiles in the game
 */
public class Tiles {
    /**
     * cost of the tile
     */
    private int cost;
    /**
     * rent the tile pays
     */
    private int rent;
    /**
     * number of houses a tile currently has
     */
    private int numHouses;
    /**
     * does the tile have a hotel
     */
    private boolean hasHotel;
    /**
     * how much the tile mortgages for
     */
    private int mortgage;
    /**
     * name of the tile
     */
    private String name;
    /**
     * has the tile been mortgaged
     */
    private boolean mortgaged;
    /**
     * color associated with tile
     */
    private Colors color;
    /**
     * owner of the tile
     */
    private Player owner;

    private boolean owned;
    


    /**
     * Tiles constructor
     * @param name name of tile
     * @param cost cost of tile
     * @param rent rent for tile
     * @param mortgage mortgage for tile
     */
    public Tiles(String name, int cost, int rent, int mortgage, Colors color){
        this.name = name;
        this.cost = cost;
        this.rent = rent;
        this.mortgage = mortgage;
        this.numHouses = 0;
        this.hasHotel = false;
        this.mortgaged = false;
        this.color = color;
        this.owner = null;

    }

    /**
     * gets the cost of the tile
     * @return cost 
     */
    public int getCost(){
        return this.cost;
    }

    /**
     * gets the rent for the tile
     * @return rent
     */
    public int getRent(){
        return this.rent;
    }

    /**
     * sets the new rent amount (based on numHouses)
     * @param newRentAmount
     */
    public void setRent(int newRentAmount){
        this.rent = newRentAmount;
    }

    /**
     * checks to see if the tile has a hotel 
     * @return true if yes or false if no
     */
    public boolean hasHotel(){
        return this.hasHotel;
    }

    /**
     * sets tiles status to has a hotel
     * @param hasHotel 
     */
    public void setHotel(boolean hasHotel){
        this.hasHotel = hasHotel;
    }

    /**
     * gets number of houses the tile has
     * @return numHouses
     */
    public int getNumHouses(){
        return this.numHouses;
    }
    /**
     * sets the number of houses the tile has
     * @param numHouses the number of houses
     */
    public void setNumHouses(int numHouses){
        this.numHouses = numHouses;
    }

    /**
     * gets the mortgage amount for the tile
     * @return mortgage
     */
    public int getMortgage(){
        return this.mortgage;
    }

    /**
     * gets the name of the tile
     * @return name
     */
    public String getName(){
        return this.name;
    }

    /**
     * checks to see if the tile has been mortgaged
     * @return true if yes or false if no
     */
    public boolean mortgaged(){
        return this.mortgaged;
    }
    /**
     * sets the tiles status to mortgaged or not mortgaged
     * @param mortgaged true or false
     */
    public void setMortgage(boolean mortgaged){
        this.mortgaged =  mortgaged;

    }

    /**
     * gets the color of the tile
     * @return color
     */
    public Colors getColor(){
        return this.color;
    }

    /**
     * sets an owner to the tile
     * @param owner
     */
    public void setOwner(Player owner){
        this.owner = owner;
        this.owned = true;

    }

    public Player getOwner(){
        return this.owner;
    }

    /**
     * checks to see if the tile is owned already or not
     * @return
     */
    public boolean owned(){
        return this.owned;
    }


    /**
     * checks to see if a tile iss equal to another
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if(obj instanceof Tiles){
            Tiles tile = (Tiles) obj;
            if(this.name.equals(tile.name)){
                result = true;
            }
        }
        return result;
    }

    /**
     * String representation of a tile
     */
    @Override
    public String toString() {
        return super.toString();
    }

}