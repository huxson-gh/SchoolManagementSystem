package view;
import controller.StaffController; import model.Staff; import javax.swing.*; import java.awt.*;
public class StaffView extends DashboardView {
 private final Staff staff; private final Runnable logout;
 public StaffView(StaffController c,Staff s,Runnable logout){super("Staff",s.getName());staff=s;this.logout=logout;buildPages();setVisible(true);} protected void onLogout(){logout.run();}
 protected void buildNavigation(JPanel side){addNav(side,"Overview","Dashboard");addNav(side,"My details","Details");}
 private void buildPages(){JPanel home=page("Welcome, "+staff.getName(),"Your staff account is active.");JPanel box=cardPanel();box.add(new JLabel("Use My details to view your registered staff information."),BorderLayout.NORTH);home.add(box,BorderLayout.CENTER);addPage("Dashboard",home);JPanel details=page("My details","Your registered staff information.");JPanel d=cardPanel();d.setLayout(new GridLayout(0,2,12,18));add(d,"Staff ID",String.valueOf(staff.getStaffId()));add(d,"Full name",staff.getName());add(d,"Username",staff.getUsername());add(d,"Department",staff.getDepartment());details.add(d,BorderLayout.CENTER);addPage("Details",details);}
 private void add(JPanel p,String k,String v){JPanel x=new JPanel(new BorderLayout(0,5));x.setOpaque(false);JLabel a=new JLabel(k);a.setForeground(new Color(105,116,135));JLabel b=new JLabel(v);b.setFont(new Font("SansSerif",Font.BOLD,15));x.add(a,BorderLayout.NORTH);x.add(b,BorderLayout.CENTER);p.add(x);}
}
