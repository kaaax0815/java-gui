package de.kaaaxcreators.awt;

import java.awt.*;
import java.awt.event.*;

/**
 * Cart in right side of the store.
 */
public class Cart extends Panel {
    public Cart() {
        setLayout(new BorderLayout());

        Store.getInstance().onChange((type, item) -> {
            System.out.println("Item " + type + ": " + item.toString());
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

class CartItems extends Panel {
    Store store = Store.getInstance();
    public CartItems() {
        setLayout(new GridBagLayout());

        store.onChange((type, item) -> {
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

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        for (int i = 0; i < items.length; i++) {
            gbc.gridy = i;
            add(new CartItem(items[i]), gbc);
        }
    }
}

class CartItem extends Panel {
    StoreItem item;
    public CartItem(StoreItem item) {
        this.item = item;
        setLayout(new GridLayout(1,2));

        Label nameLabel = new Label(item.getName(), Label.LEFT);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(nameLabel);

        Label priceLabel = new Label(item.getPrice() + "€", Label.RIGHT);
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(priceLabel);

        Label quantityLabel = new Label("x" + item.getQuantity(), Label.RIGHT);
        quantityLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(quantityLabel);

        Button removeButton = new Button("Entfernen");
        removeButton.addActionListener(new RemoveButtonListener());
        add(removeButton);
    }

    class RemoveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Store.getInstance().removeItem(item, 1);
        }
    }
}

class CartFooter extends Panel {
    Store store = Store.getInstance();
    public CartFooter() {
        setLayout(new GridLayout(2,1));

        store.onChange((type, item) -> {
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
