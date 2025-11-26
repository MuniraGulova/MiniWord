package mouseListeners;

import components.StatTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseTipTextListener extends MouseAdapter {
    private StatTextArea statArea;

    public MouseTipTextListener(StatTextArea statArea) {
        this.statArea = statArea;
    }
//todo
    @Override
    public void mouseEntered(MouseEvent e) {
        statArea.setToolTipText(statArea.getDescription());
    }
}
