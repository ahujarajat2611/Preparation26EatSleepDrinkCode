package DSA.Stack;

/**
 * Created by hadoop on 5/3/18.
 */
import java.util.*;
public class ExclusiveFunctionsTimeBest {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if(logs == null || logs.size()<2)
            return result;

        Stack<LogObj> stk = new Stack<LogObj>();
        for(int i=0; i< logs.size(); i++){
            LogObj logObj = getLogObj(logs.get(i));
            if(logObj.isStart){
                stk.push(logObj);
            } else {
                LogObj startLog = stk.pop();
                int time = logObj.timelog- startLog.timelog+1; //endtime-starttime
                if(!stk.isEmpty()){
                    stk.peek().childFxTime+=time;
                }
                result[logObj.logId] += time-startLog.childFxTime;
            }

        }
        return result;


    }
    private LogObj getLogObj(String logStr){
        String[] str = logStr.split(":");
        int funcId = Integer.parseInt(str[0]);
        int timelog = Integer.parseInt(str[2]);
        return new LogObj(funcId, timelog, str[1].equals("publish"));

    }
    private class LogObj{
        public int logId;
        public int timelog;
        public int childFxTime;
        boolean isStart;

        public LogObj(int logId, int timelog, boolean isStart){
            this.logId = logId;
            this.timelog = timelog;
            this.isStart = isStart;

        }

    }
}
