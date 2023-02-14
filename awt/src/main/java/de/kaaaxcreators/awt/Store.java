package de.kaaaxcreators.awt;

import java.util.ArrayList;
import java.util.List;

/**
 * Store of what the user wants to buy.
 */
public class Store {
    private static final Store OBJ = new Store();
    private List<StoreItem> items = new ArrayList<StoreItem>();
    private List<StoreListener> listeners = new ArrayList<StoreListener>();
        
    public static Store getInstance() {
      return OBJ;
    }

    public void addItem(StoreItem item) {
        int index = -1;
        for (StoreItem storeItem : items) {
            if (storeItem.getName().equals(item.getName())) {
                index = items.indexOf(storeItem);
                break;
            }
        }
        if (index != -1) {
            StoreItem storeItem = items.get(index);
            storeItem.setQuantity(storeItem.getQuantity().intValue() + item.getQuantity().intValue());
            emit("add", storeItem);
        } else {
            try {
                StoreItem newItem = (StoreItem)item.clone();
                items.add(newItem);
                emit("add", newItem);
            } catch (CloneNotSupportedException e) {
                return;
            }
        }
        
    }

    public StoreItem[] getItems() {
        return items.toArray(new StoreItem[items.size()]);
    }

    public void clear() {
        items.clear();
    }

    public int getTotal() {
        int total = 0;
        for (StoreItem storeItem : items) {
            total += storeItem.getPrice().intValue() * storeItem.getQuantity().intValue();
        }
        return total;
    }

    public void removeItem(StoreItem item) {
        items.remove(item);
        emit("remove", item);
    }

    public void removeItem(StoreItem item, Number quantity) {
        int itemToChange = items.indexOf(item);
        if (itemToChange == -1) {
            return;
        }
        StoreItem storeItem = items.get(itemToChange);
        if (storeItem.getQuantity().intValue() - quantity.intValue() <= 0) {
            items.remove(itemToChange);
            emit("remove", item);
            return;
        }
        storeItem.setQuantity(storeItem.getQuantity().intValue() - quantity.intValue());

        emit("remove", item);
    }

    public void onChange(StoreListener listener) {
        listeners.add(listener);
    }

    /**
     * @param event "add" or "remove"
     */
    private void emit(String event, StoreItem item) {
        for (StoreListener storeListener : listeners) {
            storeListener.onStoreChange(event, item);
        }
    }
}

interface StoreListener {
    void onStoreChange(String type, StoreItem item);
}
