package duo_vs.connect4;


public class Winner 
{	
	boolean redwon, yellowwon;
	int[] playerredx, playerredy, playeryellowy, playeryellowx;
	int count;
	
	public Winner()
	{	
		playerredx = new int[21];
		playerredy = new int[21];
		playeryellowx = new int[22];
		playeryellowy = new int[22];
	}

	public boolean RedWin(int[] playerredx, int[] playerredy, int l)
	{
		int temp2;
		count=l;
		int check;

		check=0;
		//check red player going up column 
		for(int column=60; column<655; column +=85)
		{
			for(int row=410; row>60; row-=70)
			{
				check=0;
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
		}
		//checking if the red player won by placing discs across one row
		if(!redwon)
		{
			for(int column=60; column<655; column +=85)
			{
				for(int row=410; row>60; row-=70)
				{
					int temp1=column;
				    temp2=row;
					check=0;
					for(int e=0; e<4; e++)
					{
						for(int j=0; j<21; j++)
						{
							if(playerredx[j]!=0)
							{
								if(temp1 == playerredx[j]&& temp2 ==playerredy[j])
								{
									check = check+1;
									temp1=temp1+85;
								}

								if(check==4)
								{
									j=22;
									column=655;
									row=60;
									e=4;
									redwon=true;
								}
							}
						}
					}
				}
			}
		}
		//checking up and right
		if(!redwon)
		{	
			for(int row=410; row>60; row-=70)
			{
				for(int column=60; column<655; column +=85)
				{
					int temp1=row;
				    temp2=column;
				    check=0;
					for(int e=0; e<4; e++)
					{
						for(int j=0; j<21; j++)
						{
							if(playerredx[j]!=0)
							{
								if(temp1 == playerredx[j]&& temp2 ==playerredy[j])
								{
									check = check+1;
									temp1=temp1+85;
									temp2=temp2-70;
								}
								if(check==4)
								{
									j=22;
									column=655;
									row=60;
									e=4;
									redwon=true;
								}
							}
						}
					}
				}
				check=0;
			}
		}
		//checking left and down
				if(!redwon)
				{
					for(int column=60; column<655; column +=85)
					{
						for(int row=410; row>60; row-=70)
						{
							int temp1=column;
							temp2=row;
							check=0;
							for(int e=0; e<4; e++)
							{
								for(int j=0; j<21; j++)
								{
									if(playerredx[j]!=0)
									{
										if(temp1 == playerredx[j]&& temp2 ==playerredy[j])
										{
											check = check+1;
											temp1=temp1+85;
											temp2=temp2+70;
										}
										if(check==4)
										{
											j=22;
											column=655;
											row=60;
											e=4;
											redwon=true;
										}
									}
								}
							}
						}
						
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
				check=0;
				for(int j=0; j<22; j++)
				{
					if(playeryellowx[j]!=0)
					{
						if(column == playeryellowx[j]&& row ==playeryellowy[j])
						{
							check = check+1;
							row=row-70;
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
		}
		//checking if the yellow player won by placing discs across one row
		if(!yellowwon)
		{
			for(int column=60; column<655; column +=85)
			{
				for(int row=410; row>60; row-=70)
				{
					int temp1=column;
				    int temp2=row;
				    check=0;
					for(int e=0; e<4; e++)
					{
						for(int j=0; j<21; j++)
						{
							if(playeryellowx[j]!=0)
							{
								if(temp1 == playeryellowx[j]&& temp2 ==playeryellowy[j])
								{
									check = check+1;
									temp1=temp1+85;
								}
	
								if(check==4)
								{
									j=22;
									column=655;
									row=60;
									e=4;
									yellowwon=true;
								}
							}
						}
					}	
				}
			}
		}
		//checking up and right
		if(!yellowwon)
		{
			for(int column=60; column<655; column +=85)
			{
				for(int row=410; row>60; row-=70)
				{
					int temp1=column;
					int temp2=row;
					check=0;
					for(int e=0; e<4; e++)
					{
						for(int j=0; j<21; j++)
						{
							if(playeryellowx[j]!=0)
							{	
								if(temp1 == playeryellowx[j]&& temp2 ==playeryellowy[j])
								{
									check = check+1;
									temp1=temp1+85;
									temp2=temp2-70;
								}
								if(check==4)
								{
									j=22;
									column=655;
									row=60;
									e=4;
									yellowwon=true;
								}
							}
						}
					}
				}
			}
		}
		//checking left and down
		if(!yellowwon)
		{
			for(int column=60; column<655; column +=85)
			{
				for(int row=410; row>60; row-=70)
				{
					int temp1=column;
					int temp2=row;
					check=0;
					for(int e=0; e<4; e++)
					{
						for(int j=0; j<21; j++)
						{
							if(playeryellowx[j]!=0)
							{

								if(temp1 == playeryellowx[j]&& temp2 ==playeryellowy[j])
								{
									check = check+1;
									temp1=temp1+85;
									temp2=temp2+70;
								}
								if(check==4)
								{
									j=22;
									column=655;
									row=60;
									e=4;
									yellowwon=true;
								}
							}
						}
					}
				}
			}
		}
		return yellowwon;
	}
}
