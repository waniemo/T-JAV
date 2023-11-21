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
    private TextBox itemDescription = new TextBox("");

    public Bag(App frame, ArenaPanel arena, Team playerTeam, Team enemyTeam) {
        try {
            backgroundImage = ImageIO.read(new File("../Assets/Background/bag.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());
        JButton useButton = new JButton("UTILISER");
        ImageIcon retourIcon = new ImageIcon("../Assets/Bouton/bouton_retour.png");
        JLabel retourLabel = new JLabel(retourIcon);
        retourLabel.setText("Retour");
        retourLabel.setHorizontalTextPosition(JLabel.CENTER);
        retourLabel.setVerticalTextPosition(JLabel.CENTER);
        retourLabel.setForeground(Color.white);
        retourLabel.setFont(UIManager.getFont("Label.font").deriveFont(26f));

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

        useButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlaySound.playSound("button", frame.hasSound());

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
                    itemDescription.updateText(playerTeam.useItems(item, playerTeam.getActivePokemon()), true);
                    itemImage = new ImageIcon();
                    BagHelper.updateList(itemsString, playerTeam);
                }
            }
        });
        retourLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlaySound.playSound("button", frame.hasSound());

                arena.getPlayerPvBar().updateBar(false); // animation
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
        // itemDescription.setFont(getFont().deriveFont(40f));
        itemsString.setOpaque(false);

        // List top right
        GridBagConstraints gbc = LayoutHelper.createGridBagConstraints(1, 0, 0.5, 0.5, 1, 1);
        gbc.insets = new Insets(40, 80, 80, 0);
        gbc.anchor = GridBagConstraints.NORTHEAST;
        add(itemsString, gbc);

        // Image bottom left
        LayoutHelper.modifyGridBagConstraints(gbc, 0, 1, gbc.weightx, gbc.weighty);
        gbc.insets = new Insets(80, 80, 80, 80);
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        add(itemLabel, gbc);

        // Description bottom center
        LayoutHelper.modifyGridBagConstraints(gbc, 1, 1, gbc.weightx, gbc.weighty);
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(80, 80, 80, 40);
        add(itemDescription, gbc);

        // Buttons bottom right
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        gbc.insets = new Insets(60, 0, 100, 80);
        add(useButton, gbc);
        gbc.insets = new Insets(30, 0, 0, 0);
        add(retourLabel, gbc);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image scaledBackground = backgroundImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(scaledBackground, 0, 0, this);
    }
}
