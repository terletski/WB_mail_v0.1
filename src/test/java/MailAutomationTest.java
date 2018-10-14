
import org.testng.Assert;
import org.testng.annotations.*;
import steps.Steps;

public class MailAutomationTest {

    private Steps steps;
    private final String USERNAME = "testbyeugene@mail.ru";
    private final String PASSWORD = "eugene89";
    private final String ADDRESSEE = "testbyeugene@mail.ru";
    private final String SUBJECT = "Test#1";
    private final String BODY = "The First Test#1";
    private final String DRAFTS = "черновиках";

    @Test(description = "Init browser", priority = 0)
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }
    @Test(description = "Login to MailRu", priority = 1)
    public void oneCanLoginMailRu() {
        steps.loginMailRu(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @Test(description = "Create a new mail", priority = 2)
    public void oneCanCreateNewMail() {
        steps.createNewMail(ADDRESSEE, SUBJECT, BODY);
        Assert.assertTrue(steps.isSavedInDrafts(DRAFTS));
    }

    @Test(description = "Stop Browser", priority = 3)
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
