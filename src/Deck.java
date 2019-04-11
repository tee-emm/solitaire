import javax.imageio.ImageIO;
import java.awt.*;
import java.util.LinkedList;

public class Deck {

    public static Image[] visual = new Image[52];
    public static Image cardBack;
    private LinkedList<Card> deck = new LinkedList<>();
    private int topIndex = 0;
    Deck() {

        reset();

    }

    public LinkedList<Card> dealCards(int n){
        LinkedList<Card> dealtCards = new LinkedList<>();
    }


    public LinkedList<Card> getDeck(){
        return deck;
    }

    public static void imgArray() {
        int size = 150;
        try {

            cardBack = ImageIO.read(Deck.class.getResource("Card Back.png"));
            cardBack = cardBack.getScaledInstance((int)(size*0.71428571428), size, java.awt.Image.SCALE_SMOOTH);

            for (int c = 1; c <= 13; c++) {
                Image image = ImageIO.read(Deck.class.getResource("C" + c + ".png"));
                visual[c - 1] = image.getScaledInstance((int)(size*0.71428571428), size, java.awt.Image.SCALE_SMOOTH);
            }
            for (int d = 1; d <= 13; d++) {
                Image image = ImageIO.read(Deck.class.getResource("D" + d + ".png"));
                visual[d + 12] = image.getScaledInstance((int)(size*0.71428571428), size, java.awt.Image.SCALE_SMOOTH);
            }
            for (int h = 1; h <= 13; h++) {
                Image image = ImageIO.read(Deck.class.getResource("H" + h + ".png"));
                visual[h + 25] = image.getScaledInstance((int)(size*0.71428571428), size, java.awt.Image.SCALE_SMOOTH);
            }
            for (int s = 1; s <= 13; s++) {
                Image image = ImageIO.read(Deck.class.getResource("S" + s + ".png"));
                visual[s + 38] = image.getScaledInstance((int)(size*0.71428571428), size, java.awt.Image.SCALE_SMOOTH);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reset() {

        System.out.println("creating deck...");
        char suits[] = {'c', 'd', 'h', 's'};
        deck.clear();
        Card temp;
        for (int suit = 0; suit < 4; suit++) {

            for (int type = 1; type < 14; type++) {

                temp = new Card(suits[suit], type, suit*13+type-1);
                deck.add(temp);

            }

        }
        shuffle();

    }

    private void shuffle() {

        Card temp;
        int card1, card2;
        System.out.println("shuffling deck...");
        System.out.println(deck.size());


        for (int shift = 0; shift < 1000; shift++) {

            card1 = (int) (Math.random() * deck.size());
            card2 = (int) (Math.random() * deck.size());
            while (card1 == card2) {

                card2 = (int) (Math.random() * deck.size());

            }
            temp = (Card) deck.get(card1);
            deck.set(card1, deck.get(card2));
            deck.set(card2, temp);

        }

    }

    public void render(Graphics g) {
        for (Card card : deck) {
            card.render(g);

        }
    }

    public Card dealCard() {

        return (Card) deck.removeFirst();

    }

}

