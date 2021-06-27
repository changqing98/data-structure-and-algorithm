package jian_zhi_offer.p0058_2_reverse_left_words;

public class ReverseLeftWords{
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}