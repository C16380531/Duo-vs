package duo_vs.connect4;

public class Winner 
{	
	boolean redwin;
	int[] playerredx, playerredy;
	public Winner(boolean redwin, int[] playerredx, int[] playerredy)
	{
		
	}
	
	public void RedWin()
	{
		//column 60 +85
		int check=0;
		int column=60;
		int row=60;
		if(redwin)
		{
			do
			{
				for(int j=0; j<21; j++)
				{
					redwin=false;
					if(playerredx[j]!=0)
					{
						if(column == playerredx[j])
						{
							System.out.print( "\nfirst " + column +"\nsecond "+ playerredx[j]);
							check = check+1;
							System.out.print( "\nwin " +check);
						}
						
						if(check==4)
						{
							System.out.print("RedWin RedWin");
							j=22;
							column=600;
							won=true;
						}
					}
				}
				column=column+85;
			}while(column!= 655);
			
			do
			{
				for(int j=0; j<21; j++)
				{
					redwin=false;
					if(playerredx[j]!=0)
					{
						if(row == playerredx[j])
						{
							System.out.print( "\nfirst " + row +"\nsecond "+ playerredx[j]);
							check = check+1;
							System.out.print( "\nwin " + row);
						}
						
						if(check==4)
						{
							System.out.print("RedWin RedWin");
							j=22;
							row = 600;
							won=true;
						}
					}
				}
				row = row + 85;
			}while(column!= 655);
		}
	//	}
		
	}
	
	public void YellowWin()
	{
		//column 60 +85
		int check=0;
		int column=60;
		int row=60;
		if(redwin)
		{
			do
			{
				for(int j=0; j<21; j++)
				{
					redwin=false;
					if(playerredx[j]!=0)
					{
						if(column == playerredx[j])
						{
							System.out.print( "\nfirst " + column +"\nsecond "+ playerredx[j]);
							check = check+1;
							System.out.print( "\nwin " +check);
						}
						
						if(check==4)
						{
							System.out.print("RedWin RedWin");
							j=22;
							column=600;
							won=true;
						}
					}
				}
				column=column+85;
			}while(column!= 655);
			
			do
			{
				for(int j=0; j<21; j++)
				{
					redwin=false;
					if(playerredx[j]!=0)
					{
						if(row == playerredx[j])
						{
							System.out.print( "\nfirst " + row +"\nsecond "+ playerredx[j]);
							check = check+1;
							System.out.print( "\nwin " + row);
						}
						
						if(check==4)
						{
							System.out.print("RedWin RedWin");
							j=22;
							row = 600;
							won=true;
						}
					}
				}
				row = row + 85;
			}while(column!= 655);
		}
	//	}
		
	}
}
