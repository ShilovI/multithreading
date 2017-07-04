import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

/**
 * Created by Administrator on 7/1/2017.
 */
public class Multithreading {
    static TreeSet<Integer> treeSet = new TreeSet();

    public static class Graphics extends JFrame {
        JTextField textField1, textField2;

        public Graphics() {
            super("Multithreading");
            textField1 = new JTextField(100);
            textField1.setToolTipText("OutputField");
            textField2 = new JTextField("InputField",100);
            textField2.setToolTipText("InputField");
            textField2.setFont(new Font("Dialog", Font.PLAIN, 14));
            textField2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        String s = textField2.getText();
                        int number = WordToNumber.inNumerals(s);
                        treeSet.add(number);
                        textField2.setText(null);
                }
            });
            JPanel panel = new JPanel();
            panel.add(textField1);
            panel.add(textField2);
            setContentPane(panel);
            setSize(1500, 400);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }


    public static void main(String[] args) {
        final Graphics graphics = new Graphics();
        Thread remover = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (treeSet.size()==0) {
                            graphics.textField1.setText(null);
                        } else {
                            graphics.textField1.setText(null);
                            int x = treeSet.first();
                            String s1 = NumberToWord.inWords(x);
                            graphics.textField1.setText(s1);
                            treeSet.remove(x);
                        }
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        });
        remover.start();
    }
}

