package it.m_chele.hotels.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// Generato con "com.robohorse.robopojogenerator"
public class HotelsItem implements Parcelable {

    @SerializedName("images")
    private List<String> images;

    @SerializedName("checkIn")
    private CheckIn checkIn;

    @SerializedName("contact")
    private Contact contact;

    @SerializedName("name")
    private String name;

    @SerializedName("location")
    private Location location;

    @SerializedName("id")
    private int id;

    @SerializedName("stars")
    private int stars;

    @SerializedName("checkOut")
    private CheckOut checkOut;

    @SerializedName("userRating")
    private double userRating;

    protected HotelsItem(Parcel in) {
        images = in.createStringArrayList();
        checkIn = in.readParcelable(CheckIn.class.getClassLoader());
        contact = in.readParcelable(Contact.class.getClassLoader());
        name = in.readString();
        location = in.readParcelable(Location.class.getClassLoader());
        id = in.readInt();
        stars = in.readInt();
        checkOut = in.readParcelable(CheckOut.class.getClassLoader());
        userRating = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(images);
        dest.writeParcelable(checkIn, flags);
        dest.writeParcelable(contact, flags);
        dest.writeString(name);
        dest.writeParcelable(location, flags);
        dest.writeInt(id);
        dest.writeInt(stars);
        dest.writeParcelable(checkOut, flags);
        dest.writeDouble(userRating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HotelsItem> CREATOR = new Creator<HotelsItem>() {
        @Override
        public HotelsItem createFromParcel(Parcel in) {
            return new HotelsItem(in);
        }

        @Override
        public HotelsItem[] newArray(int size) {
            return new HotelsItem[size];
        }
    };

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getImages() {
        return images;
    }

    public void setCheckIn(CheckIn checkIn) {
        this.checkIn = checkIn;
    }

    public CheckIn getCheckIn() {
        return checkIn;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    public void setCheckOut(CheckOut checkOut) {
        this.checkOut = checkOut;
    }

    public CheckOut getCheckOut() {
        return checkOut;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    public double getUserRating() {
        return userRating;
    }

    @Override
    public String toString() {
        return
                "HotelsItem{" +
                        "images = '" + images + '\'' +
                        ",checkIn = '" + checkIn + '\'' +
                        ",contact = '" + contact + '\'' +
                        ",name = '" + name + '\'' +
                        ",location = '" + location + '\'' +
                        ",id = '" + id + '\'' +
                        ",stars = '" + stars + '\'' +
                        ",checkOut = '" + checkOut + '\'' +
                        ",userRating = '" + userRating + '\'' +
                        "}";
    }
}