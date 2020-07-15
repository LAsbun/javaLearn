package btracetest;
//
//import com.sun.btrace.AnyType;
//import com.sun.btrace.annotations.*;
//
//import java.util.concurrent.atomic.AtomicInteger;
//
//import static com.sun.btrace.BTraceUtils.*;
//
//@BTrace
//public class TrainRpcListen {
//
//    @OnMethod(
//            clazz = "org.unitedata.scplatform.training.rpc.TrainingRpcService",
//            method = "call",
//            location = @Location(value = Kind.LINE, line = 52)
//    )
//    public static void traceExecute(@ProbeClassName String clzName, @ProbeMethodName String clsMName, int line) {
//        println("clsMName " + clzName + " clsMName " + clsMName + " line : " + str(line));
//
//    }
//
//    @OnMethod(
//            clazz = "org.unitedata.scplatform.dao.dao.impl.NodeDaoImpl",
//            method = "selectByPubKey",
//            location = @Location(value = Kind.RETURN)
//    )
//    public static void selectNodeParam(AnyType input, @Return AnyType xx) {
//        println("select " + str(input));
//        println("select " + str(xx));
//    }
//
//    @OnMethod(
//            clazz = "org.unitedata.scplatform.dao.dao.impl.NodeDaoImpl",
//            method = "selectByPubKey"
//    )
//    public static void selectNodeParamEnter(AnyType input) {
//        println("xxx select enter " + str(input));
//    }
//
//
//    @OnMethod(
//            clazz = "org.unitedata.scplatform.training.rpc.TrainingRpcService",
//            method = "call"
//    )
//    public static void printEnterParam(AnyType sSrc) {
//        println("enter: call " + str(sSrc));
//        println("call end");
//
//    }
//
//    @OnMethod(
//            clazz = "org.unitedata.scplatform.training.rpc.TrainingRpcService",
//            method = "validate"
//    )
//    public static void printValidateEnterParam(AnyType sSr, AnyType xs) {
//        println("enter: validate" + str(sSr));
//        println("validate end");
//
//    }
//
//}
