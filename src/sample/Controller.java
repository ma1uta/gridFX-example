package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author tolya
 * @since 28.08.14.
 */
public class Controller implements Initializable {

    @FXML
    protected TableView<String[]> tableView;

    public void addRow(ActionEvent event) {
        ObservableList<String[]> items = tableView.getItems();
        int size = items.size() + 1;
        String[] row = new String[3];
        for (int i = 0; i < 3; i++) {
            row[i] = Integer.toString(size) + Integer.toString(i + 1);
        }
        items.add(row);
    }

    public void removeRow(ActionEvent event) {
        TableView.TableViewSelectionModel<String[]> selectionModel = tableView.getSelectionModel();
        ObservableList<String[]> items = tableView.getItems();
        items.removeAll(selectionModel.getSelectedItems());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String[]> data = FXCollections
                .observableArrayList(new String[]{"11", "12", "13"}, new String[]{"21", "22", "23"},
                                     new String[]{"31", "32", "33"}, new String[]{"41", "42", "43"});

        tableView.setItems(data);
        for (int i = 0; i < tableView.getColumns().size(); i++) {
            TableColumn column = (TableColumn) tableView.getColumns().get(i);
            final int finalI = i;
            column.setCellValueFactory(cellDataFeatures -> {
                String[] value = (String[]) ((TableColumn.CellDataFeatures) cellDataFeatures).getValue();
                return new SimpleStringProperty(value[finalI]);
            });
        }
    }
}
