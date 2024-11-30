// package hust.soict.dsai.test.disc;
// // package aims;

// import hust.soict.dsai.aims.disc.DigitalVideoDisc;

// public class TestPassingParameter {
// public static void main(String[] args) {
// DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
// DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

// System.out.println("Before Swap:");
// System.out.println("jungleDVD title: " + jungleDVD.getTitle());
// System.out.println("cinderella title: " + cinderellaDVD.getTitle());

// swap(jungleDVD, cinderellaDVD);

// System.out.println("\nAfter Swap: ");
// System.out.println("jungleDVD: " + jungleDVD.getTitle());
// System.out.println("cinderellaDVD: " + cinderellaDVD.getTitle());

// System.out.println("Before changeTitle:");
// System.out.println("jungleDVD title: " + jungleDVD.getTitle());
// changeTitle(jungleDVD, cinderellaDVD.getTitle());
// System.out.println("\nAfter changeTitle:");
// System.out.println("cinderella title: " + cinderellaDVD.getTitle());
// System.out.println("jungleDVD title: " + jungleDVD.getTitle());

// // // Hiển thị thông tin ban đầu
// // System.out.println("Before swapTitles:");
// // System.out.println("jungleDVD title: " + jungleDVD.getTitle());
// // System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());

// // // // Gọi phương thức hoán đổi tiêu đề
// // swap(jungleDVD, cinderellaDVD);

// // // Hiển thị thông tin sau khi hoán đổi
// // System.out.println("\nAfter swapTitles:");
// // System.out.println("jungleDVD title: " + jungleDVD.getTitle());
// // System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());

// // }

// // public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
// // String tmp = o1.getTitle();
// // o1.setTitle(o2.getTitle());
// // o2.setTitle(tmp);
// }

// public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
// DigitalVideoDisc tmp = o1;
// o1 = o2;
// o2 = tmp;
// }

// public static void changeTitle(DigitalVideoDisc dvd, String title) {
// dvd.setTitle(title);
// }
// }
