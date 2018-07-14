import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        copy("F:\\keep_trying","F:\\money.wmv",".wmv");
        System.out.print("结束");
    }

    public static void copy(String srcname,String target, String suffix) throws IOException {

        File srcFile = new File(srcname);

        File targetFile = new File(target);
        File[] files = srcFile.listFiles();
        if(files!=null){
            for (File file : files) {
                if (file.isFile() && file.getPath().endsWith(suffix)) {
                    FileInputStream fis = new FileInputStream(file);
                    File file2 = new File(targetFile,file.getName());
                    FileOutputStream fos = new FileOutputStream(file2);

                    byte[] bs = new byte[1024*8*1024];
                    int len ;
                    while((len=fis.read(bs))!=-1){
                        fos.write(bs,0,len);
                    }
                    fis.close();
                    fos.close();
                }else{
                    copy(file.getAbsolutePath(),target,suffix);
                }
            }

        }
    }
    }

