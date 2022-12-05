package com.oracle.mn.service;

import com.oracle.mn.model.Item;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Singleton
public class NGMService {
    private static final List<Item> items = Arrays.asList(
            new Item("Apple", "Fruit", 3),
            new Item("Banana", "Fruit", 2),
            new Item("Peach", "Fruit", 3),
            new Item("Broccoli", "Vegetable", 3),
            new Item("Kale", "Vegetable", 5),
            new Item("Chicken alfredo", "Pasta", 7),
            new Item("Pie", "Dessert", 4)
    );

    public List<Item> getItems() {
        return items;
    }

    public List<String> getCategories() {
        List<String> categories = new ArrayList<>(0);
        for (Item item: items) {
            if (!categories.contains(item.getCategory())) {
                categories.add(item.getCategory());
            }
        }
        return categories;
    }
}
