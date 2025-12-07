package documentListeners;

import components.StatTextArea;
import utils.TextUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class AbzCountListener implements DocumentListener {
    private final JTextPane sourceTxtArea;
    private final JTextPane outputTxtArea;

    public AbzCountListener(JTextPane sourceTxtArea, StatTextArea outputTxtArea) {
        this.sourceTxtArea = sourceTxtArea;
        this.outputTxtArea = outputTxtArea;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {outputTxtArea.setText(AbzCountasStr());}

    @Override
    public void removeUpdate(DocumentEvent e) {outputTxtArea.setText(AbzCountasStr());}

    @Override
    public void changedUpdate(DocumentEvent e) {outputTxtArea.setText(AbzCountasStr());}

    String AbzCountasStr() {
        return " " + TextUtils.AbzCount(sourceTxtArea.getText());
    }
}
