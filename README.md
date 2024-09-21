# 使用方式

### 直接启动Main
### 默认 一键跳投 Z键   一键W跳投 J

## 修改键位

### GlobalKeyListenerExample 类中修改，具体请参考源码。
          //如果有映射关系,执行对应的方法
            if(KeyEvent.VK_Z == code){
                MyRobot.yijiantiaotou();
            }
            if(KeyEvent.VK_J == code){
                MyRobot.yijianwtiaotou();
            }