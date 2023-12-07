package ej.unogame_maven;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class UnoDeck {

    private UnoCard[] cards;
    private int cardsInDeck;

    public UnoDeck() { //84 sin las 16 de drawtwo
        cards = new UnoCard[100]; // 108 con todas las cartas
        reset();
    }

    public void reset() {
        UnoCard.Color[] colors = UnoCard.Color.values();
        cardsInDeck = 0;

        for (int i = 0; i < colors.length - 1; i++) {
            UnoCard.Color color = colors[i];

            cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(0));

            for (int j = 1; j < 10; j++) {
                cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(j));
                cards[cardsInDeck++] = new UnoCard(color, UnoCard.Value.getValue(j));
            }

//            UnoCard.Value[] values = new UnoCard.Value[]{UnoCard.Value.DrawTwo, UnoCard.Value.Skip, UnoCard.Value.Reverse}; //24 cartas
//            
//            for (UnoCard.Value value : values) {
//                cards[cardsInDeck++] = new UnoCard(color, value);
//                cards[cardsInDeck++] = new UnoCard(color, value);
//            }

            UnoCard.Value[] values = new UnoCard.Value[]{UnoCard.Value.Reverse}; //24 cartas
            
            for (UnoCard.Value value : values) {
                cards[cardsInDeck++] = new UnoCard(color, value);
                cards[cardsInDeck++] = new UnoCard(color, value); 
                cards[cardsInDeck++] = new UnoCard(color, value);
                cards[cardsInDeck++] = new UnoCard(color, value); 
            }
        }

        
        // cartas de cambio color y +4
        // 8 cartas en total, 4 y 4
        UnoCard.Value[] values = new UnoCard.Value[]{UnoCard.Value.Wild, UnoCard.Value.Wild_Four}; 
        
        for (UnoCard.Value value : values) {
            for (int i = 0; i < 4; i++) {
                cards[cardsInDeck++] = new UnoCard(UnoCard.Color.Wild, value);
            }
        }   
    }

    public void replaceDeckWith(ArrayList<UnoCard> cards) {
        this.cards = cards.toArray(new UnoCard[cards.size()]);
        this.cardsInDeck = this.cards.length;
    }

    public boolean isEmpty() {
        return cardsInDeck == 0;
    }

    public void shuffle() {
        int n = cards.length;
        Random random = new Random();

        for (int i = 0; i < cards.length; i++) {

            int randomValue = i + random.nextInt(n - i);
            UnoCard randomCard = cards[randomValue];
            cards[randomValue] = cards[i];
            cards[i] = randomCard;
        }
    }

    public UnoCard drawCard() throws IllegalArgumentException {
        if (isEmpty()) {
            throw new IllegalArgumentException("No puedes levantar una carta porque no hay mas");
        }
        return cards[--cardsInDeck];
    }

    public ImageIcon drawCardImage() throws IllegalArgumentException {
        if (isEmpty()) {
            throw new IllegalArgumentException("No puedes levantar una carta porque no hay mas");
        }
        return new ImageIcon(cards[--cardsInDeck].toString() + ".png");
    }

    public UnoCard[] drawCard(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Deberias levantar un numero positivo pero deseas levantar " + n + " cartas.");
        }

        if (n > cardsInDeck) {
            throw new IllegalArgumentException("No puedes levantar " + n + " cartas porque solo hay " + cardsInDeck + " cartas.");
        }

        UnoCard[] ret = new UnoCard[n];

        for (int i = 0; i < n; i++) {
            ret[i] = cards[--cardsInDeck];
        }
        return ret;
    }
}
