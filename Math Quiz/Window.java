import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Window extends JPanel implements Runnable{
    int FPS;

    Thread gameThread;

    public JLabel questionLabel;
    public JLabel answerLabel;

    int numberOfQuestions;
    int correctNumberOfQuestions;


    public static String answer;
    public static int correctAnswer;

    public static String currentCharacter;

    JLabel scoreLabel;


    Math math;

    Window(){
        FPS = 60;


        answer = "";
        currentCharacter = "";

        numberOfQuestions = 0;
        correctNumberOfQuestions = 0;
        
        questionLabel = new JLabel();
        questionLabel.setBounds(256, 32, 512, 64);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 50));
        questionLabel.setText("question");
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setVerticalAlignment(SwingConstants.CENTER);

        answerLabel = new JLabel();
        answerLabel.setBounds(256, 128, 512, 64);
        answerLabel.setFont(new Font("Arial", Font.BOLD, 50));
        answerLabel.setText("answer");
        answerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        answerLabel.setVerticalAlignment(SwingConstants.CENTER);

        scoreLabel = new JLabel();
        scoreLabel.setBounds(0, 256, 128, 64);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 50));
        scoreLabel.setText("");
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setVerticalAlignment(SwingConstants.CENTER);

        math = new Math();

        questionLabel.setText(Math.newQuestion());


    }

    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.dispose();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public static void addCharacter(String character){
        currentCharacter = character;
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; // 0.016666 sec.
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            correctAnswer = Math.correctAnswer;
            switch (currentCharacter) {
                case "C":
                    answer = "";
                    currentCharacter = "";
                    break;
                case "-":
                    if (answer != "") {
                        answer = Integer.toString(Integer.parseInt(answer) * -1);
                    }
                    break;
                case "->":
                    if (answer!= "") {
                        questionLabel.setText(Math.newQuestion());
                        numberOfQuestions++;
                        if (Integer.parseInt(answer)==correctAnswer) {
                            correctNumberOfQuestions++;
                        }
                        currentCharacter = "";
                        answer = "";
                        scoreLabel.setText(correctNumberOfQuestions+"/"+numberOfQuestions);
                    }
                    
                    break;
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    answer += currentCharacter;
                    break;
                default:
                    break;
            }
            currentCharacter = "";

            answerLabel.setText(answer);


            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
