package edu.ksu.canvas.interfaces;

import java.io.IOException;
import java.util.Optional;

import edu.ksu.canvas.model.CustomColumn;

/**
 * Methods to write information to custom gradebook columns
 */
public interface CustomColumnWriter extends CanvasWriter<CustomColumn, CustomColumnWriter> {

	
    Optional<CustomColumn> createCustomColumn(Integer courseId, String title, Optional<Integer> position, Optional<Boolean> hidden) throws IOException;
}
