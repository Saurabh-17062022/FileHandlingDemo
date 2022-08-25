import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class DetailsClass {
    public static void main(String[] args) {
        DetailsClass detailsClass = new DetailsClass();
        String detailsFile = "resource/output.txt";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter mobile Number");
        String mobileNumber = scanner.nextLine();
        System.out.println("Enter EmailId");
        String emailId = scanner.nextLine();
        System.out.println("Enter address");
        String address = scanner.nextLine();
        detailsClass.writeFile(name, mobileNumber, emailId, address, detailsFile);
        String fileData = detailsClass.readFile("resource/output.txt");
        System.out.println("fileData = " + fileData);
    }

    public void writeFile(String name, String mobileNumber, String emailId, String address, String detailsFile) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(detailsFile);
            fileOutputStream.write(name.getBytes());
            fileOutputStream.write('\n');
            fileOutputStream.write(mobileNumber.getBytes());
            fileOutputStream.write('\n');
            fileOutputStream.write(emailId.getBytes());
            fileOutputStream.write('\n');
            fileOutputStream.write(address.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public String readFile(String output) {
        String response = "";
        FileInputStream fileInputStream = null;
        int count = 0;
        try {
            fileInputStream = new FileInputStream(output);
            int data;
            do {
                data = fileInputStream.read();
                char readData = (char) data;
                response = response + readData;
                count++;
            } while (data != -1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        System.out.println("count = " + count);
        return response;
    }
}