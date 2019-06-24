
public class CardData {
	public enum Shape
	{
		Oval,
		Diamond,
		Triangle
	}
	public enum ColorCode
	{
		Green,
		Red,
		Purple
	}
	public enum Number
	{
		One,
		Two,
		Three
	}
	public enum Fill
	{
		Empty,
		Solid,
		Stripe
	}
	
	Shape _shape;
	ColorCode _color;
	Number _number;
	Fill _fill;
	
	public CardData(Shape shape, ColorCode color, Number number, Fill fill)
	{
		_shape = shape;
		_color = color;
		_number = number;
		_fill = fill;
	}
	
	public Shape getShape()
	{
		return _shape;
	}
	public ColorCode getColor()
	{
		return _color;
	}

	
	public Number getNumber()
	{
		return _number;
	}
	public Fill getFill()
	{
		return _fill;
	}
}
