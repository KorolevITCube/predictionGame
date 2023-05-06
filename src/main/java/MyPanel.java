import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel {
    private int val = 0;

    public MyPanel(){
        setLayout(null);
        Timer tm = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                val++;
                if(val == 256)
                    val = 0;
                repaint();
            }
        });
        tm.start();
    }

    @Override
    public void paintComponent(Graphics gr){
        super.paintComponent(gr);
        Font fnt = new Font("Verdana", 0, 18);
        gr.setFont(fnt);
        gr.drawString("Посмотрите на магический квадрат...",10,30);
        gr.drawString("Вглядитесь в будущее...",20,70);
        gr.drawString("Подумайте о том,что вы хотите...",10,370);
        gr.drawString("....и нажмите чтобы",10,400);
        for (int i = 0; i <= 255; i++){
            gr.setColor(new Color(0,(i*val)%255,0));
            gr.drawRect(250-i/2,220-i/2,i,i);
        }
    }
}
