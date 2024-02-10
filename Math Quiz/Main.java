import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

class Main{
    public static void main(String[] args) {
        ButtonCreator buttonCreator = new ButtonCreator();

        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 1024, 600);

        Window window = new Window();

        
        // frame.add(window.questionLabel);
        buttonCreator.showButtons(frame);

        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_0:
                        Window.currentCharacter = "0";
                        break;
                    case KeyEvent.VK_1:
                        Window.currentCharacter = "1";
                        break;
                    case KeyEvent.VK_2:
                        Window.currentCharacter = "2";
                        break;
                    case KeyEvent.VK_3:
                        Window.currentCharacter = "3";
                        break;
                    case KeyEvent.VK_4:
                        Window.currentCharacter = "4";
                        break;
                    case KeyEvent.VK_5:
                        Window.currentCharacter = "5";
                        break;
                    case KeyEvent.VK_6:
                        Window.currentCharacter = "6";
                        break;
                    case KeyEvent.VK_7:
                        Window.currentCharacter = "7";
                        break;
                    case KeyEvent.VK_8:
                        Window.currentCharacter = "8";
                        break;
                    case KeyEvent.VK_9:
                        Window.currentCharacter = "9";
                        break;
                    case KeyEvent.VK_C:
                    case KeyEvent.VK_BACK_SPACE:
                        Window.currentCharacter = "C";
                        break;
                    case KeyEvent.VK_ENTER:
                        Window.currentCharacter = "->";
                        break;
                    case KeyEvent.VK_MINUS:
                        Window.currentCharacter = "-";
                        break;
                }
            }
        });

        frame.add(window.scoreLabel);
        frame.add(window.questionLabel);
        frame.add(window.answerLabel);
        frame.add(window);

        frame.setVisible(true);

        window.startGameThread();

    }
}