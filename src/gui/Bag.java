package gui;

import javax.imageio.ImageIO;
import java.io.File;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Team.*;
import Item.*;

public class Bag extends JPanel {
    private Image backgroundImage;
    private JList<String> itemsString = null;

    public Bag(App frame, Team playerTeam, Team enemyTeam) {
        try {
            backgroundImage = ImageIO.read(new File("../Assets/bag.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(0, 250, 220, 0);

        List<Class<? extends Item>> teamItems = new ArrayList<>(playerTeam.getItems().keySet());
        // itemsString = BagHelper.makeList(playerTeam);

        // DefaultListModel<String> model = new DefaultListModel<>();

        // // String[] listData = itemsString.toArray(new String[0]);
        // for (Class<? extends Item> itemClass : teamItems) {
        //     model.addElement(itemClass.getSimpleName());
        // }

        itemsString = BagHelper.makeList(playerTeam);


        JButton useButton = new JButton("UTILISER");
        useButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item from the list
                String selectedItem = itemsString.getSelectedValue();
                if (selectedItem != null) {
                    int itemIndex = itemsString.getSelectedIndex();
                    Item item = null;
                    try {
                        item = teamItems.get(itemIndex).getDeclaredConstructor().newInstance();
                    }
                    catch (Exception noItem) {
                        System.err.println("No such Item.");
                    }
                    System.out.println(item.getName());
                    playerTeam.useItems(item, playerTeam.getActivePokemon());
                    BagHelper.updateList(itemsString, playerTeam);
                }
            }
        });
        JButton backButton = new JButton("RETOUR");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Take the user back to the previous UI
                // ...
            }
        });

        itemsString.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,
                        cellHasFocus);
                label.setOpaque(false);
                float newSize = frame.getHeight() / 11f;
                label.setFont(getFont().deriveFont(newSize));
                return label;
            }
        });
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int newCellHeight = (int) (frame.getHeight() / 11f);
                itemsString.setFixedCellHeight(newCellHeight);
            }
        });
        itemsString.setOpaque(false);
        add(itemsString, gbc);
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridy = 1;
        add(useButton, gbc);
        gbc.gridy = 2;
        add(backButton, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image scaledBackground = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(scaledBackground, 0, 0, this);
    }
}
