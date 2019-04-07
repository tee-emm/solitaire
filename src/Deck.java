import javax.imageio.ImageIO;
import java.awt.*;
import java.util.LinkedList;

public class Deck {

    public static Image[] visual = new Image[52];
    public static Image cardBack;
    private LinkedList<Card> deck = new LinkedList<>();

    Deck() {

        reset();

    }

    public static void imgArray() {

        try {

            cardBack = ImageIO.read(Deck.class.getResource("Card Back.png"));

            for (int c = 1; c <= 13; c++) {
                visual[c - 1] = ImageIO.read(Deck.class.getResource("C" + c + ".png"));
            }
            for (int d = 1; d <= 13; d++) {
                visual[d + 12] = ImageIO.read(Deck.class.getResource("D" + d + ".png"));
            }
            for (int h = 1; h <= 13; h++) {
                visual[h + 25] = ImageIO.read(Deck.class.getResource("H" + h + ".png"));
            }
            for (int s = 1; s <= 13; s++) {
                visual[s + 38] = ImageIO.read(Deck.class.getResource("S" + s + ".png"));
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

