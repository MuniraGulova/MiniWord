package documentListeners;

import utils.TextUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SymbolsWithoutCountListener implements DocumentListener {
    private final JTextPane sourceTxtArea;
    private final JTextPane outputTxtArea;

    public SymbolsWithoutCountListener(JTextPane sourceTxtArea, JTextPane outputTxtArea) {
        this.sourceTxtArea = sourceTxtArea;
        this.outputTxtArea = outputTxtArea;
    }

    @Override
    public void insertUpdate(DocumentEvent e ) {outputTxtArea.setText(returnresult());}

    @Override
    public void removeUpdate(DocumentEvent e) {outputTxtArea.setText(returnresult());}

    @Override
    public void changedUpdate(DocumentEvent e) {outputTxtArea.setText(returnresult());}
    public String returnresult(){
        return " " + TextUtils.countCharsWithoutSpace(sourceTxtArea.getText());
    }

}
