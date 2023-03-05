package fr.epita.assistants.myebook;

import java.util.ArrayList;
import java.util.List;

public class Book implements Readable, Paginated{

    // Instantiate a book with a certain title and page contents.
    // Only the EBook class should be able to call the Book constructor since it
    // is the only one able to print it, hence it must not be public.
    private String name;
    protected List<String> pages;
    protected int current_page;
    Book(String name, List<String> pages)
    {
        this.name = name;
        current_page = 0;
        if (pages == null)
        {
            this.pages = new ArrayList<String>();
        }
        if (pages.size() == 0)
            pages.add("");
        this.pages = new ArrayList<>(pages);

    }

    // Get the name of the book.
    public String getName()
    {
        return name;
    }

    // Create an EBook from the book.
    public EBook scan()
    {
        EBook res = new EBook(this.pages, this.name, this.current_page);
        return res;
    }

    @Override
    public String readCurrentPage() {
        if (pages == null || pages.size() <= current_page || current_page < 0)
            return null;
        String res = pages.get(current_page);
        return res;
    }

    @Override
    public void openToPage(int page) {
        if (pages == null || page < 0 || page >= pages.size())
            return;
        this.current_page = page;
    }

    @Override
    public int getCurrentPage() {
        if (current_page < 0 || pages == null)
            return -1;
        return current_page;
    }

    @Override
    public int getPageCount() {
        if (pages == null)
            return -1;
        return pages.size();
    }
}