package org.seleniumLearning.pages.helpers;

public class HotelsDataAccessObject {
    public String hotelName;
    public String hotelAddress;
    public String hotelRating;
    public String hotelPrice;


    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public void setHotelPrice(String hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public void setHotelRating(String hotelRating) {
        this.hotelRating = hotelRating;
    }

    public String getHotelRating() {
        return hotelRating;
    }

    public String getHotelPrice() {
        return hotelPrice;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    @Override
    public String toString() {
        return "HotelsDataAccessObject{" +
                "hotelAddress='" + hotelAddress + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", hotelRating='" + hotelRating + '\'' +
                ", hotelPrice='" + hotelPrice + '\'' +
                '}';
    }


}
