import javax.swing.*;
import java.awt.*;

/**
 * Created by thomassmuir on 2019-02-12.
 */
public class Window {

    public Window(int width, int height, Solitaire solitaire){

        JFrame frame = new JFrame("Solitaire");
        JTextArea loading = new JTextArea("Loading...");
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(loading);
        frame.add(solitaire);
        frame.setVisible(true);
        solitaire.start();


    }
}