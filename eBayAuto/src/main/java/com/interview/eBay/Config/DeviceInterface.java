package com.interview.eBay.Config;

import java.io.IOException;
import com.interview.eBay.pages.LoginPage;
import com.interview.eBay.pages.WelcomePage;

public interface DeviceInterface {

    public void waitForHomePage(WelcomePage welcomePage);
    public void login(LoginPage loginPage, String username, String password) throws IOException, InterruptedException;


}
