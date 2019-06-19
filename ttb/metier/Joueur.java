package ttb.metier;

import java.awt.Color;

public class Joueur
{
	public  final static Color[] COULEURS = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.PINK};
	private static int nbJoueurs = 0;
	private int id;
	private Robot[] tabRobot;
	private int[] posBase;
	private int points;

	public Joueur()
	{
		id = Joueur.nbJoueurs++;
		this.tabRobot = new Robot[] {null, null};
		this.points = 0;
	}

	public Robot[] getRobots() {return this.tabRobot;}

	public Robot getRobot(int id) {return tabRobot[id];}

	public void ajouterRobot(Robot r)
	{
		if(tabRobot[0] == null)
		{
			this.tabRobot[0] = r;
			r.setJoueur(this);
			return;
		}
		if(tabRobot[1] == null)
		{
			r.setJoueur(this);
			this.tabRobot[1] = r;
		}
	}

	public int getId() {return id;}

	public Robot getRobotParPos(int[] pos)
	{
		for(Robot r : tabRobot)
			if(pos[0] == r.getPos()[0] && pos[1] == r.getPos()[1])
				return r;

		return null;
	}

	public void addPoint() {points++;}

	public int[] getBase() {return this.posBase;}

	public void setBase(int[] pos)
	{
		if(posBase == null)
			this.posBase = pos;
	}
}