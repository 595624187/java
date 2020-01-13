package Common;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class formshow extends JFrame implements ActionListener{
JButton button;
public formshow(){
button=new JButton("点击我，出现新窗体");
add(button);
button.addActionListener(this);
this.setLayout(new FlowLayout());
this.setBounds(520, 130, 200, 100);
this.setVisible(true);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public static void main(String args[]){
formshow fs=new formshow();
}

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
if(e.getSource()==button){
form2 fm=new form2();
}
}

}

class form2 extends JFrame{
//第二个窗体；
JLabel jl;
static int n=1;
public form2(){
n++;
jl=new JLabel("我是第"+n+"个窗体。");
add(jl);
this.setTitle("我是第"+n+"个窗体");
//设置属性。
this.setLayout(new FlowLayout());
this.setBounds(120+11*n, 230+10*n, 200, 100);
this.setVisible(true);
this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
}
} 
