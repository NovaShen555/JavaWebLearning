import java.awt.*;

public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame("HelloWorld!"); //新建一个窗体
        Panel panel = new Panel(null); //新建一个面板

        frame.setLayout(null); //设置窗体的布局
        frame.setBounds(300,300,500,500); //设置窗体的大小
        frame.setBackground(new Color(0,0,255)); //设置背景颜色

        panel.setBounds(50,50,300,300); //设置面板相对坐标
        panel.setBackground(new Color(255,0,0));

        frame.add(panel);
        frame.setVisible(true);

        //此时无法关闭，需要添加关闭事件
        ws ws = new ws();
        frame.addWindowListener(ws);

    }

}

