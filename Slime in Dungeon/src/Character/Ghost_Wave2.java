package Character;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Ghost_Wave2 {
    public int speed;
    public int x;
    public int y;
    Timer timeMove;
    public Ghost_Wave2(int x,int y,int speed,JPanel page)
    {
        this.x = 15000;
        this.y = 490;
        this.speed = speed;
        this.move(page);
    }

    public void move(JPanel page) {
        this.timeMove = new Timer(speed,new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                if(x<=0) {
                    x = (int) (1000+(340+Math.random()*1000));
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