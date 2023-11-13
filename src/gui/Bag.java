package gui;

import javax.imageio.ImageIO;
import java.io.File;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
    private ImageIcon itemImage = null;
    private JLabel itemLabel = new JLabel();
    private JLabel itemDescription = new JLabel("");

    public Bag(App frame, ArenaPanel arena, Team playerTeam, Team enemyTeam) {
        try {
            backgroundImage = ImageIO.read(new File("../Assets/bag.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(0, 0, 0, 0);

        List<Class<? extends Item>> teamItems = new ArrayList<>(playerTeam.getItems().keySet());
        itemsString = BagHelper.makeList(playerTeam);


        itemsString.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int itemIndex = itemsString.getSelectedIndex();
                    Item item = null;
                    try {
                        item = teamItems.get(itemIndex).getDeclaredConstructor().newInstance();
                    } catch (Exception noItem) {
                    }
                    if (item != null) {
                        System.out.println(item.getDescription());
                        // Update itemImage based on the item name
                        itemDescription.setText(item.getDescription());
                        itemImage = new ImageIcon("../Assets/" + item.getSprite());
                        itemLabel.setIcon(itemImage);
                    }
                }
            }
        });

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
                    } catch (Exception noItem) {
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
                arena.getPlayerPvBar().updateBar();
                frame.setLayout(new BorderLayout());
                frame.getContentPane().removeAll();
                frame.getContentPane().add(arena, BorderLayout.CENTER);
                frame.revalidate();
                frame.repaint();
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
        itemDescription.setFont(getFont().deriveFont(40f));
        itemsString.setOpaque(false);
        add(itemsString, gbc);
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(itemLabel, gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        add(itemDescription, gbc);
        gbc.gridx = 4;
        gbc.gridy = 3;
        add(useButton, gbc);
        gbc.gridy = 4;
        add(backButton, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image scaledBackground = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(scaledBackground, 0, 0, this);
    }
}
