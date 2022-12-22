
import lombok.extern.log4j.Log4j2;
import model.User;
import org.testng.annotations.AfterMethod;
import steps.LoginStep;
import steps.UserPageStep;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Log4j2
public class BoardsTest extends BaseTest {
    private LoginStep loginStep;
    private UserPageStep userPageStep;
    private final String titleBoard = "Test One";
    private final String titleCard = "Daily sync";
    private final String descriptionCard = "Buy products";
    private final String comment = "It needs to be done ASAP!";

    @BeforeMethod
    public void logIn() {
        loginStep = new LoginStep();

        loginStep.logIn(new User());
    }

    @Test
    public void testCreateBoard() {
        log.info("Test create board");
        userPageStep = new UserPageStep();
        userPageStep.createBoard(titleBoard);

        Assert.assertEquals(userPageStep.getTitleBoard(), titleBoard,"Actual and expected title board are not the same");

    }

    @Test
    public void testBoardWithCard() {
        log.info("Test create board with card");
        userPageStep = new UserPageStep();

        userPageStep.createBoard(titleBoard);
        userPageStep.createCard(titleCard, descriptionCard);
        Assert.assertEquals(userPageStep.getTitleCard(), titleCard,"Actual and expected title card are not the same");

    }

    @Test
    public void refactorCardOnExistentBoard() {
        log.info("Test refactor card on exist board");
        userPageStep = new UserPageStep();
        userPageStep.createBoard(titleBoard);
        userPageStep.createCard(titleCard, descriptionCard);

        userPageStep.refactorCardOnBoard(comment);
        Assert.assertEquals(userPageStep.getCommentFromCard(), comment,"Actual and expected description card are not the same"); // getCommentFromCard() иногда выбрасывает stale element , т.к. страница не успевает загрузится, ожидалка есть
        //закрыть карточку, иначе доска не удалится @AfterMethod
        userPageStep.closeCardAfterRefactor();

    }

    @Test
    public void testDeleteBoard() {
        log.info("Test delete board");
        userPageStep = new UserPageStep();
        userPageStep.createBoard(titleBoard);
        userPageStep.deleteBoard();

        // ASSERT!!!!
    }

    @AfterMethod
    public void deleteBoard() {
        new UserPageStep().deleteBoard();
    }
}
