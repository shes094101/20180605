import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

    private Container cp;
    private JLabel jlb =new JLabel();
    private JLabel jlb2 =new JLabel();
    private ImageIcon img1=new ImageIcon("人物1.png");
    private ImageIcon imgRocket=new ImageIcon("炸彈.png");
    private ImageIcon imgBoom=new ImageIcon("爆炸.png");
    private ImageIcon img5=new ImageIcon("人物2.png");
    private Timer t1;

    public MainFrame(){
        work();
    }
    private void work(){
        this.setDefaultCloseOperation(3);//設定關閉視窗的按鈕
        this.setBounds(50,50,800,700);//設置介面大小
        MainFrame.this.setTitle("20180605-work");//視窗上的名字

        cp = this.getContentPane();
        cp.setLayout(null);
        jlb.setBounds(350,100,120,60);
        cp.add(jlb);
        jlb.setIcon(img1);


        Image img=img1.getImage();
        Image img2=img.getScaledInstance(120,80,Image.SCALE_SMOOTH);
        img1.setImage(img2);


        Image imga=imgRocket.getImage();
        Image imgb=imga.getScaledInstance(50,40,Image.SCALE_SMOOTH);
        imgRocket.setImage(imgb);

        Image imgx=imgBoom.getImage();
        Image imgy=imgx.getScaledInstance(50,40,Image.SCALE_SMOOTH);
        imgBoom.setImage(imgy);

        Image imgm=img5.getImage();
        Image imgn=imgm.getScaledInstance(120,80,Image.SCALE_SMOOTH);
        img5.setImage(imgn);

        t1=new Timer(200, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlb2.setLocation(jlb2.getX(),jlb2.getY()+50);
                if (jlb2.getY()>550){
                    jlb2.setIcon(imgBoom);
                    t1.stop();
                }
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case 37:
                        jlb.setIcon(img1);
                        jlb.setLocation(jlb.getX()-5,jlb.getY());
                        break;
                    case 39:
                        jlb.setIcon(img5);
                        jlb.setLocation(jlb.getX()+5,jlb.getY());
                        break;
                    case 40:
                        jlb.setLocation(jlb.getX(),jlb.getY()+5);
                        break;
                    case 38:
                        jlb.setLocation(jlb.getX(),jlb.getY()-5);
                        break;
                    case 32:
                        jlb2.setBounds(jlb.getX()+50,jlb.getY(),120,80);
                        cp.add(jlb2);
                        jlb2.setIcon(imgRocket);
                        t1.start();
                        break;
                }
            }
        });

    }
}