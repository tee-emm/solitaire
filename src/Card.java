public class Card {

    private char suit;
    private int face;
    private boolean faceUp;

        Card(char s, int f) {

            suit = s;
            face = f;
            faceUp=false;

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


    }

