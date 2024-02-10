import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonCreator {
    static String[][] buttons;
    static JButton button;

    ButtonCreator(){
        buttons = new String[][]{   {"1","2","3","C"}, 
                                    {"4","5","6"}, 
                                    {"7","8","9"},
                                    {"-","0","->"}};
    }

    public static JButton createButton(String character, int x, int y){
        button = new JButton();
        button.setBounds((y*128)+512-256, (x*64)+256, 128, 64);
        button.setText(character);
        button.setFont(new Font("Ariel", Font.BOLD, 64));
        button.setFocusable(false);
        button.addActionListener(e->Window.addCharacter(character));
        return button;
    }

    public void showButtons(JFrame frame){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                frame.add(createButton(buttons[i][j], i, j));
            }
        }
        frame.add(createButton(buttons[0][3], 0, 3));
    }


}
