package automation.client.actions;

import org.openqa.selenium.WebElement;

/**
 * Created by jien.huang on 19/10/2016.
 */
public class CloseBrowser extends Action {
    public WebElement findTestObject() {
        return null;
    }

    protected void handle(WebElement testObject) {
        BrowserInstance.getInstance().close();
    }
}
