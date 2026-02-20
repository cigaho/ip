package freddy.storage;

import freddy.Freddy;
import freddy.task.Task;
import freddy.task.Todo;
import freddy.task.Deadline;
import freddy.task.Event;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Storage {
    private final static String path = "data/Freddy.txt";
    private final Path data;

    public Storage() {
        this.data = choosePath();
        ensureDirectoryExists();
    }

    private Path choosePath() {
        String jarDir = getJarDirectory();
        Path jarDataPath = Paths.get(jarDir, "data", "Freddy.txt");
        if (Files.exists(jarDataPath)) {
            return jarDataPath;
        }

        Path currentDataPath = Paths.get("data", "Freddy.txt");
        return currentDataPath;
    }


    private String getJarDirectory() {
        try {
            String classPath = Storage.class.getProtectionDomain()
                    .getCodeSource().getLocation().toURI().getPath();

            if (classPath.startsWith("/")) {
                classPath = classPath.substring(1);
            }

            File classFile = new File(classPath);

            if (classFile.isFile() && classPath.toLowerCase().endsWith(".jar")) {
                return classFile.getParent();
            } else {
                return System.getProperty("user.dir");
            }
        } catch (Exception e) {
            return System.getProperty("user.dir");
        }
    }


    private void ensureDirectoryExists() {
        try {
            Path parent = data.getParent();
            if (parent != null && !Files.exists(parent)) {
                Files.createDirectories(parent);
            }
        } catch (IOException e) {
            System.err.println("Freddy: Oops, data file can't be properly created.");
        }
    }

    public void writeAll(ArrayList<Task> tasks){
        ArrayList<String> lines = new ArrayList<>();
        for (Task t: tasks){
            lines.add(t.write_detail());
        }
        try {
            Files.write(data, lines);
        } catch (IOException e) {
            System.err.println("Error occurs when writing into file: " + e.getMessage());
        }

    }


    public ArrayList<Task> readAll(){
        ArrayList<Task> temp = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(data);
            for (String line : lines) {
                String[] results = line.split(" \\| ");
                boolean done = results[1].equals("1");
                switch (results[0]){
                case "T":
                    Todo td = new Todo(results[2], done);
                    temp.add(td);
                    break;
                case "D":
                    temp.add(new Deadline(results[2],results[3], done));
                    break;
                case "E":
                    temp.add(new Event(results[2],results[3],results[4],done));
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("You don't have a record yet, you must be new here!");
            System.out.println(Freddy.reply+" Please start your sentence with commands.");
            System.out.println(Freddy.reply+"Commands avaiable: list, mark, unmark, todo, event, deadline, bye");
            Freddy.ui.printline();
        }
        return temp;
    }

}
