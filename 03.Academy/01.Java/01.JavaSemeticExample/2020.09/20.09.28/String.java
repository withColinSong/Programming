
###01
package com.exstring;

class Sample1
{
    public static void main(String[] args)
    {
        String str = "Hello";
        
        char ch1 = str.charAt(0);
        char ch2 = str.charAt(1);
        
        int len = str.length();
        
        System.out.println(str + " 의 첫 번째 문자는 " + ch1 );
        System.out.println(str + " 의 두 번째 문자는 " + ch2 );
        System.out.println(str + "길이는 "+ len );
    }
}


###02
package com.exstring;

import java.io.*;

class Sample2
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("영문자를 입력하십시오.");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        
        String stru = str.toUpperCase();
        String strl = str.toLowerCase();
        
        System.out.println ("대문자로 변환하면 "+ stru );
        System.out.println("소문자로 변환하면 "+ strl );
    }
}


###03
package com.exstring;

import java.io.*;

class Sample3
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("문자열을 입력하십시오.");
        
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        
        String str1 = br.readLine ();
        
        System.out.println ("안녕하십니까. 검색어를 입력하십시오.");
        
        String str2 = br.readLine();
        char ch = str2.charAt(0);
        
        int num = str1.indexOf(ch);
        
        if(num != -1)
            System.out.println(str1 + " 의 " + (num+1) + "번째에서 ' "+ ch +" '발견");
        else
            System.out.println (str1 + "에서 '" + ch + "' 을(를) 찾을 수 없었습니다.");
    }
}


###04
package com.exstring;

import java.io.*;

class Sample4
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("문자열을 입력하십시오.");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str1 = br.readLine();
        
        System.out.println("추가할 문자열을 입력하십시오.");
        
        String str2 = br.readLine();
        
        StringBuffer sb = new StringBuffer(str1);
        sb.append(str2);
        
        System.out.println (str1 + " 에 "+ str2 + " 을(를) 추가하면 " + sb );
    }
}



###05
package com.exstring;

import java.io.*;

class Sample5
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("정수를 2개 입력하십시오.");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str1 = br.readLine();
        String str2 = br.readLine();
        
        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);
        
        int ans = Math.max(num1, num2);
        
        System.out.println (num1 + " 와(과) "+ num2 + " 중 큰 쪽은 " + ans );
    }
}
