package com.mycompany.asm2.buiquochung;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Room {
    private String roomNumber;
    private Date checkInDate;
    private Date checkOutDate;
    private String guestName;
    private String guestPhoneNumber;
    private TypeRoom roomType;
    private double roomPrice;
    private double totalPrice;


    // Thêm biến instance để lưu giá trị mặc định
    private static double defaultLuxuryPrice = 200.0;
    private static double defaultNormalPrice = 100.0;

    public enum TypeRoom {
        Luxury,
        Normal
    }

    public Room(String roomNumber, Date checkInDate, Date checkOutDate, String guestName, String guestPhoneNumber, TypeRoom roomType) {
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.guestName = guestName;
        this.guestPhoneNumber = guestPhoneNumber;
        this.roomType = roomType;
        this.roomPrice = calculateRoomPrice(checkInDate, checkOutDate, roomType);
    }

    public double calculateRoomPrice(Date checkInDate, Date checkOutDate, TypeRoom roomType) {
        long diffInMillies = checkOutDate.getTime() - checkInDate.getTime();
        long diffInDays = diffInMillies / (24 * 60 * 60 * 1000);

        // Sử dụng giá trị mặc định tương ứng với loại phòng
        double basePrice = (roomType == TypeRoom.Luxury) ? defaultLuxuryPrice : defaultNormalPrice;
        return diffInDays * basePrice;
    }

    // Các phương thức getter và setter

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public double calculateTotalPrice() {
        // Replace this with your actual calculation logic
        double basePrice = (roomType == TypeRoom.Luxury) ? 200.0 : 100.0;
        long duration = checkOutDate.getTime() - checkInDate.getTime();
        int numberOfNights = (int) (duration / (24 * 60 * 60 * 1000));
        return basePrice * numberOfNights;
    }
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestPhoneNumber() {
        return guestPhoneNumber;
    }

    public void setGuestPhoneNumber(String guestPhoneNumber) {
        this.guestPhoneNumber = guestPhoneNumber;
    }

    public TypeRoom getRoomType() {
        return roomType;
    }

    public void setRoomType(TypeRoom roomType) {
        this.roomType = roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public static double getDefaultLuxuryPrice() {
        return defaultLuxuryPrice;
    }

    public static void setDefaultLuxuryPrice(double defaultLuxuryPrice) {
        Room.defaultLuxuryPrice = defaultLuxuryPrice;
    }

    public static double getDefaultNormalPrice() {
        return defaultNormalPrice;
    }

    public static void setDefaultNormalPrice(double defaultNormalPrice) {
        Room.defaultNormalPrice = defaultNormalPrice;
    }
    // Add this method to your Room class
    public String getFormattedCheckInDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(checkInDate);
    }

    // Add this method to your Room class
    public String getFormattedCheckOutDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(checkOutDate);
    }

}

class LuxuryRoom extends Room {

    public LuxuryRoom(String roomNumber, Date checkInDate, Date checkOutDate, String guestName, String guestPhoneNumber) {
        super(roomNumber, checkInDate, checkOutDate, guestName, guestPhoneNumber, TypeRoom.Luxury);
    }
}

class NormalRoom extends Room {

    public NormalRoom(String roomNumber, Date checkInDate, Date checkOutDate, String guestName, String guestPhoneNumber) {
        super(roomNumber, checkInDate, checkOutDate, guestName, guestPhoneNumber, TypeRoom.Normal);
    }
}
