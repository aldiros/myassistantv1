package com.example.aldiros.myassistant;

/**
 * Created by aldiros on 25/04/2018.
 */

public class babysitterUser {
    public String alamat, gaji, nama;

    public babysitterUser() {
    }

    public babysitterUser(String alamat, String gaji, String nama) {
        this.alamat = alamat;
        this.gaji = gaji;
//        this.image = image;
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}



