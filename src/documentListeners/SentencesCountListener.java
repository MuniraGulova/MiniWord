package documentListeners;

import utils.TextUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SentencesCountListener implements DocumentListener {
    private final JTextPane sourceTxtArea;
    private final JTextPane outputTxtArea;

    public SentencesCountListener(JTextPane sourceTxtArea, JTextPane outputTxtArea) {
        this.sourceTxtArea = sourceTxtArea;
        this.outputTxtArea = outputTxtArea;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        outputTxtArea.setText(countSentencesAsStr());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        outputTxtArea.setText(countSentencesAsStr());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        outputTxtArea.setText(countSentencesAsStr());
    }

    public String countSentencesAsStr() {
        return " " + TextUtils.countSentences(sourceTxtArea.getText());
    }
}
