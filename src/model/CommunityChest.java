/**
 * Community Chest Tile Class
 * Author: Cody Thompson
 * 
 * Contains all the methods required for Comunity Chest tile interactions
 */

package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import logic.AdvanceToGoCard;
import logic.Collect200Card;
import logic.Collect50Card;
import logic.CommunityChestCard;
import logic.GetOutOfJailFreeCard;
import logic.GoToJailCard;
import logic.Lose100Card;
import logic.Lose50Card;

public class CommunityChest extends Tiles {

    private List<CommunityChestCard> communityChestCards;

    /**
     * CommunityChest Constructor
     * @param name the name of the tile
     * @param cost the cost of the tile (N/A for Community Chest)
     * @param rent the rent of the tile (N/A for Community Chest)
     * @param mortgage the mortgage of the tile (N/A for Community Chest)
     * @param color the color of the tile (Community Chest for Community Chest)
     * initializes and shuffles the Community Chest Deck
     */
    public CommunityChest(String name, int cost, int rent, int mortgage, Colors color) {
        super(name, cost, rent, mortgage, color);
        communityChestCards = new ArrayList<>();
        initializeChanceCards();
        shuffleCards();
         
    }

    /**
     * Initializes the Community Chest Deck
     */
    public void initializeChanceCards(){
        Random random = new Random();
        int numPos200Cards = random.nextInt(5);
        int numNeg100Cards = random.nextInt(4);
        for (int i = 0; i < numPos200Cards; i++){
            communityChestCards.add(new Collect200Card());
        }
        for (int i = 0; i < numNeg100Cards; i++){
            communityChestCards.add(new Lose100Card());
        }
        int numPos50Cards = random.nextInt(5);
        int numNeg50Cards = random.nextInt(4);
        for (int i = 0; i < numPos50Cards; i++){
            communityChestCards.add(new Collect50Card());
        }
        for (int i = 0; i < numNeg50Cards; i++){
            communityChestCards.add(new Lose50Card());
        }
        communityChestCards.add(new GoToJailCard());
        communityChestCards.add(new GetOutOfJailFreeCard());
        communityChestCards.add(new AdvanceToGoCard());
    }

    /**
     * Shuffles the cards in the Community Chest Deck
     */
    public void shuffleCards(){
        Collections.shuffle(communityChestCards);
    }

    /**
     * Draws a card in the Community Chest deck
     * @return the card drawn
     */
    public CommunityChestCard drawCard(){
        if (communityChestCards.isEmpty()){
            initializeChanceCards();
            shuffleCards();
        }
        return communityChestCards.remove(0);
    }

}

