package documentListeners;

import utils.TextUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LetterCountListener implements DocumentListener {
    private final JTextArea sourceTxtArea;
    private final JTextArea outputTxtArea;

    public LetterCountListener(JTextArea sourceTxtArea, JTextArea outputTxtArea) {
        this.sourceTxtArea = sourceTxtArea;
        this.outputTxtArea = outputTxtArea;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        outputTxtArea.setText(countWordsAsStr());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        outputTxtArea.setText(countWordsAsStr());

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        outputTxtArea.setText(countWordsAsStr());

    }

    public String countWordsAsStr() {
        return " " + TextUtils.countWords(sourceTxtArea.getText());
    }
}
