package ttb.metier;

/**
 * Classe Robot
 * @version 2019-06-18
 */

public class Robot
{
	private static int nbRobots = 0;
	private int[]  pos;
	/** Direction du robot, commence à 0 et va jusqu'à 5, sens horaire */
	private int    dir;
	private int    id;
	private Joueur monJoueur;
	private Tuile crystal;

	public Robot(int ligne, int colonne, int dir)
	{
		this.pos = new int[] {ligne, colonne};
		this.dir = dir;
		this.id  = Robot.nbRobots++ % 2;
	}

	public int      getDir()    { return dir; }
	public int[]    getPos()    { return pos; }
	public int      getId()     { return id ; }
	public Joueur   getJoueur() { return this.monJoueur; }

	public boolean hasCristal()
	{
		return crystal != null;
	}

	public boolean chargerCrystal(Tuile c)
	{
		if(crystal != null)
		{
			return false;
		}

		crystal = c;
		return true;
	}

	public Tuile deposerCrystal()
	{
		Tuile c = crystal;
		crystal = null;
		return c;
	}

	public Tuile getCristal() { return crystal; }

	public void setJoueur(Joueur j) {monJoueur = j;}

	public void setPos(int[] pos) {this.pos = pos;}

	public void turnAround(boolean left)
	{
		if(left)
			dir = Math.floorMod((dir - 1), 6);
		else
			dir = (dir+1) % 6;
	}

	public void setDir(int dir) {this.dir = dir;}

	public String getCouleur()
	{
		return this.monJoueur.getCouleur();
	}
}
