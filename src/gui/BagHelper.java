package gui;

import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import Item.Item;
import Team.Team;

public class BagHelper {
    public static JList<String> makeList(Team team) {
        DefaultListModel<String> model = new DefaultListModel<>();
        Map<Class<? extends Item>, Integer> itemsMap = team.getItems();

        for (Map.Entry<Class<? extends Item>, Integer> entry : itemsMap.entrySet()) {
            String itemName = entry.getKey().getSimpleName();
            int quantity = entry.getValue();
            model.addElement(itemName + "      x" + quantity);
        }

        JList<String> list = new JList<>(model);

        return list;
    }

    public static void updateList(JList<String> list, Team team) {
        DefaultListModel<String> model = new DefaultListModel<>();
        Map<Class<? extends Item>, Integer> itemsMap = team.getItems();

        for (Map.Entry<Class<? extends Item>, Integer> entry : itemsMap.entrySet()) {
            String itemName = entry.getKey().getSimpleName();
            int quantity = entry.getValue();
            model.addElement(itemName + "      x" + quantity);
        }

        list.setModel(model);
    }
}
