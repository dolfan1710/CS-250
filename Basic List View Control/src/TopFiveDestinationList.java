import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import javafx.scene.paint.Color;

public class TopFiveDestinationList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
                topDestinationListFrame.setTitle("Top 5 Destination List");
                topDestinationListFrame.setVisible(true);
            }
        });
    }
}


class TopDestinationListFrame extends JFrame {
    private DefaultListModel listModel;

    public TopDestinationListFrame() {
        super("Top Five Destination List");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 750);

        listModel = new DefaultListModel();


        //Make updates to your top 5 list below. Import the new image files to resources directory.
        
        // image published by Navigator334 @ https://commons.wikimedia.org/wiki/File:View_from_above_of_colorful_buildings_in_Oranjestad_on_the_island_of_Aruba_in_the_morning_sun.jpg
        addDestinationNameAndPicture("  Top Destination - Aruba, A Luxurious Island Experience!", new ImageIcon(getClass().getResource("/resources/Aruba.jpg")));
        
        // image published by The ed17 @ https://commons.wikimedia.org/wiki/File:Myrtle_Beach_ferris_wheel.jpg
        addDestinationNameAndPicture("  2nd Top Destination - Myrtle Beach SC, America's Family Beach Destination!", new ImageIcon(getClass().getResource("/resources/myrtle.jpg")));
        
        // image published by Ryancoke2020 @ https://commons.wikimedia.org/wiki/File:Punta_Cana,_Dominican_Republic_(Resort).jpg
        addDestinationNameAndPicture("  3rd Top Destination - Punta Cana DR, A Tropical Beach Vacation at a Bargain! ", new ImageIcon(getClass().getResource("/resources/Punta_Cana,_DR.jpg")));
        
        // image published by Kaleeb18 @ https://commons.wikimedia.org/wiki/File:Walt_Disney_World_Cinderella_Castle_in_2021.jpg
        addDestinationNameAndPicture("  4th Top Destination - Walt Disney World, Come Experience the Magic!", new ImageIcon(getClass().getResource("/resources/disney.jpg")));
        
        // image published by WPPilot@ https://commons.wikimedia.org/wiki/File:Lighthouse_Beach,_Edgartown,_Marthas_Vineyard_Island_in_the_Dukes_County,_Massachusetts_by_Don_Ramey_Logan.jpg
        addDestinationNameAndPicture("  5th Top Destination - Martha's Vineyard MA, Enjoy Classic New England!", new ImageIcon(getClass().getResource("/resources/martha_vineyard.jpg")));
        
       
        JList list = new JList(listModel);
        
        JScrollPane scrollPane = new JScrollPane(list);
        
        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);
        
        list.setCellRenderer(renderer);
        
        //add lebel that includes my name to top border
        JLabel nameLabel = new JLabel("Developer: Joe Silva");
        getContentPane().add(nameLabel, BorderLayout.NORTH);
        
        //add label that has the company name SNHU Travel in the bottom border
        JLabel nameLabel1 = new JLabel("SNHU Travel");
        getContentPane().add(nameLabel1, BorderLayout.SOUTH);
        
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void addDestinationNameAndPicture(String text, Icon icon) {
        TextAndIcon tai = new TextAndIcon(text, icon);
        listModel.addElement(tai);
    }
}


class TextAndIcon {
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}


class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer {
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value,
    int index, boolean isSelected, boolean hasFocus) {
        // The object from the combo box model MUST be a TextAndIcon.
        TextAndIcon tai = (TextAndIcon) value;

        // Sets text and icon on 'this' JLabel.
        setText(tai.getText());
        setIcon(tai.getIcon());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        Border outsideBorder;

        if (hasFocus) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // The following methods are overridden to be empty for performance
    // reasons. If you want to understand better why, please read:
    //
    // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}