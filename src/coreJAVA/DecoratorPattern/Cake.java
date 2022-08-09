package coreJAVA.DecoratorPattern;

public interface Cake {
    void cakeMaker();
}
class RedVelvetCake implements Cake{
    @Override
    public void cakeMaker(){
        System.out.println("RedVelvet Cake :: ");
    }
}
class BlackForest implements Cake{
    @Override
    public void cakeMaker() {
        System.out.println("BlackForest Cake :: ");
    }
}
abstract class CakeDecorator{
    Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }
    public void cakeMaker(){
        cake.cakeMaker();
    }
}
class GarnishCakeDecorator extends CakeDecorator{
    public GarnishCakeDecorator(Cake cake) {
        super(cake);
    }
    public void cakeMaker(){
         cake.cakeMaker();
         addGarnish(cake);
    }
    public void addGarnish(Cake cake){
        System.out.println("Garnish++ :");
    }
}
class CakeMakingDemo{
    public static void main(String[] args) {
//        Cake cake = new BlackForest();
//        Cake garnishedBlackForestCake =  new CakeDecorator(new BlackForest());
    }
}
