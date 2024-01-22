// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами,
// их необходимо считать, как одного человека с разными телефонами.
// Вывод должен быть отсортирован по убыванию числа телефонов.

package ExamTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.addphone("Alex", 867954234);
        myPhoneBook.addphone("Pete", 345567345);
        myPhoneBook.addphone("Pete", 123456789);
        myPhoneBook.addphone("Pete", 234654367);
        myPhoneBook.addphone("Maria", 98713675);
        myPhoneBook.addphone("Maria", 32432433);
        myPhoneBook.printbook();
        myPhoneBook.removeName("Maria");
    }

    public void addphone(String name, int phoneNum) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(0, phoneNum);
        if (phoneBook.containsKey(name)) {
            numbers.addAll(0, phoneBook.get(name));
            phoneBook.put(name, numbers);
        } else {
            phoneBook.put(name, numbers);
        }
    }

    public void removeName(String name) {
        phoneBook.remove(name);
    }

    public ArrayList<Integer> find(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        } else {
            return new ArrayList<Integer>();
        }
    }

    public void printbook() {
        HashMap<String, ArrayList<Integer>> thing = new HashMap<>();
        thing.putAll(phoneBook);
        int n = thing.size();
        Map.Entry<String, ArrayList<Integer>> maxEntry = null;
        for (int i = 0; i < n; i++) {
            for (Map.Entry<String, ArrayList<Integer>> entry : thing.entrySet()) {
                if (maxEntry == null
                        || Integer.valueOf(entry.getValue().size()).compareTo(maxEntry.getValue().size()) > 0) {
                    maxEntry = entry;
                }
            }
            System.out.println("Имя = "+maxEntry.getKey()+": Номера телефонов = "+maxEntry.getValue());
            thing.remove(maxEntry.getKey());
            maxEntry = null;
        }
    }
}
