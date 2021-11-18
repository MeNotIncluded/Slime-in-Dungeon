package Character;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Ghost_Wave1 {
    public int speed;
    public int x;
    public int y;
    Timer timeMove;
    public Ghost_Wave1(int x,int y,int speed,JPanel page)
    {
        this.x = 5000;
        this.y = 310;
        this.speed = speed;
        this.move(page);
    }

    public void move(JPanel page) {
        this.timeMove = new Timer(speed,new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                if(x<=0) {
                    x = (int) (1000+(320+Math.random()*1000));
                }
                x -= 30;
                page.repaint();
            }
        });
        this.timeMove.start();
    }

    public BufferedImage getImage()
    {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("img/Ghost.png"));
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
}
