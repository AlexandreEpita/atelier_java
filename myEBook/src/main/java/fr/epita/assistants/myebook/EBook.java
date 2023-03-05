package fr.epita.assistants.myebook;

import java.util.ArrayList;
import java.util.List;

public class EBook implements Editable, Paginated{
    public List<String> pages;
    public String name;
    public int current_page;

    // Instantiate an ebook with a specific name.
    public EBook(String name)
    {
        this.name = name;
        pages = new ArrayList<>();
        pages.add("");
        this.current_page = 0;
    }

    public EBook(List<String> pages, String name, int current_page) {
        this.pages = pages;
        this.name = name;
        this.current_page = current_page;
    }

    // Get the name of the book.
    public String getName()
    {
        return this.name;
    }

    // Create a book from the EBook.
    // The instantiated book is a version of the ebook, and can no longer be modified
    public Book print()
    {
        Book res = new Book(this.name, new ArrayList<>(this.pages));
        return res;
    }

    @Override
    public void writeCurrentPage(String pageText){

        if (this.pages.size() == 0)
            this.pages.add(new String());
        this.pages.remove(current_page);
        this.pages.add(current_page, pageText);
    }

    @Override
    public void addPage() {
        if (this.pages == null)
            return;
        this.pages.add(current_page + 1, "");
    }

    @Override
    public void deletePage() {
        if (current_page < 0 || current_page >= pages.size())
            return;;

        if (this.pages == null)
        {
            this.pages = new ArrayList<>();
        }
        if (this.pages.size() == 0)
        {
            this.addPage();
        }

        this.pages.remove(current_page);
        if (this.pages.size() == 0) {
            this.pages.add("");
        }
    }
    @Override
    public void openToPage(int page) {
        if (this.pages == null || page < 0 || page >= pages.size())
            return;
        current_page = page;
    }

    @Override
    public int getCurrentPage() {
        if (pages == null || current_page < 0 || current_page >= pages.size())
            return - 1;
        return current_page;
    }

    @Override
    public int getPageCount() {
        if (this.pages == null)
            return -1;
        return pages.size();
    }
}