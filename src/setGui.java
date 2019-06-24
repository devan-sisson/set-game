import javax.swing.*;

import java.awt.*;

import javax.swing.JToggleButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import net.miginfocom.swing.MigLayout;

import java.awt.CardLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class setGui extends JFrame implements IGameView {
	public setGui() {
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		setSize(new Dimension(900, 500));
		


		//GenerateColumn();
		//GenerateColumn();
		//GenerateColumn();
		//GenerateColumn();

		/*Card tglbtnNewToggleButton = new Card();
		tglbtnNewToggleButton.addMouseListener(new cardMouseAdapter(_state));
		tglbtnNewToggleButton.setCardData(new CardData(CardData.Shape.Diamond, CardData.ColorCode.Green, CardData.Number.One, CardData.Fill.Solid));
		getContentPane().add(tglbtnNewToggleButton, "4, 4");
		
		
		
		
		
		Card tglbtnNewToggleButton_1 = new Card();
		tglbtnNewToggleButton_1.addMouseListener(new cardMouseAdapter(_state));
		tglbtnNewToggleButton_1.setCardData(new CardData(CardData.Shape.Oval, CardData.ColorCode.Purple, CardData.Number.Two, CardData.Fill.Empty));
		getContentPane().add(tglbtnNewToggleButton_1, "6, 4");
		
		
		
		
		
		Card tglbtnNewToggleButton_2 = new Card();
		tglbtnNewToggleButton_2.addMouseListener(new cardMouseAdapter(_state));
		tglbtnNewToggleButton_2.setCardData(new CardData(CardData.Shape.Triangle, CardData.ColorCode.Red, CardData.Number.Three, CardData.Fill.Stripe));
		getContentPane().add(tglbtnNewToggleButton_2, "8, 4");
		
		
		
		
		
		Card tglbtnNewToggleButton_3 = new Card();
		tglbtnNewToggleButton_3.addMouseListener(new cardMouseAdapter(_state));
		getContentPane().add(tglbtnNewToggleButton_3, "10, 4");
		
		
		
		
		
		Card tglbtnNewToggleButton_4 = new Card();
		tglbtnNewToggleButton_4.addMouseListener(new cardMouseAdapter(_state));
		getContentPane().add(tglbtnNewToggleButton_4, "4, 6");
		
		
		
		
		
		Card tglbtnNewToggleButton_5 = new Card();
		tglbtnNewToggleButton_5.addMouseListener(new cardMouseAdapter(_state));
		getContentPane().add(tglbtnNewToggleButton_5, "6, 6");
		
		
		
		
		
		Card tglbtnNewToggleButton_6 = new Card();
		tglbtnNewToggleButton_6.addMouseListener(new cardMouseAdapter(_state));
		getContentPane().add(tglbtnNewToggleButton_6, "8, 6");
		
		
		
		
		
		Card tglbtnNewToggleButton_7 = new Card();
		tglbtnNewToggleButton_7.addMouseListener(new cardMouseAdapter(_state));
		getContentPane().add(tglbtnNewToggleButton_7, "10, 6");
		
		
		
		
		
		Card tglbtnNewToggleButton_8 = new Card();
		tglbtnNewToggleButton_8.addMouseListener(new cardMouseAdapter(_state));
		getContentPane().add(tglbtnNewToggleButton_8, "4, 8");
		
		
		
		
		
		Card tglbtnNewToggleButton_9 = new Card();
		tglbtnNewToggleButton_9.addMouseListener(new cardMouseAdapter(_state));
		getContentPane().add(tglbtnNewToggleButton_9, "6, 8");
		
		
		
		
		
		Card tglbtnNewToggleButton_10 = new Card();
		tglbtnNewToggleButton_10.addMouseListener(new cardMouseAdapter(_state));
		getContentPane().add(tglbtnNewToggleButton_10, "8, 8");
		
		
		
		
		
		Card tglbtnNewToggleButton_11 = new Card();
		tglbtnNewToggleButton_11.addMouseListener(new cardMouseAdapter(_state));
		getContentPane().add(tglbtnNewToggleButton_11, "10, 8");
		*/
		
		
		
		_state = new GameState(this);
		_state.StartGame();
	}
	GameState _state;
	
	int nextColumn = 2;
	
	private void GenerateColumn()
	{
		Card card = new Card();
		card.addMouseListener(new cardMouseAdapter(_state));
		getContentPane().add(card, nextColumn + ", 2");
		card = new Card();
		card.addMouseListener(new cardMouseAdapter(_state));
		getContentPane().add(card, nextColumn + ", 4");	
		card = new Card();
		card.addMouseListener(new cardMouseAdapter(_state));
		getContentPane().add(card, nextColumn + ", 6");
		
		nextColumn+=2;
	
	}
	
	private void RemoveColumn() 
	{
		for(int i = 0; i < 3; i++)
		{
			getContentPane().remove(getContentPane().getComponentCount()-1);
		}		
		nextColumn-=2;
	}
	
	public void RefreshCards(ArrayList<CardData> cardsInPlay)
	{
		while(cardsInPlay.size() > getContentPane().getComponentCount())
		{
			GenerateColumn();
		}
		while(cardsInPlay.size() < getContentPane().getComponentCount())
		{
			RemoveColumn();
		}
		
		for(int i = 0; i < getContentPane().getComponentCount(); i++)
		{
			Card card = ((Card)getContentPane().getComponents()[i]);
			card.setCardData(cardsInPlay.get(i));
			card.setSelected(false);
		}
		repaint();
	}
	//int score = 0;
	public void SetFound()
	{
		JOptionPane.showMessageDialog (this, "You found a SET!");
		//score++;
		//textbox.setText("Score: " + score);
	}
	
	public void NotSet()
	{
		
	}
	

}
