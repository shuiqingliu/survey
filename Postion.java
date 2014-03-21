import java.util.Scanner; //导入Scanner类
class Test{               //定义计算类
	public double x1;     //定义坐标变量
	public double y1;
	public double x2;
	public double y2;
	public double r;
	public double s;
	public double d;
	public int e;
	public double a;
	public int b;
	public double c;
	public int h;
	public void calculate(){   //定义计算方法
		if(x2 - x1 > 0 && y2-y1 >0){     //判断x,y的坐标增量
			getInfo();
			s = r;
			change(s);
		}else if(x2-x1<0 &&  y2-y1>0){
			getInfo();
			s = r + 180;
			change(s);

		}else if(x2-x1 <0 && y2-y1 <0){
			getInfo();
			s = r+ 180;
			change(s);
		}else if (x2-x1 >0 && y2-y1 <0){
			getInfo();
			s = r + 360;
			change(s);
		}
		if(x2-x1 >0 && y2-y1 ==0){   //判断是否位于坐标轴上
			s = 0;
			change(s);
		}else if (x2-x1 == 0 && y2-y1 >0){
			s = 90;
			change(s);

		}else if (x2-x1 <0 && y2-y1 ==0){
			s = 180;
			change(s);

		}else if (x2-x1 == 0 && y2-y1 <0){
			s =270;
			change(s);

		}
		System.out.println("坐标方位角是：" + e + "°" +  b + "'" + h + "''");
	}
	public double getInfo(){   //定义计算R的方法
		r = Math.atan((y2-y1)/(x2-x1)) *206265/3600;
		return this.r;
	}
	public void change(double d){   //将度数转换为度分秒
		e =(int)Math.floor(d);
		a = (d - e) * 60;
		b = (int)Math.floor(a);
		c = (a - b) * 60;
		h = (int)Math.floor(c);
	}
}
public class Postion{    
	public static void main(String[] args){		
		Test t1 = new Test();   //实例化Test
		Scanner sc = new Scanner(System.in);  //调用Scanner类
		System.out.print("请输入坐标A 的X坐标x1:");
		t1.x1 = sc.nextDouble();
		System.out.print("请输入坐标A 的Y坐标y1:");
		t1.y1 = sc.nextDouble();
		System.out.print("请输入坐标B 的x坐标x2:");
		t1.x2 = sc.nextDouble();
		System.out.print("请输入坐标B 的Y坐标y2:");
		t1.y2 = sc.nextDouble();
		t1.calculate();  //调用Test 类中的calculate方法


	}
}