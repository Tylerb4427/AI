/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author bovenzit2681
 */
public class Wall implements WallData{


    private static ArrayList<Cone> wall; 
    
    public Wall(){
        wall=new ArrayList<>();
       for(int i=0;i<xVals.length;i+=1){
           wall.add(new Cone(yVals[i],xVals[i]-20));
       }
    }
    
    public void drawAll(Graphics window){
        for(Cone cone:wall){
            cone.draw(window);
        }
    }
    
    public static ArrayList<Cone> getList() {
        return wall; 
    }
}
