package coreJAVA.Week_1.Day_8;

/**
 * 2)Create an abstract class Instrument which has the abstract function play.
 * Create three more subclasses from Instrument which are Piano, Flute, Guitar.
 * Override the play method inside all three classes printing a message. "Piano is playing
   tan tan tan tan " for Piano class "Flute is playing toot toot toot toot" for Flute class
 * "Guitar is playing tin tin tin" for Guitar class
 * You must not allow the user to declare an object of Instrument class. Create an array of|
 * 10 Instruments. Assign different types of instrument to Instrument reference. Check for
 * the polymorphic behavior of the play method. Use the instanceof operator to print
 * which object stored at which index of instrument array.
 */
abstract class Instrument {
    abstract void play();
}
class Piano extends Instrument{
    @Override
    void play() {
        System.out.println("Piano is playing tan tan tan tan ");
    }
}
class Flute extends Instrument{
    @Override
    void play() {
        System.out.println("Flute is playing toot toot toot toot");
    }
}
class Guitar extends Instrument{
    @Override
    void play() {
        System.out.println("Guitar is playing tin tin tin");
    }
}
public class Ques2 {
    public static void main(String[] args) {
        Instrument[] instrumentsArray = new Instrument[10];

                int randomValue =0;
                for(int i=0;i<10;i++){
                    randomValue =(int)(Math.random()*100);
                   // System.out.println(randomValue);
                    if(randomValue<33) {
                        instrumentsArray[i] = new Guitar();
                    }
                    else if (randomValue >70) {
                        instrumentsArray[i] = new Flute();
                    }
                    else{
                        instrumentsArray[i] = new Piano();
                    }
                }
                // using instanceOf
                for(int i=0;i<10;i++){
                    if(instrumentsArray[i] instanceof Flute) instrumentsArray[i].play();
                    else if(instrumentsArray[i] instanceof Piano) instrumentsArray[i].play();
                    else instrumentsArray[i].play();
                }
                /*
                Flute is playing toot toot toot toot
                Flute is playing toot toot toot toot
                Piano is playing tan tan tan tan
                Guitar is playing tin tin tin
                Guitar is playing tin tin tin
                Flute is playing toot toot toot toot
                Guitar is playing tin tin tin
                Flute is playing toot toot toot toot
                Guitar is playing tin tin tin
                Piano is playing tan tan tan tan
                 */

        }

}
