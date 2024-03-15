import javax.swing.*;
import java.awt.*;

public class TrafficLightPanel extends JPanel {
    private Color redColor = Color.RED;
    private Color yellowColor = Color.YELLOW;
    private Color greenColor = Color.GREEN;
    private int selectedLight = 0; // 0: Red, 1: Yellow, 2: Green

    public TrafficLightPanel() {
        setPreferredSize(new Dimension(100, 300));
    }

    public void setSelectedLight(int light) {
        selectedLight = light;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        // Draw outer rectangle
        g.setColor(Color.BLACK);
        g.fillRect(width / 3, height / 10, width / 3, height * 8 / 10);

        // Draw lights
        int lightDiameter = width / 3;
        int lightY = height / 10 + (selectedLight * lightDiameter) + selectedLight * (height / 10);
        g.setColor(redColor);
        g.fillOval(width / 3, lightY, lightDiameter, lightDiameter);

        g.setColor(yellowColor);
        g.fillOval(width / 3, lightY + lightDiameter + height / 10, lightDiameter, lightDiameter);

        g.setColor(greenColor);
        g.fillOval(width / 3, lightY + 2 * (lightDiameter + height / 10), lightDiameter, lightDiameter);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Traffic Light");
        TrafficLightPanel trafficLightPanel = new TrafficLightPanel();
        frame.add(trafficLightPanel);
        frame.setSize(200, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Test changing lights (remove this for actual use)
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    trafficLightPanel.setSelectedLight(0);
                    Thread.sleep(2000);
                    trafficLightPanel.setSelectedLight(1);
                    Thread.sleep(2000);
                    trafficLightPanel.setSelectedLight(2);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
