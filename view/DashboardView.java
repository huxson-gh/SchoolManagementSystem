package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class DashboardView extends JFrame {
    protected final JPanel content = new JPanel(new BorderLayout(12,12));
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel cards = new JPanel(cardLayout);
    private final Color navy = new Color(25, 39, 66);
    private final Color blue = new Color(48, 105, 190);
    protected DashboardView(String role, String userName) {
        setTitle("School Management System | " + role); setSize(1120,720); setMinimumSize(new Dimension(900,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setLocationRelativeTo(null);
        JPanel root=new JPanel(new BorderLayout()); root.setBackground(new Color(245,247,251));
        JPanel side=new JPanel(); side.setBackground(navy); side.setPreferredSize(new Dimension(225,0)); side.setLayout(new BoxLayout(side,BoxLayout.Y_AXIS)); side.setBorder(new EmptyBorder(24,16,20,16));
        JLabel brand=new JLabel("SCHOOL  /  SYSTEM"); brand.setForeground(Color.WHITE); brand.setFont(new Font("SansSerif",Font.BOLD,17)); brand.setBorder(new EmptyBorder(0,5,8,0)); side.add(brand);
        JLabel who=new JLabel("Welcome, " + userName); who.setForeground(new Color(190,204,225)); who.setFont(new Font("SansSerif",Font.PLAIN,13)); who.setBorder(new EmptyBorder(0,5,28,0)); side.add(who);
        buildNavigation(side);
        side.add(Box.createVerticalGlue()); JButton logout=navButton("Log out"); logout.addActionListener(e->{dispose();onLogout();}); side.add(logout);
        JPanel top=new JPanel(new BorderLayout()); top.setBackground(Color.WHITE); top.setBorder(new EmptyBorder(18,26,18,26)); JLabel heading=new JLabel(role+" Dashboard"); heading.setFont(new Font("SansSerif",Font.BOLD,23)); heading.setForeground(navy); top.add(heading,BorderLayout.WEST);
        content.setBorder(new EmptyBorder(22,26,24,26)); content.setOpaque(false); cards.add(content,"Dashboard");
        root.add(side,BorderLayout.WEST); root.add(top,BorderLayout.NORTH); root.add(cards,BorderLayout.CENTER); setContentPane(root);
        showPage("Dashboard");
    }
    protected abstract void buildNavigation(JPanel side);
    protected abstract void onLogout();
    protected void addNav(JPanel side,String label,String page){JButton b=navButton(label);b.addActionListener(e->showPage(page));side.add(b);side.add(Box.createVerticalStrut(7));}
    protected JButton navButton(String text){JButton b=new JButton(text);b.setAlignmentX(Component.LEFT_ALIGNMENT);b.setMaximumSize(new Dimension(195,42));b.setPreferredSize(new Dimension(195,42));b.setFocusPainted(false);b.setForeground(Color.WHITE);b.setBackground(new Color(39,57,89));b.setBorder(new EmptyBorder(8,14,8,10));b.setHorizontalAlignment(SwingConstants.LEFT);b.setFont(new Font("SansSerif",Font.PLAIN,14));return b;}
    protected void addPage(String name, JPanel panel){cards.add(panel,name);}
    protected void showPage(String name){cardLayout.show(cards,name);}
    protected JPanel page(String title,String subtitle){JPanel p=new JPanel(new BorderLayout(12,16));p.setOpaque(false);JPanel h=new JPanel();h.setOpaque(false);h.setLayout(new BoxLayout(h,BoxLayout.Y_AXIS));JLabel t=new JLabel(title);t.setFont(new Font("SansSerif",Font.BOLD,22));t.setForeground(navy);JLabel s=new JLabel(subtitle);s.setFont(new Font("SansSerif",Font.PLAIN,13));s.setForeground(new Color(105,116,135));h.add(t);h.add(Box.createVerticalStrut(5));h.add(s);p.add(h,BorderLayout.NORTH);return p;}
    protected JPanel cardPanel(){JPanel p=new JPanel(new BorderLayout());p.setBackground(Color.WHITE);p.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(229,233,240)),new EmptyBorder(16,16,16,16)));return p;}
    protected JTable styledTable(Object[][] data,String[] columns){JTable table=new JTable(data,columns);table.setRowHeight(30);table.setFont(new Font("SansSerif",Font.PLAIN,13));table.getTableHeader().setFont(new Font("SansSerif",Font.BOLD,13));table.setFillsViewportHeight(true);return table;}
    protected void info(String message){JOptionPane.showMessageDialog(this,message,"School Management System",JOptionPane.INFORMATION_MESSAGE);}
    protected void error(String message){JOptionPane.showMessageDialog(this,message,"Please check",JOptionPane.WARNING_MESSAGE);}
}
