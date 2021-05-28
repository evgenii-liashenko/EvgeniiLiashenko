package ru.training.at.hw7.pageobjects._void.components;


import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class MenuBar {

//    //Header items
    @UI("ul.uui-navigation>li:nth-child(4)>a[href='metals-colors.html']")
    public Button metalsAndColors;
    @UI("#user-icon")
    public Button userIcon;
    @UI("#user-name")
    public Text displayedFullName;

}
