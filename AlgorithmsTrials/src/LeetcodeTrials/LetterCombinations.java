package LeetcodeTrials;
import java.util.ArrayList;
import java.util.List;
// 17. 电话号码的字母组合：

public class LetterCombinations{
    private static final String[]Mappings={
       "", // 0
       "",
       "abc",
       "def",
       "ghi",
       "jkl",
       "mno",
       "pqrs",  // 7
       "tuv",
       "wxyz"  // 9

    };

    public List<String> letterCombinations(String digits){
        List<String> result= new ArrayList<>();
        if (digits==null||digits.length()==0) return result;

        StringBuilder path=new StringBuilder();
        backTrack(digits,0,path,result);
        return result;
    }


    public void backTrack(String digits, int index, StringBuilder path, List<String> result){
        if (path.length()==digits.length()){
            result.add(path.toString());
            return;
        } 

        String letter=Mappings[digits.charAt(index)-'0']; 
        for (char c:letter.toCharArray()){
            path.append(c);
            backTrack(digits, index+1, path, result);
            path.deleteCharAt(path.length()-1);
        }

    }



}