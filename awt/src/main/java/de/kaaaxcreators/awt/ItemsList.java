package de.kaaaxcreators.awt;

/**
 * Emulate external data source, like a database.
 */
public class ItemsList {
    public ItemsList() {
        return;
    }

    ListItem[] getList() {
        ListItem[] items = {
            new ListItem("Banane", "Leckere gelbe Banane", 2),
            new ListItem("Coca Cola", "Erfrischendes Erfrischungsgetränk", 3),
            new ListItem("Schokolade", "So süüß", 1),
        };
        return items;
    }
    class ListItem {
        String name;
        String description;
        Number price;

        public ListItem(String name, String description, Number price) {
            this.name = name;
            this.description = description;
            this.price = price;
        }
    }
}
