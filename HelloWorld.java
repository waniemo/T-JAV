import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HelloWorld extends JFrame implements MouseListener {

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setVisible(true);
    }

    private Container contentPane;
    private JLabel label;

    public HelloWorld() {
        setTitle("Hello World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 800);
        setLocationRelativeTo(null);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("/home/medaly/Pictures/Wallpapers/kalubuntu_bkg.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        label = new JLabel(imageIcon);

        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(label, BorderLayout.CENTER);

        contentPane.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked");
        contentPane.remove(label);
        contentPane.add(label, BorderLayout.SOUTH);
        contentPane.revalidate();
        contentPane.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released");
    }
}
