package by.yasenchak.library_epam.service;

import by.yasenchak.library_epam.service.impl.BookServiceImpl;
import by.yasenchak.library_epam.service.impl.ClientServiceImpl;

public final class ServiceFactory {
    private final static ServiceFactory instance = new ServiceFactory();
    private final ClientService clientService = new ClientServiceImpl();
    private final BookService bookService = new BookServiceImpl();

    private ServiceFactory(){

    }
    public static ServiceFactory getInstance(){
        return instance;
    }

    public ClientService getClientService(){
        return clientService;
    }

    public BookService getBookService(){
        return bookService;
    }
}
