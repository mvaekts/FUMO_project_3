package sample;

import com.sun.rowset.internal.Row;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.Collections;

public class Controller
{
    private static final int RowCount = 5;

    public TableColumn<PointsRow, Integer> fourthCol;
    public TableColumn<PointsRow, Integer> thirdCol;
    public TableColumn<PointsRow, Integer> firstCol;
    public TableColumn<PointsRow, Integer> secondCol;
    public TableView ValuesTable;
    public Label maximumLabel;
    public Label minimumLabel;
    private ObservableList<PointsRow> Values = FXCollections.observableArrayList();

    public void FillRandomClick(MouseEvent mouseEvent)
    {
        Values.clear();

        for (int i = 0; i < RowCount; ++i)
        {
            Values.add(new PointsRow(-10, 50));
        }

        firstCol.setCellValueFactory(new PropertyValueFactory<PointsRow, Integer>("First"));
        secondCol.setCellValueFactory(new PropertyValueFactory<PointsRow, Integer>("Second"));
        thirdCol.setCellValueFactory(new PropertyValueFactory<PointsRow, Integer>("Third"));
        fourthCol.setCellValueFactory(new PropertyValueFactory<PointsRow, Integer>("Fourth"));

        ValuesTable.setItems(Values);
    }

    public void SolveClick(MouseEvent mouseEvent)
    {
        int maximum = Values.get(0).getMaximum();
        int minimum = Values.get(0).getMinimum();

        for (int i = 1; i < RowCount; ++i)
        {
            int rowMaximum = Values.get(i).getMaximum();
            int rowMinimum = Values.get(i).getMinimum();
            if (rowMaximum > maximum)
            {
                maximum = rowMaximum;
            }
            if (rowMinimum < minimum)
            {
                minimum = rowMinimum;
            }
        }

        if (minimum == 0 || Math.abs(maximum / minimum) > 10)
        {
            for (int i = 0; i < RowCount; ++i)
            {
                Values.get(i).solveRow();
            }
        }

        maximumLabel.setText("Максимальный элемент: " + maximum);
        minimumLabel.setText("Минимальный элемент: " + minimum);

        ValuesTable.refresh();

    }
}
