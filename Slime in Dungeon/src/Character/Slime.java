package Character;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Slime
{
    public int x;
    public int y;
    public int health = 180;
    public static int speed = 90;

    public Slime()
    {

    }

    public Slime(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void Up(JPanel page)
    {
        this.y -= speed;
        page.repaint();
        //--- fall ---
        Timer timer =new Timer(640,new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                y += speed;
                page.repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void Down(JPanel page)
    {
        this.y += speed;
        page.repaint();
        Timer timer =new Timer(640,new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                y -= speed;
                page.repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    //public void Front(JPanel page)
    //{
    //    this.x += speed;
    //    page.repaint();
    //    Timer timer =new Timer(640,new ActionListener()
    //    {
    //        public void actionPerformed(ActionEvent e)
    //        {
    //            x -= speed;
    //            page.repaint();
    //        }
    //    });
    //    timer.setRepeats(false);
    //    timer.start();
    //}

    //public void Back(JPanel page)
    // {
    //    this.x -= speed;
    //    page.repaint();
    //    Timer timer =new Timer(640,new ActionListener()
    //    {
    //        public void actionPerformed(ActionEvent e)
    //        {
    //            x += speed;
    //            page.repaint();
    //        }
    //    });
    //    timer.setRepeats(false);
    //    timer.start();
    //}

    public BufferedImage getImage()
    {
        BufferedImage image = null;
        try
        {
            image = ImageIO.read(new File("img/Slime.png"));
            return image;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return image;
    }
}