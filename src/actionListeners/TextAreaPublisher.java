package actionListeners;

import java.awt.event.ActionListener;

public interface TextAreaPublisher extends ActionListener {
    void setText(String text);
    void printText();
}
