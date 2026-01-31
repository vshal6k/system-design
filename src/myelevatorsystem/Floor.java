package myelevatorsystem;

import myelevatorsystem.button.ExternalButton;

class Floor {
    int number;
    ExternalButton externalButton;

    public Floor(int number) {
        this.number = number;
        this.externalButton = new ExternalButton();
    }

    void pressUpExternalButton() {
        this.externalButton.pressUp(number);
    }

    void pressDownExternalButton() {
        this.externalButton.pressDown(number);
    }
}