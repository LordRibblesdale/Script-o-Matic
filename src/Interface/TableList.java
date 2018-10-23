package Interface;

import ControlCenter.Controller;
import Data.Program;

import javax.swing.*;

public class TableList extends JPanel {
    private JScrollPane scrollPane;
    private ProgramTable modelTable;
    private JTable table;
    private JButton back, next;
    private JButton add, remove;
    private SpringLayout layout;

    private Controller controller;

    TableList(Controller controller) {
        this.controller = controller;

        setLayout(layout = new SpringLayout());

        back = new JButton(controller.getLanguage().getString("previousButton"));
        next = new JButton(controller.getLanguage().getString("nextButton"));

        add = new JButton(controller.getLanguage().getString("addEntry"));
        remove = new JButton(controller.getLanguage().getString("removeSelectedEntry"));

        modelTable = new ProgramTable(controller);
        table = new JTable(modelTable);
        scrollPane = new JScrollPane(table);

        add(scrollPane);
        add(back);
        add(next);
        add(add);
        add(remove);

        layout.putConstraint(SpringLayout.NORTH, scrollPane,
                5,
                SpringLayout.NORTH, TableList.this);
        layout.putConstraint(SpringLayout.WEST, scrollPane,
                5,
                SpringLayout.WEST, TableList.this);
        layout.putConstraint(SpringLayout.EAST, scrollPane,
                -5,
                SpringLayout.EAST, TableList.this);

        layout.putConstraint(SpringLayout.SOUTH, back,
                -5,
                SpringLayout.SOUTH, TableList.this);
        layout.putConstraint(SpringLayout.WEST, back,
                5,
                SpringLayout.WEST, TableList.this);

        layout.putConstraint(SpringLayout.EAST, next,
                -5,
                SpringLayout.EAST, TableList.this);
        layout.putConstraint(SpringLayout.SOUTH, next,
                -5,
                SpringLayout.SOUTH, TableList.this);

        layout.putConstraint(SpringLayout.SOUTH, remove,
                -5,
                SpringLayout.NORTH, next);
        layout.putConstraint(SpringLayout.EAST, remove,
                -5,
                SpringLayout.EAST, TableList.this);

        layout.putConstraint(SpringLayout.EAST, add,
                -5,
                SpringLayout.WEST, remove);
        layout.putConstraint(SpringLayout.SOUTH, add,
                -5,
                SpringLayout.NORTH, next);
    }

    TableList(Controller controller, Program[] exec) {  //TODO Optimise here
        this.controller = controller;

        setLayout(layout = new SpringLayout());

        back = new JButton(controller.getLanguage().getString("previousButton"));
        next = new JButton(controller.getLanguage().getString("nextButton"));

        add = new JButton(controller.getLanguage().getString("addEntry"));
        remove = new JButton(controller.getLanguage().getString("removeSelectedEntry"));

        modelTable = new ProgramTable(controller, exec);    //TODO only here
        table = new JTable(modelTable);
        scrollPane = new JScrollPane(table);

        layout.putConstraint(SpringLayout.NORTH, scrollPane,
                5,
                SpringLayout.NORTH, TableList.this);
        layout.putConstraint(SpringLayout.WEST, scrollPane,
                5,
                SpringLayout.WEST, TableList.this);
        layout.putConstraint(SpringLayout.EAST, scrollPane,
                -5,
                SpringLayout.EAST, TableList.this);

        layout.putConstraint(SpringLayout.SOUTH, back,
                -5,
                SpringLayout.SOUTH, TableList.this);
        layout.putConstraint(SpringLayout.WEST, back,
                5,
                SpringLayout.WEST, TableList.this);

        layout.putConstraint(SpringLayout.EAST, next,
                -5,
                SpringLayout.EAST, TableList.this);
        layout.putConstraint(SpringLayout.SOUTH, next,
                -5,
                SpringLayout.SOUTH, TableList.this);

        layout.putConstraint(SpringLayout.SOUTH, remove,
                -5,
                SpringLayout.NORTH, next);
        layout.putConstraint(SpringLayout.EAST, remove,
                -5,
                SpringLayout.EAST, TableList.this);

        layout.putConstraint(SpringLayout.EAST, add,
                -5,
                SpringLayout.WEST, remove);
        layout.putConstraint(SpringLayout.SOUTH, add,
                -5,
                SpringLayout.NORTH, next);
    }
}
