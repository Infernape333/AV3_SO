package SO;

import java.util.ArrayList;
import java.util.List;

class FileSystemSimulator {
    private Directory root;
    private Journal journal;

    public FileSystemSimulator() {
        this.root = new Directory("root");
        this.journal = new Journal();
    }

    public void createFile(String path, String name) {
        journal.log("CREATE_FILE", path + "/" + name);
        Directory dir = findDirectory(path);
        if (dir != null) {
            dir.addFile(new File(name));
        }
    }

    public void deleteFile(String path, String name) {
        journal.log("DELETE_FILE", path + "/" + name);
        Directory dir = findDirectory(path);
        if (dir != null) {
            dir.removeFile(name);
        }
    }

    public void renameFile(String path, String oldName, String newName) {
        journal.log("RENAME_FILE", path + "/" + oldName + " TO " + newName);
        Directory dir = findDirectory(path);
        if (dir != null) {
            dir.renameFile(oldName, newName);
        }
    }

    public void createDirectory(String path, String name) {
        journal.log("CREATE_DIR", path + "/" + name);
        Directory dir = findDirectory(path);
        if (dir != null) {
            dir.addDirectory(new Directory(name));
        }
    }

    public void deleteDirectory(String path, String name) {
        journal.log("DELETE_DIR", path + "/" + name);
        Directory dir = findDirectory(path);
        if (dir != null) {
            dir.removeDirectory(name);
        }
    }

    public void renameDirectory(String path, String oldName, String newName) {
        journal.log("RENAME_DIR", path + "/" + oldName + " TO " + newName);
        Directory dir = findDirectory(path);
        if (dir != null) {
            dir.renameDirectory(oldName, newName);
        }
    }

    public List<String> listFiles(String path) {
        Directory dir = findDirectory(path);
        if (dir != null) {
            return dir.listFiles();
        }
        return new ArrayList<>();
    }

    private Directory findDirectory(String path) {
        String[] parts = path.split("/");
        Directory current = root;
        for (String part : parts) {
            if (part.isEmpty()) continue;
            current = current.getDirectory(part);
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public List<String> getJournal() {
        return journal.getLog();
    }
}