package overtime.demo_67;

import java.io.File;
import java.io.IOException;

public class ViDuTaoTapTinVaThuMuc {
    public static void main(String[] args) {
        File folder1 = new File("src/overtime/demo_67");
        System.out.println("Kiểm tra folder1 có tồn tại hay không : " + folder1.exists());
        // Tạo thư mục
        //Phương Thức mkdir()
        File d1 = new File("src/overtime/demo_67/Directory_1");
        d1.mkdir();

        //Phương thức mkdirs() => tạo nhiều thư mục cùng lúc
        File d2 = new File("src/overtime/demo_67/Directory_1/Directory_2/Directory_3/Directory_4/Directory_5");
        d2.mkdirs();

        //Tạo tập tin( có phần mở rộng: .exe, .txt, .doc, .xls ...)

        File file1 = new File("src/overtime/demo_67/Directory_1/Vidu1.txt");
        try {
            file1.createNewFile();
        } catch (IOException e) {
            // không có quyền tạo tập tin
            // ổ cứng bị đầy
            // đường dẫn bị sai
            e.printStackTrace();
        }
    }
}
