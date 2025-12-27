package api.mcmeta.banword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordList {
    private static final Set<String> BAD_WORDS = new HashSet<>(Arrays.asList(
            "нахуй", "сука", "дура", "дурочка", "дурак", "дурачок", "дурень",
            "хуесос", "пидорас", "пидар", "пидор", "педик", "гомик",
            "даун", "аутист", "дебил", "дегенерат", "имбецил",
            "идиот", "мудак", "мудила", "гандон", "конча",
            "пизда", "пиздабол", "пиздюк",
            "ебан", "еблан", "ебучка",
            "блядь", "блядина", "блядский",
            "хер", "хрен", "херов", "херня",
            "шлюха", "проститутка", "блудница",
            "уебан", "выебок", "долбоеб", "долбаеб",
            "придурок", "кретин", "редиска", "конченый", "уебок",
            "жопа", "задница", "сучка", "скотина",
            "мразь", "гадина", "падла", "сволочь",
            "лох", "лошара", "чмо", "чмырь"
    ));

    private static final Set<String> FORBIDDEN_PARTS = new HashSet<>(Arrays.asList(
            "хуй", "пизд", "еб", "бля", "ганд", "муд", "деби",
            "пид", "педик", "гом", "даун", "аутист"
    ));

    public static boolean containsBadWord(String message) {
        String lowerMessage = cleanMessage(message);


        String[] words = lowerMessage.split(" ");
        for (String word : words) {
            if (BAD_WORDS.contains(word)) {
                return true;
            }
        }


        for (String badPart : FORBIDDEN_PARTS) {
            if (lowerMessage.contains(badPart)) {
                return true;
            }
        }

        return false;
    }

    public static String filterBadWords(String message) {
        String originalMessage = message;
        String lowerMessage = cleanMessage(message);
        String[] words = originalMessage.split(" ");

        for (int i = 0; i < words.length; i++) {
            String originalWord = words[i];
            String cleanWord = cleanMessage(originalWord);

            if (BAD_WORDS.contains(cleanWord)) {
                words[i] = "****";
                continue;
            }

            for (String badPart : FORBIDDEN_PARTS) {
                if (cleanWord.contains(badPart)) {
                    words[i] = words[i].replaceAll("(?i)" + badPart, "***");
                }
            }
        }

        return String.join(" ", words);
    }

    private static String cleanMessage(String message) {
        return message.toLowerCase()
                .replaceAll("[^а-яa-zё]", " ")
                .replaceAll("\\s+", " ")
                .trim();
    }
}