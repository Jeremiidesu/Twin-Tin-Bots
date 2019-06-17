import java.util.Arrays;

public class Plateau
{
	private final int NB_LIGNES;
	private final int NB_COLONNES;
	private String[][] plateau;
	private Joueur[]   tabJoueurs;

	public Plateau(int nbJoueurs)
	{
		NB_LIGNES   = 9 + nbJoueurs > 4?2:0;
		NB_COLONNES = NB_LIGNES;

		int nbCasesVoulu = plateau.length/2;
		int aRemplir;
		for (int i=0; i<plateau.length; i++)
		{
			aRemplir = plateau.length-nbCasesVoulu;
			if (i < plateau.length/2+1)
				nbCasesVoulu++;
			else {
				aRemplir+=2;
				nbCasesVoulu--;
			}
			for (int j=aRemplir/2; j<aRemplir/2+nbCasesVoulu; j++)
			{
				plateau[i][j] = "T"; // Tuile vide
			}
		}
	}

	public boolean isNextFree(Robot r, int dir)
	{
		int[] pos = joueur.getPos();
		pos = nextPos(pos, dir);
		return isFree(pos);
	}

	public Robot isFree(int[] pos)
	{
		for(Joueur j : tabJoueurs)
		{
			for(Robot r : j.getRobots())
			{
				if(r.getPos() == pos)
					return r;
			}
		}

		return null;
	}

	private int[] nextPos(int[] initPos, int dir)
	{
		int[] pos = Arrays.copyOf(initPos, initPos.length);
		switch(dir)
		{
			case 1 :
				if(pos[0] % 2 == 0)
				{
					pos[0]--;
					pos[1]--;
				}
				else
				{
					pos[0]--;
				}
				break;
			case 2 :
				if(pos[0] % 2 == 0)
				{
					pos[0]--;
				}
				else
				{
					pos[0]--;
					pos[1]++;
				}
				break;
			case 3 :
				pos[1]++;
				break;
			case 4 :
				if(pos[0] % 2 == 0)
				{
					pos[0]++;
				}
				else
				{
					pos[0]++;
					pos[1]++;
				}
				break;
			case 5 :
				if(pos[0] % 2 == 0)
				{
					pos[0]++;
					pos[1]--;
				}
				else
				{
					pos[0]--;
				}
				break;
			case 6 :
				pos[1]--;
				break;

		}

		if(pos[0] < 0 || pos[0] >= plateau.length ||
		   pos[1] < 0 || pos[1] >= plateau.length ||
		   plateau[pos[0]][pos[1]] == null
		  )
		  	return initPos;

		return pos;
	}

	public boolean avancer(Robot r, boolean canPush)
	{
		int[] pos = nextPos(r.getPos(), r.getDir());
		if(pos == r.getPos())
			return false;

		Robot nextHex = isFree(pos);
		if(isFree(pos) == null || (canPush && avancer(nextHex, false)))
		{
			r.setPos(pos);
			return true;
		}

		return false;
	}

	public String toString()
	{
		String retour = "";
		for (int i=0; i<plateau.length; i++)
		{
			//if (i%2!=0)
			//	System.out.print("  ");
			for (int j=0; j<plateau[i].length; j++)
			{	
				retour += "  "+plateau[i][j] + " ";
			}
			retour += "\n";
		}
		return retour;
	}
}
