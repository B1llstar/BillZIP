package main.java.io.billzip;

import java.util.HashMap;
import java.util.Map;

public class EncodingAlgorithm {
    public static String encodeText(String text) {
        Map<String, String> key = new HashMap<>();
        String encodedText = "";
        int uniqueCount = 0;
        
        for (int i = 0; i < text.length() - 1; i++) {
            String pair = text.substring(i, i + 2);
            if (!key.containsKey(pair)) {
                String specialChar = generateSpecialCharacter(uniqueCount);
                key.put(pair, specialChar);
                uniqueCount++;
            }
            encodedText += key.get(pair);
        }
        
        return encodedText;
    }
    
    private static String generateSpecialCharacter(int count) {
        // Array of special characters in the desired order
        char[] specialCharacters = {
            '≈', '⌀', '℥', '‡', '÷', '∝', '∀', '∁', '∂', '∃',
            '∄', '∅', '∆', '∇', '∈', '∉', '∊', '∋', '∌', '∍',
            '∎', '∏', '∐', '∑', '−', '∓', '∔', '∕', '∖', '∗',
            '∘', '∙', '√', '∛', '∜', '∝', '∞', '∟', '∠', '∡',
            '∢', '∣', '∤', '∥', '∦', '∧', '∨', '∩', '∪', '∫',
            '∬', '∭', '∮', '∯', '∰', '∱', '∲', '∳', '∴', '∵',
            '∶', '∷', '∸', '∹', '∺', '∻', '∼', '∽', '∾', '∿',
            '≀', '≁', '≂', '≃', '≄', '≅', '≆', '≇', '≈', '≉',
            '≊', '≋', '≌', '≍', '≎', '≏', '≐', '≑', '≒', '≓',
            '≔', '≕', '≖', '≗', '≘', '≙', '≚', '≛', '≜', '≝'
            // Add the list of special characters here
        };
        
        // Get the special character at the given index
        if (count < specialCharacters.length) {
            return String.valueOf(specialCharacters[count]);
        } else {
            // Handle the case when count exceeds the number of special characters
            return String.valueOf((char) (count + 65));
        }
    }
}
