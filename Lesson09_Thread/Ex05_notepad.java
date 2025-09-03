/*Mô tả: viết một chương trình Java để mở file .txt bằng Notepad hoặc trình soạn thảo mặc định của hệ điều hành, sử dụng các kỹ thuật khác nhau: Runtime.exec(), ProcessBuilder, và Desktop.open().
Các phương thức:
- useDeprecate() – dùng Runtime.exec() (cũ, dễ lỗi).
- useUpdate() – dùng ProcessBuilder (tốt hơn).
- useDefaultEditor() – dùng Desktop.getDesktop().open(...) (chuẩn hiện đại).

 */
package session03_thread;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Ex05_notepad {

    //1.tạo đối tượng file trong thư mục hiện hành
    String bash = "notepad src/session03_thread/zEx05.txt";
    File file = new File(bash);

    //2.dùng Deprecate()method
    void useDeprecate() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(bash);
        try {
            Thread.sleep(1000);
            JOptionPane.showMessageDialog(null, "Look funny?");
        } catch (Exception e) {
        }
    }

    //3.update()method
    void useUpdate() throws IOException {
        String bash = "notepad";
        String para = "src/session03_thread/zEx05.txt";
        ProcessBuilder builder = new ProcessBuilder(bash, para);

        try {
            builder.start();
            Thread.sleep(1000);
            JOptionPane.showMessageDialog(null, "Look not funny?");
        } catch (Exception e) {
        }
    }

    //4.defaultEditor()method
    void useDefaultEditor() throws IOException {
        if (!file.exists()) {
            System.out.println("File không tồn tại: " + file.getPath());
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
            Thread.sleep(1000);
            JOptionPane.showMessageDialog(null, "The end...");
        } catch (InterruptedException | IOException e) {
            System.err.println(e.toString());
        }
    }

    //5.main()method
    public static void main(String[] args) throws IOException {
        var ex05 = new Ex05_notepad();
//        ex05.useDeprecate();
//        ex05.useUpdate();
        ex05.useDefaultEditor();
    }
}
