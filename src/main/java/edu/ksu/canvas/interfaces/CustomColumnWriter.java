package edu.ksu.canvas.interfaces;

import java.io.IOException;
import java.util.Optional;

import edu.ksu.canvas.model.CustomColumn;

/**
 * Methods to write information to cutom gradebook columns
 */
public interface CustomColumnWriter extends CanvasWriter<CustomColumn, CustomColumnWriter> {

	/**
     * Create an assignment in Canvas. The only required field is name.
     * @param courseId ID of the course to create the assignment in
     * @param assignment Assignment object to create. Must have at least a name set
     * @return The created assignment object
     * @throws IOException When there is an error communicating with Canvas
     */
    Optional<CustomColumn> createCustomColumn(Integer courseId, String title, Optional<Integer> position, Optional<Boolean> hidden) throws IOException;
}
