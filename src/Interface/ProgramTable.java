package Interface;

import ControlCenter.Controller;
import Data.Program;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProgramTable extends AbstractTableModel {
    private String[] columns;
    private ArrayList<Object[]> data;

    private Controller controller;

    public ProgramTable(Controller controller) {
        this.controller = controller;

        columns = new String[] {
                controller.getLanguage().getString("nameProgram"),
                controller.getLanguage().getString("executableFile"),
                controller.getLanguage().getString("absoluteLocation"),
                controller.getLanguage().getString("descriptionProgram"),
                controller.getLanguage().getString("urlProgram")
        };

        data = new ArrayList<>(1);
    }

    public ProgramTable(Controller controller, Program[] exec) {
        this.controller = controller;   //TODO is this useful?

        columns = new String[] {
                controller.getLanguage().getString("nameProgram"),
                controller.getLanguage().getString("executableFile"),
                controller.getLanguage().getString("absoluteLocation"),
                controller.getLanguage().getString("descriptionProgram"),
                controller.getLanguage().getString("urlProgram")
        };

        data = new ArrayList<>(exec.length);

        for (Program p : exec) {
            data.add(new Object[] {
                    p.getName(),
                    p.getExecLocation().getPath(),
                    p.getExecLocation().getAbsolutePath(),
                    p.getDescription(),
                    p.getLink()
            });
        }
    }

    public void addProgram(Program exec) {
        data.add(new Object[] {
                exec.getName(),
                exec.getExecLocation().getName(),
                exec.getExecLocation().getAbsolutePath(),
                exec.getDescription(),
                exec.getLink()
        });
    }

    public Object[] getProgram(int index) {
        return data.get(index);
    }

    public void editProgram(int index, Program exec) {
        data.set(index, new Object[] {
                exec.getName(),
                exec.getExecLocation().getName(),
                exec.getExecLocation().getAbsolutePath(),
                exec.getDescription(),
                exec.getLink()
        });
    }

    public void removeProgram(int index) {
        if (!data.isEmpty() && index != -1) {
            data.remove(index);
        }
    }

    public void removeAllPrograms() {
        data.clear();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
