package com.example.l0663298.designpatterns.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by l0663298 on 20/02/2018.
 */

public class PatternItem implements Parcelable {

    @SerializedName("name")
    private String name;
    @SerializedName("intent")
    private String intent;
    @SerializedName("usage")
    private String usage;
    @SerializedName("link")
    private String link;
    @SerializedName("image")
    private String imageURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.intent);
        dest.writeString(this.usage);
        dest.writeString(this.link);
        dest.writeString(this.imageURL);
    }

    public PatternItem() {
    }

    protected PatternItem(Parcel in) {
        this.name = in.readString();
        this.intent = in.readString();
        this.usage = in.readString();
        this.link = in.readString();
        this.imageURL = in.readString();
    }

    public static final Parcelable.Creator<PatternItem> CREATOR = new Parcelable.Creator<PatternItem>() {
        @Override
        public PatternItem createFromParcel(Parcel source) {
            return new PatternItem(source);
        }

        @Override
        public PatternItem[] newArray(int size) {
            return new PatternItem[size];
        }
    };
}
