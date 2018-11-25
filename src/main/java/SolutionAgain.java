import java.util.HashSet;

/**
 * Created by hadoop on 24/1/18.
 */
public class SolutionAgain {
     String validate(String input) {
      //  input = "|name|address|~n|Patrick|patrick@test.com|pat@gm|~n|Annie|annietest@com|~n";
        String split [] = input.split("~n");
      //  System.out.println(split.length-1);
         int first = split.length-1;
        // System.out.println(split[0]);
         String column[] = split[0].split("\\|");
         System.out.println(column.length);
         int record = 0;
         int columnlength = 0;
         HashSet<String> names = new HashSet<>();
         for(int i=1;i<=split.length;i++){
             String columnagain[] = split[i].split("\\|");
             columnlength = columnagain.length;
             for(int k =0;k<columnagain.length;k++){
                 if(names.contains(columnagain[0])){
                     return "0:0:0:format_error";
                 }
                 names.add(columnagain[0]);
                if(columnagain[k].equals("")){
                    record++;
                }
             }
         }
        return ""+first + ":"+columnlength+":"+record+":"+column[column.length-1]+"_"+(columnlength-column.length);
    }

    public static void main(String[] args) {
        SolutionAgain solutionAgain = new SolutionAgain();
        solutionAgain.validate("");
    }
}
