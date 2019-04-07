import javax.imageio.ImageIO;
import java.awt.*;
import java.util.LinkedList;

public class Deck
{

    private LinkedList deck= new LinkedList();
    public static Image[] visual = new Image[52];

    public static void imgArray(){

        for (int c = 0; c < 12; c++){
            visual[c] = ImageIO.read(Deck.class.getResource("/resources/c" + c));
            }
        }


    Deck()
    {

        reset();

    }

    private void reset()
    {

        System.out.println("creating deck...");
        char suits[] = {'h', 'd', 'c', 's'};
        deck.clear();
        Card temp;
        for(int suit=0; suit<4; suit++)
        {

            for(int type=1; type<14; type++)
            {

                temp = new Card(suits[suit], type);
                deck.add(temp);

            }

        }
        shuffle();

    }

    private void shuffle()
    {

        Card temp;
        int card1, card2;
        System.out.println("shuffling deck...");
        System.out.println(deck.size());


        for(int shift=0; shift<1000; shift++)
        {

            card1 = (int) (Math.random()*deck.size());
            card2 = (int) (Math.random()*deck.size());
            while(card1 == card2)
            {

                card2 = (int) (Math.random()*deck.size());

            }
            temp = (Card) deck.get(card1);
            deck.set(card1, deck.get(card2));
            deck.set(card2, temp);

        }

    }

    public Card dealCard()
    {

        return (Card) deck.removeFirst();

    }

}

