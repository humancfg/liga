package lesson_3.homework.categories;

import lesson_3.homework.Category;
import lesson_3.homework.utils.Souts;

import static lesson_3.homework.utils.constants.ConstantCategories.*;

public class PhotoAndVideoCameras extends Category {
    private String categoryName;

    public PhotoAndVideoCameras() {
        super(ICON_PHOTO_VIDEO_CAMERAS, NAME_PHOTO_VIDEO_CAMERAS);
        this.categoryName = CATEGORY_ELECTRONICS;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String getType() {
        return TYPE_LINK_IMAGE;
    }

    @Override
    public String open() {
        return Souts.open(getName());
    }

    @Override
    public String hover() {
        return "No actions after hover";
    }

    @Override
    public String  click() {
        return Souts.click(getName());
    }

    @Override
    public String toString() {
        return "Smartphones: " +
                "\nIcon Description = " + getIconDescription() +
                "\nName = " + getName() +
                "\nCategory Name = " + categoryName;
    }
}