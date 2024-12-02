import javax.swing.*;
import java.awt.*;

public class Main {
   public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,600);
       frame.setLayout(new BorderLayout());
       //Teksts
        JPanel textPanel = new JPanel(new GridLayout(1,1));
        JTextField text = new JTextField("0");
        text.setPreferredSize(new Dimension(200,100));
        text.setFont(new Font("Arial", Font.PLAIN, 70));
        text.setHorizontalAlignment(JTextField.RIGHT);
        textPanel.add(text);
      //pogas
        JPanel btnPanel = new JPanel(new GridLayout(5, 5, 5, 5));
        JButton acBtn =new JButton("AC");
        btnPanel.add(acBtn);
        JButton dzestBtn =new JButton("del");
        btnPanel.add(dzestBtn);
        JButton procentiBtn =new JButton("%");
        btnPanel.add(procentiBtn);
        JButton dalitsBtn =new JButton("/");
        btnPanel.add(dalitsBtn);
        JButton septiniBtn =new JButton("7");
        btnPanel.add(septiniBtn);
        JButton astoniBtn =new JButton("8");
        btnPanel.add(astoniBtn);
        JButton deviniBtn =new JButton("9");
        btnPanel.add(deviniBtn);
        JButton reizBtn =new JButton("x");
        btnPanel.add(reizBtn);
        JButton cetriBtn =new JButton("4");
        btnPanel.add(cetriBtn);
        JButton pieciBtn =new JButton("5");
        btnPanel.add(pieciBtn);
        JButton sesiBtn =new JButton("6");
        btnPanel.add(sesiBtn);
        JButton minusBtn =new JButton("-");
        btnPanel.add(minusBtn);
        JButton viensBtn =new JButton("1");
        btnPanel.add(viensBtn);
        JButton diviBtn =new JButton("2");
        btnPanel.add(diviBtn);
        JButton trisBtn =new JButton("3");
        btnPanel.add(trisBtn);
        JButton plusBtn =new JButton("+");
        btnPanel.add(plusBtn);
        JButton neredzamaBtn = new JButton();
        neredzamaBtn.setVisible(false);
        btnPanel.add(neredzamaBtn);
        JButton nulleBtn =new JButton("0");
        btnPanel.add(nulleBtn);
        JButton komatsBtn =new JButton(",");
        btnPanel.add(komatsBtn);
        JButton vienadsBtn =new JButton("=");
        btnPanel.add(vienadsBtn);



        frame.add(textPanel, BorderLayout.BEFORE_FIRST_LINE);
        frame.add(btnPanel, BorderLayout.CENTER);
        frame.setVisible(true);


    }
}