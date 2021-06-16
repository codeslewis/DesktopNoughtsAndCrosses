package listeners;

import ui.LabelStatus;

import java.awt.event.ActionEvent;

public interface CellListener {
    void onCellClicked(ActionEvent actionEvent, LabelStatus LabelStatus);
}
