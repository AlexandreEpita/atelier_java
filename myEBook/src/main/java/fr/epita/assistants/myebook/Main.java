package fr.epita.assistants.myebook;

import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class Main {
    public static void main(String[] args) {

        EBook e = new EBook("fdsf");
        System.out.println(e.pages.size());
        EBook n = new EBook("name");
        n.writeCurrentPage("fjdhf");

        n.deletePage();

        n.addPage();
        n.openToPage(1);
        n.writeCurrentPage("dks");

        System.out.println("count" + n.getPageCount());

        Book b = n.print();
        b.openToPage(1);

        System.out.println(b.current_page);
        System.out.println(b.readCurrentPage());

        EBook e1 = b.scan();
        EBook e2 = b.scan();

        System.out.println("==============================");

        System.out.println(e1.pages.get(0));
        System.out.println(e2.pages.get(0));
        e1.writeCurrentPage("lol");

        System.out.println(e1.pages.get(0));
        System.out.println(e2.pages.get(0));

    }
}
