package edu.ksu.canvas.interfaces;

import java.io.IOException;
import java.util.List;

import edu.ksu.canvas.model.ColumnDatum;
import edu.ksu.canvas.model.CustomColumn;

/**
 * Methods to read information from and about accounts
 */
public interface CustomColumnDataReader extends CanvasReader<ColumnDatum, CustomColumnDataReader> {

	List<ColumnDatum> getColumnData(Integer courseId, CustomColumn value, Boolean includeHidden) throws IOException;
}
