package it.m_chele.hotels;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

class Hotel implements Parcelable {

    // TODO: dummy data, prendere da network
//    @SerializedName("name")
    public List images;
    public String name;
    public int stars;
    public String address;
    public String checkin;
    public String checkout;
    public String email;
    public String phone;
    public double rating;


    public Hotel(String name) {

        this.images = new ArrayList();
        images.add("https://aff.bstatic.com/images/hotel/max500/102/102202628.jpg");
        this.name = name;
        this.stars = 4;
        this.address = "via del Pippo";
        this.checkin = "17:00 to 22:00";
        this.checkout = "07:00 to 12:00";
        this.email = "hotel.pippo@gnail.com";
        this.phone = "+33 333 777666 ";
        this.rating = 9.8;
    }

    protected Hotel(Parcel in) {
        name = in.readString();
        stars = in.readInt();
        address = in.readString();
        checkin = in.readString();
        checkout = in.readString();
        email = in.readString();
        phone = in.readString();
        rating = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(stars);
        dest.writeString(address);
        dest.writeString(checkin);
        dest.writeString(checkout);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeDouble(rating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Hotel> CREATOR = new Creator<Hotel>() {
        @Override
        public Hotel createFromParcel(Parcel in) {
            return new Hotel(in);
        }

        @Override
        public Hotel[] newArray(int size) {
            return new Hotel[size];
        }
    };
}
