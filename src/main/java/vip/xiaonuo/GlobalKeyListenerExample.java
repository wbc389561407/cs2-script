package vip.xiaonuo;

/**
 * @Author: wangbingchen
 * @CreateTime: 2024-08-22
 */
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


public class GlobalKeyListenerExample implements NativeKeyListener {


    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        String keyText = NativeKeyEvent.getKeyText(e.getKeyCode());

        //如果按下z键， 实现 一件跳投的功能
        if(keyText.equals("Z")) {  //按下z键 一键跳投 可以修改
            MyRobot.yijiantiaotou();
        }

        if(keyText.equals("J")) {  //按下j键 一键W跳投 可以修改
            MyRobot.yijianwtiaotou();
        }

    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }


}

