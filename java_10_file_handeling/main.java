import java.io.*;

public class main {
    public static void main(String[] args) {
        System.out.println("\n------- File Handeling ----------\n");
        // Q1();
        // Q2();
        // Q3(args);
        // Q4();
        // Q5(args);
        // Q6();
        // Q7(args);
        Q8();
    }

    public static void Q1() {
        System.out.println("1. Write a program to copy contents of one file to another file.");
        String srcFile = "src.txt";
        String desFile = "des.txt";

        try {
            // io
            FileInputStream fin = new FileInputStream(srcFile);
            FileOutputStream fout = new FileOutputStream(desFile);
            // buffer
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fin.read(buffer)) != -1) {
                fout.write(buffer, 0, bytesRead);
            }
            fin.close();
            fout.close();
            System.out.println("file copied sucessfully");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

    }

    public static void Q2() {
        String filename = "writeBytesOP.txt";
        byte[] bytesToWrite = { 65, 66, 67, 65 + 32 };// A B C a
        try {
            FileOutputStream fo = new FileOutputStream(filename);
            fo.write(bytesToWrite);
            fo.close();
            System.out.println("Sucessfully written to file");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void Q3(String[] args) {
        System.out.println("3. Develop a program to display contents of file supplied as command line\r\n" + //
                "argument.");
        if (args.length != 1) {
            System.err.println(
                    "Usage of this program is this way:->   java main(enable Q3) <filename>");
            System.exit(1);
        }
        String filename = args[0];
        try {
            FileReader fin = new FileReader(filename);
            BufferedReader BR = new BufferedReader(fin);
            String line;
            while ((line = BR.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }

    public static void Q4() {
        String fileName = "src.txt"; // Specify the file name
        int startIndex = 10; // Starting index from where to read the file
        int bytesToSkip = 20; // Number of bytes to skip

        try {
            FileInputStream fis = new FileInputStream(fileName);
            // Skip the specified number of bytes
            long skippedBytes = fis.skip(bytesToSkip);
            if (skippedBytes != bytesToSkip) {
                System.err.println("Failed to skip specified number of bytes.");
                return;
            }
            // Read the file starting from the specified index
            byte[] buffer = new byte[1024];
            int totalBytesRead = 0;
            int bytesRead;

            // Read and display the contents from the specified index
            while ((bytesRead = fis.read(buffer, totalBytesRead, buffer.length - totalBytesRead)) != -1) {
                totalBytesRead += bytesRead;
                if (totalBytesRead >= startIndex) {
                    System.out.println("Contents of the file from index " + startIndex + " onwards:");
                    System.out.println(new String(buffer, startIndex, totalBytesRead - startIndex));
                    break;
                }
            }
            fis.close();
        } catch (IOException e) {
            System.err.println("Error occurred while reading the file: " + e.getMessage());
        }
    }

    public static void Q5(String[] args) {
        System.out.println("enter text to append as command line argument");
        if (args.length != 1) {
            System.err.println(
                    "Usage of this program is this way:->   java main(enable Q5) <text to add>");
            System.exit(1);
        }
        String textToappend = args[0];
        String filename = "des.txt";
        try {
            FileWriter fw = new FileWriter(filename, true);
            fw.write(textToappend);
            fw.close();
            System.out.println("Sucess");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void Q6() {
        System.out.println("6. Write Java program to read a file line by line.");
        String filename = "des.txt";
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int lineNo = 1;
            while ((line = br.readLine()) != null) {
                System.out.println("line" + lineNo + " : " + line);
                lineNo++;
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void Q7(String args[]) {
        System.out.println("7. Write Java program to delete a file.");
        if (args.length != 1) {
            System.err.println(
                    "Usage of this program is this way:->   java main(enable Q5) <text to add>");
            System.exit(1);
        }
        String filename = args[0];
        File file = new File(filename);
        try {
            if (file.exists()) {
                if (file.delete()) {
                    System.out.println("Sucess");
                } else {
                    System.out.println("failed to delete");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void Q8() {
        String fileName = "sample.txt"; // Change this to your file's name

        File file = new File(fileName);

        if (file.exists()) {
            System.out.println("File Name: " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("File Size: " + file.length() + " bytes");
            System.out.println("Last Modified: " + file.lastModified());
        } else {
            System.err.println("File does not exist.");
        }
    }
}