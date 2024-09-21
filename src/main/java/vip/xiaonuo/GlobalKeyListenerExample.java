package vip.xiaonuo;

/**
 * @Author: wangbingchen
 * @CreateTime: 2024-08-22
 */
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.event.KeyEvent;
import java.util.HashMap;


public class GlobalKeyListenerExample implements NativeKeyListener {


    //创建一个 map 通过 NativeKeyEvent code 转换为 java reobt KeyEvent code
    public static HashMap<Integer, Integer> keyPressedMap = new HashMap<Integer, Integer>();
    public static HashMap<Integer, Integer> keyReleasedMap = new HashMap<Integer, Integer>();

    static {
        //按下指定件触发的动作
        keyPressedMap.put(NativeKeyEvent.VC_Z, KeyEvent.VK_Z);
        keyPressedMap.put(NativeKeyEvent.VC_J, KeyEvent.VK_J);

        //弹起指定件触发的动作
        keyReleasedMap.put(NativeKeyEvent.VC_A, KeyEvent.VK_A);
        keyReleasedMap.put(NativeKeyEvent.VC_D, KeyEvent.VK_D);
        keyReleasedMap.put(NativeKeyEvent.VC_W, KeyEvent.VK_W);
        keyReleasedMap.put(NativeKeyEvent.VC_S, KeyEvent.VK_S);
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
//        String keyText = NativeKeyEvent.getKeyText(e.getKeyCode());
        Integer code = keyPressedMap.get(e.getKeyCode());
        if(code!= null && !MyRobot.virtuallyPressKey(code)){
            //如果有映射关系,执行对应的方法
            if(KeyEvent.VK_Z == code){
                MyRobot.yijiantiaotou();
            }
            if(KeyEvent.VK_J == code){
                MyRobot.yijianwtiaotou();
            }
        }
    }


    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        String keyText = NativeKeyEvent.getKeyText(e.getKeyCode());
        Integer code = keyReleasedMap.get(e.getKeyCode());
        //急停 整体不好用
        if(code!= null && !MyRobot.virtuallyReleaseKey(code)){
            MyRobot.jiting(code);
            System.out.println("手动释放键"+keyText);
        }
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }


}

