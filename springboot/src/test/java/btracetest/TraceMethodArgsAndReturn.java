package btracetest;

/**
 * Created by louxiu
 */

import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class TraceMethodArgsAndReturn {
    @OnMethod(
            clazz="btracetest.StringTableTest",
            method="intern",
            location=@Location(Kind.RETURN)
    )
    public static void traceExecute(int sSrc,@Return long result){
        println("invoke StringTableTest.intern");
        println(strcat("input arg is:", str(sSrc)));
        // 打印函数返回结果result
        println(strcat("result is:",str(result)));
        //打印方法执行时间点
        println(strcat("time is:",str(timeMillis())));
        //打印线程堆栈
        jstack();
    }
    @OnMethod(
            clazz="com.ezlippi.StringTableTest",
            location=@Location(value=Kind.LINE,line=22)
    )
    public static void traceExecute(@ProbeClassName String pcn,@ProbeMethodName String pmn,int line){
        println(strcat(strcat(strcat("call ",pcn),"."),pmn));
    }
}
