import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class cardMouseAdapter extends MouseAdapter {
	GameState _state;
	
	public cardMouseAdapter(GameState state)
	{
		_state = state;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		Card source = (Card)e.getSource();
		if (source.isSelected())
		{
			_state.AddCardToSelection(source.getCardData());
		}
		else
		{
			_state.RemoveCardFromSelection(source.getCardData());
		}
	}
}
