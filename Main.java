import javax.swing.*;
import java.awt.*;

public class Main {

    private static double storedValue = 0;
    private static String operator = "";
    private static boolean newEntry = true;

    public static void main(String[] args) {
       JFrame frame = new JFrame("Kalkulators");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(400, 600);
       frame.setLayout(new BorderLayout());

       // Displejs
       JPanel textPanel = new JPanel(new GridLayout(1, 1));
       JTextField text = new JTextField("0");
       text.setPreferredSize(new Dimension(200, 100));
       text.setFont(new Font("Arial", Font.PLAIN, 70));
       text.setHorizontalAlignment(JTextField.RIGHT);
       text.setEditable(false);
       textPanel.add(text);

       // Pogas
       JPanel btnPanel = new JPanel(new GridLayout(5, 4, 5, 5));

       JButton acBtn = new JButton("AC");
       JButton mainusPlussBtn = new JButton("+/-");
       JButton procentiBtn = new JButton("%");
       JButton dalitsBtn = new JButton("/");
       JButton septiniBtn = new JButton("7");
       JButton astoniBtn = new JButton("8");
       JButton deviniBtn = new JButton("9");
       JButton reizBtn = new JButton("x");
       JButton cetriBtn = new JButton("4");
       JButton pieciBtn = new JButton("5");
       JButton sesiBtn = new JButton("6");
       JButton minusBtn = new JButton("-");
       JButton viensBtn = new JButton("1");
       JButton diviBtn = new JButton("2");
       JButton trisBtn = new JButton("3");
       JButton plusBtn = new JButton("+");
       JButton dzestBtn = new JButton("del");
       JButton nulleBtn = new JButton("0");
       JButton komatsBtn = new JButton(",");
       JButton vienadsBtn = new JButton("=");

        //  Pielāgo pogu fontu 
       Font btnFont = new Font("Arial", Font.BOLD, 28);
       for (JButton btn : new JButton[]{acBtn, mainusPlussBtn, procentiBtn, dalitsBtn,
               septiniBtn, astoniBtn, deviniBtn, reizBtn,
               cetriBtn, pieciBtn, sesiBtn, minusBtn,
               viensBtn, diviBtn, trisBtn, plusBtn,
               dzestBtn, nulleBtn, komatsBtn, vienadsBtn}) {
           btn.setFont(btnFont);
       }

       btnPanel.add(acBtn);
       btnPanel.add(mainusPlussBtn);
       btnPanel.add(procentiBtn);
       btnPanel.add(dalitsBtn);
       btnPanel.add(septiniBtn);
       btnPanel.add(astoniBtn);
       btnPanel.add(deviniBtn);
       btnPanel.add(reizBtn);
       btnPanel.add(cetriBtn);
       btnPanel.add(pieciBtn);
       btnPanel.add(sesiBtn);
       btnPanel.add(minusBtn);
       btnPanel.add(viensBtn);
       btnPanel.add(diviBtn);
       btnPanel.add(trisBtn);
       btnPanel.add(plusBtn);
       btnPanel.add(dzestBtn);
       btnPanel.add(nulleBtn);
       btnPanel.add(komatsBtn);
       btnPanel.add(vienadsBtn);

       // Ciparu pogas
       for (JButton btn : new JButton[]{viensBtn, diviBtn, trisBtn, cetriBtn, pieciBtn,
               sesiBtn, septiniBtn, astoniBtn, deviniBtn, nulleBtn}) {
           String digit = btn.getText();
           btn.addActionListener(e -> {
               String current = text.getText();
               if (newEntry || current.equals("0")) {
                   text.setText(digit);
                   newEntry = false;
               } else {
                   text.setText(current + digit);
               }
           });
       }

       // Komats (decimālpunkts)
       komatsBtn.addActionListener(e -> {
           String current = text.getText();
           if (newEntry) {
               text.setText("0,");
               newEntry = false;
           } else if (!current.contains(",")) {
               text.setText(current + ",");
           }
       });

       // AC — notīra visu
       acBtn.addActionListener(e -> {
           text.setText("0");
           storedValue = 0;
           operator = "";
           newEntry = true;
       });

       // del — dzēš pēdējo ciparu
       dzestBtn.addActionListener(e -> {
           String current = text.getText();
           if (current.length() > 1) {
               text.setText(current.substring(0, current.length() - 1));
           } else {
               text.setText("0");
               newEntry = true;
           }
       });

       // +/- — mainīt zīmi
       mainusPlussBtn.addActionListener(e -> {
           double val = parseDisplay(text.getText());
           text.setText(formatResult(-val));
       });

       // % — procentos
       procentiBtn.addActionListener(e -> {
           double val = parseDisplay(text.getText());
           text.setText(formatResult(val / 100));
           newEntry = true;
       });

       // Operācijas: +, -, x, /
       for (JButton btn : new JButton[]{plusBtn, minusBtn, reizBtn, dalitsBtn}) {
           String op = btn.getText();
           btn.addActionListener(e -> {
               storedValue = parseDisplay(text.getText());
               operator = op;
               newEntry = true;
           });
       }

       // = — aprēķina rezultātu
       vienadsBtn.addActionListener(e -> {
           double current = parseDisplay(text.getText());
           double result = switch (operator) {
               case "+" -> storedValue + current;
               case "-" -> storedValue - current;
               case "x" -> storedValue * current;
               case "/" -> current != 0 ? storedValue / current : Double.NaN;
               default -> current;
           };
           text.setText(Double.isNaN(result) ? "Kļūda" : formatResult(result));
           operator = "";
           newEntry = true;
       });

       frame.add(textPanel, BorderLayout.BEFORE_FIRST_LINE);
       frame.add(btnPanel, BorderLayout.CENTER);
       frame.setVisible(true);
    }

    // Pārvērš displeja tekstu (ar komatu) par double
    private static double parseDisplay(String s) {
       try {
           return Double.parseDouble(s.replace(",", "."));
       } catch (NumberFormatException e) {
           return 0;
       }
    }

    // Formatē double rezultātu — noņem .0 veselajiem skaitļiem
    private static String formatResult(double val) {
       if (val == Math.floor(val) && !Double.isInfinite(val)) {
           return String.valueOf((long) val);
       }
       return String.valueOf(val).replace(".", ",");
    }
}