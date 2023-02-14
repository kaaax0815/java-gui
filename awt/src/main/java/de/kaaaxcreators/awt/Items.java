package de.kaaaxcreators.awt;

import java.awt.*;
import java.awt.event.*;

/**
 * List of Items in left side of the store.
 */
public class Items extends Panel {
    ItemsList itemsList = new ItemsList();
    public Items() {
        setLayout(new GridLayout(3,1));

        for (ItemsList.ListItem listItem: itemsList.getList()) {
            add(new Item(new StoreItem(listItem.name, listItem.description, listItem.price)));
        }
    }
}

class Item extends Panel {
    private StoreItem item;

    public Item(StoreItem item) {
        setLayout(new GridLayout(1,2));

        this.item = item;

        ItemName itemName = new ItemName();
        add(itemName);

        ItemProps itemProps = new ItemProps();
        add(itemProps);
    }

    class ItemName extends Panel {
        public ItemName() {
            setLayout(new GridLayout(2,1));

            Label nameLabel = new Label(item.getName());
            nameLabel.setFont(new Font("Arial", Font.BOLD, 20));

            Label descriptionLabel = new Label(item.getDescription());
            descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 12));

            add(nameLabel);
            add(descriptionLabel);
        }
    }

    class ItemProps extends Panel {
        public ItemProps() {
            setLayout(new GridLayout(2,1));

            Label priceLabel = new Label(item.getPrice() + "€", Label.CENTER);
            priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
            Button buyButton = new Button("Kaufen");
            buyButton.addActionListener(new BuyButtonListener());

            add(priceLabel);
            add(buyButton);
        }
        
        class BuyButtonListener implements ActionListener  {
            public void actionPerformed(ActionEvent e) {
                Store store = Store.getInstance();
                store.addItem(item);
            }
        }
    }
}
