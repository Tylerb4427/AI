/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author bovenzit2681
 */
public class aiGroup {

    private static ArrayList<Car> group;
    private int numActive;


    public aiGroup(int num) {
        ArrayList<Integer> test = new ArrayList<>();
        ArrayList<Integer> test2 = new ArrayList<>();
//        for (int i = 0; i < 50; i++) {
//            test.add(1);
//            test2.add(0);
//        }
        group = new ArrayList<Car>();
        numActive = num;
        for (int i = 0; i < num; i++) {
            //group.add(new Car(100, 135, 0, 1, 1, Color.getHSBColor((float) i / num, 1f, .5f)));
            group.add(0,new Car(100, 135, 30, 1, 1, Color.getHSBColor((float) i / num, 1f, .5f),test2,test,50));
            group.get(i).setSpeed(1);
        }
    }

    public void drawAll(Graphics window) {
        for (Car i : getGroup()) {
            i.draw(window);
        }
    }

    public void moveAll() {
        for (Car i : getGroup()) {
            if (i.getActive()) {
                i.drive();
                i.move();
            }
        }
        //System.out.println(numActive);
    }

    public void sort() {
        {
            int n = getGroup().size();
            Car temp;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {
                    if (getGroup().get(j - 1).getScore()/getGroup().get(j - 1).getStep() > getGroup().get(j).getScore()/getGroup().get(j).getStep()) {
                        temp = getGroup().get(j-1);
                        getGroup().set(j-1,getGroup().get(j));
                        getGroup().set(j,temp);
                    }

                }
            }

        }

    }

    public void checkCollision() {
        sort();
        for (int a = getGroup().size() - 1; a >= 0; a--) {
            Car i = getGroup().get(a);
            if (getGroup().get(a).getActive()) {
                for (Cone o : Wall.getList()) {
                    if (i.getX() < o.getX() && i.getX() + i.getWidth() > o.getX() + 1) {
                        if (i.getY() < o.getY() && i.getY() + i.getHeight() > o.getY() + 1) {
                            //group.remove(a);
                            if (i.getActive()) {
                                numActive--;
                            }
                            getGroup().get(a).setActive(false);
                            getGroup().get(a).setTts(getGroup().get(a).getStep()-10);
                            getGroup().remove(a);
                                    //sort();
                            int place=getGroup().size()-1;
                            //int place = Util.round(Math.random() * (group.size() - 1));
                            getGroup().add(new Car(100, 135, 30, 1, 1, Color.getHSBColor((float) 100, 1f, .5f), Util.subArray(getGroup().get(place).turns, 1,getGroup().get(place)), Util.subArray(getGroup().get(place).gas, 1,getGroup().get(place)),getGroup().get(place).getStep()));
                        }
                    }
                }
            }
        }
    }

    public static ArrayList<Car> getGroup() {
        return group;
    }
}
