package form;

import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TableColumnAdjuster {

    private JTable table;
    private int spacing;
    private boolean isColumnHeaderIncluded;
    private boolean isOnlyAdjustLarger;

    /*
     *  Convenience constructor.  Spcaing is 1 pixel and
     *  isColumnHeaderIncluded is false and isOnlyAdjustLarger is false.
     *
     *  @param table  the table to adjust
     */
    public TableColumnAdjuster(JTable table)
    {
        this(table, 1);
    }

    /*
     *  Convenience constructor.  isColumnHeaderIncluded is false and
     *  isOnlyAdjustLarger is false.
     *
     *  @param table   the table to adjust
     *  @param spacing the amount of spacing between columns
     */
    public TableColumnAdjuster(JTable table, int spacing)
    {
        this(table, spacing, false);
    }

    /*
     *  Convenience constructor.  isOnlyAdjustLarger is false.
     *
     *  @param table   the table to adjust
     *  @param spacing the amount of spacing between columns
     *  @param isColumnHeaderIncluded  true when the width of the column
     *				header should be used when calculating the width
     */
    public TableColumnAdjuster(JTable table, int spacing, boolean isColumnHeaderIncluded)
    {
        this(table, spacing, isColumnHeaderIncluded, false);
    }

    /*
     *  Specify the table and other information needed to do the calculation.
     *
     *  @param table   the table to adjust
     *  @param spacing the amount of spacing between columns
     *  @param isColumnHeaderIncluded  true when the width of the column
     *				header should be used when calculating the width
     *  @param isOnlyAdjustLarger  true when the column width will only be
     *				increased and never decreased
     */
    public TableColumnAdjuster(JTable table, int spacing, boolean isColumnHeaderIncluded, boolean isOnlyAdjustLarger)
    {
        this.table = table;
        this.spacing = spacing;
        this.isColumnHeaderIncluded = isColumnHeaderIncluded;
        this.isOnlyAdjustLarger = isOnlyAdjustLarger;
    }

    /*
     *  Adjust the columns to be sized according to the data contained in the
     *  column.
     */
    public void adjustColumns()
    {
        TableColumnModel tcm = table.getColumnModel();

        for (int i = 0; i < tcm.getColumnCount(); i++)
        {
            adjustColumn(i);
        }
    }

    /*
     *  Adjust the width of the specified column in the table.
     *
     *  @param column  the column to adjust
     */
    public void adjustColumn(int column)
    {
        TableColumn tableColumn = table.getColumnModel().getColumn(column);

        if (! tableColumn.getResizable()) return;

        int columnHeaderWidth = getColumnHeaderWidth(column);
        int columnDataWidth   = getColumnDataWidth(column);
        int preferredWidth    = Math.max(columnHeaderWidth, columnDataWidth);

        updateTableColumn(column, preferredWidth);
    }

    /*
     *  Calculated the width based on the column header
     *
     *  @param column  the column to calculate the width of
     *
     *  @return the width of the column header
     */
    private int getColumnHeaderWidth(int column)
    {
        if (! isColumnHeaderIncluded) return 0;

        TableColumn tableColumn = table.getColumnModel().getColumn(column);
        Object value = tableColumn.getHeaderValue();
        TableCellRenderer renderer = tableColumn.getHeaderRenderer();

        if (renderer == null)
        {
            renderer = table.getTableHeader().getDefaultRenderer();
        }

        Component c = renderer.getTableCellRendererComponent(table, value, false, false, -1, column);
        return c.getPreferredSize().width;
    }

    /*
     *  Calculated the width based on the widest cell in the column.
     *
     *  @param column  the column to calculate the width of
     *
     *  @return the width of the widest cell in the column
     */
    private int getColumnDataWidth(int column)
    {
        int preferredWidth = 0;
        int maxWidth = table.getColumnModel().getColumn(column).getMaxWidth();

        for (int row = 0; row < table.getRowCount(); row++)
        {
            preferredWidth = Math.max(preferredWidth, getCellDataWidth(row, column));

            //  We've exceeded the maximum width, no need to check other rows

            if (preferredWidth >= maxWidth)
            {
                break;
            }
        }

        return preferredWidth;
    }

    /*
     *  Get the preferred width for the specified cell
     *
     *  @param row     the row of the cell
     *  @param column  the column of the cell
     *
     *  @return  the preferred width of the cell
     */
    private int getCellDataWidth(int row, int column)
    {
        TableCellRenderer renderer = table.getCellRenderer(row, column);
        Component c = table.prepareRenderer(renderer, row, column);
        Rectangle rect = c.getBounds();
        return c.getPreferredSize().width + table.getIntercellSpacing().width;
    }

    /*
     *  Update the TableColumn with the newly calculated width
     *
     *  @param column		the column to update
     *  @param preferredWidth  the width to use for the TableColumn
     */
    private void updateTableColumn(int column, int preferredWidth)
    {
        TableColumn tableColumn = table.getColumnModel().getColumn(column);

        if (! isOnlyAdjustLarger)
        {
            tableColumn.setPreferredWidth(preferredWidth);
        }
        else
        {
            int currentWidth = tableColumn.getWidth();

            if (preferredWidth > currentWidth)
            {
                tableColumn.setPreferredWidth(preferredWidth);
            }
        }
    }
}

