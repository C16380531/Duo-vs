package duo_vs.connect4;

import java.util.Arrays;

public class Winner 
{	
	boolean redwon, yellowwon;
	int[] playerredx, playerredy, playeryellowy, playeryellowx;

	public Winner()
	{	
		playerredx = new int[21];
		playerredy = new int[21];
		playeryellowx = new int[22];
		playeryellowy = new int[22];
	}

	public boolean RedWin(int[] playerredx, int[] playerredy)
	{
		//values into array
		for(int i=0; i<21; i++)
		{
			this.playerredx[i] = playerredx[i];
			this.playerredy[i] = playerredy[i];
		}
		
		//checking if the red player won by placing discs up in one column
		int check=0;
			for(int column=60; column<655; column +=85)
			{
				for(int row=410; row>60; row-=70)
				{
					for(int j=0; j<21; j++)
					{
						if(playerredx[j]!=0)
						{
							if(column == playerredx[j]&& row ==playerredy[j])
							{
								check = check+1;
								row=row-70;
							}
							
							if(check==4)
							{
								j=22;
								column=655;
								row=60;
								redwon=true;
							}
						}
					}
				}
				check=0;
			}
			//checking if the red player won by placing discs across one row
			if(!redwon)
			{
				for(int row=410; row>60; row-=70)
				{	
					int[] rowstaken =new int[7];
					int s=0;
					for(int column=60; column<655; column +=85)
					{
						for(int j=0; j<21; j++)
						{
							if(playerredx[j]!=0)
							{
								if(column == playerredx[j])
								{
									
									rowstaken[s] =playerredy[j];
									Arrays.sort(rowstaken);
									for(int i=0; i<7; i++)
									{
										if(rowstaken[i]!=0)
										{
											if(rowstaken[i]==playerredy[j]) 
											{
												System.out.print( "\nfirst " + column +"\nsecond "+ playerredx[j]);
												System.out.print( "\nfirst " + row +"\nsecond "+ playerredy[j]);
												check = check+1;
												System.out.print( "\nyoyoyyo " +check);
												i=7;
											}
										}
									}
								}
								
								if(check==4)
								{
									System.out.print("wrong");
									j=22;
									column=655;
									row=60;
									redwon=true;
								}
							}
						}
					}	
				check=0;
				}
			}

			return redwon;
		
	}
	
	public boolean YellowWin(int[] playeryellowx, int[] playeryellowy)
	{
		for(int i=0; i<21; i++)
		{
			this.playeryellowx[i] = playeryellowx[i];
			this.playeryellowy[i] = playeryellowy[i];
		}
		//checking if the yellow player won by placing discs up in one column
		int check=0;
			for(int column=60; column<655; column +=85)
			{
				for(int row=410; row>60; row-=70)
				{
					for(int j=0; j<22; j++)
					{
						if(playeryellowx[j]!=0)
						{
							if(column == playeryellowx[j]&& row ==playeryellowy[j])
							{
								System.out.print( "\nfirst " + column +"\nsecond "+ playeryellowx[j]);
								System.out.print( "\nfirst " + row +"\nsecond "+ playeryellowy[j]);
								check = check+1;
								System.out.print( "\nwin " +check);
								row=row-70;
							}
							
							if(check==4)
							{
								System.out.print("Yellow win Yellow win");
								j=22;
								column=655;
								row=60;
								yellowwon=true;
							}
						}
					}
				}
				check=0;
			}
			//checking if the yellow player won by placing discs across one row
			if(!yellowwon)
			{
				for(int row=410; row>60; row-=70)
				{	
					int[] rowstaken =new int[7];
					int s=0;
					for(int column=60; column<655; column +=85)
					{
						for(int j=0; j<21; j++)
						{
							if(playeryellowx[j]!=0)
							{
								if(column == playeryellowx[j])
								{
									
									rowstaken[s] =playeryellowy[j];
									Arrays.sort(rowstaken);
									for(int i=0; i<7; i++)
									{
										if(rowstaken[i]!=0)
										{
											if(rowstaken[i]==playeryellowy[j]) 
											{
												check = check+1;
												i=7;
											}
										}
									}
								}
								
								if(check==4)
								{
									j=22;
									column=655;
									row=60;
									yellowwon=true;
								}
							}
						}
					}	
				check=0;
				}
			}
			return yellowwon;

	}
}

