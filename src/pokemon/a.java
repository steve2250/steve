package pokemon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class a extends JFrame{
	
	character mine = new character();
	
	character com = new character();
	
	static JLabel hp_en = new JLabel("몬스터");
	
	static JLabel at_en = new JLabel("공격력");
	
	static JLabel df_en = new JLabel("방어력");
	
	static JLabel stp_en = new JLabel("회피율");
	
	static JLabel hp_me = new JLabel("내 HP");
	
	static JButton at_me=new JButton("일반공격");
	
	static JButton df_me=new JButton("방어");
	
	static JButton stp_me=new JButton("회피");
	
	private Listener listener = new Listener();
	
	public a() {
		this.setTitle("pokemon");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		com.monster();
		
		mine.monster();
		
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		
		at_me.addActionListener(listener);
		
		df_me.addActionListener(listener);
		
		stp_me.addActionListener(listener);	
		
		JPanel mon = new JPanel();
		
		c.add(mon, BorderLayout.NORTH);
		
		mon.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		mon.add(hp_en);
		hp_en.setText("몬스터 HP:"+com.hp);
		mon.add(at_en);
		at_en.setText("공격력:"+com.at);
		mon.add(df_en);
		df_en.setText("방어력:"+com.df);
		mon.add(stp_en);
		stp_en.setText("회피율:"+com.stp);
		
		JPanel my = new JPanel();
		
		c.add(my, BorderLayout.SOUTH);
		
		my.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		my.add(hp_me);
		hp_me.setText("내 HP:"+mine.hp);
		my.add(at_me);
		at_me.setText("공격:"+mine.at_pp);
		my.add(df_me);
		df_me.setText("방어:"+mine.df_pp);
		my.add(stp_me);
		stp_me.setText("회피:"+mine.stp_pp);
		
		setSize(400,600);
		setVisible(true);
	}
	class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==at_me&&mine.at_pp>0) {

				system.at_sk(com.stp,com.hp,mine.at,mine.at_pp,com.df);

				com.hp=system.r_hp;
				
				com.stp=system.r_stp;

 				mine.at_pp=system.r_pp;

 				a.hp_en.setText("몬스터 HP:"+com.hp);

 				a.hp_me.setText("내 HP:"+mine.hp);
 				
 				a.at_me.setText("공격:"+mine.at_pp);
 				
 				System.out.println("공격력:"+mine.at);
 				System.out.println("방어력:"+mine.df);
 				System.out.println("회피율:"+mine.stp);
 			}
 			else if(e.getSource()==df_me&&mine.df_pp>0) {

 				system.df_sk(mine.df,mine.df_pp);

 				mine.df_pp=system.r_pp;

 				mine.df=system.r_df;
 				
 				a.hp_en.setText("몬스터 HP:"+com.hp);

 				a.hp_me.setText("내 HP:"+mine.hp);
 				
 				a.df_me.setText("방어:"+mine.df_pp);
 				
 				System.out.println("공격력:"+mine.at);
 				System.out.println("방어력:"+mine.df);
 				System.out.println("회피율:"+mine.stp);
 			}

 			else if(e.getSource()==stp_me&&mine.stp_pp>0) {

 				system.df_sk(mine.stp,mine.stp_pp);

 				mine.stp_pp=system.r_pp;

 				mine.stp=system.r_stp;
 				
 				a.hp_en.setText("몬스터 HP:"+com.hp);

 				a.hp_me.setText("내 HP:"+mine.hp);
 				
 				a.stp_me.setText("회피:"+mine.stp_pp);
 				
 				System.out.println("공격력:"+mine.at);
 				System.out.println("방어력:"+mine.df);
 				System.out.println("회피율:"+mine.stp);


 			}	

		    if(com.hp<=0) {
		    	JOptionPane.showMessageDialog(a.this, "이겼습니다!", "Message", JOptionPane.INFORMATION_MESSAGE);
		    	System.exit(0);

		    }

		    try {

		    	Thread.sleep(1000);

		       } catch (InterruptedException c) {

		    	c.printStackTrace();

		       }

		    Random r= new Random();

			int sk=r.nextInt(10);

			if(sk<=4) {

				system.at_sk(mine.stp,mine.hp,com.at,com.at_pp,mine.df);

				mine.hp=system.r_hp;

	 			com.at_pp=system.r_pp;

	 			a.hp_en.setText("몬스터 HP:"+com.hp);

 				a.hp_me.setText("내 HP:"+mine.hp);
 				
 				a.at_me.setText("공격:"+mine.at_pp);
	 		}

	 		else if(sk<=7) {

				system.df_sk(com.df,com.df_pp);

	 			com.df_pp=system.r_pp;

	 			com.df=system.r_df;

	 			a.hp_en.setText("몬스터 HP:"+com.hp);
	 			
	 			a.df_en.setText("방어력:"+com.df);

 				a.hp_me.setText("내 HP:"+mine.hp);
 				
 				a.df_me.setText("방어:"+mine.df_pp);	
	 		}

	 		else if(sk<=10) {

	 			system.df_sk(com.stp,com.stp_pp);

	 			com.stp_pp=system.r_pp;

	 			com.stp=system.r_stp;

	 			a.hp_en.setText("몬스터 HP:"+com.hp);
	 			
	 			a.stp_en.setText("회피율:"+com.stp);

 				a.hp_me.setText("내 HP:"+mine.hp);
 				
 				a.stp_me.setText("회피:"+mine.stp_pp);			
	 		}	

		    if(mine.hp<=0) {
		    	JOptionPane.showMessageDialog(a.this, "패배했습니다...", "Message", JOptionPane.INFORMATION_MESSAGE);
		    	System.exit(0);

		    }
		}
}
	public static void main(String[] args) {

		new a();

	}

}