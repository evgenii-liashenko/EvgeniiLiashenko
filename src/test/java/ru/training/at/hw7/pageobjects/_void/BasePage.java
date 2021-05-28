package ru.training.at.hw7.pageobjects._void;


import com.epam.jdi.light.elements.composite.WebPage;
import ru.training.at.hw7.entities.User;
import ru.training.at.hw7.pageobjects._void.components.MenuBar;
import ru.training.at.hw7.pageobjects._void.components.SideBar;
import ru.training.at.hw7.pageobjects._void.forms.allpages.UserAccountForm;


public abstract class BasePage extends WebPage {
    public MenuBar menuBar;
    public UserAccountForm userAccountForm;
    public SideBar sideBar;


    public void authorizeUser(User user){
        menuBar.userIcon.click();
        userAccountForm.login(user);
    }
}
