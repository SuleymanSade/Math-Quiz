import java.util.Random;

public class Math {
    static int num1;
    static int num2;
    
    static int operator;
    static Random rand;

    static int correctAnswer;

    public static String question;

    Math(){
        rand = new Random();
    }

    public static String newQuestion(){
        operator = rand.nextInt(4);
        switch (operator) {
            case 0:
                num1 = rand.nextInt(100);
                num2 = rand.nextInt(100);
                correctAnswer = num1 + num2;
                return num1 + "+" + num2;
            case 1:
                num1 = rand.nextInt(100);
                num2 = rand.nextInt(100);
                correctAnswer = num1 - num2;
                return num1 + "-" + num2;
            case 2:
                num1 = rand.nextInt(15);
                num2 = rand.nextInt(15);
                correctAnswer = num1 * num2;
                return num1 + "*" + num2;
            case 3:
                num1 =1;
                num2 =2;
                while (((double)num1/num2)%1 != 0) {
                    num1 = rand.nextInt(100);
                    num2 = rand.nextInt(100);
                    while (num2 == 0) {
                        num2 = rand.nextInt(10);
                    }
                }
                correctAnswer = num1 / num2;
                return num1 + "/" + num2;
        }
        return question;
    }
}
