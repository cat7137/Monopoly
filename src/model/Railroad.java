/**
 * Railroad Class
 * Author: Cody Thompson
 * 
 * Contains all the methods required for Railroad interactions
 */


package model;

public class Railroad extends Tiles{

    /**
     * rent for oneRailroad
     */
    private int oneRailroadRent;
    /**
     * rent for twoRailRoads
     */
    private int twoRailroadsRent;
    /**
     * rent for threeRailroads
     */
    private int threeRailroadsRent;
    /**
     * rent for fourRailroads
     */
    private int fourRailroadsRent;

    /**
     * Railroad constructor
     * @param name name of railroad
     * @param cost cost of railroad
     * @param rent rent for railroad
     * @param mortgage mortgage for railroad
     * @param color color for railroad (RAILROAD)
     */
    public Railroad(String name, int cost, int rent, int mortgage, Colors color) {
        super(name, cost, rent, mortgage, color);
        this.oneRailroadRent = rent;
        this.twoRailroadsRent = (rent * 2);
        this.threeRailroadsRent = (twoRailroadsRent * 2);
        this.fourRailroadsRent = (threeRailroadsRent * 2);
    }

    /**
     * Gets the rent for OneRailRoad
     * @return
     */
    public int getOneRailroadRent(){
        return this.oneRailroadRent;
    }
    /**
     * Gets the rent for TwoRailroads
     * @return
     */
    public int getTwoRailroadsRent(){
        return this.twoRailroadsRent;
    }
    /**
     * Gets the rent for ThreeRailroads
     * @return
     */
    public int getThreeRailroadsRent(){
        return this.threeRailroadsRent;
    }
    /**
     * Gets the rent for FourRailroads
     * @return
     */
    public int getFourRailroadsRent(){
        return this.fourRailroadsRent;
    }

    /**
     * Gets the cost of a railroad
     */
    public int getCost(){
        return super.getCost();
    }

    /**
     * Gets the mortgage for the railroad
     */
    public int getMortgage(){
        return super.getMortgage();
    }

    public void completeAction(){
        
    }

    /**
     * String representation of a railroad
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
