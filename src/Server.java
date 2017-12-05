import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Server extends JFrame {
    //------------------------------元件
    Container cp;
    private JButton[] jbt = new JButton[9];
    private JPanel jpnOX = new JPanel(new GridLayout(3,3));
    private JTextField jtfright = new JTextField();
    private boolean flag = false;

        //------側邊文字
    private JPanel jpnleft = new JPanel(new GridLayout(7,1,5,5));
    private JLabel jlbip = new JLabel("Server IP: ");
    private JTextField jtfip = new JTextField("10.51.3.69");
    private JLabel jlbport = new JLabel("Port: ");
    private JTextField jtfport = new JTextField("1723");
    private JButton jbtstart = new JButton("Start");
    private JButton jbtstop = new JButton("Stop");
    private JButton jbtexit = new JButton("Exit");

        //------下方輸入文字
    private JPanel jpnsou = new JPanel();
    private JTextField jtf = new JTextField();
    private JButton jbtsent = new JButton("Sent");

    //------------------------------連結
    private MainFrame mainFrame;
    public Server(MainFrame main){
        mainFrame = main;
        initComp();
    }
    private void initComp(){

        //---------------------------基本設置
        this.setBounds(100,100,700,500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(true);
            }
        });
        this.setTitle("Server");

        //---------------------------頁面排版
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(5,5));

        cp.add(jtfright, BorderLayout.WEST);
        jtfright.setEditable(false);
        jtfright.setPreferredSize(new Dimension(150,400));

        cp.add(jpnsou, BorderLayout.SOUTH);
        jpnsou.add(jtf,BorderLayout.CENTER);
        jtf.setPreferredSize(new Dimension(600,30));
        jpnsou.add(jbtsent,BorderLayout.EAST);

        cp.add(jpnOX,BorderLayout.CENTER);
        for(int i=0;i<9;i++){
            jbt[i] = new JButton("");
            jbt[i].setEnabled(flag);
            jpnOX.add(jbt[i]);
        }

        cp.add(jpnleft,BorderLayout.EAST);
        jpnleft.add(jlbip);
        jpnleft.add(jtfip);
        jpnleft.add(jlbport);
        jpnleft.add(jtfport);
        jpnleft.add(jbtstart);
        jpnleft.add(jbtstop);
        jpnleft.add(jbtexit);

        jbtexit.setOpaque(true);
        jbtexit.setBackground(new Color(0xFFAEB6));
        jbtexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                mainFrame.setVisible(true);
            }
        });

        jbtstart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = true;
                for(int i=0;i<9;i++)
                    jbt[i].setEnabled(flag);
            }
        });



    }
}
