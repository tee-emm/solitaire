import java.util.LinkedList;

public abstract class Stack {

        private LinkedList stack = new LinkedList();

        Stack()
        {

            reset();

        }

        private void reset()
        {

            System.out.println("creating deck...");
            char suits[] = {'h', 'd', 'c', 's'};
            stack.clear();
            Card temp;
            for(int suit=0; suit<4; suit++)
            {

                for(int type=1; type<14; type++)
                {

                    temp = new Card(suits[suit], type);
                    stack.add(temp);

                }

            }
            shuffle();

        }

        private void shuffle()
        {

            Card temp;
            int card1, card2;
            System.out.println("shuffling deck...");
            System.out.println(stack.size());


            for(int shift=0; shift<1000; shift++)
            {

                card1 = (int) (Math.random()*stack.size());
                card2 = (int) (Math.random()*stack.size());
                while(card1 == card2)
                {

                    card2 = (int) (Math.random()*stack.size());

                }
                temp = (Card) stack.get(card1);
                stack.set(card1, stack.get(card2));
                stack.set(card2, temp);

            }

        }

        public Card dealCard()
        {

            return (Card) stack.removeFirst();

        }

    }


