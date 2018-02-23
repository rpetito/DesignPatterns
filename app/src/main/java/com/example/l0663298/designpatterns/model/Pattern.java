package com.example.l0663298.designpatterns.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by l0663298 on 20/02/2018.
 */

public class Pattern implements Parcelable {

    @SerializedName("type")
    private String type;
    @SerializedName("patternItems")
    private List<PatternItem> patternItemList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<PatternItem> getPatternItemList() {
        return patternItemList;
    }

    public void setPatternItemList(List<PatternItem> patternItemList) {
        this.patternItemList = patternItemList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeList(this.patternItemList);
    }

    public Pattern() {
    }

    protected Pattern(Parcel in) {
        this.type = in.readString();
        this.patternItemList = new ArrayList<PatternItem>();
        in.readList(this.patternItemList, PatternItem.class.getClassLoader());
    }

    public static final Creator<Pattern> CREATOR = new Creator<Pattern>() {
        @Override
        public Pattern createFromParcel(Parcel source) {
            return new Pattern(source);
        }

        @Override
        public Pattern[] newArray(int size) {
            return new Pattern[size];
        }
    };
}
