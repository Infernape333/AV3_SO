package SO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Directory {
    private String name;
    private Map<String, File> files;
    private Map<String, Directory> directories;

    public Directory(String name) {
        this.name = name;
        this.files = new HashMap<>();
        this.directories = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Directory getDirectory(String name) {
        return directories.get(name);
    }

    public void addFile(File file) {
        files.put(file.getName(), file);
    }

    public void removeFile(String name) {
        files.remove(name);
    }

    public void renameFile(String oldName, String newName) {
        File file = files.remove(oldName);
        if (file != null) {
            file.setName(newName);
            files.put(newName, file);
        }
    }

    public void addDirectory(Directory directory) {
        directories.put(directory.getName(), directory);
    }

    public void removeDirectory(String name) {
        directories.remove(name);
    }

    public void renameDirectory(String oldName, String newName) {
        Directory dir = directories.remove(oldName);
        if (dir != null) {
            dir.name = newName;
            directories.put(newName, dir);
        }
    }

    public List<String> listFiles() {
        List<String> list = new ArrayList<>(files.keySet());
        for (String dirName : directories.keySet()) {
            list.add(dirName + "/");
        }
        return list;
    }
}