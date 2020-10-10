package nightmare_realm;

import java.awt.Color;

import javax.swing.JFrame;

public class NRFrame extends JFrame 
{
	public NRFrame(int x, int y, int width, int height)
	{
		setBounds(x, y, width + 16, height);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		NRPanel panel = new NRPanel(x, y + 40, width, height);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
        add(panel);
        setVisible(true);
        setResizable(false);
        panel.setVisible(true);
	}
}
