package com.phonebook.utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Maynard", "Keenan", "1234567890", "karl@gm.com", "London", "singer"});
        list.add(new Object[]{"Maynard", "Keenan", "12345678901", "karl@gm.com", "London", "singer"});
        list.add(new Object[]{"Maynard", "Keenan", "12345678901234", "karl@gm.com", "London", "singer"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewContactWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line=reader.readLine();

        while(line !=null){
            String[] split= line.split(",");
            list.add(new Object[]{new Contact()
                    .setName(split[0])
                    .setLastName(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
