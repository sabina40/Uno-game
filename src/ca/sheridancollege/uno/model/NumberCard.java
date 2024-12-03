package ca.sheridancollege.uno.model;

public class NumberCard extends Card {
    private final String number;

    public NumberCard(String color, String value, String number) {
        super(color, value);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean matches(Card topCard) {
        if (topCard instanceof NumberCard) {
            NumberCard otherCard = (NumberCard) topCard;
            return this.getColor().equals(otherCard.getColor()) || this.getNumber().equals(otherCard.getNumber());
        }
        return false;
    }

    @Override
    public String toString() {
        return getColor() + " " + number;
    }
}
