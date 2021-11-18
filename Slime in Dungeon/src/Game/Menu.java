package Game;

import Element.EleButton;
import Element.EleLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Menu extends JPanel {

    private static final long serialVersionUID = 1L;
    public long point;

    public Menu(long point, ActionListener main) {
        try {
            this.point = point;
            this.setBackground(new Color(50, 50, 50));
            this.setBounds(0,0,1000,600);
            this.setFocusable(true);
            this.setLayout(null);

            EleLabel status = new EleLabel("Game Over",40,372,100,300,100);
            status.setForeground(Color.white);

            EleLabel showPoint = new EleLabel("Score : "+this.point,30,390,200,200,100);
            showPoint.setForeground(Color.white);

            EleButton restart = new EleButton("Restart",15,380,300,200,50);
            restart.addActionListener(main);

            this.add(showPoint);
            this.add(status);
            this.add(restart);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
