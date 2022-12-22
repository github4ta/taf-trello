package steps;

import page.UserPage;

public class UserPageStep extends UserPage {
    UserPage userPage = new UserPage();
    public void createBoard(String titleBoard){
        userPage.createNewBoard()
                .addBoardTitle(titleBoard)
                .confirmCreateBoard();
    }
    public void createCard(String titleCard,String description){
        userPage.addCardTitle(titleCard)
                .addCard()
                .changeCard()
                .addCardDescription(description)
                .saveDescriptionCard()
                .closeCard();
    }

    public void refactorCardOnBoard(String comment){
        userPage.clickExistentCard()
//                .changeCard()
                .addCommentOnCard(comment)
                .clickSaveComment()
                .closeCard();
    }

    public void closeCardAfterRefactor(){
        userPage.closeCard();
    }
    public void deleteBoard() {
//        userPage.clickExistentBoard()
        if (isBoardExist()) {
            userPage.clickOnActiveBoard()
                    .clickMenuForDelete()
                    .clickCloseBoard()
                    .clickConfirmClose()
                    .clickDeleteBoard()
                    .clickConfirmDelete();
        }
    }
    public String getTitleBoard(){
        return getActualTitleBoard();
    }
    public String getTitleCard(){
        return getActualTitleCard();
    }
    public String getCommentFromCard(){
        userPage.clickExistentCard();
        return getComment();
    }
}

