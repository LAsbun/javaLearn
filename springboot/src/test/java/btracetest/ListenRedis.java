package btracetest;

import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class ListenRedis {

    @OnMethod(
            clazz = "org.unitedata.scplatform.training.rpc.TrainingRpcService",
            method = "call",
            location = @Location(value = Kind.LINE, line = 52)
    )
    public static void traceExecute(@ProbeClassName String clzName, @ProbeMethodName String clsMName, int line) {
        println("clsMName " + clzName + " clsMName " + clsMName + " line : " + str(line));

    }


    @OnMethod(
            clazz = "org.unitedata.scplatform.training.rpc.TrainingRpcService",
            method = "call"
    )
    public static void printEnterParam(AnyType sSrc) {
        println("enter: " + str(sSrc));
        println("enter end");

    }

}
