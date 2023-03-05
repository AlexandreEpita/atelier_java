package fr.epita.assistants.myebook;

public class EBookReader implements Readable, Updatable, Paginated{
    // Instantiate a new ebook reader with firmware 1.0

    public double firmware;
    public Book my_book;
    public EBookReader()
    {
        this.firmware = 1.0;
        my_book = null;
    }

    // Load an ebook into the reader.
    public void openEbook(EBook ebook)
    {
        if (ebook == null)
            return;
        this.my_book = ebook.print();
    }

    @Override
    public void openToPage(int page) {
        if (my_book == null)
            return;
        my_book.openToPage(page);
    }

    @Override
    public int getCurrentPage() {
        if (my_book == null)
            return -1;
        return my_book.getCurrentPage();
    }

    @Override
    public int getPageCount() {
        if (my_book == null)
            return -1;
        return my_book.getPageCount();
    }

    @Override
    public String readCurrentPage() {
        if (my_book == null)
            return null;
        return my_book.readCurrentPage();
    }

    @Override
    public double getVersion() {
        return firmware;
    }

    @Override
    public void update(double version) {
        if (version <= this.firmware)
            return;
        this.firmware = version;
    }
}
