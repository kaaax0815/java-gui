package de.kaaaxcreators.awt;

import java.util.ArrayList;
import java.util.List;

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
            for (StoreListener storeListener : listeners) {
                storeListener.onStoreChange(storeItem);
            }
        } else {
            try {
                StoreItem newItem = (StoreItem)item.clone();
                items.add(newItem);
                for (StoreListener storeListener : listeners) {
                    storeListener.onStoreChange(item);
                }
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
    }

    public void onItemAdded(StoreListener listener) {
        listeners.add(listener);
    }
}

interface StoreListener {
    void onStoreChange(StoreItem item);
}
