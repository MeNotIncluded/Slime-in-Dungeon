package Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Element.Element;
import Event.Event;
import Character.*;


public class Game extends JPanel implements KeyListener
{

    private static final long serialVersionUID = 1L;

    private static int speed = 50,slimeSize = 60 ,waveHeight = 50;
    private static int base = 400,xStart = 1000;
    private long point = 0,lastPress = 0;

    private Slime slime = new Slime(100,base-50);
    static Display display;
    //	------------------Wave Size ----------------------------
    private Ghost_Wave[] waveSet = makeWave(4);
    private Ghost_Wave1[] waveSet1 = makeWave1(4);
    private Ghost_Wave2[] waveSet2 = makeWave2(4);
    //--------------------Cloud--------------------------------
    private Environment[] envSet = makeEnv(2,Environment.smoke);
    private Environment building = new Environment(xStart-100,base-150,this,Environment.BUILDING,4);

    public Game()
    {
        this.setBounds(0,0,1000,600);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setLayout(null);
    }

    @Override
    public void paint(Graphics g)
    {
        try
        {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            this.drawBackground(g2);
            //--- Score ---
            g2.setFont(Element.getFont(30));
            g2.setColor(Color.white);
            g2.drawString("Score : "+point,750,40);
            //--- Slime ---
            g2.setColor(Color.RED);
            drawslimeHealth(g2);
            g2.drawImage(slime.getImage(),slime.x,slime.y,slimeSize,slimeSize, null);
            //--- Ghost_Wave ---
            for(Ghost_Wave item : waveSet)
            {
                drawWave(item,g2);
            }
            for(Ghost_Wave1 item1 : waveSet1)
            {
                drawWave1(item1,g2);
            }
            for(Ghost_Wave2 item1 : waveSet2)
            {
                drawWave2(item1,g2);
            }
            this.point+=1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void drawBackground(Graphics2D g2) throws IOException
    {
        g2.drawImage(ImageIO.read(new File("img/Bg11.png")),0,0,2000,1000, null);
        g2.drawImage(building.getImage(),building.x,building.y,500,200,null);
        g2.drawImage(ImageIO.read(new File("img/Bg12.png")),0,base+10,2000,220, null);
        for(Environment item:envSet)
        {
            g2.drawImage(item.getImage(),item.x,item.y,250,160, null);
        }
    }

    private void drawslimeHealth(Graphics2D g2)
    {
        try
        {
            g2.drawImage(ImageIO.read(new File("img/Heart.png")),10,15, 25,25,null);
            g2.setStroke(new BasicStroke(18.0f));
            g2.setColor(new Color(230, 0, 0));
            g2.drawLine(60, 30,60+slime.health,30);
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(6.0f));
            g2.drawRect(50,20, 200,20);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Ghost_Wave[] makeWave(int size)
    {
        Ghost_Wave[] waveSet = new Ghost_Wave[size];
        int far = 500;
        for(int i=0;i<size;i++)
        {
            waveSet[i] = new Ghost_Wave(xStart+far,base,speed,this);
            far+=500;
        }
        return waveSet;
    }

    private Ghost_Wave1[] makeWave1(int size)
    {
        Ghost_Wave1[] waveSet1 = new Ghost_Wave1[size];
        int far = 500;
        for(int i=0;i<size;i++)
        {
            waveSet1[i] = new Ghost_Wave1(xStart+far,base,speed,this);
            far+=500;
        }
        return waveSet1;
    }

    private Ghost_Wave2[] makeWave2(int size)
    {
        Ghost_Wave2[] waveSet2 = new Ghost_Wave2[size];
        int far = 500;
        for(int i=0;i<size;i++)
        {
            waveSet2[i] = new Ghost_Wave2(xStart+far,base,speed,this);
            far+=500;
        }
        return waveSet2;
    }

    private Environment[] makeEnv(int size,int eType)
    {
        Environment[] envSet = new Environment[size];
        int far = 0;
        for(int i=0;i<size;i++)
        {
            envSet[i] = new Environment(xStart+far,20,this,eType,10);
            far+=600;
        }
        return envSet;
    }

    private void drawWave(Ghost_Wave wave,Graphics2D g2)
    {
        g2.drawImage(wave.getImage(),wave.x ,(wave.y-waveHeight),40,waveHeight+10,null);
        if(Event.checkHit(slime,wave,slimeSize,waveHeight))
        {
            g2.setColor(new Color(250, 250, 250));
            g2.fillRect(0, 0,1000,1000);
            slime.health-=3;
            if(slime.health<=0)
            {
                display.endGame(this.point);
                slime.health = new Slime().health;
                this.point = 0;
            }
        }
    }

    private void drawWave1(Ghost_Wave1 wave,Graphics2D g2)
    {
        g2.drawImage(wave.getImage(),wave.x ,(wave.y-waveHeight),40,waveHeight+10,null);
        if(Event.checkHit1(slime,wave,slimeSize,waveHeight))
        {
            g2.setColor(new Color(250, 250, 250));
            g2.fillRect(0, 0,1000,1000);
            slime.health-=3;
            if(slime.health<=0)
            {
                display.endGame(this.point);
                slime.health = new Slime().health;
                this.point = 0;
            }
        }
    }

    private void drawWave2(Ghost_Wave2 wave,Graphics2D g2)
    {
        g2.drawImage(wave.getImage(),wave.x ,(wave.y-waveHeight),40,waveHeight+10,null);
        if(Event.checkHit2(slime,wave,slimeSize,waveHeight))
        {
            g2.setColor(new Color(250,250, 250));
            g2.fillRect(0, 0,1000,1000);
            slime.health-=3;
            if(slime.health<=0)
            {
                display.endGame(this.point);
                slime.health = new Slime().health;
                this.point = 0;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        //System.out.println(e);
        if(System.currentTimeMillis() - lastPress > 630)
        {
            if(e.getKeyCode()==32||e.getKeyCode()==38||e.getKeyCode()==87)
            {
                slime.Up(this);
                lastPress = System.currentTimeMillis();
            }
        }
        if(System.currentTimeMillis() - lastPress > 630)
        {
            if(e.getKeyCode()==40||e.getKeyCode()==83)
            {
                slime.Down(this);
                lastPress = System.currentTimeMillis();
            }
        }
        //if(System.currentTimeMillis() - lastPress > 630)
        //{
        //    if(e.getKeyCode()==39||e.getKeyCode()==68)
        //    {
        //        slime.Front(this);
        //        lastPress = System.currentTimeMillis();
        //    }
        //}
        //if(System.currentTimeMillis() - lastPress > 630)
        // {
        //    if(e.getKeyCode()==37||e.getKeyCode()==65)
        //    {
        //        slime.Back(this);
        //        lastPress = System.currentTimeMillis();
        //    }
        //}
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] arg) {
        display = new Display();
    }
}