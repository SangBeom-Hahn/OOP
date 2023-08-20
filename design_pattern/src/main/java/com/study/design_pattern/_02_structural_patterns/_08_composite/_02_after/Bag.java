package com.study.design_pattern._02_structural_patterns._08_composite._02_after;

import com.study.design_pattern._02_structural_patterns._08_composite._01_before.Item;

import java.util.ArrayList;
import java.util.List;

public class Bag implements Component{
    
    private List<Component> components = new ArrayList<>();
    
    public void add(Component component) {
        components.add(component);
    }
    
    public List<Component> getItems() {
        return components;
    }
    
    @Override
    public int getPrice() {
        return components.stream()
                .mapToInt(Component::getPrice)
                .sum();
    }
}
