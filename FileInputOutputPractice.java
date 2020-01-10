
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
public class FileInputOutputPractice {

     public static void main(String[] args) {
//        Scanner key = new Scanner(System.in);C:\Users\intel\Desktop\
//        String inputPath;
//        inputPath = key.nextLine();
        IoPractice op = new IoPractice();
       Path fullpath = op.createPath("C:\\Users\\intel\\Desktop\\dEVIL\\my.java");
         
         try {
             //op.createFile(fullpath,"My.java");
             //  op.createFolder("raja");
             //  System.out.println(fullpath.toString());
             //    op.deletFile(fullpath);
             //  try {
             //  BasicFileAttributes fAtt = Files.readAttributes(fullpath,BasicFileAttributes.class);
             // } catch (IOException ex) {
             //    Logger.getLogger(FileInputOutputPractice.class.getName()).log(Level.SEVERE, null, ex);
             // }
             System.out.println(Files.readAllLines(fullpath));
         } catch (IOException ex) {
             System.out.println("Something went wrong ");
         }

    }
}

 class IoPractice {

    public Path createPath(String s) {
        Path p = Paths.get(s);
        return p;
    }

    public Path createPath() {
        Path fullpath = Paths.get("C:\\Users\\intel\\Desktop\\dEVIL\\my.javas");
        return fullpath;
    }

    public void createFile(Path s, String fileName) {
        Path p = Paths.get(s.toString(), fileName);
        try {
            Files.createFile(p);
//            Files.cr
            System.out.println("File created on location " + s.toString() + "File name is " + p.getFileName());
        } catch (IOException e) {
            System.out.println("Something went wrong ....");
        }

    }

    public void checkAcceess(Path p) {
        try {
            p.getFileSystem().provider().checkAccess(p, AccessMode.READ);
            System.out.println("file has the access to read");
        } catch (IOException e) {
            e.getMessage();
            System.out.println("Programme have not");
        }
    }

    public void delay() {
        for (int i = 0; i < 100000; i++) {
            System.out.print("-");
        }
    }

    public void deletFile(Path p) {
        try {
            Files.delete(p);
            System.out.println("file " + p.getFileName() + " was delete on Path " + p.toString());

        } catch (IOException e) {
            e.getMessage();
            System.out.println(" SomeThing went wrong ");
        }
        System.out.println(p.toString());
    }

    public void createFolder(String p) {
        Path newP = Paths.get("C:\\Users\\intel\\Desktop\\dEVIL", p);
        try {
            Path s = Files.createDirectory(newP);
            System.out.println("Folder is created on location  " + newP);
        } catch (IOException e) {
            System.out.println("Somthing went wrong");

        }

    }

    public void isExsist(Path fullpath) {
        try {
            fullpath.getFileSystem().provider().checkAccess(fullpath);
            System.out.println("File is exist");
        } catch (IOException ex) {
            // Logger.getLogger(FileInputOutputPractice.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("file does not exisr here"
                    + "Program is countinue here");
        }
    }
    public void infoFile(Path p){
        try {
             BasicFileAttributes fAtt = Files.readAttributes(p,BasicFileAttributes.class);
             System.out.println(fAtt.lastAccessTime()+"Last modified time ");
             System.out.println(fAtt.creationTime()+"Create time ");
             System.out.println(fAtt.size()/1024 +" Kb");
             } catch (IOException ex) {
            // Logger.getLogger(FileInputOutputPractice.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Somthing went wrong");
         }
         
    }
    public void writeInFile(Path p,String S,StandardOpenOption op){
        byte[] s = S.getBytes();
        OutputStream output=null;
        try{
            output = new BufferedOutputStream(Files.newOutputStream(p,op));
            output.write(s);
            output.flush();
            output.close();
        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }
    }
    
}

