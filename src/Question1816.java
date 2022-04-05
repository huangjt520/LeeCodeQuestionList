public class Question1816 {
    public String truncateSentence(String s, int k) {
        String[] list = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<k&&i<list.length; i++)
            builder.append(" "+list[i]);

        return builder.replace(0,1,"").toString();

    }

    public String truncateSentence1(String s, int k) {
        StringBuilder builder = new StringBuilder();
        char[] charArray = s.toCharArray();
        int count = 0;

        for(int i=0,len = charArray.length; i<len; i++)
        {
            if (charArray[i]==' ') count++;
            if (count>=k) break;
            builder.append(charArray[i]);
        }



        return builder.toString();

    }
}
