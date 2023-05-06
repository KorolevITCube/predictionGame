import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MyFrame extends JFrame{

    private MyPanel contentPane;
    private DB data;

    public MyFrame(){
        data = new DB();
        setFocusable(true);
        setTitle("Предсказания");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300,100,500,500);
        contentPane = new MyPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);



        Font btnFont = new Font("Verdana",0,18);
        var tapButton = new JButton("узнать");
        tapButton.setBounds(220,380,100,35);
        tapButton.setFont(btnFont);
        tapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = (int)(Math.random()*21)+1;
                String pred = data.getPrediction(id);
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(null,pred);
                    }
                });
            }
        });
        add(tapButton);

        setVisible(true);
    }
}
