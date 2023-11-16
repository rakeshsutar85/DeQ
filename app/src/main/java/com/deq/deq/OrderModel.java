package com.deq.deq;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class OrderModel implements Parcelable{

    private String PersonName;
    private String ArrivalTime;
    private  String OrderData;
    private String OrderID;


    public OrderModel(){

    }

    public OrderModel(String personName, String arrivalTime, String orderData, String orderID) {
        PersonName = personName;
        ArrivalTime = arrivalTime;
        OrderData = orderData;
        OrderID = orderID;
    }

    protected OrderModel(Parcel in) {
        PersonName = in.readString();
        ArrivalTime = in.readString();
        OrderData = in.readString();
        OrderID = in.readString();
    }

    public static final Creator<OrderModel> CREATOR = new Creator<OrderModel>() {
        @Override
        public OrderModel createFromParcel(Parcel in) {
            return new OrderModel(in);
        }

        @Override
        public OrderModel[] newArray(int size) {
            return new OrderModel[size];
        }
    };

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }

    public String getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public String getOrderData() {
        return OrderData;
    }

    public void setOrderData(String orderData) {
        OrderData = orderData;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(PersonName);
        parcel.writeString(ArrivalTime);
        parcel.writeString(OrderData);
        parcel.writeString(OrderID);
    }
}
