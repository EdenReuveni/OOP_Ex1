package Ex1;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


import com.google.gson.*;

public class Functions_GUI implements functions{

	private ArrayList<function> colFunc;

	public Functions_GUI() {
		this.colFunc=new ArrayList<function>();
	}
	@Override
	public int size() {
		return colFunc.size();
	}

	@Override
	public boolean isEmpty() {
		return colFunc.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return colFunc.contains(o);
	}

	@Override
	public Iterator<function> iterator() {
		return colFunc.iterator();
	}

	@Override
	public Object[] toArray() {
		return colFunc.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return colFunc.toArray(a);
	}

	@Override
	public boolean add(function e) {
		if(!(""+e).contains("null"))
			return colFunc.add(e);
		return false;

	}

	@Override
	public boolean remove(Object o) {
		return colFunc.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return colFunc.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends function> c) {
		return colFunc.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return colFunc.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return colFunc.retainAll(c);
	}

	@Override
	public void clear() {
		colFunc.clear();		
	}
	
	/**
	 * Init a new collection of functions from a file
	 * @param file - the file name
	 * @throws IOException if the file does not exists of unreadable (wrong format)
	 */
	@Override
	public void initFromFile(String file) throws IOException {
		// TODO Auto-generated method stub
		{
			try 
			{
				FileInputStream fstream = new FileInputStream(file);
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String line = "";
				while ((line = br.readLine()) != null) {
					ComplexFunction f =new ComplexFunction(new Monom("0"));
					function fx;
					fx=	f.initFromString(line);
					if(!(""+fx).contains("null"))// check if the function is valid
						colFunc.add(fx);
				}
				br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				System.out.println("Error: " + e.getMessage());
			}

		}

	}
	/**
	 * 
	 * @param file - the file name
	 * @throws IOException if the file is not writable
	 */
	@Override
	public void saveToFile(String file) throws IOException {
		// TODO Auto-generated method stub
		String fileName = file;
		try 
		{
			PrintWriter pw = new PrintWriter(new File(fileName));
			StringBuilder sb = new StringBuilder();
			for (Iterator<function> iterator = colFunc.iterator(); iterator.hasNext();) {
				function function = (function) iterator.next();
				sb.append(function.toString()+"\n");
			}
			pw.write(sb.toString());
			pw.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}
	}
	/**
	 * Draws all the functions in the collection in a GUI window using the
	 * given parameters for the GUI windo and the range & resolution
	 * @param width - the width of the window - in pixels
	 * @param height - the height of the window - in pixels
	 * @param rx - the range of the horizontal axis
	 * @param ry - the range of the vertical axis
	 * @param resolution - the number of samples with in rx: the X_step = rx/resulution
	 */
	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		Color[] Colors = {Color.blue, Color.cyan, Color.MAGENTA, Color.ORANGE, 
				Color.red, Color.GREEN, Color.PINK};
		int n = resolution;
		StdDraw.setCanvasSize(width, height);
		int size = colFunc.size();
		double[] x = new double[n+1];
		double[][] yy = new double[size][n+1];
		double x_step = (rx.get_max()-rx.get_min())/n;
		double x0 = rx.get_min();
		for (int i=0; i<=n; i++) {
			x[i] = x0;
			for(int a=0;a<size;a++) {
				yy[a][i] = colFunc.get(a).f(x[i]);
			}
			x0+=x_step;	

		}
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());

		for(double xl=rx.get_min();xl<=rx.get_max();xl++) {
			StdDraw.setPenColor(Color.gray);
			StdDraw.setPenRadius(0.0005);
			StdDraw.line(xl,ry.get_max(), xl,ry.get_min());
			StdDraw.setPenColor(Color.black);
			String s=""+(int)xl;
			Font font= new Font("David", Font.BOLD,20);
			StdDraw.setFont(font);
			StdDraw.text(xl,-0.4 ,s);
		}

		for(double yl=ry.get_min();yl<=ry.get_max();yl++) {
			StdDraw.setPenColor(Color.gray);
			StdDraw.setPenRadius(0.0005);
			StdDraw.line(rx.get_min(),yl,rx.get_max(),yl);
			StdDraw.setPenColor(Color.black);
			String s=""+(int)yl;
			StdDraw.text(-0.4,yl ,s);
		}
		//draw x axis and y axis
		StdDraw.setPenColor(Color.black);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(rx.get_min(),0, rx.get_max(),0);
		StdDraw.line(0,ry.get_min(), 0,ry.get_max());

		// plot the approximation to the function
		for(int a=0;a<size;a++) {
			int c = a%Colors.length;
			StdDraw.setPenRadius(0.004);
			StdDraw.setPenColor(Colors[c]);
			System.out.println(a+") "+Colors[c]+"  f(x)= "+colFunc.get(a));
			for (int i = 0; i < n; i++) {
				StdDraw.line(x[i], yy[a][i], x[i+1], yy[a][i+1]);
			}
		}
	}
	/**
	 * Draw Function with default parameters.
	 */
	public void drawFunctions() {
		this.drawFunctions(1000, 600, new Range(-10,10), new Range (-5,15), 200);
	}
	/**
	 * Draws all the functions in the collection in a GUI window using the given JSON file
	 * @param json_file - the file with all the parameters for the GUI window. 
	 * Note: is the file id not readable or in wrong format should use default values. 
	 */
	@Override
	public void drawFunctions(String json_file) {
		Gson gson = new Gson();			
		try 
		{
			//Option 2: from JSON file to Object
			FileReader reader = new FileReader(json_file);
			Parameters par = gson.fromJson(reader,Parameters.class);
			this.drawFunctions(par.getWidth(),par.getHeight(),new Range(par.Range_X[0],par.Range_X[1]),new Range(par.Range_Y[0],par.Range_Y[1]),par.getResolution());
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
