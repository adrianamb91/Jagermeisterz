import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length != 6) {
			System.out.println("Wrong arguments!");
			return;
		}
		
		int timeout = Integer.parseInt(args[0]);
		int iniTimeout = Integer.parseInt(args[1]);
		
		String execDirName = args[2];
		String imgFilename = args[3];
		String BAMresultDir = args[4];
		
		String resultImgFilename = args[5];
		
		File execDir = new File(execDirName);
		ArrayList<String> names = new ArrayList<String>(Arrays.asList(execDir.list()));
		
		for (int i = 0; i < names.size(); i++) {
			//System.out.println(names.get(i));
			if (names.get(i).endsWith(".exe")) {
				String execName = execDirName + "\\" + names.get(i);
				System.out.println("We should run this one: " + execName);
				try {
					String params[] = {execName, imgFilename};
					System.out.println(execName + " " + imgFilename);
					Process p;
					//ProcessBuilder pb = new ProcessBuilder(names.get(i), imgFilename);
					//pb.directory(execDir);
					//p = pb.start();
					
					
					p = Runtime.getRuntime().exec(params);
					//Process process = new ProcessBuilder(execName, imgFilename).start();
					
//					InputStream is = process.getInputStream();
//					InputStreamReader isr = new InputStreamReader(is);
//					BufferedReader br = new BufferedReader(isr);
//					String line;
//
//					System.out.printf("Output of running %s is:", Arrays.toString(args));
//
//					while ((line = br.readLine()) != null) {
//					  System.out.println(line);
//					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}

}
