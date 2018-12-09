package by.yasenchak.library_epam.logic;

public enum EnumPages {
    ERROR_PAGE("/pages/Error.jsp"),
    AUTH_FAILS("/pages/AuthFails.jsp"),
    USER_AUTH("/pages/UserAuth.jsp"),
    MAIN_PAGE("/index.jsp");

    private String code;
    EnumPages(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
