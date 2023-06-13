import java.io.*;
import java.util.List;

public class Main {
    // Создание статического СтрингБилдера нежелательно, но по условиям задания мы не можем передавать его в приватный метод.
    private static final StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {


        String basePath = "C:\\learning\\IdeaProjects\\HomeWorks\\Games\\";

        List<String> directories = List.of(basePath + "src", basePath + "res", basePath + "res\\drawables", basePath + "res\\vectors",
                basePath + "res\\icons", basePath + "res\\icons", basePath + "res\\icons", basePath + "savegames", basePath + "temp",
                basePath + "src\\test", basePath + "src\\main");
        directories.forEach(path -> saveDirectory(path));


        createFile(basePath + "src\\main", "Main.java");
        createFile(basePath + "src\\main", "Utils.java");
        createFile(basePath + "temp", "temp.txt");

        String log = builder.toString();

        try (FileWriter writer = new FileWriter("C:\\learning\\IdeaProjects\\HomeWorks\\Games\\temp\\temp.txt")) {
            writer.write(log);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static void saveDirectory(String path) {
        File dir = new File(path);
        if (dir.mkdir())
            builder.append("The directory ").append(path).append(" has been created\n");
        else {
            builder.append("The directory ").append(path).append(" was not created\n");
        }
    }

    private static void createFile(String path, String fileName) {
        File file = new File(path, fileName);
        try {
            if (file.createNewFile()) {
                builder.append("The file ").append(path).append("\\").append(fileName).append(" has been created\n");
            } else {
                builder.append("The file ").append(path).append("\\").append(fileName).append(" was not created\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
