package components;

import javax.swing.*;

public class StatTextArea extends JTextArea {
    private final String description;

    public String getDescription() {
        return this.description;
    }

    public StatTextArea(String text, String description) {
        super(text); //вызовы супер конструктор
        this.description = description; //продолжи делать что-то ещё
    }
}
