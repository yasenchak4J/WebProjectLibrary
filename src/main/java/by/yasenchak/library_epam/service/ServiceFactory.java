package by.yasenchak.library_epam.service;

import by.yasenchak.library_epam.service.impl.BookServiceImpl;
import by.yasenchak.library_epam.service.impl.ClientServiceImpl;
import by.yasenchak.library_epam.service.impl.GenreServiceImpl;
import by.yasenchak.library_epam.service.impl.SubscriptionServiceImpl;

public final class ServiceFactory {
    private final static ServiceFactory instance = new ServiceFactory();
    private final ClientService clientService = new ClientServiceImpl();
    private final BookService bookService = new BookServiceImpl();
    private final GenreService genreService = new GenreServiceImpl();
    private final SubscriptionService subscriptionService = new SubscriptionServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public ClientService getClientService(){
        return clientService;
    }

    public BookService getBookService(){
        return bookService;
    }

    public GenreService getGenreService(){
        return genreService;
    }

    public SubscriptionService getSubscriptionService(){
        return subscriptionService;
    }
}
