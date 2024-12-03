package ca.sheridancollege.uno.model;

public class SpecialCard extends Card {
    private final String action;

    public SpecialCard(String color, String value, String action) {
        super(color, value);
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    @Override
    public boolean matches(Card topCard) {
        return this.getColor().equals(topCard.getColor()) || topCard instanceof SpecialCard;
    }

    @Override
    public String toString() {
        return getColor() + " " + action;
    }
}
