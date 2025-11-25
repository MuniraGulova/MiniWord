package actionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintToConsoleActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("action performed");
    }
}
