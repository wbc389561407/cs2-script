package vip.xiaonuo;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wangbingchen
 * @CreateTime: 2024-08-22
 */
public class MyRobot {

    //定义一个静态的Robot对象
    private static Robot robot;

    //是否是人类操作的状态属性
//    public static boolean humanFlag = true;

    //用map存放按下的键
    public static Set<Integer> keyPressSet = new HashSet<>();
    //用map存放弹起的键
    public static Set<Integer> keyReleaseSet = new HashSet<>();

    static {
        try {
            //创建Robot对象
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    //一键跳投
    public static void yijiantiaotou() {
        System.out.println("一键跳投");
        //按下空格键 释放空格键
        MyRobot.key(KeyEvent.VK_SPACE);
        //延迟
        MyRobot.sleep(30);
        //释放鼠标左键
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        //释放鼠标右键
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }


    //w跳投
    public static void yijianwtiaotou() {
        System.out.println("w跳投");
        //按下W键
        robot.keyPress(KeyEvent.VK_W);
        //按下空格键
        robot.keyPress(KeyEvent.VK_SPACE);
        //释放鼠标左键
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        //释放W键
        MyRobot.sleep(50);
        robot.keyRelease(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_SPACE);
    }
    public static void jiting(Integer code) {
        MyRobot.sleep(50);
        if(KeyEvent.VK_W == code) {
            MyRobot.key(KeyEvent.VK_S);
        }
        if(KeyEvent.VK_S == code) {
            MyRobot.key(KeyEvent.VK_W);
        }
        if(KeyEvent.VK_A == code) {
            MyRobot.key(KeyEvent.VK_D);
        }
        if(KeyEvent.VK_D == code) {
            MyRobot.key(KeyEvent.VK_A);
        }
    }

    public static void jiting(String keyText) {

        MyRobot.sleep(100);
        if(keyText.equals("W")) {
            MyRobot.key(KeyEvent.VK_S);
        }
        if(keyText.equals("S")) {
            MyRobot.key(KeyEvent.VK_W);
        }
        if(keyText.equals("A")) {
            MyRobot.key(KeyEvent.VK_D);
        }
        if(keyText.equals("D")) {
            MyRobot.key(KeyEvent.VK_A);
        }
    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void key(Integer keycode) {
        System.out.println("放入缓存："+keycode);
        keyPressSet.add(keycode);
        keyReleaseSet.add(keycode);
        System.out.println("放入缓存完成："+keycode);
        robot.keyPress(keycode);
        MyRobot.sleep(50); //这里暂且用 50 毫秒，可以根据实际情况调整 调整随机数 50 到 200
        robot.keyRelease(keycode);
    }

    public static boolean virtuallyReleaseKey(Integer keyCode) {
        return keyReleaseSet.remove(keyCode);
    }

    public static boolean virtuallyPressKey(Integer keyCode) {
        return keyPressSet.remove(keyCode);
    }


}
