/*************************************************************************
	> File Name: Calculator.java
	> Author: 李俊宏
	> Mail: 
	> Created Time: 2018年06月20日 星期三 15时51分35秒
 ************************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Stack;

public class Calculator
{
    public static void main(String args[])
    {
        MyFrame my = new MyFrame();
        my.setVisible(true);
    }
}

class MyFrame extends JFrame implements ActionListener,MouseListener
{
    boolean is_first = true;
    double number1;
    double number2;
    double zuokuo;
    char o1,o2;

    //三个文本框字符串
    String str_text1 = new String("");
    String str_text2 = new String("");
    String str_text3 = new String("");
    String str_tmp = new String("");
    String str_xu = new String("");
    String last = new String("");

    //三个文本框
    MyJTextField text1 = new MyJTextField("");
    MyJTextField text2 = new MyJTextField("0");
    MyJTextField text3 = new MyJTextField("表达正确");
    
    //按钮
    MyJButton button_2nd = new MyJButton("2nd");
    MyJButton button_deg = new MyJButton("deg");
    MyJButton button_sin = new MyJButton("sin");
    MyJButton button_cos = new MyJButton("cos");
    MyJButton button_tan = new MyJButton("tan");
    MyJButton button_mao = new MyJButton("^");
    MyJButton button_lg = new MyJButton("lg");
    MyJButton button_ln = new MyJButton("ln");
    MyJButton button_zuokuo = new MyJButton("(");
    MyJButton button_youkuo = new MyJButton(")");
    MyJButton button_sqrt = new MyJButton("sqrt");
    MyJButton button_AC = new MyJButton("AC");
    MyJButton button_Back = new MyJButton("Back");
    MyJButton button_divi = new MyJButton("/");
    MyJButton button_multi = new MyJButton("x");
    MyJButton button_gan = new MyJButton("!");
    MyJButton button_7 = new MyJButton("7");
    MyJButton button_8 = new MyJButton("8");
    MyJButton button_9 = new MyJButton("9");
    MyJButton button_jian = new MyJButton("-");
    MyJButton button_dao = new MyJButton("1/X");
    MyJButton button_4 = new MyJButton("4");
    MyJButton button_5 = new MyJButton("5");
    MyJButton button_6 = new MyJButton("6");
    MyJButton button_jia = new MyJButton("+");
    MyJButton button_PI = new MyJButton("PI");
    MyJButton button_1 = new MyJButton("1");
    MyJButton button_2 = new MyJButton("2");
    MyJButton button_3 = new MyJButton("3");
    MyJButton button_deng = new MyJButton("=");
    MyJButton button_e = new MyJButton("e");
    MyJButton button_bai = new MyJButton("%");
    MyJButton button_0 = new MyJButton("0");
    MyJButton button_dian = new MyJButton(".");

    //栈
    Stack<Double> number = new Stack<Double>();
    Stack<Character> op1 = new Stack<Character>();
    Stack<String> number_str = new Stack<String>();
    Stack<String> number_str1 = new Stack<String>();

    double result;

    public MyFrame()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        setTitle("计算器");
        setLocationRelativeTo(null);
        setLayout(null);
        //设置按钮大小和位置
        button_2nd.setBounds(0,80,80,60);
        button_deg.setBounds(80,80,80,60);
        button_sin.setBounds(160,80,80,60);
        button_cos.setBounds(240,80,80,60);
        button_tan.setBounds(320,80,80,60);
        button_mao.setBounds(0,140,80,60);
        button_lg.setBounds(80,140,80,60);
        button_ln.setBounds(160,140,80,60);
        button_zuokuo.setBounds(240,140,80,60);
        button_youkuo.setBounds(320,140,80,60);
        button_sqrt.setBounds(0,200,80,60);
        button_AC.setBounds(80,200,80,60);
        button_Back.setBounds(160,200,80,60);
        button_divi.setBounds(240,200,80,60);
        button_multi.setBounds(320,200,80,60);
        button_gan.setBounds(0,260,80,60);
        button_7.setBounds(80,260,80,60);
        button_8.setBounds(160,260,80,60);
        button_9.setBounds(240,260,80,60);
        button_jian.setBounds(320,260,80,60);
        button_dao.setBounds(0,320,80,60);
        button_4.setBounds(80,320,80,60);
        button_5.setBounds(160,320,80,60);
        button_6.setBounds(240,320,80,60);
        button_jia.setBounds(320,320,80,60);
        button_PI.setBounds(0,380,80,60);
        button_1.setBounds(80,380,80,60);
        button_2.setBounds(160,380,80,60);
        button_3.setBounds(240,380,80,60);
        button_deng.setBounds(320,380,80,120);
        button_e.setBounds(0,440,80,60);
        button_bai.setBounds(80,440,80,60);
        button_0.setBounds(160,440,80,60);
        button_dian.setBounds(240,440,80,60);

        this.add(button_2nd);
        this.add(button_deg);
        this.add(button_sin);
        this.add(button_cos);
        this.add(button_tan);
        this.add(button_mao);
        this.add(button_lg);
        this.add(button_ln);
        this.add(button_zuokuo);
        this.add(button_youkuo);
        this.add(button_sqrt);
        this.add(button_AC);
        this.add(button_Back);
        this.add(button_divi);
        this.add(button_multi);
        this.add(button_gan);
        this.add(button_7);
        this.add(button_8);
        this.add(button_9);
        this.add(button_jian);
        this.add(button_dao);
        this.add(button_4);
        this.add(button_5);
        this.add(button_6);
        this.add(button_jia);
        this.add(button_PI);
        this.add(button_1);
        this.add(button_2);
        this.add(button_3);
        this.add(button_deng);
        this.add(button_e);
        this.add(button_bai);
        this.add(button_0);
        this.add(button_dian);
        
        //添加文本框，使用三个文本框
        text1.setBounds(0,0,400,20);
        text2.setBounds(0,20,400,30);
        text3.setBounds(0,50,400,30);
        text1.setFont(new Font("标楷体",Font.BOLD,15));
        text2.setFont(new Font("标楷体",Font.BOLD,25));
        text3.setFont(new Font("标楷体",Font.BOLD,15));
        this.add(text1);
        this.add(text2);
        this.add(text3);

        //添加事件响应
        text1.addMouseListener(this);
        button_2nd.addActionListener(this);
        button_deg.addActionListener(this);
        button_sin.addActionListener(this);
        button_cos.addActionListener(this);
        button_tan.addActionListener(this);
        button_mao.addActionListener(this);
        button_lg.addActionListener(this);
        button_ln.addActionListener(this);
        button_zuokuo.addActionListener(this);
        button_youkuo.addActionListener(this);
        button_sqrt.addActionListener(this);
        button_AC.addActionListener(this);
        button_Back.addActionListener(this);
        button_divi.addActionListener(this);
        button_multi.addActionListener(this);
        button_gan.addActionListener(this);
        button_7.addActionListener(this);
        button_8.addActionListener(this);
        button_9.addActionListener(this);
        button_jian.addActionListener(this);
        button_dao.addActionListener(this);
        button_4.addActionListener(this);
        button_5.addActionListener(this);
        button_6.addActionListener(this);
        button_jia.addActionListener(this);
        button_PI.addActionListener(this);
        button_1.addActionListener(this);
        button_2.addActionListener(this);
        button_3.addActionListener(this);
        button_deng.addActionListener(this);
        button_e.addActionListener(this);
        button_bai.addActionListener(this);
        button_0.addActionListener(this);
        button_dian.addActionListener(this);
    }
    //事件响应
    public void actionPerformed(ActionEvent e)
    {
//中缀表达式转后缀表达式

        //0-9事件处理 TODO
        if(e.getSource() == button_1 || e.getSource() == button_2 
                ||e.getSource() == button_3 || e.getSource() == button_4
                ||e.getSource() == button_5 || e.getSource() == button_6
                ||e.getSource() == button_7 || e.getSource() == button_8
                ||e.getSource() == button_9 || e.getSource() == button_0 || e.getSource() == button_dian)
        {
            last = e.getActionCommand();
            str_tmp+=e.getActionCommand();
            if(is_first)//避免第一次的0无法输入0.几
            {
                str_text2 = ""+e.getActionCommand();
                str_xu = ""+e.getActionCommand();
                is_first = false;
            }
            else
            {
                str_text2 += e.getActionCommand();
                str_xu += e.getActionCommand();
            }
            text2.setText(str_xu);
        }

        //判断运算符优先级和入栈出栈操作
        
        //+ - * / ( ) ^ 事件处理
        if(e.getSource() == button_jia || e.getSource() == button_jian
                    || e.getSource() == button_multi || e.getSource() == button_divi
                    || e.getSource() == button_zuokuo || e.getSource() == button_youkuo
                    || e.getSource() == button_sin || e.getSource() == button_cos 
                    || e.getSource() == button_gan || e.getSource() == button_lg
                    || e.getSource() == button_ln || e.getSource() == button_tan
                    || e.getSource() == button_sqrt || e.getSource() == button_dao
                    || e.getSource() == button_bai || e.getSource() == button_mao)
        {
            if(e.getSource() == button_jia && last.equals("+") || e.getSource() == button_jian && last.equals("-")
                        || e.getSource() == button_multi && last.equals("x") || e.getSource() == button_divi && last.equals("/")
                        || e.getSource() == button_mao && last.equals("^") || e.getSource() == button_bai && last.equals("%")
                        || e.getSource() == button_youkuo && last.equals(")"))
            {
                str_text3 = "符号相同";
                text3.setText(str_text3);
            }
            else
            {
            last = e.getActionCommand();
            char now_op = e.getActionCommand().toCharArray()[0];
            switch(now_op)
            {
                case 's':
                    {
                        if(e.getSource() == button_sqrt)
                            now_op = 's';
                        else if(e.getSource() == button_sin)
                            now_op = 'i';
                        break;
                    }
                case 'c':
                    {
                        now_op = 'o';
                        break;
                    }
                case 't':
                    {
                        now_op = 'a';
                        break;
                    }
                case 'l':
                    {
                        if(e.getSource() == button_lg)
                          now_op = 'g';
                        else if(e.getSource() == button_ln)
                          now_op = 'n';
                        break;
                    }
                case '1':
                    {
                        if(e.getSource() == button_dao)
                          now_op = 'd';
                        break;
                    }
            }
            if(!str_tmp.equals(""))
            {
                number_str.push(str_tmp);//将运算符之前的数字入栈
                str_tmp = "";//这个是临时存储数字的
            }
            if(op1.empty())//如果操作符栈中为空 则入栈
            {
                op1.push(now_op);
            }
            else
            {
                if(priority(now_op) > priority(op1.peek()) || op1.peek() == '(' && now_op != ')')
                {
                    op1.push(now_op);
                }
                else
                {
                    if(now_op == ')')
                    {
                        while(op1.peek() != '(')
                        {
                            number_str.push(String.valueOf(op1.pop()));
                        }
                        op1.pop();
                    }
                    else
                    {
                        if(!op1.empty())
                        {
                            while(!op1.empty() && op1.peek() != '(' && priority(now_op) <= priority(op1.peek()))
                            {
                                number_str.push(String.valueOf(op1.pop()));
                            }
                            op1.push(now_op);
                        }
                    }
                }
            }
            /*
            while(!op1.empty())
            {
                number_str.push(String.valueOf(op1.pop()));
            }
            */
            if(e.getSource() == button_sin)
            {
                if(is_first)
                {
                    str_text2 = ""+"i";
                    str_xu = ""+"sin";
                    is_first = false;
                }
                else
                {
                str_text2 += 'i';
                str_xu += "sin";
                }
                text2.setText(str_xu);
            }
            else if(e.getSource() == button_cos)
            {
                if(is_first)
                {
                    str_text2 = ""+"o";
                    str_xu = ""+"cos";
                    is_first = false;
                }
                else
                {
                str_text2 += 'o';
                str_xu += "cos";
                }
                text2.setText(str_xu);
            }
            else if(e.getSource() == button_tan)
            {
                if(is_first)
                {
                    str_text2 = ""+"a";
                    str_xu = ""+"tan";
                    is_first = false;
                }
                else
                {
                str_xu += "tan";
                str_text2 += 'a';
                }
                text2.setText(str_xu);
            }
            else if(e.getSource() == button_lg)
            {
                if(is_first)
                {
                    str_text2 = ""+"g";
                    str_xu = ""+"lg";
                    is_first = false;
                }
                else
                {
                str_text2 += 'g';
                str_xu += "lg";
                }
                text2.setText(str_xu);
            }
            else if(e.getSource() == button_ln)
            {
                if(is_first)
                {
                    str_text2 = ""+"n";
                    str_xu = ""+"ln";
                    is_first = false;
                }
                else
                {
                str_text2 += 'n';
                str_xu += "ln";
                }
                text2.setText(str_xu);
            }
            else if(e.getSource() == button_sqrt)
            {
                if(is_first)
                {
                    str_text2 = ""+"s";
                    str_xu = ""+"sqrt";
                    is_first = false;
                }
                else
                {
                str_text2 += 's';
                str_xu += "sqrt";
                }
                text2.setText(str_xu);
            }
            else if(e.getSource() == button_dao)
            {
                if(is_first)
                {
                    str_text2 = ""+"d";
                    str_xu = ""+"(-1)";
                    is_first = false;
                }
                else
                {
                str_text2 += "d";
                str_xu += "(-1)";
                }
                text2.setText(str_xu);
            }
            else
            {
                if(is_first)
                {
                    str_text2 = ""+e.getActionCommand();
                    str_xu = ""+e.getActionCommand();
                    is_first = false;
                }
                else
                {
                str_xu += e.getActionCommand();
                str_text2+=e.getActionCommand();
                }
                text2.setText(str_xu);
            }
            }
            //测试
            /*
            for(String x:number_str)
            {
                System.out.println(x);
            }
            System.out.println("--------");
            */
        }
        //AC事件处理
        if(e.getSource() == button_AC)
        {
            while(!op1.empty())
              op1.pop();
            while(!number.empty())
              number.pop();

            while(!number.empty())
              number_str.pop();

            while(!number.empty())
              number_str1.pop();

            if(text1.getText().equals("0"))
            {
                text1.setText("");
            }
            else if(text2.getText().equals("0"))
            {
                text1.setText("");
            }
            else
            {//TODO
                str_text1 = str_xu;
                str_xu = "0";
                str_text2 = "";
                is_first = true;
                str_tmp = "";
                text2.setText(str_xu);
                text1.setText(str_text1);
                str_text3 = "表达正确";
                text3.setText(str_text3);
            }
        }
        //e事件
        if(e.getSource() == button_e)
        {
            if(last.equals("e"))
            {
                str_text3 = "非法操作";
                text3.setText(str_text3);
            }
            else
            {
            last = e.getActionCommand();
            System.out.println(last);
            str_text2+="2.71828183";
            text2.setText(str_text2);
            str_tmp = "2.71828183";
            }
        }
        //PI事件处理
        if(e.getSource() == button_PI)
        {
            if(last.equals("PI"))
            {
                str_text3 = "非法操作";
                text3.setText(str_text3);
            }
            else
            {
            last = e.getActionCommand();
            str_text2 += "3.14159265";
            System.out.println(last);
            text2.setText(str_text2);
            str_tmp = "3.14159265";
            }
        }
        //Back事件处理
        if(e.getSource() == button_Back)
        {
            try
            {
            if(last.equals(""))
                {
                    last = str_text2.substring(str_text2.length()-1,str_text2.length());
                    str_tmp = new StringBuffer(new StringBuffer(str_tmp).reverse().toString().replaceFirst(new StringBuffer(last).reverse().toString(),"")).reverse().toString();
                }
            else
            {
           if(last.toCharArray()[0] >= '0' && last.toCharArray()[0] <= '9')
           {
               str_tmp = new StringBuffer(new StringBuffer(str_tmp).reverse().toString().replaceFirst(new StringBuffer(last).reverse().toString(),"")).reverse().toString();
           }
            }

            str_text2 = new StringBuffer(new StringBuffer(str_text2).reverse().toString().replaceFirst(new StringBuffer(last).reverse().toString(),"")).reverse().toString();
            text2.setText(str_text2);
            last = "";
            }
            catch(StringIndexOutOfBoundsException f)
            {
                str_text3 = "栈空";
                text3.setText(str_text3);
            }
        }

        //=事件处理
        if(e.getSource() == button_deng)
        {
            if(!str_tmp.equals(""))
            {
                number_str.push(str_tmp);
                str_tmp = "";
            }
            while(!op1.empty())
            {
                number_str.push(String.valueOf(op1.pop()));
            }
            
            while(!number_str.empty())
              number_str1.push(number_str.pop());
            for(String x:number_str1)
              System.out.println(x);

            while(!number_str1.empty())
            {
                try
                {
                if(priority(number_str1.peek().toCharArray()[0]) == 0)
                {
                  number.push(Double.valueOf(number_str1.pop()));
                }
                else
                {
                    if((number_str1.peek().toCharArray()[0] == '+' || number_str1.peek().toCharArray()[0] == '-' 
                                || number_str1.peek().toCharArray()[0] == 'x' || number_str1.peek().toCharArray()[0] == '/'
                                || number_str1.peek().toCharArray()[0] == '^'))
                    {
                        if((number_str1.peek().toCharArray()[0] == '-' ||number_str1.peek().toCharArray()[0] == '+') && number.size() == 1)
                        {
                          number1 = number.pop();
                          if(number1 % 1 == 0)
                            result = qufan((int)number1,number_str1.pop().toCharArray()[0]);
                          else
                            result = operation(number1,number_str1.pop().toCharArray()[0]);
                        }
                        else
                        {
                        number1 = number.pop();
                        number2 = number.pop();
                        /*
                        if(number1 % 1 == 0 && number2 % 1 == 0)
                            result = operation((int)number2,(int)number1,number_str1.pop().toCharArray()[0]);
                        else*/
                            result = operation(number2,number1,number_str1.pop().toCharArray()[0]);
                        }
                        number.push(result);
                    }
                    else if(number_str1.peek().toCharArray()[0] == '!')
                    {
                      number1 = number.pop();
                      if(number1 % 1 == 0)
                         result = jiecheng((int)number1);
                      else
                        result = jiecheng(number1);
                      number_str1.pop();
                      number.push(Double.valueOf(result));
                    }
                    else if(number_str1.peek().toCharArray()[0] == '%' || number_str1.peek().toCharArray()[0] == '!'
                                || number_str1.peek().toCharArray()[0] == 'd')
                    {
                        number1 = number.pop();
                        result = operation(number1,number_str1.pop().toCharArray()[0]);
                        number.push(Double.valueOf(result));
                    }
                    else if(number_str1.peek().toCharArray()[0] == 's')
                    {
                        /*
                        number1 = number.pop();
                        if(number1 < 0)
                        {
                        str_text3 = "不能为负数";
                        text3.setText(str_text3);
                        }
                        else
                        {*/
                         number1 = number.pop();
                       result = operation(number1,number_str1.pop().toCharArray()[0]);
                       number.push(Double.valueOf(result));


                        //}

                    }
                    else if(number_str1.peek().toCharArray()[0] == 'i' || number_str1.peek().toCharArray()[0] == 'o'
                                || number_str1.peek().toCharArray()[0] == 'a' || number_str1.peek().toCharArray()[0] == 'g'
                                || number_str1.peek().toCharArray()[0] == 'n' || number_str1.peek().toCharArray()[0] == 's')
                    {
                       number1 = number.pop();
                       result = operation(number1,number_str1.pop().toCharArray()[0]);
                       number.push(Double.valueOf(result));
                    }
                }
                }
                catch(java.util.EmptyStackException ggg)
                {
                    str_text3 = "数字栈为空";
                    text3.setText(str_text3);
                }
                /*
                System.out.println("begin");
                for(Double x:number)
                {
                    System.out.println(x);
                }
                System.out.println("ttttttttttttt");
                */
            }
            try
            {
                double a = number.pop();
            is_first = true;
            str_tmp = "";
            str_text1 = ""+str_xu;
            text1.setText(str_text1);
            if(a %1 == 0)
              text2.setText(String.valueOf((int)a));
            else
              text2.setText(String.format("%.6f",a));
            //str_text2 = "0";
            }
            catch(java.util.EmptyStackException ff)
            {
                str_text3 += "结果栈为空";
                text3.setText(str_text3);
            }
        }

    }
    int priority(char signal)
    {
        int prior = 0;
        switch(signal)
        {
            case '+':
                {
                    return 1;
                }
            case '-':
                {
                    return 1;
                }
            case 'x':
                {
                    return 2;
                }
            case '/':
                {
                    return 2;
                }
            case 'i':
                {
                    return 2;
                }
            case 'o':
                {
                    return 2;
                }
            case 'a':
                {
                    return 2;
                }
            case 'g':
                {
                    return 2;
                }
            case 'n':
                {
                    return 2;
                }   
            case 's':
                {
                    return 2;
                }   
            case '!':
                {
                    return 2;
                }
            case '^':
                {
                    return 2;
                }
            case 'd':
                {
                    return 2;
                }
            case 'P':
                {
                    return 2;
                }
            case 'e':
                {
                    return 2;
                }
            case '%':
                {
                    return 2;
                }
            case '(':
                {
                    return 3;
                }
            case ')':
                {
                    return 1;
                }
            default:
                return 0;
        }
    }

    //重载，计算整数
    int operation(int a,int b,char symbol)
    {
        switch(symbol)
        {
            case '+':
                {
                    return a+b;
                }
            case '-':
                {
                    return a-b;
                }
            case 'x':
                {
                    return a*b;
                }
            case '/':
                { if(b == 0)
                    {
str_text3 = "除数为0";
                        text3.setText(str_text3);
                        return 0;
                    }
                    else
                      return a/b;
/*
                    try
                    {
                        return a/b;
                    }
                    catch(ArithmeticException gg)
                    {
                        str_text3 = "除数为0";
                        text3.setText(str_text3);
                        return 0;
                    }   
*/
                }

            case '^':
                {
                    return (int)Math.pow(a,b);
                }
            default:
                return 0;
        }
    }

    //重载计算小数
    double operation(double a,double b,char symbol)
    {
        switch(symbol)
        {
            case '+':
                {
                    return a+b;
                }
            case '-':
                {
                    return a-b;
                }
            case 'x':
                {
                    return a*b;
                }
            case '/':
                {
                    if(b == 0)
                    {
str_text3 = "除数为0";
                        text3.setText(str_text3);
                        return 0;
                    }
                    else
                      return a/b;
                    /*
                    try
                    {
                        return a/b;
                    }
                    catch(Exception gg)
                    //catch(ArithmeticException gg)
                    {
                        str_text3 = "除数为0";
                        text3.setText(str_text3);
                        return 0;
                    } */  

                }
            case '^':
                {
                    return Math.pow(a,b);
                }
            default:
                return 0;
        }
    }
//重载 计算sin,cos,tan,lg,ln,sqrt,1/x,%
    
    double operation(double a,char symbol)
    {
        switch(symbol)
        {
            case 'i':
                {
                    return Math.sin(a);
                }
            case 'o':
                {
                    return Math.cos(a);
                }
            case 'a':
                {
                    return Math.tan(a);
                }
            case 'g':
                {
                    return Math.log10(a);
                }
            case 'n':
                {
                    return Math.log10(a)/Math.log10(2.71828);
                }
            case 's':
                {
                    if(a<0)
                    {
                        str_text3 = "不能为负数";
                        text3.setText(str_text3);
                        return 0;
                    }
                    else
                    return Math.sqrt(a);
                }
            case 'd':
                {
                    return 1/a; 
                }
            case '-':
                {
                    return -a;
                }
            case '+':
                return a;
            case '%':
                {
                    return a/100;
                }
            default:
                return 0;
        }
    }
    //取反
    int qufan(int a,char symbol)
    {
        if(symbol == '-')
        return -a;
        else
          return a;
    }


//计算阶乘
    int jiecheng(int n)
    {
        int sum = 1;
        for(int i = n;i>=1;i--)
            sum *= i;
        return sum;
    }

//小数阶乘
    double jiecheng(double n)
    {
       double array[]  = {
           0.999999999,676.520368,-1259.139216,771.323428,-176.615029,12.50734327,-0.138571,9.9843695780e-6,1.50563273514e-7
       };
       int num = 7;
       if(n<0.5)
       {
           return Math.PI / (Math.sin(Math.PI * n)* jiecheng(1-n));
       }
       else
       {
            n-=1;
            double x = array[0];
            for(int i = 1;i<(num + 2);i++)
            {
                x+=array[i] / (n+i);
            }
            double t = n+num + 0.5;
            return Math.sqrt(2*Math.PI)*Math.pow(t,(n+0.5))*Math.exp(-t)*x;
       }
    }

    public void mouseClicked(MouseEvent aa)
    {
        if(aa.getClickCount() == 2)
        {
            is_first = false;
            str_xu = ""+str_text1;
            System.out.println(str_xu);
            str_text1 = "";
            text2.setText(str_xu);
            System.out.println(str_xu);
            text1.setText(str_text1);
            str_text2 = str_xu.replaceAll("sqrt","s");
            str_text2 = str_xu.replaceAll("sin","i");
            str_text2 = str_xu.replaceAll("cos","o");
            str_text2 = str_xu.replaceAll("tan","a");
            str_text2 = str_xu.replaceAll("lg","g");
            str_text2 = str_xu.replaceAll("ln","n");
            str_text2 = str_xu.replaceAll("(-1)","d");
            System.out.println(str_xu);

            /////////////////////////////////
            //last = e.getActionCommand();
            while(!number_str.empty())
              number_str.pop();
            while(!op1.empty())
              op1.pop();
            str_tmp = "";
            char [] tmp = str_text2.toCharArray();
            String tmp_num = new String();
            for(int i = 0;i< tmp.length;i++)
            {
            char now_op = tmp[i];
            if(now_op >= '0' && now_op <= '9')
            {
                str_tmp += now_op;
            }
            else
            {
            if(!str_tmp.equals(""))
            {
                number_str.push(str_tmp);//将运算符之前的数字入栈
                str_tmp = "";//这个是临时存储数字的
            }
            if(op1.empty())//如果操作符栈中为空 则入栈
            {
                op1.push(now_op);
            }
            else
            {
                if(priority(now_op) > priority(op1.peek()) || op1.peek() == '(' && now_op != ')')
                {
                    op1.push(now_op);
                }
                else
                {
                    if(now_op == ')')
                    {
                        while(op1.peek() != '(')
                        {
                            number_str.push(String.valueOf(op1.pop()));
                        }
                        op1.pop();
                    }
                    else
                    {
                        if(!op1.empty())
                        {
                            while(!op1.empty() && op1.peek() != '(' && priority(now_op) <= priority(op1.peek()))
                            {
                                number_str.push(String.valueOf(op1.pop()));
                            }
                            op1.push(now_op);
                        }
                    }
                }
            }
            }
            }
        }
    }
    public void mousePressed(MouseEvent aa)
    {
    }
    public void mouseReleased(MouseEvent aa)
    {
    }
    public void mouseEntered(MouseEvent aa)
    {
    }
    public void mouseExited(MouseEvent aa)
    {
    }
    public void mouseDragged(MouseEvent aa)
    {
    }
    public void mouseMoved(MouseEvent aa)
    {
    }

}

//可能出错的
//1.除数为零
//2.开头为0或者操作符
//3.结尾为操作符
//4.两个操作符连在一起了
//5.括号不匹配
//6.
//7.
class MyJButton extends JButton
{
    public MyJButton(String s)
    {
        setText(s);
        setContentAreaFilled(false); //设置透明
        //setBorderPainted(false); //设置去掉边框
        setFocusPainted(false);
        setFont(new java.awt.Font("华文行楷",1,18));
    }
}

class MyJTextField extends JTextField
{
    public MyJTextField(String s)
    {
        setText(s);
        setBorder(null);
        setEditable(false);
        setHorizontalAlignment(JTextField.RIGHT);
    }
}


