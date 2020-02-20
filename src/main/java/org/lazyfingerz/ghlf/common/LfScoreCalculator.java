package org.lazyfingerz.ghlf.common;

import org.lazyfingerz.ghlf.model.LfResult;

public class LfScoreCalculator {

    public int getScore(LfResult result){
        int score = 0;
        for(int i=0; i<result.getOutput().size(); i++){
            score += getScore(result.getOutput().get(i));
        }
        return score;
    }

    public int getScore(Integer item){
        return 1;
    }
}
