package nightmare_realm;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;

import javax.swing.*;

public class NRPanel extends JPanel implements MouseListener, MouseMotionListener
{
	public NRPanel(int x, int y, int width, int height)
	{
		setBounds(0, y + 40, width, height);
		game_field = new NRField();
		game_field.setExampleConfig();
		//game_field.setWinCheckConfig(); //для отладки
		rects = new ArrayList<>(); //массив квадратов, которые будут рисоваться на экране
		for(int i = 0; i < NRField.field_size; i++)
		{
			for(int j = 0; j < NRField.field_size; j++)
			{
				rects.add(new Rectangle2D.Double((this.getWidth() - box_size * NRField.field_size) / 2 + j * box_size, box_size + box_color_offset + i * box_size, box_size, box_size));
			}
		}
		text.setFont(new Font("Arial", Font.PLAIN, 14));
		text.setSize(text.getPreferredSize());
		text.setLocation((this.getWidth() - text.getWidth()) / 2, 335);
		text.setVisible(false);
		add(text);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(0,0,0));
		//рисуем поле
		for(int i = 0; i < NRField.field_size; i++)
		{
			for(int j = 0; j < NRField.field_size; j++)
			{
				switch(game_field.getField(i, j))
				{
					case 0:
						g2d.setColor(Color.WHITE);
						g2d.fill(rects.get(i * NRField.field_size + j));
						g2d.setColor(Color.BLACK);
						g2d.draw(rects.get(i * NRField.field_size + j));
						break;
					case 1:
						g2d.setColor(Color.YELLOW);
						g2d.fill(rects.get(i * NRField.field_size + j));
						g2d.setColor(Color.BLACK);
						g2d.draw(rects.get(i * NRField.field_size + j));
						break;
					case 2:
						g2d.setColor(Color.ORANGE);
						g2d.fill(rects.get(i * NRField.field_size + j));
						g2d.setColor(Color.BLACK);
						g2d.draw(rects.get(i * NRField.field_size + j));
						break;
					case 3:
						g2d.setColor(Color.RED);
						g2d.fill(rects.get(i * NRField.field_size + j));
						g2d.setColor(Color.BLACK);
						g2d.draw(rects.get(i * NRField.field_size + j));
						break;
					case 127:
						g2d.draw(rects.get(i * NRField.field_size + j));
						g2d.drawLine((int)rects.get(i * NRField.field_size + j).getX(), (int)rects.get(i * NRField.field_size + j).getY(), (int)(rects.get(i * NRField.field_size + j).getX() + rects.get(i * NRField.field_size + j).getWidth()), (int)(rects.get(i * NRField.field_size + j).getY() + rects.get(i * NRField.field_size + j).getHeight()));
						g2d.drawLine((int)rects.get(i * NRField.field_size + j).getX(), (int)(rects.get(i * NRField.field_size + j).getY() + rects.get(i * NRField.field_size + j).getHeight()), (int)(rects.get(i * NRField.field_size + j).getX() + rects.get(i * NRField.field_size + j).getWidth()), (int)rects.get(i * NRField.field_size + j).getY());
						break;
				}
			}
		}
		//рисуем индикаторы цветов
		for(int j = 0; j < (NRField.field_size + 1) / 2; j++)
		{
			switch(game_field.getColor(j))
			{
				case 1:
					g2d.setColor(Color.YELLOW);
					break;
				case 2:
					g2d.setColor(Color.ORANGE);
					break;
				case 3:
					g2d.setColor(Color.RED);
					break;
			}
			g2d.fillRect((this.getWidth() - box_size * NRField.field_size) / 2 + 2 * j * box_size, 10, box_size, box_size);
			g2d.setColor(Color.BLACK);
			g2d.drawRect((this.getWidth() - box_size * NRField.field_size) / 2 + 2 * j * box_size, 10, box_size, box_size);
		}
	}
	/**
	 * Функция, для проверки условий завершения игры. Если они выполнены, то выводится соответствующая надпись, а управление блокируется
	 */
	private void checkWin()
	{
		boolean f = true;
		for(int j = 0; j < (NRField.field_size + 1) / 2; j++)
		{
			for(int i = 0; i < NRField.field_size; i++)
			{
				f = f && (game_field.getField(i, 2 * j) == game_field.getColor(j));
			}
		}
		if(f)
		{
			removeMouseListener(this);
			removeMouseMotionListener(this);
			text.setVisible(true);
		}
	}
	
	public void mouseClicked(MouseEvent e) 
	{
		
	}

	public void mousePressed(MouseEvent e) 
	{
		//когда кнопку мыши зажимают, ищем квадрат, который выбрал игрок и делаем его активным
		for(int i = 0; i < rects.size(); i++)
		{
			if (rects.get(i).contains(new Point2D.Double(e.getX(), e.getY())))
			{
				if ((game_field.getField(i / NRField.field_size, i % NRField.field_size) != 0) && (game_field.getField(i / NRField.field_size, i % NRField.field_size) != 127))
				{
					current_active = i;
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) 
	{
		current_active = -1;
		
	}

	public void mouseEntered(MouseEvent e) 
	{

	}

	public void mouseExited(MouseEvent e) 
	{

	}
	
	public void mouseDragged(MouseEvent e)
	{ //когда кнопку мыши зажали и перетаскивают, проверяем, можно ли перетащить квадрат в указанное место, если да, то тащим, после перетаскивания перерисовываем поле и проверяем условие победы
		for(int i = 0; i < rects.size(); i++)
		{
			if (rects.get(i).contains(new Point2D.Double(e.getX(), e.getY())) && (current_active != -1))
			{
				if((game_field.getField(i / NRField.field_size, i % NRField.field_size) == 0) && (i != current_active))
				{
					game_field.setField(i / NRField.field_size, i % NRField.field_size, game_field.getField(current_active / NRField.field_size, current_active % NRField.field_size));
					game_field.setField(current_active / NRField.field_size, current_active % NRField.field_size, (byte)0);
					current_active = i;
					repaint();
					checkWin();
				}
			}
		}
		
	}
	
	public void mouseMoved(MouseEvent e) 
	{
		
	}
	
	private NRField game_field;
	private static int box_size = 50; //размер одного поля в пикселях
	private static int box_color_offset = 25; //вертикальное расстояние между игровым полем и индикаторами цветов
	private int current_active = -1; // текущий активный элемент(для перетаскивания квадратов)
	private ArrayList<Rectangle2D> rects;
	private JLabel text = new JLabel("Игра окончена");
	
}
