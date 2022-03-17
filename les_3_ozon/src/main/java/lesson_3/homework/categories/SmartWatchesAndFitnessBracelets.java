package lesson_3.homework.categories;

import lesson_3.homework.Category;
import lesson_3.homework.utils.Souts;

import static lesson_3.homework.utils.constants.ConstantCategories.*;
import static lesson_3.homework.utils.constants.ConstantCategories.TYPE_LINK_IMAGE;

public class SmartWatchesAndFitnessBracelets extends Category {
    private String categoryName;

    public SmartWatchesAndFitnessBracelets() {
        super(ICON_SMARTWATCHES_AND_FITBRACE, NAME_SMARTWATCHES_AND_FITBRACE);
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
    public String click() {
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

