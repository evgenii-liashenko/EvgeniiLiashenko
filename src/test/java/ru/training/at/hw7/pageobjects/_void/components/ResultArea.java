package ru.training.at.hw7.pageobjects._void.components;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ResultArea {
    @UI(".info-panel-section>.results>.summ-res")
    public Text summary;

    @UI(".info-panel-section>.results>.elem-res")
    public Text elements;

    @UI(".info-panel-section>.results>.col-res")
    public Text color;

    @UI(".info-panel-section>.results>.met-res")
    public Text metal;

    @UI(".info-panel-section>.results>.sal-res")
    public Text vegetables;


}
