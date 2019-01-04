package by.yasenchak.library_epam.utils;

public enum Page {
    ERROR_PAGE("/pages/Error.jsp"),
    AUTH_FAILS("/pages/AuthFails.jsp"),
    USER_AUTH("/pages/UserAuth.jsp"),
    MAIN_PAGE("/index.jsp"),
    EDIT_PAGE("/WEB-INF/EditBook.jsp"),
    ADMIN_PAGE("/WEB-INF/AdminPage.jsp"),
    USER_PAGE("/WEB-INF/UserPage.jsp"),
    USER_RENEW_SUBS("/WEB-INF/UserRenewSubs.jsp"),
    AGREE_RENEW("/WEB-INF/AgreeRenew.jsp"),
    ADD_NEW_BOOK("/WEB-INF/AdminAddNewBook.jsp"),
    ALL_AUTHORS("/WEB-INF/AdminAllAuthors.jsp"),
    ALL_GENRES("/WEB-INF/AdminAllGenres.jsp"),
    All_USERS("/WEB-INF/AdminAllUsers.jsp"),
    LIBRARIAN_PAGE("/WEB-INF/LibrarianPage.jsp"),
    LIBRARIAN_BOOK("/WEB-INF/LibrarianBook.jsp"),
    RENEW_SUBS("/WEB-INF/LibrarianRenewSubs.jsp"),
    CURRENT_SUBS("/WEB-INF/LibrarianCurrentSubs.jsp"),
    CONCRETE_SUBS("/WEB-INF/LibrarianConcreteSubs.jsp"),
    SUBS_PAGE("/WEB-INF/Subscription.jsp");

    private String code;
    Page(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
