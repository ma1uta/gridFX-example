package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.text.MessageFormat;

/**
 * @author tolya
 * @since 28.08.14.
 */
public class GridPaneController {

    protected int i = 0;

    @FXML
    protected GridPane gridPane;

    public void addRow(ActionEvent event) {
        Label label = new Label(MessageFormat.format("{0}-label", i++));
        gridPane.addColumn(0, label);
    }

    public void removeRow(ActionEvent event) {
        ObservableList<Node> children = gridPane.getChildren();
        if (children.size() > 1) {
            children.remove(children.size() - 1);
        }
    }

}
