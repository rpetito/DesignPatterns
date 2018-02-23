package com.example.l0663298.designpatterns.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by l0663298 on 20/02/2018.
 */

public class PatternData {

    @SerializedName("patterns")
    private List<Pattern> patternList;

    public List<Pattern> getPatternList() {
        return patternList;
    }

    public void setPatternList(List<Pattern> patternList) {
        this.patternList = patternList;
    }
}
