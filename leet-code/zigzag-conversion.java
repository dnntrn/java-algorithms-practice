import java.util.*;
class Solution {
    public String convert(String s, int numRows) {

        HashMap<Integer, ArrayList<Character>> hm = new HashMap<Integer, ArrayList<Character>>();


        boolean pivot = false;

        for (int i = 1; i <= numRows; i++){
            hm.put(i, new ArrayList<Character>());
        }

        int count2 = 1;
        for (int i = 0; i < s.length(); i++){
            ArrayList<Character> temp2 = hm.get(count2);
            hm.get(count2).add(s.charAt(i));
            hm.put(count2, temp2);

            if (numRows > 1){
                if (count2 == 1){
                    pivot = false;
                }


                if (count2 == numRows){
                    pivot = true;
                }


                if (!pivot){
                    count2 += 1;
                } else{
                    count2 -=1;
                }

            }


        }


        StringBuilder builder = new StringBuilder(s.length());


        System.out.println(hm);
        for (int i = 1; i <= numRows; i++){

            for(Character ch: hm.get(i)){
                builder.append(ch);
            }

        }


        return builder.toString();


    }
}
