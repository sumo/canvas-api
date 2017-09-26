package edu.ksu.canvas.interfaces;

import java.io.IOException;
import java.util.Optional;

import edu.ksu.canvas.model.ColumnDatum;
import edu.ksu.canvas.model.CustomColumn;

public interface CustomColumnDataWriter extends CanvasWriter<ColumnDatum, CustomColumnDataWriter> {

	public Optional<ColumnDatum> updateCustomColumn(Integer courseId, CustomColumn col, String userId, String data) throws IOException;

	public void deleteCustomColumn(Integer courseId, CustomColumn col, String userId) throws IOException;
}
