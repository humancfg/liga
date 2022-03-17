package lesson_3.homework.menu.horizontal;

import lesson_3.homework.Category;
import lesson_3.homework.utils.Collections;
import lesson_3.homework.utils.Souts;

import java.util.Map;

import static lesson_3.homework.utils.constants.ConstantMenu.*;

public class HorizontalMenuCategories extends Category {
    private String homeAppliances;
    private String smartphonesAndSmartwatches;
    private String TV;
    private String LaptopsAndTablets;
    private String Computers;
    private String HeadphonesAndAudioEquip;
    private String GamesAndConsoles;
    private Map<String, String> commands;
    private String name;


    public HorizontalMenuCategories() {
        super(ICON_HORIZONTAL_CAT_MENU, HORIZONTAL_CAT_MENU);
        this.name = HORIZONTAL_CAT_MENU;
        this.homeAppliances = HOME_APPLIANCES;
        this.smartphonesAndSmartwatches = SMARTPHONES_AND_SMARTWATCHES;
        this.TV = TV_SETS;
        this.LaptopsAndTablets = LAPTOPS_AND_TABLETS;
        this.Computers = COMPUTERS;
        this.HeadphonesAndAudioEquip = HEADPHONES_AND_AUDIO_EQUIP;
        this.GamesAndConsoles = GAMES_AND_CONSOLES;
        this.commands = Map.of(
                "homeappl", getHomeAppliances(),
                "phonewatch", getSmartphonesAndSmartwatches(),
                "tv", getTV(),
                "laptab", getLaptopsAndTablets(),
                "comp", getComputers(),
                "headaudio", getHeadphonesAndAudioEquip(),
                "gamesole", getGamesAndConsoles()
        );
    }

    @Override
    public String getName() {
        return name;
    }

    public String getHomeAppliances() {
        return homeAppliances;
    }

    public String getSmartphonesAndSmartwatches() {
        return smartphonesAndSmartwatches;
    }

    public String getTV() {
        return TV;
    }

    public String getLaptopsAndTablets() {
        return LaptopsAndTablets;
    }

    public String getComputers() {
        return Computers;
    }

    public String getHeadphonesAndAudioEquip() {
        return HeadphonesAndAudioEquip;
    }

    public String getGamesAndConsoles() {
        return GamesAndConsoles;
    }

    public Map<String, String> getCommands() {
        return commands;
    }

    @Override
    public String open() {
        System.out.println("Please enter command to open " +
                "\n('homeappl', 'phonewatch', 'tv', 'laptab', 'comp', 'headaudio', 'gamesole')");
        return Souts.open(Collections.findIn(getCommands()));
    }

    @Override
    public String hover() {
        System.out.println("Please enter command to hover " +
                "\n('homeappl', 'phonewatch', 'tv', 'laptab', 'comp', 'headaudio', 'gamesole')");
        return Souts.hover(Collections.findIn(getCommands()));
    }

    @Override
    public String getType() {
        return TYPE_DROPDOWN_HOVER;
    }

    @Override
    public String click() {
        System.out.println("Please enter command to click " +
                "\n('homeappl', 'phonewatch', 'tv', 'laptab', 'comp', 'headaudio', 'gamesole')");
        return Souts.click(Collections.findIn(getCommands()));
    }
}
