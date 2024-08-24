package vip.xiaonuo;

/**
 * @Author: wangbingchen
 * @CreateTime: 2024-08-22
 */
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;


public class Main {

    public static void main(String[] args) {

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new GlobalKeyListenerExample());

    }


}