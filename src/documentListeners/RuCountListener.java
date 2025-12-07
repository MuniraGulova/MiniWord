package documentListeners;

import components.StatTextArea;
import utils.TextUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.time.temporal.Temporal;

public class RuCountListener implements DocumentListener {
    private final JTextPane sourceTxtArea;
    private final JTextPane outputTxtArea;

    public RuCountListener(JTextPane sourceTxtArea, StatTextArea outputTxtArea) {
        this.outputTxtArea = outputTxtArea;
        this.sourceTxtArea = sourceTxtArea;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {outputTxtArea.setText(RuCountasStr());}

    @Override
    public void removeUpdate(DocumentEvent e) {outputTxtArea.setText(RuCountasStr());}

    @Override
    public void changedUpdate(DocumentEvent e) {outputTxtArea.setText(RuCountasStr());}

    public String RuCountasStr() {
        return " " + TextUtils.RuCount(sourceTxtArea.getText());
    }
}
