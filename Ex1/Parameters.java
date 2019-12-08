package Ex1;

public class Parameters {
	private int width;
	private int height; 
	public double[] rx;
	public double[] ry;
	private int resolution;

	public Parameters() {

		this.rx = new double[2];
		this.ry = new double[2];
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
		this.width = width;
		this.height = height;
		this.rx = rx;
		this.ry = ry;
		this.resolution = resolution;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getResolution() {
		return resolution;
	}

}
