package overtime.demo_68.main;

import java.io.File;
import java.util.Scanner;

public class ViduFile {
    File file;

    public ViduFile(String tenFile) {
        this.file = new File(tenFile);
    }

    public boolean kiemTraThucThi() {
        //Kieerm tra file có thể thc thi
        return this.file.canExecute();
    }

    public boolean kiemTraDoc() {
        //Kiểm tra file có thể dọc
        return this.file.canRead();
    }

    public boolean kiemTraGhi() {
        //Kiểm tra file có thể ghi
        return this.file.canWrite();
    }

    public void inDuongDan() {
        //In ra đường dẫn file
        System.out.println(this.file.getAbsolutePath());
    }

    public void inTen() {
        //In ra tên file
        System.out.println(this.file.getName());
    }

    public void kiemTraLaThuMucHoacTapTin() {
        //kiểm tra là thư mục hay file
        if (this.file.isDirectory()) {
            System.out.println("Dây là thư mục");
        } else if (this.file.isFile()) {
            System.out.println("Dây là File");
        }
    }

    public void inDanhSachCacFileCon() {
        //kiểm tra là thư mục hay file
        if (this.file.isDirectory()) {
            System.out.println("Các tập tin con/thư mục con là: ");
            File[] mangCon = this.file.listFiles();
            for (File file1 : mangCon) {
                System.out.println(file1.getAbsolutePath());
            }
        } else if (this.file.isFile()) {
            System.out.println("Dây là taajp tin, không có dữ liệu con bên trong");
        }
    }

    public void inCayThuMuc() {
        this.inChiTietCayThuMuc(this.file, 1);
    }

    public void inChiTietCayThuMuc(File f, int bac) {
        for (int i = 0; i < bac; i++) {
            System.out.print("\t");
        }
        System.out.print("|__");
        System.out.println(f.getName());
        if (f.canRead() && f.isDirectory()) {
            File[] mangCon = f.listFiles();
            for (File fx : mangCon) {
                inChiTietCayThuMuc(fx, bac + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int luaChon = 0;
        System.out.println("Nhập tên file: ");
        String tenFile = sc.nextLine();
        ViduFile vdf = new ViduFile(tenFile);
        do {
            System.out.println("MENU--------");
            System.out.println("1. Kiểm tra file có thể thực thi ");
            System.out.println("2. Kiểm tra file có thể đọc ");
            System.out.println("3. Kiểm tra file có thể ghi ");
            System.out.println("4. In Đường Dẫn: ");
            System.out.println("5. In tên file :  ");
            System.out.println("6. Kiểm tra file là thư mục hoặc tập tin  ");
            System.out.println("7. In ra danh sách cc file con: ");
            System.out.println("8. In ra cây thư mục: ");
            System.out.println("0. Thoát chương trình. ");
            System.out.println("Nhập lựa chọn");
            luaChon = Integer.parseInt(sc.nextLine());
            switch (luaChon) {
                case 1:
                    System.out.println(vdf.kiemTraThucThi());
                    break;
                case 2:
                    System.out.println(vdf.kiemTraDoc());
                    break;
                case 3:
                    System.out.println(vdf.kiemTraGhi());
                    break;
                case 4:
                    vdf.inDuongDan();
                    break;
                case 5:
                    vdf.inTen();
                    break;
                case 6:
                    vdf.kiemTraLaThuMucHoacTapTin();
                    break;
                case 7:
                    vdf.inDanhSachCacFileCon();
                    break;
                case 8:
                    vdf.inCayThuMuc();
                    break;
            }
            sc.nextLine();

        } while (luaChon != 0);
    }
}
