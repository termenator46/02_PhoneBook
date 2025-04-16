package phoneBook.utils;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import phoneBook.model.Contact;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> addNewContact() {
        ArrayList<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "1234567890", "kan@gm.com",});
        list.add(new Object[]{"Oliver", "Kan", "12345678901", "kan@gm.com", "Berlin", "goalkiper"});
        list.add(new Object[]{"Oliver", "Kan", "1234567890555", "kan@gm.com", "Berlin", "goalkiper"});

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> addNewContactFroundCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();


        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{new Contact().setName(split[0]).setLastName(split[1]).setPhone(split[2]).setEmail(split[3]).setAddress(split[4]).setDesc(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }




    @DataProvider
    public Iterator<Object[]> addNewContact2() {
        ArrayList<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Nasti", "Kevin", "kan96@gm.com", "Password@156", "Password@156"});
        list.add(new Object[]{"Olivia", "Kannong", "kan78@gm.com", "Password178", "Password@178"});
        list.add(new Object[]{"Oliver", "Kenni", "kan23@gm.com", "Password@199", "Password@199"});
        return list.iterator();
    }

    @DataProvider
        public Iterator<Object[]> RegisteruserCsv() throws IOException {
            List<Object[]> list = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(",");

                list.add(new Object[]{new Contact().setName(split[0]).setLastName(split[1]).setEmail(split[2]).setPassword(split[3]).setConfirmpassword(split[4])});
            }
            return list.iterator();
        }
}








