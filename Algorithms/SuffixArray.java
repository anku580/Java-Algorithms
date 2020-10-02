import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class SuffixArray {
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final char DEFAULT_END_SEQ_CHAR = '$';
    private final char endSeqChar;
    private String string;
    private ArrayList<Integer> suffixArray;
    private ArrayList<Integer> KMRarray;
    public SuffixArray(CharSequence sequence) {
        this(sequence, DEFAULT_END_SEQ_CHAR);
    }
    public SuffixArray(CharSequence sequence, char endChar) {
        endSeqChar = endChar;
        string = buildStringWithEndChar(sequence);
    }
    public ArrayList<Integer> getSuffixArray() {
        if (suffixArray == null)
            KMRalgorithm();
        return suffixArray;
    }
    public ArrayList<Integer> getKMRarray() {
        if (KMRarray == null)
            KMRalgorithm();
        return KMRarray;
    }
    public String getString(){
        return string;
    }
    private void KMRalgorithm() {
        final int length = string.length();
        ArrayList<KMRsWithIndex> KMRinvertedList = new ArrayList<KMRsWithIndex>();
        ArrayList<Integer> KMR = getBasicKMR(length);
        int radius = 1;
        while (radius < length) {
            KMRinvertedList = getKMRinvertedList(KMR, radius, length);
            KMR = getKMR(KMRinvertedList, length);
            radius *= 2;
        }
        KMRarray = new ArrayList<Integer>(KMR.subList(0, length));
        suffixArray = new ArrayList<Integer>();
        for (KMRsWithIndex kmr : KMRinvertedList) {
            suffixArray.add(new Integer(kmr.index));
        }
    }
    private ArrayList<Integer> getKMR(ArrayList<KMRsWithIndex> KMRinvertedList, int length) {
        final ArrayList<Integer> KMR = new ArrayList<Integer>(length*2);
        for (int i=0; i<2*length; i++) 
            KMR.add(new Integer(-1));
        int counter = 0;
        for (int i=0; i<length; i++){
            if(i>0 && substringsAreEqual(KMRinvertedList, i))
                counter++;
            KMR.set(KMRinvertedList.get(i).index, new Integer(counter));
        }
        return KMR;
    }
    private boolean substringsAreEqual(ArrayList<KMRsWithIndex> KMRinvertedList, int i) {
        return (KMRinvertedList.get(i-1).beginKMR.equals(KMRinvertedList.get(i).beginKMR) == false) || 
               (KMRinvertedList.get(i-1).endKMR.equals(KMRinvertedList.get(i).endKMR) == false);
    }
    private ArrayList<KMRsWithIndex> getKMRinvertedList(ArrayList<Integer> KMR, int radius, int length) {
        final ArrayList<KMRsWithIndex> KMRinvertedList = new ArrayList<KMRsWithIndex>();
        for (int i=0; i<length; i++)
            KMRinvertedList.add(new KMRsWithIndex(KMR.get(i), KMR.get(i+radius), i));
        Collections.sort(KMRinvertedList,
            new Comparator<KMRsWithIndex>() {
                @Override
                public int compare(KMRsWithIndex A, KMRsWithIndex B) {
                    if (A.beginKMR.equals(B.beginKMR) == false)
                        return A.beginKMR.compareTo(B.beginKMR);
                    if (A.endKMR.equals(B.endKMR) == false)
                        return A.endKMR.compareTo(B.endKMR);
                    return A.index.compareTo(B.index);
                }
            }
        );
        return KMRinvertedList;
    }
    private ArrayList<Integer> getBasicKMR(int length) {
        final ArrayList<Integer> result = new ArrayList<Integer>(length*2);
        final char[] characters = string.toCharArray();
        for (int i=0; i<length; i++)
            result.add(new Integer(characters[i]));
        for (int i=0; i<length; i++)
            result.add(new Integer(-1));
        return result;
    }
    private String buildStringWithEndChar(CharSequence sequence) {
        STRING_BUILDER.setLength(0);
        STRING_BUILDER.append(sequence);
        if (STRING_BUILDER.indexOf(String.valueOf(endSeqChar)) < 0)
            STRING_BUILDER.append(endSeqChar);
        return STRING_BUILDER.toString();
    }
    private class KMRsWithIndex{
        Integer beginKMR;
        Integer endKMR;
        Integer index;
        KMRsWithIndex(Integer begin, Integer end, Integer index){
            this.beginKMR = begin;
            this.endKMR = end;
            this.index = index;
        }
    }
}