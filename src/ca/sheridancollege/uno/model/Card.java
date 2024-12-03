package ca.sheridancollege.uno.model;

public abstract class Card {
    private final String color;
    private final String value;

    public Card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean matches(Card topCard);

    @Override
    public String toString() {
        return color + " " + value;
    }
    
    public boolean isPlayable(Card topCard) {
        return this.color.equals(topCard.color) || this.value.equals(topCard.value);
    }


}
