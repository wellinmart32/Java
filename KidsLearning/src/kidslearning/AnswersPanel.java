/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kidslearning;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author welli
 */
public class AnswersPanel extends JPanel {
    
    private int width, height, posX, posY;
    private ArrayList<Answer> answers;

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
    
    public void setAnswers(QuestionAnswersGame questionAnswersGame, int answerWidth, int answerHeight) {
        answers = new ArrayList<Answer>();
        Answer answer1 = new Answer(questionAnswersGame.getAnswer1(), 
        questionAnswersGame.getResult1() == 1 ? true : false,
        answerWidth, answerHeight);
        answers.add(answer1);
        System.out.println("Ingresando primera respuesta: " + answer1.getText());
        Answer answer2 = new Answer(questionAnswersGame.getAnswer2(), 
        questionAnswersGame.getResult2() == 1 ? true : false,
        answerWidth, answerHeight);
        answers.add(answer2);
        System.out.println("Ingresando segunda respuesta: " + answer2.getText());
        Answer answer3 = new Answer(questionAnswersGame.getAnswer3(), 
        questionAnswersGame.getResult3() == 1 ? true : false,
        answerWidth, answerHeight);
        answers.add(answer3);
        System.out.println("Ingresando tercera respuesta: " + answer3.getText());
        if(questionAnswersGame.getAnswer4() != null && !questionAnswersGame.getAnswer4().isEmpty()) {
            Answer answer4 = new Answer(questionAnswersGame.getAnswer4(), 
            questionAnswersGame.getResult4() == 1 ? true : false,
            answerWidth, answerHeight);
            answers.add(answer4);
            System.out.println("Ingresando cuarta respuesta: " + answer4.getText());
        }
        if(questionAnswersGame.getAnswer5() != null && !questionAnswersGame.getAnswer5().isEmpty()) {
            Answer answer5 = new Answer(questionAnswersGame.getAnswer5(), 
            questionAnswersGame.getResult5() == 1 ? true : false,
            answerWidth, answerHeight);
            answers.add(answer5);
            System.out.println("Ingresando quinta respuesta: " + answer5.getText());
        }
    }
    
    public void setRandomAnswerPosition(Answer answer, int answerWidth, int answerHeight) {
        answer.setPosX((int) Math.floor(Math.random()*(width-answer.getWidth())));
        answer.setPosY((int) Math.floor(Math.random()*(height-answer.getHeight())));
        answer.setBounds(answer.getPosX(), answer.getPosY(), answer.getWidth(), answer.getHeight());
        answer.setBorder(new RoundedBorder(40));
    }
    
    public void displayAnswers() {
        setLayout(null);
        for(Answer answer: answers) {
            setRandomAnswerPosition(answer, answer.getWidth(), answer.getHeight());
            add(answer);
            System.out.println("Dibujando respuesta: " + answer.getText() + " en el contenedor");
        }
    }
    
    public void setNewAnswersPosition() {
        for(Answer answer: answers) {
            if(answer.getOrientationX()==1 && answer.getOrientationY()==1) {
                answer.setPosX(answer.getPosX()+1);
                answer.setPosY(answer.getPosY()+1);
                answer.setLocation(answer.getPosX(), answer.getPosY());
            }else if(answer.getOrientationX()==-1 && answer.getOrientationY()==1) {
                answer.setPosX(answer.getPosX()-1);
                answer.setPosY(answer.getPosY()+1);
            }else if(answer.getOrientationX()==1 && answer.getOrientationY()==-1) {
                answer.setPosX(answer.getPosX()+1);
                answer.setPosY(answer.getPosY()-1);
            }else {
                answer.setPosX(answer.getPosX()-1);
                answer.setPosY(answer.getPosY()-1);
            }
            answer.setLocation(answer.getPosX(), answer.getPosY());
            System.out.println("Actualizando la posición de la pregunta: " + answer.getText() 
                        + " en : " + answer.getPosX() + " e y: " + answer.getPosY());
        }
        
        this.repaint();
    }
    
    public void moveAnswers() {
        TimerTask timerTask = new TimerTask() {
            public void run() {
                for(Answer answer: answers) {
                    if((answer.getPosX()+answer.getWidth() > 0 && answer.getPosX()+answer.getWidth() < width) && answer.getOrientationX()==1) {
                        answer.setOrientationX(1);
                    }else if((answer.getPosX() > 0 && answer.getPosX() < width) && answer.getOrientationX()==-1) {
                        answer.setOrientationX(-1);
                    }else if(answer.getPosX() <= 0 && answer.getOrientationX()==-1) {
                        answer.setOrientationX(1);
                    }else {
                        answer.setOrientationX(-1);
                    }
                    if((answer.getPosY()+answer.getHeight() > 0 && answer.getPosY()+answer.getHeight() < height) && answer.getOrientationY()==1) {
                        answer.setOrientationY(1);
                    }else if((answer.getPosY() > 0 && answer.getPosY() < height) && answer.getOrientationY()==-1) {
                        answer.setOrientationY(-1);
                    }else if(answer.getPosY() <= 0 && answer.getOrientationY()==-1) {
                        answer.setOrientationY(1);
                    }else {
                        answer.setOrientationY(-1);
                    }
                }
                setNewAnswersPosition();
            }
        };
        new Timer().scheduleAtFixedRate(timerTask, 0, 50);
    }
}
