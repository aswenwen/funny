package xixi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by W-L on 2018/4/9.
 */
public class HapiJia extends JFrame{
    private static final long serialVersionUID = 1L;


    private JLabel     label;
    private JButton    button1;
    private JButton    button2;
    private JDialog    dialog1;


    private int enterCount = 0;
    private boolean chooseFlag = false;


    public static final int screenWidth =
            (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int screenHeight =
            (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();


    public HapiJia() {
        label   = new JLabel("baby jia,i'm your handson boy,do you miss me ?", SwingConstants.CENTER); // 自行修改
        button1 = new JButton("No, I don't!"); // 按钮1
        button2 = new JButton("Yes, I do!");   // 按钮2
        dialog1 = new JDialog(this);           // 创建一个新的对话框，并设置父窗口为当前窗体
        windowInitial();
        setWindowListener();
    }// constructor


    public HapiJia(String labelTxt, String bt1Txt, String bt2Txt) {
        label   = new JLabel(labelTxt, SwingConstants.CENTER);
        button1 = new JButton(bt1Txt);
        button2 = new JButton(bt2Txt);
        dialog1 = new JDialog(this);
        windowInitial();
        chooseFlag = true;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }// constructor_String


    /**
     * 窗体初始化，使用的是绝对布局
     */
    private void windowInitial() {
        setDialog(dialog1, "oye!", "Meeting you is the luckest thing in my life!"); // 自行修改


        label.setFont(new Font("", Font.BOLD, 17));
        label.setBounds(0, 30, 480, 20);

        /**
         * 以匿名内部类的方式为按钮1添加鼠标事件监听器，当鼠标进入按钮1后将突然改变自己的位置
         */
        button1.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {return;}
            @Override
            public void mousePressed(MouseEvent e) {return;}
            @Override
            public void mouseExited(MouseEvent e) {return;}
            @Override
            public void mouseEntered(MouseEvent e) {
                switch(enterCount) {
                    case 0:
                        button1.setBounds(75, 60, 110, 30);
                        HapiJia.this.repaint();
                        ++enterCount;
                        break;
                    case 1:
                        button1.setBounds(75, 110, 110, 30);
                        HapiJia.this.repaint();
                        ++enterCount;
                        break;
                    case 2:
                        button1.setBounds(155, 60, 110, 30);
                        HapiJia.this.repaint();
                        ++enterCount;
                        break;
                    case 3:
                        button1.setBounds(75, 110, 110, 30);
                        HapiJia.this.repaint();
                        ++enterCount;
                        break;
                    case 4:
                        button1.setBounds(310, 110, 110, 30);
                        button2.setBounds(75, 110, 110, 30);
                        HapiJia.this.repaint();
                        ++enterCount;
                        break;
                    case 5:
                        button1.setBounds(75, 110, 110, 30);
                        button2.setBounds(310, 110, 110, 30);
                        HapiJia.this.repaint();
                        enterCount = 0;
                        break;
                }// seitch_entercount
            }// mouseEntered
            @Override
            public void mouseClicked(MouseEvent e) {
                dialog1.setVisible(true);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }// mouseClicked
        });// MouseListener

        button1.setBounds(70, 110, 110, 30);
        button1.setFont(new Font("", Font.BOLD, 13));

        /**
         * 以匿名内部类的方式为按钮2添加鼠标事件监听器，按下时显示对话框
         */
        button2.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {return;}
            @Override
            public void mousePressed(MouseEvent e) {return;}
            @Override
            public void mouseExited(MouseEvent e) {return;}
            @Override
            public void mouseEntered(MouseEvent e) {return;}
            @Override
            public void mouseClicked(MouseEvent e) {
                dialog1.setVisible(true);
                chooseFlag = true;
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }// mouseClicked
        });// MouseListener
        button2.setBounds(310, 110, 110, 30);
        button2.setFont(new Font("", Font.BOLD, 13));


        Container c = getContentPane();
        c.setLayout(null);
        c.add(label);
        c.add(button1);
        c.add(button2);
        setTitle("hello jiajia!"); // 自行修改
        setBounds(screenWidth/2-250, screenHeight/2-100, 500, 200);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }// windowInitial


    /**
     * 设置对话框属性
     * @param diag
     * @param tittle
     * @param txt
     */
    private void setDialog(final JDialog diag, String tittle, String txt) {
        JLabel diagLabel = new JLabel(txt, SwingConstants.CENTER);
        diagLabel.setFont(new Font("", Font.BOLD, 17));
        diagLabel.setBounds(0, 40, 430, 20);
        JButton diagBut = new JButton("Confirm");
        diagBut.setFont(new Font("", Font.BOLD, 14));
        diagBut.setBounds(155, 100, 100, 30);
        diagBut.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {return;}
            @Override
            public void mousePressed(MouseEvent e) {return;}
            @Override
            public void mouseExited(MouseEvent e) {return;}
            @Override
            public void mouseEntered(MouseEvent e) {return;}
            @Override
            public void mouseClicked(MouseEvent e) {
                diag.dispose();
                if (chooseFlag)
                    System.exit(0);
            }// mouseClicked
        });
        diag.setTitle(tittle);
        diag.setBounds(screenWidth/2-225, screenHeight/2-100, 450, 200);
        diag.setLayout(null);
        diag.add(diagBut);
        diag.add(diagLabel);
    }// setDialog
    /**
     * 设置单击窗口关闭按钮时的动作
     */
    private void setWindowListener() {
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {return;}
            @Override
            public void windowIconified(WindowEvent e) {return;}
            @Override
            public void windowDeiconified(WindowEvent e) {return;}
            @Override
            public void windowDeactivated(WindowEvent e) {return;}
            @Override
            public void windowClosed(WindowEvent e) {return;}
            @Override
            public void windowActivated(WindowEvent e) {return;}
            @Override
            public void windowClosing(WindowEvent e) {
                if(!chooseFlag) {
                    String labelTxt = "so,you miss me? \"Yes, I do!\"?"; // 自行修改
                    new HapiJia(labelTxt, "NO", "YES");
                }// if
            }// windowClosing
        });// WindowListener
    }// setWindowListener


    public static void main(String[] args) {
        HapiJia myApp = new HapiJia();
        myApp.setVisible(true);
    }// main
}
