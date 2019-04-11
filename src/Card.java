import java.awt.*;

public class Card {

    private char suit;
    private int face;
    private boolean faceUp;
    private int x, y;
    private int imgIndex;

    Card(char s, int f, int imgIndex) {

        suit = s;
        face = f;
        faceUp=false;
        x = 100;
        y = 140;
        this.imgIndex = imgIndex;
    }

        Card(char s, int f, int x, int y) {

            suit = s;
            face = f;
            faceUp=false;
            this.x = x;
            this.y = y;
        }

        public char getSuit()
        {

            return suit;

        }

        public int getFace()
        {

            return face;

        }

        public boolean getFaceUp()
        {

            return faceUp;

        }

        public void flipCard()
        {

            faceUp = !faceUp;

        }

        public void render(Graphics g)
        {
            if (faceUp)
            g.drawImage(Deck.visual[imgIndex], x - Deck.visual[imgIndex].getWidth(null)/2, y -Deck.visual[imgIndex].getHeight(null)/2, null);
            else
                g.drawImage(Deck.cardBack, x - Deck.visual[imgIndex].getWidth(null)/2, y -Deck.visual[imgIndex].getHeight(null)/2, null);

        }

        public void setX(int x){
        this.x = x;
        }
    public void setY(int y){
        this.y = y;
    }


    }

