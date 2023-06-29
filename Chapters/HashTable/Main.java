package HashTable;

public class Main {
    public static void main(String[] args) {
        Object existing, nonExisting;
        System.out.println("Initializing hash table with default capacity");
        HashTable defaultTable = new HashTable();
        System.out.print("The table is: ");
        defaultTable.printTable();
        System.out.println();
        /* ----------------------------------------------------------------------------------------- 
         * Inserting 2 pairs
         * ----------------------------------------------------------------------------------------- */
        System.out.println("Test: inserting two pairs");
        defaultTable.put("Gianni", 1);
        defaultTable.put("Giorgio", 1);
        System.out.println("Table size: " + defaultTable.size());
        System.out.print("The table is: ");
        defaultTable.printTable();
        System.out.println();
        /* ----------------------------------------------------------------------------------------- 
         * Inserting 4 pairs, one has an already existing key
         * ----------------------------------------------------------------------------------------- */
        System.out.println("Test: inserting 4 pairs with one having an already present key");
        defaultTable.put("Marianna", 6);
        defaultTable.put("Stefania", 9);
        defaultTable.put("Massimo", 3);
        defaultTable.put("Gianni", 4);
        System.out.println("Table size: " + defaultTable.size());
        System.out.print("The table is: ");
        defaultTable.printTable();
        System.out.println();
        /* ----------------------------------------------------------------------------------------- 
         * Removing pairs with existing and non-existing keys
         * ----------------------------------------------------------------------------------------- */
        System.out.println("Test: remove a pair with an existing key");
        existing = defaultTable.remove("Giorgio");
        System.out.println("Value of removed pair: " + existing);
        System.out.println("Test: remove a pair with a non-existing key");
        nonExisting = defaultTable.remove("Gino");
        System.out.println("Value of removed pair: " + nonExisting);
        System.out.println("Table size: " + defaultTable.size());
        System.out.print("The table is: ");
        defaultTable.printTable();
        System.out.println();
        /* ----------------------------------------------------------------------------------------- 
         * Getting values from existing and non-existing keys
         * ----------------------------------------------------------------------------------------- */
        System.out.println("Test: get the value associated to a non-existing key");
        nonExisting = defaultTable.get("Gino");
        System.out.println("The value is: " + nonExisting);
        System.out.println("Test: get the value associated to an existing key");
        existing = defaultTable.get("Marianna");
        System.out.println("The value is: " + existing);
        System.out.println();
        /* ----------------------------------------------------------------------------------------- 
         * Calculating Hash value of a pair
         * ----------------------------------------------------------------------------------------- */
        System.out.println("Test: get the hash value of a pair");
        int hashValue = defaultTable.hashValue("Gianni");
        System.out.println("The pair with the given key has hash value: " + hashValue);

    }
}
