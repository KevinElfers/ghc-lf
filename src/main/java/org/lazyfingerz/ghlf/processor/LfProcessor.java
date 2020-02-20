package org.lazyfingerz.ghlf.processor;

import org.lazyfingerz.ghlf.model.LfProblemInstance;
import org.lazyfingerz.ghlf.model.LfResult;

public class LfProcessor {

    public LfResult process(LfProblemInstance problemInstance) {
        return new LfResult(problemInstance.getInput());
    }

}
