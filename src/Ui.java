import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kraken on 19/03/16.
 */
public class Ui extends JPanel {
    JPanel butPanel;
    JLabel field;

    Ui() {
        setLayout(new BorderLayout());
        field = new JLabel(" ");


        field.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        butPanel=createButtPanel();
        JButton b=new JButton("=");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(Calc.getResult(field.getText()) + " ");
               if (isOpened)showHistory();
            }
        });
        b.setBackground(Color.RED);
       JPanel pan=new JPanel();
        pan.setLayout(new BoxLayout(pan,BoxLayout.X_AXIS));
        b.setAlignmentX(RIGHT_ALIGNMENT);
        pan.add(Box.createHorizontalGlue());
        pan.add(field);
        pan.add(b);
        add(pan, BorderLayout.NORTH);


        add(Box.createVerticalStrut(30));
        add(butPanel, BorderLayout.CENTER);

        setBackground(Color.white);
        setSize(500, 500);
        setVisible(true);

    }
    JPanel createButtPanel(){
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5, 4, 8, 8));
        p.setBackground(Color.white);
        for (String buttonName : buttons) {
            JButton but=createButton(buttonName);
            if (Utils.isDigit(buttonName)){

                but.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
            }
            but.setBackground(Color.white);
            but.setBorderPainted(false);
            but.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
            p.add(but);
        }

        JButton button = new JButton("<-");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearInputLine();


            }
        });
        button.setBackground(Color.gray);
        p.add(button);
        JButton button2 = new JButton(">");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                toggleHistory();
            }
        });
        button2.setBackground(Color.gray);
        p.add(button2);

        return p;
    }
    static  boolean isOpened=false;
    JPanel history = new JPanel();
  void  toggleHistory(){
      if (isOpened){
          closeHistory();
      }else {
          showHistory();
      }
      isOpened=!isOpened;
  }
    void closeHistory(){
        System.out.println("closing");
        history.removeAll();
        history.setPreferredSize(new Dimension(0,getHeight()));

        repaint();
        revalidate();
    }
    void showHistory() {
        history.setBackground(Color.white);

        history.removeAll();
        history.setLayout(new BoxLayout(history, BoxLayout.Y_AXIS));
        for (String s : Calc.history) {
            System.out.println(s);
            setBackground(Color.white);
            JLabel label=new JLabel(s);
            label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
            history.add(label);
        }
        history.setPreferredSize(new Dimension(getWidth()/2,getHeight()));
        setSize(getWidth()+getWidth()/2,getHeight());
        add(history, BorderLayout.EAST);
        repaint();
        revalidate();
    }

    final static String[] buttons =
            {"7", "8", "9", "/",
                    "4", "5", "6", "*",
                    "1", "2", "3", "-",
                    "0", "(", ")", "^", "+", "."};

    void clearInputLine() {
        field.setText(field.getText().substring(0,field.getText().length()-1));
    }

    JButton createButton(final String s) {
        JButton button = new JButton(s);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + s);

            }

        });
        return button;
    }


    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(600, 400);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        f.add(new Ui());
        f.setVisible(true);

    }
}
