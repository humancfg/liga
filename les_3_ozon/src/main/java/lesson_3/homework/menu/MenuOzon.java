package lesson_3.homework.menu;

import lesson_3.homework.Element;
import lesson_3.homework.utils.Collections;
import lesson_3.homework.utils.Souts;

import java.util.Map;

import static lesson_3.homework.utils.constants.ConstantMenu.*;

public class MenuOzon implements Element {
    private String searchField;
    private String searchButton;
    private String everywhereButton;
    private Map<String, String> commands;

    public MenuOzon() {
        this.searchField = SEARCH_FIELD;
        this.searchButton = SEARCH_BUTTON;
        this.everywhereButton = EVERY_BUTTON;
        this.commands = Map.of(
                "field", getSearchField(),
                "search",getSearchButton(),
                "every", getEverywhereButton()
        );
    }

    public String getSearchField() {
        return searchField;
    }

    public String getSearchButton() {
        return searchButton;
    }

    public String getEverywhereButton() {
        return everywhereButton;
    }

    public Map<String, String> getCommands() {
        return commands;
    }

    @Override
    public String getType() {
        System.out.println("Please enter 'field', 'search' or 'every' to get type");
        return Souts.getType(Collections.findIn(getCommands()));
    }

    @Override
    public String click() {
        System.out.println("Please enter name to click ('field', 'search' or 'every')");
        return Souts.click(Collections.findIn(getCommands()));
    }
}
