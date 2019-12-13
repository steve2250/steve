package pokemon;

import java.util.Random;

public class system {

	public static int r_hp;

	public static int r_pp;

	public static int r_df;

	public static int r_stp;

	public static void at_sk(int stp, int hp, int at,int at_pp,int df){

		Random r=new Random();

		at_pp--;

		r_pp=at_pp;

		if(r.nextInt(100)>stp){

			hp=hp-at+df;
			
			r_stp=stp;

			r_hp=hp;
			
			return ;

		}
	}

	public static void df_sk(int df,int df_pp){

		df=df+1;

		r_df=df;

		df_pp--;

		r_pp=df_pp;
		
		return ;

	}

	public static void st_sk(int stp,int stp_pp){

		stp=stp+5;

		r_stp=stp;

		stp_pp--;

		r_pp=stp_pp;
		
		return ;

	}

}