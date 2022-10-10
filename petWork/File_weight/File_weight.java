import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class File_weight {
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("¬ведите путь к папке");
            Scanner sc = new Scanner(System.in);
            String path = sc.nextLine();
            Path directory = Paths.get(path);
            List<Integer> list = new ArrayList<>();
            Files.walk(directory).map(Path::toFile).filter(File::isFile).forEach(file -> list.add((int) file.length()));
            int a = 0;
            list.stream().sequential().reduce(Integer::sum).ifPresent(integer -> {
                int i = a + integer;
                String string = "";
                int s = 0;
                while (i > 1024) {
                    i = i / 1024;
                    s++;
                }
                if (s == 0) {
                    string = "байт";
                }
                if (s == 1) {
                    string = "килобaйт";
                }
                if (s == 2) {
                    string = "мегабaйт";
                }
                if (s == 3) {
                    string = "гигабaйт";
                }
                System.out.println(i + " " + string);
            });
        }catch (Exception e){
            System.out.println("stack trace");
        }
    }
}

