package edu.ksu.canvas.interfaces;

import java.io.IOException;
import java.util.List;

import edu.ksu.canvas.model.CustomColumn;

/**
 * Methods to read information from and about accounts
 */
public interface CustomColumnReader extends CanvasReader<CustomColumn, CustomColumnReader> {

    /**
     * Return a list of custom columns for a course
     * 
     */
    List<CustomColumn> listCustomColumns(Integer courseId, Boolean includeHidden) throws IOException;

}
