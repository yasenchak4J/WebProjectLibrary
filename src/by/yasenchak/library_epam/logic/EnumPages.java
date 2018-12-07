package by.yasenchak.library_epam.logic;

public enum EnumPages {
    ERROR_PAGE("/pages/Error.jsp"),
    LIBRARY("/pages/library.jsp"),
    AUTH_FAILS("/pages/AuthFails.jsp");

    private String code;
    EnumPages(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
