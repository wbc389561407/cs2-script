package vip.xiaonuo;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * @Author: wangbingchen
 * @CreateTime: 2024-08-22
 */
public class MyRobot {

    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
    //一键跳投
    public static void yijiantiaotou() {
        System.out.println("一键跳投");
        //按下空格键
        robot.keyPress(KeyEvent.VK_SPACE);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        robot.keyRelease(KeyEvent.VK_SPACE);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //释放鼠标左键
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        //释放鼠标右键
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    //w跳投
    public static void yijianwtiaotou() {
//        Robot robot = null;
//        try {
//            robot = new Robot();
//        } catch (AWTException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("w跳投");
        //按下W键
        robot.keyPress(KeyEvent.VK_W);
        //按下空格键
        robot.keyPress(KeyEvent.VK_SPACE);
        //释放鼠标左键
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        //释放W键
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        robot.keyRelease(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_SPACE);
    }
}
