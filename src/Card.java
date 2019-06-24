import javax.swing.*;

import java.awt.*;

public class Card extends JToggleButton {
	CardData _data;
	
	static final int[][] Positions = new int[][]{new int[]{0}, new int[]{-30, 30}, new int[]{-50, 0, 50}};
	
	static{
		
		
	}
	public Card()
	{
		setPreferredSize(new Dimension(200, 128));
	}
	
	public void setCardData(CardData data)
	{
		_data = data;
		repaint();
	}
	
	public CardData getCardData()
	{
		return _data;
	}
	
	@Override
	public void setSize(Dimension newDim)
	{
		
	}
	public static Color getDrawingColor(CardData data)
	{
		Color c;
		if(data.getColor() == CardData.ColorCode.Green)
			c = Color.GREEN;
		else if(data.getColor() == CardData.ColorCode.Purple)
			c = Color.CYAN;
		else c = Color.RED;
		
		return c;
	}
	
	public static Color getFillColor(CardData data)
	{
		Color c;
		if(data.getFill() == CardData.Fill.Empty)
			c = Color.BLACK;
		else if(data.getFill() == CardData.Fill.Solid)
			c = Color.YELLOW;
		else c = Color.PINK;
		
		return c;
	}
	public static int getPositionIndex(CardData data)
	{
		return (int)data.getNumber().ordinal();
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		final int DEFAULT_SCALE = 40;
		super.paintComponent(g);
		if(_data != null)
		{
			g.setColor(getFillColor(_data));
			g.fillRect(5, 40, this.getWidth()-10, this.getHeight()-80);
			g.setColor(getDrawingColor(_data));
			//g.fillRect(5, 5, getWidth()-10, getHeight()-10);
			//DrawDiamond(g, new Dimension(50, 5), 30);
			//g.fillOval(5, 5, 20, 30);
			
			int[] pos = Positions[getPositionIndex(_data)];
					
			for(int i = 0; i < pos.length; i++)
			{
				if(_data.getShape() == CardData.Shape.Triangle)
					DrawTriangle(g, new Dimension(pos[i]+this.getWidth()/2,this.getHeight()/2),DEFAULT_SCALE);
				else if(_data.getShape() == CardData.Shape.Diamond)
					DrawDiamond(g, new Dimension(pos[i]+this.getWidth()/2,this.getHeight()/2),DEFAULT_SCALE);
				else if(_data.getShape() == CardData.Shape.Oval)
					DrawOval(g, new Dimension(pos[i]+this.getWidth()/2,this.getHeight()/2),DEFAULT_SCALE);
			}
		}
	}
	
	private void DrawOval(Graphics g, Dimension pos, double scale)
	{	
		g.fillOval((int)(pos.width - scale / 2), (int)(pos.height - scale / 2), (int)scale, (int)scale);
	}
	
	private void DrawTriangle(Graphics g, Dimension pos, double scale)
	{	
		int[] xPos = new int[]{(int)(pos.getWidth()),(int)(pos.getWidth() + scale / 2), (int)(pos.getWidth() - scale / 2),(int)(pos.getWidth())};
		int[] yPos = new int[]{(int)(pos.getHeight() - scale / 2),(int)(pos.getHeight() + scale / 2),(int)(pos.getHeight() + scale / 2),(int)(pos.getHeight() - scale / 2)};
		g.fillPolygon(xPos, yPos, 4);
	}
	
	private void DrawDiamond(Graphics g, Dimension pos, int scale)
	{
		int[] xPos = new int[]{(int)(pos.getWidth()),(int)(pos.getWidth() + scale / 2), (int)(pos.getWidth()), (int)(pos.getWidth() - scale / 2),(int)(pos.getWidth())};
		int[] yPos = new int[]{(int)(pos.getHeight() - scale / 2),(int)(pos.getHeight()),(int)(pos.getHeight() + scale / 2),(int)(pos.getHeight()), (int)(pos.getHeight() - scale / 2)};
	
		g.fillPolygon(xPos, yPos, 5);
	}
	
}
