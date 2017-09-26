package edu.ksu.canvas.interfaces;

import java.io.IOException;
import java.util.List;

import edu.ksu.canvas.model.CustomColumn;
import edu.ksu.canvas.model.GradingStandard;

/**
 * Methods to read information from and about accounts
 */
public interface GradingStandardReader extends CanvasReader<GradingStandard, GradingStandardReader> {

    /**
     * Return a list of custom columns for a course
     * 
     */
    List<GradingStandard> getGradingStandardsForAccount(Integer accountId) throws IOException;

}
