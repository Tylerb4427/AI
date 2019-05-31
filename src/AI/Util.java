/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

import java.util.ArrayList;

/**
 *
 * @author bovenzit2681
 */
public class Util {

    public static int round(double num) {
        return (int) Math.round(num);
    }

    public static double toRadian(double deg) {
        return (deg * Math.PI) / 180;
    }

    public static ArrayList<Integer> subArray(ArrayList<Integer> init, int end,Car car) {

        ArrayList<Integer> ans = new ArrayList<>();
        if (init.size() < end) {
            return ans;
        }
        for (int i = 0; i < car.getStep() - end&&i<init.size(); i++) {
            ans.add(init.get(i));
        }
        return ans;
    }
}
