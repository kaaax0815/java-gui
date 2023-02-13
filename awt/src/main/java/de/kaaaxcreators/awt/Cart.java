package de.kaaaxcreators.awt;

import java.awt.*;

public class Cart extends Panel {
    public Cart() {
        setLayout(new BorderLayout());

        Store.getInstance().onItemAdded((item) -> {
            System.out.println("Item Added: " + item.toString());
        });

        init();
    }
    public void init() {

        Label titleLabel = new Label("Einkaufswagen", Label.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        add(new CartItems(), BorderLayout.CENTER);

        add(new CartFooter(), BorderLayout.SOUTH);
    }
}

// TODO: https://www.tutorialspoint.com/awt/awt_gridbaglayout.htm
class CartItems extends Panel {
    Store store = Store.getInstance();
    public CartItems() {
        setLayout(new GridLayout(1,1));

        store.onItemAdded((item) -> {
            removeAll();
            init();
            revalidate();
            repaint();
        });

        init();
    }

    void init() {
        StoreItem[] items = store.getItems();

        if (items.length == 0) {
            Label emptyLabel = new Label("Keine Artikel im Einkaufswagen", Label.CENTER);
            emptyLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            add(emptyLabel);
            return;
        }

        List list = new List(items.length);
        for (StoreItem storeItem : items) {
            list.add(storeItem.getName() + " - " + storeItem.getQuantity());
        }
        add(list);
    }
}

class CartFooter extends Panel {
    Store store = Store.getInstance();
    public CartFooter() {
        setLayout(new GridLayout(2,1));

        store.onItemAdded((item) -> {
            removeAll();
            init();
            revalidate();
            repaint();
        });

        init();
    }

    void init() {
        Label checkoutLabel = new Label("Zur Kasse", Label.CENTER);
        checkoutLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(checkoutLabel);

        Label priceLabel = new Label(Store.getInstance().getTotal() + "€", Label.CENTER);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(priceLabel);
    }
}
