package documentListeners;

import utils.TextUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SymbolsCountListener implements DocumentListener {
    private final JTextArea sourceTxtArea;
    private final JTextArea outputTxtArea;

    public SymbolsCountListener(JTextArea sourceTxtArea, JTextArea outputTxtArea) {
        this.sourceTxtArea = sourceTxtArea;
        this.outputTxtArea = outputTxtArea;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        outputTxtArea.setText(countSymbolsAsStr());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        outputTxtArea.setText(countSymbolsAsStr());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        outputTxtArea.setText(countSymbolsAsStr());
    }

    public String countSymbolsAsStr() {
        return " " + TextUtils.countChars(sourceTxtArea.getText());
    }
}
