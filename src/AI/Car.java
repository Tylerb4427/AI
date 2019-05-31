/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author bovenzit2681
 */
public class Car extends Object {

    private double x, y, theta, speed, turnSpeed, score, totalDistance;
    private int step,tts;
    private final int width = 7, height = 7;
    private Image image;
    private Color color;
    private boolean active;
    public ArrayList<Integer> turns;
    public ArrayList<Integer> gas;

    public Car(double x, double y, double theta, double speed, double turnSpeed, Color color, ArrayList<Integer> turn, ArrayList<Integer> gas,int tts) {
        this(x, y, theta, speed, turnSpeed, color);
        this.turns = turn;
        this.gas = gas;
        this.tts=tts;
    }

    public Car(double x, double y, double theta, double speed, double turnSpeed, Color color) {
        this.x = x;
        this.y = y;
        this.theta = theta;
        this.speed = speed;
        this.turnSpeed = turnSpeed;
        this.color = color;
        score = 0;
        totalDistance = 0;
        active = true;
        turns = new ArrayList<>();
        gas = new ArrayList<>();
        step = 1;
    }

    public void move() {
        totalDistance += speed;
        x += speed * Math.cos(Util.toRadian(theta));
        y -= speed * Math.sin(Util.toRadian(theta));
        score += speed*speed ;
    }

    public void draw(Graphics window) {

        //window.drawImage(temp, Util.round(getX()), Util.round(getY()), width, height, null);
        Graphics2D gg = (Graphics2D) window.create();
        gg.rotate(Util.toRadian(-theta), x + width / 2, y + height / 2);
        gg.setColor(Color.getHSBColor((float) score / 1000, 1f, 1f));
        gg.fillRect(Util.round(x), Util.round(y), width, height);
        gg.dispose();
        gg = (Graphics2D) window.create();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setActive(boolean bool) {
        active = bool;
    }

    public boolean getActive() {
        return active;
    }

    public void drive() {
        if (getTts()>getStep()&&turns.size() > getStep() && gas.size() > getStep()) {
            doSomething(turns.get(getStep()), gas.get(getStep()));
        } else {
            doRandom();
        }
        setStep(getStep() + 1);
        
    }

    public void doSomething(int t, int g) {

        switch (t) {
            case -1:
                turns.add(1);
                this.setTheta(this.getTheta() + 10);
                setSpeed(getSpeed()*.995);
                break;
            case 1:
                turns.add(-1);
                this.setTheta(this.getTheta() - 10);
                setSpeed(getSpeed()*.995);
                break;
            default:
                break;
        }

        switch (g) {
            case 1:
                gas.add(1);
                if (this.getSpeed() < 3) {
                    this.setSpeed(this.getSpeed() + .05);
                }
                break;
            case -1:
                gas.add(-1);
                if (this.getSpeed() > 0) {
                    this.setSpeed(this.getSpeed() - .045);
                }
                break;
            default:
                break;

        }
    }

    public void doRandom() {
        int choice = (int) Math.round(Math.random() * 4);
        switch (choice) {
            case 1:
                turns.add(1);
                this.setTheta(this.getTheta() + 10);
                setSpeed(getSpeed()*.995);
                break;
            case 2:
                turns.add(-1);
                this.setTheta(this.getTheta() - 10);
                setSpeed(getSpeed()*.995);
                break;
            default:
                break;
        }
        choice = (int) Math.round(Math.random() * 3);
        switch (choice) {
            case 1:
                gas.add(1);
                if (this.getSpeed() < 3) {
                    this.setSpeed(this.getSpeed() + .05);
                }
                break;
            case 2:
                gas.add(-1);
                if (this.getSpeed() > 0) {
                    this.setSpeed(this.getSpeed() - .045);
                }
                break;
            default:
                break;

        }
    }

    public double getWidth() {
        return width;
    }

    double getHeight() {
        return height;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String toString() {
        return "" + score;
    }

    public int compareTo(Car other) {
        return Util.round(this.getScore() - other.getScore());
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getTts() {
        return tts;
    }

    public void setTts(int tts) {
        this.tts = tts;
    }
}
