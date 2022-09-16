import java.io.*;
import java.util.*;

public class replaceTheString {

    Scanner input = new Scanner(System.in);

    public void replaceStringFromSourceToTarget(String sourceFileName, String targetFileName,
                                                String oldString, String newString) throws FileNotFoundException {


        System.out.println("Replace string from source to target!");
        System.out.println("Source file name: ");
        sourceFileName = input.nextLine();
        File sourceFile = new File(sourceFileName);
        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist!");
            return;
        }

        System.out.println("Target file name: ");
        targetFileName = input.nextLine();
        File targetFile = new File(targetFileName);
        if (targetFile.exists()) {
            System.out.println("Target file already exists");
            return;
        }
        try (
                Scanner in = new Scanner(sourceFile);
                PrintWriter output = new PrintWriter(targetFile);
        ) {
            while (in.hasNext()) {
                String s1 = in.nextLine();
                String s2 = s1.replaceAll(oldString, newString);
                output.println(s2);
            }
        }
        return;

    }

    //}
    public static void main(String[] args) {
        replaceTheString obj = new replaceTheString();
        try {
            obj.replaceStringFromSourceToTarget
                    ("OldFile", "NewFile", "My", "Her");
            System.out.println("String successfully replaced!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

