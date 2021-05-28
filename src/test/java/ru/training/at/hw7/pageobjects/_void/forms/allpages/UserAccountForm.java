package ru.training.at.hw7.pageobjects._void.forms.allpages;


import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import ru.training.at.hw7.entities.User;

public class UserAccountForm extends Form<User> {
    @Css("#name")
    private TextField name;

    @Css("#password")
    private TextField password;

    @Css(".fa-sign-in")
    private Button enter;

}
