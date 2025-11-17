import java.util.Scanner;

class Entry {
    int key; String value;
    Entry(int k, String v) { key = k; value = v; }
}

public class DictionaryHashing {
    static int SIZE = 11;
    static Entry[] table;

    static void init(int size) {
        SIZE = size;
        table = new Entry[SIZE];
    }

    static int hash(int k) { return Math.abs(k) % SIZE; }

    static void insert(int k, String v) {
        int i = hash(k), start = i;
        do {
            if (table[i] == null || table[i].key == k) { table[i] = new Entry(k, v); return; }
            i = (i + 1) % SIZE;
        } while (i != start);
        System.out.println("Table full");
    }

    static void search(int k) {
        int i = hash(k), start = i;
        do {
            if (table[i] == null) { System.out.println("Not Found"); return; }
            if (table[i].key == k) { System.out.println("Found: " + table[i].value); return; }
            i = (i + 1) % SIZE;
        } while (i != start);
        System.out.println("Not Found");
    }

    static void delete(int k) {
        int i = hash(k), start = i;
        do {
            if (table[i] == null) { System.out.println("Not Found"); return; }
            if (table[i].key == k) { table[i] = null; System.out.println("Deleted"); rehashFrom((i + 1) % SIZE); return; }
            i = (i + 1) % SIZE;
        } while (i != start);
        System.out.println("Not Found");
    }

    // rehash cluster after deletion to keep search correct
    static void rehashFrom(int idx) {
        int i = idx;
        while (table[i] != null) {
            Entry e = table[i];
            table[i] = null;
            insert(e.key, e.value);
            i = (i + 1) % SIZE;
        }
    }

    static void display() {
        for (int i = 0; i < SIZE; i++)
            System.out.println(i + " -> " + (table[i] == null ? "empty" : table[i].key + ":" + table[i].value));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter table size (prime recommended, e.g., 11): ");
        init(sc.nextInt());
        while (true) {
            System.out.println("\n1.Insert 2.Search 3.Delete 4.Display 5.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter key and value: ");
                    insert(sc.nextInt(), sc.next());
                    break;
                case 2:
                    System.out.print("Enter key: "); search(sc.nextInt()); break;
                case 3:
                    System.out.print("Enter key: "); delete(sc.nextInt()); break;
                case 4: display(); break;
                case 5: System.out.println("Exit"); sc.close(); System.exit(0); break;
                default: System.out.println("Invalid choice");
            }
        }
    }
}
