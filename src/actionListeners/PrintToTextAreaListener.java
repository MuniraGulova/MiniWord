package actionListeners;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PrintToTextAreaListener implements TextAreaPublisher {
    private final JTextArea textArea;
    private String message;
    private int pressedCount;

    public int getPressedCount() {
        return this.pressedCount;
    }
    public PrintToTextAreaListener(JTextArea textArea, String message) {
        this.textArea = textArea;
        this.message = message;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.printText();
        this.pressedCount++;
    }

    @Override
    public void setText(String text) {
        this.message = text;
    }

    @Override
    public void printText() {
        textArea.setEnabled(true);
        textArea.setText(message);
    }
}
