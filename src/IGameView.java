import java.util.ArrayList;


public interface IGameView {
void RefreshCards(ArrayList<CardData> cardsInPlay);
void SetFound();
void NotSet();
}
