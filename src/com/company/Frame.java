package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame extends JFrame implements MouseListener {
    Panel panel;
    JButton run = new JButton("Run");
    private int runX =200;
    private int runY =200;
    JButton reset = new JButton("Reset");

    Frame()
    {
        panel = new Panel();


        run.setBounds(200,200,100,100);
        reset.setBounds(5,5,100,100);
        reset.addActionListener(e ->
        {
            run.setBounds(200,200,100,100);
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setResizable(false);
        add(panel);
        add(run);
        add(reset);
        setLayout(null);
        setVisible(true);
        setTitle("Lab 4");
    }


    public void button_run()
    {
        if(runY==200) runY=5;
        if(runY==5 && runX==200) runX=395;
        if(runY==5 && runX==395) runY=395;
        if(runY==395 && runX==395) runX=5;
        if(runY==395 && runX==5) runY=110;
        if(runY==110 && runX==5) runX=110;
        if(runY==110 && runX==110) runY=5;
        if(runY==5 && runX==110) runX=395;
        run.setBounds(runY,runX,100,100);
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