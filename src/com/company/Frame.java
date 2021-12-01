package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame extends JFrame implements MouseListener {
    JButton run = new JButton("Run");
    private int runX =200;
    private int runY =200;
    JButton reset = new JButton("Reset");
    public char key;
    @Override
    public void paint(Graphics g)
    {
        Point mouse = getMousePosition();
        Graphics2D g2D =(Graphics2D) g;
        if(key=='o')g2D.drawOval((int)mouse.getX(),(int)mouse.getY(),70,70);
        if(key=='k') g2D.drawRect((int)mouse.getX(),(int)mouse.getY(),70,70);
        run.setBounds(runX,runY,100,100);
        reset.setBounds(5,5,100,100);
    }
    Frame()
    {

        reset.addActionListener(e ->
        {
            runY=200;
            runX=200;
            run.setBounds(runY,runX,100,100);
        });
        run.addMouseListener(this);

        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(500,500);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Lab 4");
        setFocusable(true);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                key = e.getKeyChar();
                repaint();
            }
        });
        add(run);
        add(reset);
    }

    //PRZYCISK NIE UCIEKA JEŚLI NAJEDZIEMY MYSZKĄ OD GÓRNEJ KRAWĘDZI
    public void button_run()
    {
        Point mouse = getMousePosition();
        double y = mouse.getY();
        if(y<runY+34) return;
        if(runY==200) runY=5;
        else if(runY==5 && runX==200) runX=380;
        else if(runY==5 && runX==380) runY=357;
        else if(runY==357 && runX==380) runX=5;
        else if(runY==357 && runX==5) runY=110;
        else if(runY==110 && runX==5) runX=110;
        else if(runY==110 && runX==110) runY=5;
        else if(runY==5 && runX==110) runX=380;
        run.setBounds(runX,runY,100,100);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        button_run();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}