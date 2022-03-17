package lesson_3.homework;

import lesson_3.homework.categories.*;
import lesson_3.homework.menu.MenuOzon;
import lesson_3.homework.menu.horizontal.HorizontalMenuCategories;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Category> categories = Arrays.asList(
                new ComputersAndAccessories(),
                new GamesAndConsoles(),
                new HeadphonesAndAudioEquipment(),
                new Laptops(),
                new OfficeEquipment(),
                new PhotoAndVideoCameras(),
                new SmartHomeAndSecurity(),
                new Smartphones(),
                new SmartWatchesAndFitnessBracelets(),
                new Tablets(),
                new TV(),
                new HorizontalMenuCategories()
        );

        categories.forEach(x->actions(x));
        actions(new MenuOzon());


    }

    public static void actions(Category cat) {
            System.out.println("====================================");
            System.out.println("1:" + cat);
            System.out.println("2:" + cat.open());
            System.out.println("3:" + cat.getName());
            System.out.println("4:" + cat.getType());
            System.out.println("5:" + cat.getIconDescription());
            System.out.println("6:" + cat.click());
            System.out.println("7:" + cat.hover());
    }

    public static void actions(Element element) {
        System.out.println(element.getType());
        System.out.println(element.click());
    }
}
