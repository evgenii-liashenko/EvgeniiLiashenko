package ru.training.at.hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import ru.training.at.hw7.pageobjects._void.HomePage;
import ru.training.at.hw7.pageobjects._void.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiWebsite {

    @Url("/index.html")
    public static HomePage homePage;

    @Url("metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void open(){
        homePage.open();
    }
}
