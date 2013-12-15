import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImageFromBAM {

	public String resultImagePath;
	public BufferedImage image;
	public BufferedImage confTIF;


	//HashMap <Integer, ArrayList<Integer>> conf = new HashMap <Integer, ArrayList<Integer>>();

	public ImageFromBAM (String path) {
		this.resultImagePath = path;
	}

	public void readImage() throws IOException {
		File f = new File(resultImagePath);
		image = ImageIO.read(f);
	}

	public void writeImage() throws IOException{
		ImageIO.write(image, "tif", new File(resultImagePath.replace(".tif", "_output.tif")));
	}

	public void readConf() throws IOException {
		String filepath = resultImagePath.replace(".tif", "_conf.tif");
		System.out.println(filepath);
		File f = new File(filepath);
		confTIF = ImageIO.read(f);	
	}

	/*
	public void readConf() throws Exception {
		String filepath = resultImagePath.replace(".tif", "_conf");
		System.out.println(filepath);

		Integer width, height;
        conf = new HashMap<Integer, ArrayList<Integer>>();
        BufferedReader bufferRead = new BufferedReader(new FileReader(filepath));
        String line;
        line = bufferRead.readLine();

        String[] tokens = line.split(" ");

        width = Integer.parseInt(tokens[0]);
        height = Integer.parseInt(tokens[1]);

        for (int i = 0; i < height; i++) {
        	ArrayList<Integer> currentLine = new ArrayList<Integer>();
        	line = bufferRead.readLine();
        	tokens = line.split(" ");
        	if (tokens.length != width) {
        		throw new Exception();
        	}
        	for (int j = 0; j < width; j++) {
        		currentLine.add(Integer.parseInt(tokens[j]));
        	}
        	conf.put(i, currentLine);
        }

        bufferRead.close();
	}
	 */

}
