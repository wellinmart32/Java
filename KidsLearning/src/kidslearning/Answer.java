/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kidslearning;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author welli
 */
public class Answer extends JButton {
    private String text;
    private boolean result;
    private int posX, posY, orientationX, orientationY, width, height;

    public Answer(String text, boolean result, int width, int height) {
        this.text = text;
        this.result = result;
        this.width = width;
        this.height = height;
        orientationX = 1;
        orientationY = 1;
        if(text.length() > 10)
            this.setFont(new Font("Agency FB", Font.BOLD, 10));
        else
            this.setFont(new Font("Agency FB", Font.BOLD, 15));
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(result) {
                    
                }
            }
        });
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getOrientationX() {
        return orientationX;
    }

    public void setOrientationX(int orientationX) {
        this.orientationX = orientationX;
    }

    public int getOrientationY() {
        return orientationY;
    }

    public void setOrientationY(int orientationY) {
        this.orientationY = orientationY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
