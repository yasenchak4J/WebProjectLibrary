package by.yasenchak.library_epam.utils;

public enum DataBaseField {
    ID_GENRE("id_genre"),
    GENRE_NAME("genreName"),
    AUTHOR_NAME("authorName"),
    SURNAME("Surname"),
    ID_AUTHOR("id_author"),
    ID_BOOK("id_book"),
    NAME("name"),
    ISBN("isbn"),
    IMAGE("image"),
    PAGE_COUNT("pageCount"),
    PUBLISHER("publisher"),
    USER_NAME("userName"),
    PASSWORD("password"),
    ROLE("role"),
    ID_USERS("idUsers");

    private String code;

    DataBaseField(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
