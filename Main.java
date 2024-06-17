package SO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileSystemSimulator fs = new FileSystemSimulator();

        fs.createDirectory("/", "dir1");
        fs.createFile("/dir1", "file1.txt");
        fs.renameFile("/dir1", "file1.txt", "file2.txt");
        fs.createDirectory("/", "dir2");
        fs.renameDirectory("/", "dir2", "dir3");
        fs.deleteFile("/dir1", "file2.txt");
        fs.deleteDirectory("/", "dir3");

        List<String> files = fs.listFiles("/");
        for (String file : files) {
            System.out.println(file);
        }

        System.out.println("Journal:");
        for (String entry : fs.getJournal()) {
            System.out.println(entry);
        }
    }
}