package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import logic.AdvanceToGoCard;
import logic.ChanceCard;
import logic.Collect200Card;
import logic.Collect50Card;
import logic.GetOutOfJailFreeCard;
import logic.GoToJailCard;
import logic.Lose100Card;
import logic.Lose50Card;

public class Chance extends Tiles {

    private List<ChanceCard> chanceCards;

    public Chance(String name, int cost, int rent, int mortgage, Colors color) {
        super(name, cost, rent, mortgage, color);
        chanceCards = new ArrayList<>();
        initializeChanceCards();
        shuffleCards();
         
    }

    public void initializeChanceCards(){
        Random random = new Random();
        int numPos200Cards = random.nextInt(5);
        int numNeg100Cards = random.nextInt(4);
        for (int i = 0; i < numPos200Cards; i++){
            chanceCards.add(new Collect200Card());
        }
        for (int i = 0; i < numNeg100Cards; i++){
            chanceCards.add(new Lose100Card());
        }
        int numPos50Cards = random.nextInt(5);
        int numNeg50Cards = random.nextInt(4);
        for (int i = 0; i < numPos50Cards; i++){
            chanceCards.add(new Collect50Card());
        }
        for (int i = 0; i < numNeg50Cards; i++){
            chanceCards.add(new Lose50Card());
        }
        chanceCards.add(new GoToJailCard());
        chanceCards.add(new GetOutOfJailFreeCard());
        chanceCards.add(new AdvanceToGoCard());
    }

    public void shuffleCards(){
        Collections.shuffle(chanceCards);
    }

    public ChanceCard drawCard(){
        if (chanceCards.isEmpty()){
            initializeChanceCards();
            shuffleCards();
        }
        return chanceCards.remove(0);
    }
    
}
