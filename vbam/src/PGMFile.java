import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class PGMFile {

        public Integer width = null, height = null;
        HashMap<Integer, ArrayList<Integer>> data = new HashMap<Integer, ArrayList<Integer>>();

        void readFile(String filepath) throws Exception {
                String line;
                Integer width, height;
                HashMap<Integer, ArrayList<Integer>> data = new HashMap<Integer, ArrayList<Integer>>();
                BufferedReader bufferRead = new BufferedReader(new FileReader(filepath));
                do {
                        line = bufferRead.readLine();
                } while (line.startsWith("#"));
                if (!line.contains("P5")) {
                        bufferRead.close();
                        return;
                }
                do {
                        line = bufferRead.readLine(); // should be max value
                } while (line.startsWith("#"));
                String[] tokens = line.split(" ");
                do {
                        bufferRead.readLine(); // should be width and height
                } while (line.startsWith("#"));
                width = Integer.parseInt(tokens[0]);
                height = Integer.parseInt(tokens[1]);
                for (int i = 0; i < height; i++) {
                        ArrayList<Integer> currentLine = new ArrayList<Integer>();
                        for (int j = 0; j < width; j++) {
                                String ln = bufferRead.readLine();
                                if (ln.startsWith("#")) {
                                        j--;
                                        continue;
                                }
                                Integer elem = Integer.parseInt(ln);
                                currentLine.add(elem);
                        }
                        data.put(i, currentLine);
                }
                bufferRead.close();

                this.data = data;
                this.width = width;
                this.height = height;
        }

        void writeResult(String resultpath) throws Exception {
                File file = new File(resultpath);
                if (!file.exists()) {
                        file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("P2\n");
                bw.write(width + " " + height + "\n");
                bw.write("255\n");
                Set<Integer> keys = data.keySet();
                ArrayList<Integer> sorted = new ArrayList<Integer>();
                sorted.addAll(keys);
                Collections.sort(sorted);
                for (Integer i : sorted) {
                        ArrayList<Integer> values = data.get(i);
                        for (Integer value : values) {
                                bw.write(value + "\n");
                        }
                }
                bw.close();
        }


}
