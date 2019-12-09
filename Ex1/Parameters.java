package Ex1;

public class Parameters {
	private int Width;
	private int Height; 
	public double[] Range_X;
	public double[] Range_Y;
	private int Resolution;

	public Parameters() {

		this.Range_X = new double[2];
		this.Range_Y = new double[2];
	}
	/**
	 * constructor
	 * @param width
	 * @param height
	 * @param rx
	 * @param ry
	 * @param resolution
	 */
	public Parameters(int width, int height, double[] rx, double[] ry, int resolution) {
		super();
		this.Width = width;
		this.Height = height;
		this.Range_X = rx;
		this.Range_Y = ry;
		this.Resolution = resolution;
	}
	public int getWidth() {
		return Width;
	}
	public int getHeight() {
		return Height;
	}
	public int getResolution() {
		return Resolution;
	}

}
