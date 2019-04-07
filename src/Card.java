public class Card {

    private char suit;
    private int face;
    private int value;
    private boolean faceUp;

        Card(char s, int f) {

            suit = s;
            face = f;
            if(face<10) value = face;
            else value = 10;
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

        public int getValue()
        {

            return value;

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

