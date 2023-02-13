package de.kaaaxcreators.awt;

import java.awt.*;

public class Items extends Panel {
    public Items() {
        setLayout(new GridLayout(3,1));

        add(new Item(new StoreItem("Banane", "Leckere gelbe Banane", 2)));
        add(new Item(new StoreItem("Coca Cola", "Erfrischendes Erfrischungsgetränk", 3)));
        add(new Item(new StoreItem("Schokolade", "So süüß", 1)));
    }
}
