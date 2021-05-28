package ru.training.at.hw7.pageobjects._void;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import ru.training.at.hw7.pageobjects._void.components.LogArea;
import ru.training.at.hw7.pageobjects._void.components.ResultArea;
import ru.training.at.hw7.pageobjects._void.forms.MetalsAndColorsForm;

@Title("Metal and Colors")
public class MetalsAndColorsPage extends BasePage {

    public MetalsAndColorsForm metalsAndColorsForm;
    public LogArea logArea;
    public ResultArea resultArea;
}
