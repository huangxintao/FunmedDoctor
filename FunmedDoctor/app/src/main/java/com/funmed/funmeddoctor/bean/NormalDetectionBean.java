package com.funmed.funmeddoctor.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tony on 2017/8/2.
 */

public class NormalDetectionBean implements Parcelable {
    private String id;
    private String name;
    private int number;
    private double price;
    private String image;

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    private int imageResource;

    public String getDetection_field() {
        return detection_field;
    }

    public void setDetection_field(String detection_field) {
        this.detection_field = detection_field;
    }

    private String detection_field;

    public NormalDetectionBean(String id, String name, double price, int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public NormalDetectionBean(String id, String name, String detection_field, double price, int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.detection_field = detection_field;
    }

    public NormalDetectionBean(String id, String name, double price, int number,int imageResource) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.imageResource = imageResource;
    }

    protected NormalDetectionBean(Parcel in) {
        id = in.readString();
        name = in.readString();
        number = in.readInt();
        price = in.readDouble();
        image = in.readString();
    }

    public static final Creator<NormalDetectionBean> CREATOR = new Creator<NormalDetectionBean>() {
        @Override
        public NormalDetectionBean createFromParcel(Parcel in) {
            return new NormalDetectionBean(in);
        }

        @Override
        public NormalDetectionBean[] newArray(int size) {
            return new NormalDetectionBean[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeInt(number);
        parcel.writeDouble(price);
        parcel.writeString(image);
    }
}
