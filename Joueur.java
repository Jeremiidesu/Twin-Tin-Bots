public class Joueur
{
	private int[] pos;
	private int dir;

	public Joueur(int ligne, int colonne, int dir)
	{
		this.pos = {ligne, colonne};
		this.dir = dir;
	}

	public char getDir() {return dir;}
	public int[] getPos() {return pos;}

	public void chargeDir(int dir) {this.dir = (this.dir + dir) % Plateau.tabDir.length;}
}
