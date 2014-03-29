import java.io.*;            //导入java的io包
import java.text.*;
import java.math.*;
class ReadFile{               //定义读取文件，转换，保存文件类
    public double[] readMatrix(){   //将读取的string 转换为 double数组
        String buff2= this.read();     //调用read方法
        String[] s1 = buff2.split(" ");    //采用空格分隔字符串 
        double[] w = new double[s1.length];
        for(int i =0;i < s1.length;i++){
            w[i] = Integer.parseInt(s1[i]);
        }
        return w;          //返回double类型数组w
    }
    public String read(){    //读取文件中的数据
        String buff = null;
        try{
            InputStream in = ReadFile.class.getResourceAsStream("transform.txt"); //调用inputsteam类
            InputStreamReader str  = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(str);
            buff = br.readLine();

        }catch(IOException ioe){
            ioe.getMessage();
        }
        return buff;      //返回得到的字符串
    }
    public void transform(double[] st) throws IOException{   //定义转换
        OutputStream output = new FileOutputStream("complete.txt");   //将数据输出到文件
        DecimalFormat df = new DecimalFormat("0.000000");    //设置保留的小数点位数
        byte[] byBuffer = new byte[1024];                    
        df.setRoundingMode(RoundingMode.HALF_UP);            //四舍五入操作
        double r = (st[0]*3600 + st[1]*60 + st[2])/206265;   //计算弧度
        String str = st[0] + "°" + st[1] + "'" + st[2] + "''" +"--->转换成弧度为 ：" + df.format(r);
        byBuffer = str.getBytes();                           //字符串转换为byte数组
        output.write(byBuffer);
        System.out.println("==============角度转弧度计算完成，请在complete中查看==========");
        output.close();                                     //关闭流
    }
}
public class Transform{ 
    public static void main(String[] args) throws IOException{
        ReadFile rf = new ReadFile();         //实例化ReadFile对象
        System.out.println("==============================================================");
        System.out.println("=请在transform.txt中输入要转换的角度,度 分 秒分别用空格代替**=");
        System.out.println("=度分秒分别用空格代替,格式如下:57°23'46''写成57 23 46然后保存=");
        System.out.println("=程序暂不支持一次转换多个角度请谨记,如果完成会显示弧度计算完成=");
        rf.transform(rf.readMatrix());         //调用transform方法
    }
}