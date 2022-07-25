package coreJAVA.Week_1.Day_5;

public class Ques_5 {
        private static int x=10;
        static {
            x++;
        }

        static {
            ++x;
        }
        {
            x--;
        }
        public static void main(String[] args) {
            Ques_5 obj = new Ques_5();
            Ques_5 obj2 = new Ques_5();
            Ques_5 obj3 = new Ques_5();

            System.out. println(x);

        }

}
