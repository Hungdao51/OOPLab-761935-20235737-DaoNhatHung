package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle", "", 0, 0, "");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella", "", 0, 0, "");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(DigitalVideoDisc d1, DigitalVideoDisc d2) {
        String tmpTitle = d1.getTitle();
        d1.setTitle(d2.getTitle());
        d2.setTitle(tmpTitle);
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle, "", 0, 0, ""); // Dòng này không có tác dụng do pass-by-value
    }
}
