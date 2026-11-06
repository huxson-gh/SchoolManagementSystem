package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.BiConsumer;

public class LoginView extends JFrame {
    private JTextField username;
    private JPasswordField password;

    public LoginView(BiConsumer<String, String> loginAction) {
        setTitle("School Management System - Login");
        setSize(520, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel root = new JPanel(new GridBagLayout());
        root.setBackground(new Color(239, 243, 250));

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(390, 540));
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(28, 34, 24, 34));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel brand = new JLabel("SCHOOL MANAGEMENT SYSTEM");
        brand.setFont(new Font("SansSerif", Font.BOLD, 17));
        brand.setForeground(new Color(29, 48, 78));
        brand.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel title = new JLabel("Welcome back");
        title.setFont(new Font("SansSerif", Font.BOLD, 27));
        title.setForeground(new Color(29, 48, 78));
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel sub = new JLabel("Sign in to continue to your dashboard");
        sub.setForeground(new Color(115, 125, 143));
        sub.setAlignmentX(Component.LEFT_ALIGNMENT);

        username = new JTextField();
        password = new JPasswordField();
        styleField(username);
        styleField(password);

        panel.add(brand);
        panel.add(Box.createVerticalStrut(22));
        panel.add(title);
        panel.add(Box.createVerticalStrut(4));
        panel.add(sub);
        panel.add(Box.createVerticalStrut(22));
        panel.add(label("USERNAME"));
        panel.add(Box.createVerticalStrut(6));
        panel.add(username);
        panel.add(Box.createVerticalStrut(14));
        panel.add(label("PASSWORD"));
        panel.add(Box.createVerticalStrut(6));
        panel.add(password);
        panel.add(Box.createVerticalStrut(20));

        JButton login = new JButton("Sign in");
        login.setAlignmentX(Component.LEFT_ALIGNMENT);
        login.setMaximumSize(new Dimension(320, 44));
        login.setBackground(new Color(48, 105, 190));
        login.setForeground(Color.WHITE);
        login.setFocusPainted(false);
        login.setFont(new Font("SansSerif", Font.BOLD, 14));
        login.addActionListener(e -> loginAction.accept(username.getText().trim(), new String(password.getPassword())));
        password.addActionListener(e -> login.doClick());
        panel.add(login);
        panel.add(Box.createVerticalStrut(16));

        // Demo credentials panel displaying all roles
        JPanel demoBox = new JPanel();
        demoBox.setLayout(new BoxLayout(demoBox, BoxLayout.Y_AXIS));
        demoBox.setBackground(new Color(245, 248, 252));
        demoBox.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(222, 230, 240)),
            new EmptyBorder(8, 12, 8, 12)
        ));
        demoBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        demoBox.setMaximumSize(new Dimension(320, 115));

        JLabel demoHeader = new JLabel("Demo Accounts (Role : Username / Password):");
        demoHeader.setFont(new Font("SansSerif", Font.BOLD, 10));
        demoHeader.setForeground(new Color(50, 70, 95));
        demoHeader.setAlignmentX(Component.LEFT_ALIGNMENT);
        demoBox.add(demoHeader);
        demoBox.add(Box.createVerticalStrut(5));

        String[][] demoUsers = {
            {"Admin", "admin", "admin123"},
            {"Teacher", "teacher1", "teacher123"},
            {"Student", "student1", "student123"},
            {"Staff", "staff1", "staff123"}
        };

        for (String[] demo : demoUsers) {
            JLabel credLabel = new JLabel("• " + demo[0] + ":  " + demo[1] + "  /  " + demo[2]);
            credLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
            credLabel.setForeground(new Color(85, 95, 115));
            credLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            credLabel.setToolTipText("Click to auto-fill " + demo[0] + " credentials");
            credLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    username.setText(demo[1]);
                    password.setText(demo[2]);
                }
            });
            credLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            demoBox.add(credLabel);
            demoBox.add(Box.createVerticalStrut(2));
        }

        panel.add(demoBox);
        root.add(panel);
        setContentPane(root);
    }

    private JLabel label(String s) {
        JLabel l = new JLabel(s);
        l.setFont(new Font("SansSerif", Font.BOLD, 11));
        l.setForeground(new Color(80, 92, 110));
        l.setAlignmentX(Component.LEFT_ALIGNMENT);
        return l;
    }

    private void styleField(JComponent c) {
        c.setMaximumSize(new Dimension(320, 40));
        c.setPreferredSize(new Dimension(320, 40));
        c.setFont(new Font("SansSerif", Font.PLAIN, 14));
        c.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(215, 222, 232)),
            new EmptyBorder(7, 10, 7, 10)
        ));
        c.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Login failed", JOptionPane.ERROR_MESSAGE);
    }
}
