package it.m_chele.hotels;

import java.util.ArrayList;
import java.util.List;

class Hotel {

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
}
