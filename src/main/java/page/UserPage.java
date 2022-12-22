package page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiters.Waiters;

@Log4j2
public class UserPage extends BasePage {

    @FindBy(xpath = "//div[@class='board-tile mod-add']//span[contains(text(),'Create new board')]")
    private WebElement createNewBoardBtn;
    @FindBy(xpath = "//input[@data-testid='create-board-title-input']")
    private WebElement fieldTitleBoard;
    @FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
    private WebElement confirmCreateBoardBtn;
    @FindBy(xpath = "//textarea[contains(@class, 'list-card-composer-textarea')]")
    private WebElement fieldTitleCard;
    @FindBy(xpath = "//span[contains(@class, 'list-card-title')]")
    private WebElement labelCardTitle;
    @FindBy(xpath = "//input[@value='Add card']")
    private WebElement addCardBtn;
    @FindBy(xpath = "//div[@class ='list-card-details js-card-details']")
    //находит 1 элт только с полным название класса
    private WebElement cardDetailsBtn;
    @FindBy(xpath = "//div[@class='description-edit edit']//textarea[@placeholder='Add a more detailed description…']")
    private WebElement fieldCardDescription;
    @FindBy(xpath = "//div[@class='description-edit edit']//input[@value = 'Save']")
    private WebElement saveDescriptionBtn;
    @FindBy(xpath = "//a[contains(@class,'dialog-close-button')]")
    private WebElement closeCardBtn;
    @FindBy(xpath = "//a[contains(@aria-label,'currently active')]")
    private WebElement labelActiveBoard; // get Text
    @FindBy(xpath = "//span[contains(@class,'list-card-title')]")
    private WebElement existentCard;
    @FindBy(xpath = "//textarea[@aria-label='Write a comment']")
    private WebElement fieldCommentCard;
    @FindBy(xpath = "//div[@class='comment-controls u-clearfix']//input[@value = 'Save']")
    private WebElement saveCommentBtn;
    @FindBy(xpath = "//div[contains(@class,'js-list-actions')]//div[@class = 'current-comment js-friendly-links js-open-card']//p")
    private WebElement textActualComment;
    @FindBy(xpath = "//a[contains(@aria-label,'currently active')]") // элнт с названием активной доски
    private WebElement activeBoardBtn;
    @FindBy(xpath = "//button[@aria-label='Board actions menu']//span[@aria-label='OverflowMenuHorizontalIcon']")
    private WebElement deleteMenuBtn;
    @FindBy(xpath = "//button[@title='Close board']")
    private WebElement closeBoardBtn;
    @FindBy(xpath = "//button[@title='Close']")
    private WebElement confirmCloseBtn;
    @FindBy(xpath = "//button[@data-testid='close-board-delete-board-button']")
    private WebElement deleteBoardBtn;
    @FindBy(xpath = "//button[@data-testid='close-board-delete-board-confirm-button']")
    private WebElement confirmDeleteBtn;

    public UserPage() {
        super();
    }

    public UserPage createNewBoard() {
        Waiters.waitForElementToBeClickable(createNewBoardBtn);
        createNewBoardBtn.click();
        log.info("Click button create new board");
        return this;
    }

    public UserPage addBoardTitle(String titleBoard) {
        Waiters.waitForVisibilityOfElement(fieldTitleBoard);
        fieldTitleBoard.sendKeys(titleBoard);
        log.info(String.format("Input title Board - %s",titleBoard));
        return this;
    }

    public UserPage confirmCreateBoard() {
        confirmCreateBoardBtn.click();
        log.info("Click button for confirm create board");
        return this;
    }

    public UserPage addCardTitle(String titleCard) {
        Waiters.waitForVisibilityOfElement(fieldTitleCard);
        fieldTitleCard.sendKeys(titleCard);
        log.info(String.format("Input title card in created board - %s" ,titleCard));
        return this;
    }

    public UserPage addCard() {
        addCardBtn.click();
        log.info("Click button for add card");
        return this;
    }

    public UserPage changeCard() {
        Waiters.waitForElementToBeClickable(cardDetailsBtn);
        cardDetailsBtn.click();
        log.info("Click button for add details in exist card");
        return this;
    }

    public UserPage addCardDescription(String description) {
        Waiters.waitForVisibilityOfElement(fieldCardDescription);
        fieldCardDescription.sendKeys(description);
        log.info(String.format("Input details in exist card - %s",fieldCardDescription));
        return this;
    }

    public UserPage saveDescriptionCard() {
        saveDescriptionBtn.click();
        log.info("Click button for save description card");
        return this;
    }

    public UserPage closeCard() {
        closeCardBtn.click();
        log.info("Click button for close card");
        return this;
    }

    public String getActualTitleBoard() {
        Waiters.waitForVisibilityOfElement(labelActiveBoard);
        String titleBoard = labelActiveBoard.getText();
        log.info(String.format("get Title Board - %s",titleBoard));
        return titleBoard;
    }

    public String getActualTitleCard() {
        String titleCard = labelCardTitle.getText();
        log.info(String.format("get Title Card - %s", titleCard));
        return titleCard;
    }

    public UserPage clickExistentCard() {
        Waiters.waitForVisibilityOfElement(existentCard);
        existentCard.click();
        log.info("Click field existent card");
        return this;
    }

    public UserPage addCommentOnCard(String comment) {
        Waiters.waitForVisibilityOfElement(fieldCommentCard);
        fieldCommentCard.sendKeys(comment);
        log.info(String.format("Input comment in existent card - %s",fieldCommentCard));
        return this;
    }

    public UserPage clickSaveComment() {
        saveCommentBtn.click();
        log.info("Click button for save comment on card");
        return this;
    }

    public String getComment() {
        Waiters.waitForLoad();
        String comment = textActualComment.getText();
        log.info(String.format("Get Comment - %s",comment));
        return comment;
    }

    public UserPage clickOnActiveBoard() {
        Waiters.waitForElementToBeClickable(activeBoardBtn);
        activeBoardBtn.click();
        log.info("Click on name of active button");
        return this;
    }

    public boolean isBoardExist() {
        try {
            Waiters.waitForElementToBeClickable(activeBoardBtn);
            return activeBoardBtn.isDisplayed();
        } catch (TimeoutException e) {
            e.printStackTrace();
            log.info("All boards are delete");
            return false;
        }
    }

    public UserPage clickMenuForDelete() {
        Waiters.waitForElementToBeClickable(deleteMenuBtn);
        deleteMenuBtn.click();
        log.info("Click button for deleting menu");
        return this;
    }

    public UserPage clickCloseBoard() {
        closeBoardBtn.click();
        log.info("Click button close board");
        return this;
    }

    public UserPage clickConfirmClose() {
        confirmCloseBtn.click();
        log.info("Click button confirm close board");
        return this;
    }

    public UserPage clickDeleteBoard() {
        Waiters.waitForElementToBeClickable(deleteBoardBtn);
        deleteBoardBtn.click();
        log.info("Click button delete board");
        return this;
    }

    public UserPage clickConfirmDelete() {
        confirmDeleteBtn.click();
        log.info("Click button confirm delete board");
        return this;
    }
}


