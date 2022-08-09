package coreJAVA.Day_10;
class DownCastParent{

}
class DownCastChild extends DownCastParent{
    static void downCast(DownCastParent downCastParent){
        if(downCastParent instanceof DownCastChild) {
            DownCastChild downCastChild = (DownCastChild) downCastParent;
        }
        System.out.println("DownCastChild downCastChild = (DownCastChild) downCastParent; \nThis is downCasting !!");
    }
}
public class DownCastDemo {
    public static void main(String[] args) {
        DownCastParent downCastParent = new DownCastParent();
        DownCastChild.downCast(downCastParent);
    }
}
/*
DownCastChild downCastChild = (DownCastChild) downCastParent;
This is downCasting !!

 */