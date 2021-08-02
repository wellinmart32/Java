/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kidslearning;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author welli
 */
public class Question extends JLabel {
    
    private String text;
    private int width, height, posX, posY;

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
    
    public void displayQuestion(QuestionAnswersGame questionAnswersGame) {
        text = questionAnswersGame.getQuestion();
        setText(text);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        if(text.length() > 60)
            this.setFont(new Font("Agency FB", Font.BOLD, 30));
        else
            this.setFont(new Font("Agency FB", Font.BOLD, 36));
    }
}
