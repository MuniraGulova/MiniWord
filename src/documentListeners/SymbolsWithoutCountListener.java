package documentListeners;

import utils.TextUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SymbolsWithoutCountListener implements DocumentListener {
    private final JTextArea sourceTxtArea;
    private final JTextArea outputTxtArea;

    public SymbolsWithoutCountListener(JTextArea sourceTxtArea, JTextArea outputTxtArea) {
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
