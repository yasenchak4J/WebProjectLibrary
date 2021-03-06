package by.yasenchak.library_epam.concrete_controller;

public enum EnumPages {
    ERROR_PAGE("/pages/Error.jsp"),
    AUTH_FAILS("/pages/AuthFails.jsp"),
    USER_AUTH("/pages/UserAuth.jsp"),
    MAIN_PAGE("/index.jsp"),
    EDIT_PAGE("/WEB-INF/EditBook.jsp"),
    ADMIN_PAGE("/WEB-INF/AdminPage.jsp"),
    USER_PAGE("/WEB-INF/UserPage.jsp"),
    SUBS_PAGE("/WEB-INF/Subscription.jsp");

    private String code;
    EnumPages(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
