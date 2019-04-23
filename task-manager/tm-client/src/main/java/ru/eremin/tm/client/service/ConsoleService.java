package ru.eremin.tm.client.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.eremin.tm.client.util.DateUtils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Scanner;

/**
 * @autor av.eremin on 11.04.2019.
 */

public class ConsoleService {

    @NotNull
    private final Scanner scanner;

    public ConsoleService(@NotNull final Scanner scanner) {
        this.scanner = scanner;
    }

    public String getNextLine() {
        return scanner.nextLine();
    }

    @NotNull
    public String getStringFieldFromConsole(@Nullable final String field) {
        if (field == null || field.isEmpty()) throw new NullPointerException("wrong method attribute");
        String name;
        boolean flag;
        do {
            System.out.println("*** Please write " + field + " ***");
            flag = true;
            name = scanner.nextLine();
            if (name == null || name.isEmpty()) {
                System.out.println("*** " + field + " can't be empty ***");
                flag = false;
            }
        } while (!flag);
        return name;
    }

    @Nullable
    public XMLGregorianCalendar getDateFieldFromConsole(@Nullable final String field) {
        if (field == null || field.isEmpty()) throw new NullPointerException("wrong method attribute");
        String deadline;
        boolean flag;
        do {
            flag = true;
            System.out.println("*** Please write " + field + " in format dd.mm.yyyy ***");
            deadline = scanner.nextLine();
            if (!deadline.matches(DateUtils.DATE_REGEX)) {
                System.out.println("*** Wrong format ***");
                flag = false;
            }
        } while (!flag);
        return getDateFromString(deadline);
    }

    @Nullable
    private XMLGregorianCalendar getDateFromString(@NotNull final String dateString) {
        XMLGregorianCalendar date = null;
        try {
            date = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateString);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return date;
    }

}
